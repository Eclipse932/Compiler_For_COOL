/*
Copyright (c) 2000 The Regents of the University of California.
All rights reserved.

Permission to use, copy, modify, and distribute this software for any
purpose, without fee, and without written agreement is hereby granted,
provided that the above copyright notice and the following two
paragraphs appear in all copies of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR
DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES ARISING OUT
OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UNIVERSITY OF
CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS
ON AN "AS IS" BASIS, AND THE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATION TO
PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

// This is a project skeleton file

import java.io.PrintStream;
import java.util.Vector;
import java.util.Enumeration;
import java.util.LinkedHashMap;

//StackLocation class is used to store the correct location to retrieve an attribute, a method argument and a temporary variable.
class StackLocation {
	public String baseRegister;
	public int offset;

    public StackLocation(String reg, int off){
        baseRegister = reg; 
        offset = off;
    }
}	


/** This class is used for representing the inheritance tree during code
    generation. You will need to fill in some of its methods and
    potentially extend it in other useful ways. */
class CgenClassTable extends SymbolTable {

    /** All classes in the program, represented as CgenNode */
    private Vector<CgenNode> nds;

    /** This is the stream to which assembly instructions are output */
    private PrintStream str;

    private int stringclasstag;
    private int intclasstag;
    private int boolclasstag;

    //counter for the next available class tag
    private int currentNameTag = 0;
    //counter for the next available label number
    private int currentLabel = -1;
    //records the distance(in word) from sp to fp; used to keep track of the next available stack location
    private int spFromfp = 1;
    //the current containing class; used for self_type
    private CgenNode currentClass;

    //LinkedHashMap of CgenNodes in the order they're assigned to class tag; map node name to node
    private LinkedHashMap<AbstractSymbol, CgenNode> taggedNodes = new LinkedHashMap<AbstractSymbol, CgenNode>();

    
    //helper method to get CgenNode using class name.
    public CgenNode getCgenNode(AbstractSymbol name){
      if(name.equals(TreeConstants.SELF_TYPE)) return currentClass;
      CgenNode node = taggedNodes.get(name);
      if(node == null) Utilities.fatalError("returning null value from CgenClassTable.getCgenNode");
      return node;
    }

    //perform depth-first search to assign class tags to nodes. Children should always get a bigger tag number than its parent.
    public void setClassTagsHelper(CgenNode curNode) {
    	curNode.setClassTag(currentNameTag);
    	taggedNodes.put(curNode.getName(), curNode);
    	currentNameTag++;
    	for (Enumeration<CgenNode> e = curNode.getChildren(); e.hasMoreElements();) {
            CgenNode child = (CgenNode)e.nextElement();
            setClassTagsHelper(child);
        }
    }

    public void setClassTags() {
    	setClassTagsHelper(root());
    	
    }

    //perform depth-first search to install class methods and class attributes to each CgenNode.
    private void installAllClassFeatures() {
    	installAllClassFeaturesHelper(root(), new Vector<MethodNodePair>(), new Vector<attr>());
    }

    private void installAllClassFeaturesHelper(CgenNode curNode, Vector<MethodNodePair> inheritedMethods, Vector<attr> inheritedAttrs) {
    	curNode.setInheritedAttrs(inheritedAttrs);
    	Vector<MethodNodePair> curMethods = new Vector<MethodNodePair>(inheritedMethods);
    	Vector<MethodNodePair> newMethods = new Vector<MethodNodePair>();//hold all locally defined methods
    	Vector<attr> localAttrs = new Vector<attr>(); //hold all locally defined attributes
    	for (Enumeration e = curNode.getFeatures().getElements(); e.hasMoreElements();) {
            Feature feature= ((Feature)e.nextElement());
            if (feature instanceof method) {
                newMethods.add(new MethodNodePair(curNode, ((method)feature)));
            } else if (feature instanceof attr) {
                localAttrs.add(((attr)feature));
            }
        }

        //we need to replace the inherited method with new locally-defined method. 
        for (int i = 0; i < curMethods.size(); i++) {
        	MethodNodePair met = curMethods.get(i);
        	int position = newMethods.indexOf(met);
             
        	if (position != -1) {
        		curMethods.set(i, newMethods.get(position));
        		newMethods.remove(position);
        	}
        }
        curMethods.addAll(newMethods);
        curNode.setMethods(curMethods);
        curNode.setLocalAttrs(localAttrs);

        Vector<attr> allAttrs = curNode.getAllAttrs();
        for (Enumeration<CgenNode> e = curNode.getChildren(); e.hasMoreElements();) {
            CgenNode child = (CgenNode)e.nextElement();
            installAllClassFeaturesHelper(child, curMethods, allAttrs);
        }

    }

    private void codeClassNameTable() {
    	str.print(CgenSupport.CLASSNAMETAB + CgenSupport.LABEL);
    	for(CgenNode node: taggedNodes.values()) {
    		str.print(CgenSupport.WORD);
    		((StringSymbol) AbstractTable.stringtable.lookup(node.name.getString())).codeRef(str);
        str.println();
    	}
    }

    private void codeClassObjTable() {
    	str.print(CgenSupport.CLASSOBJTAB + CgenSupport.LABEL);
    	for(CgenNode node: taggedNodes.values()) {
    		str.print(CgenSupport.WORD);
    		CgenSupport.emitProtObjRef(node.name, str);
        str.println();
        str.print(CgenSupport.WORD);
    		CgenSupport.emitInitRef(node.name, str);
    		str.println();
    	}
    }

   
    private void codeDispatchTables() {
    	for(CgenNode cnode: taggedNodes.values()){
    		str.print(cnode.name.getString() + CgenSupport.DISPTAB_SUFFIX + CgenSupport.LABEL);
    		for(MethodNodePair met : cnode.getMethods()){
    			str.print(CgenSupport.WORD);
    			CgenSupport.emitMethodRef(met.node.name, met.mt.name, str);
    			str.println();
    		}
    	}
    }

    //emit default values of attributes in prototype objects
    private void codeAttr(attr att) {
    	str.print(CgenSupport.WORD);
     	AbstractSymbol clas = att.type_decl;
      	if(clas.equals(TreeConstants.Int)){
        	((IntSymbol) AbstractTable.inttable.lookup("0")).codeRef(str);
     	 } else if (clas.equals(TreeConstants.Bool)) {
        	BoolConst.falsebool.codeRef(str);
      	} else if (clas.equals(TreeConstants.Str)) {
        	((StringSymbol) AbstractTable.stringtable.lookup("")).codeRef(str);
      	} else {
        	str.print(0); // void
      	}
      	str.println();
    }

    private void codeProtObjects() {
    	for (CgenNode node: taggedNodes.values()) {
    		str.println(CgenSupport.WORD + "-1");
    		str.print(node.name.getString() + CgenSupport.PROTOBJ_SUFFIX  + CgenSupport.LABEL);
    		str.println(CgenSupport.WORD + node.getClassTag());
    		Vector<attr> allAttrs = node.getAllAttrs();
    		int objSize = 3 + allAttrs.size();
    		str.println(CgenSupport.WORD + objSize);
    		str.println(CgenSupport.WORD + node.name.getString() + CgenSupport.DISPTAB_SUFFIX);
    		for (attr att: allAttrs) {
    			codeAttr(att);
    		}
    	}
    }
    //emit code for initialization method of all classes
    private void codeInitializers() {
    	for (CgenNode node: taggedNodes.values()) {
    		str.print(node.name.getString() + CgenSupport.CLASSINIT_SUFFIX + CgenSupport.LABEL);
    		enterScope();
     		Vector<attr> attrs = node.getAllAttrs();
     		for (int i = 0; i < attrs.size(); i++) {
     			StackLocation newLoc = new StackLocation(CgenSupport.SELF, 3 + i); 
        		this.addId(attrs.get(i).name, newLoc);//store the location of an attribute in the CgenClassTable
      		}
      		CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, -12, str);
      		CgenSupport.emitStore(CgenSupport.FP, 3, CgenSupport.SP, str); //store old fp
      		CgenSupport.emitStore(CgenSupport.SELF, 2, CgenSupport.SP, str); //store old self
      		CgenSupport.emitStore(CgenSupport.RA, 1, CgenSupport.SP, str); //store old return address
      		//enter the initializer function
      		resetSpFromFp();
      		//fp points to the ra
      		CgenSupport.emitAddiu(CgenSupport.FP, CgenSupport.SP, 4, str);
      		CgenSupport.emitMove(CgenSupport.SELF, CgenSupport.ACC, str); //update SELF to reference the object being initialized
      		AbstractSymbol parent = node.getParent();
          //initialized parent first; all inherited attributes get initialized
      		if(!parent.equals(TreeConstants.No_class)){ 
        		str.print(CgenSupport.JAL);
        		str.print(parent.getString() + CgenSupport.CLASSINIT_SUFFIX);
        		str.println();
      		}
          //now initialized all locally-defined attributes
      		setCurrentClass(node);
      		for (attr att: node.getLocalAttrs()) {
      			if (att.init instanceof no_expr) continue;
      			att.init.code(str, this);
      			int offset = node.getAttrOffset(att.name);
      			CgenSupport.emitStore(CgenSupport.ACC, offset, CgenSupport.SELF, str); //store the initialization result in the correct attribute slot
            //in case the garbage collector is enabled, we need to report assignment to gc. 
		    	  if(Flags.cgen_Memmgr == 1){
            		CgenSupport.emitAddiu(CgenSupport.A1, CgenSupport.SELF, 4 * offset, str);
            		CgenSupport.emitGCAssign(str);    
        		}
      		}
      		setCurrentClass(null);

      		CgenSupport.emitMove(CgenSupport.ACC, CgenSupport.SELF, str); //restore accumulator to the object which is already initialized
      		CgenSupport.emitLoad(CgenSupport.FP, 3, CgenSupport.SP, str); //restore old fp
      		CgenSupport.emitLoad(CgenSupport.SELF, 2, CgenSupport.SP, str); //restore old self
      		CgenSupport.emitLoad(CgenSupport.RA, 1, CgenSupport.SP, str); //restore old return address
      		CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 12, str); //pop old fp, self and return address off stack
      		CgenSupport.emitReturn(str);
      		exitScope();
    	}
    }



    // The following methods emit code for constants and global
    // declarations.

    /** Emits code to start the .data segment and to
     * declare the global names.
     * */
    private void codeGlobalData() {
	// The following global names must be defined first.

	str.print("\t.data\n" + CgenSupport.ALIGN);
	str.println(CgenSupport.GLOBAL + CgenSupport.CLASSNAMETAB);
	str.print(CgenSupport.GLOBAL); 
	CgenSupport.emitProtObjRef(TreeConstants.Main, str);
	str.println("");
	str.print(CgenSupport.GLOBAL); 
	CgenSupport.emitProtObjRef(TreeConstants.Int, str);
	str.println("");
	str.print(CgenSupport.GLOBAL); 
	CgenSupport.emitProtObjRef(TreeConstants.Str, str);
	str.println("");
	str.print(CgenSupport.GLOBAL); 
	BoolConst.falsebool.codeRef(str);
	str.println("");
	str.print(CgenSupport.GLOBAL); 
	BoolConst.truebool.codeRef(str);
	str.println("");
	str.println(CgenSupport.GLOBAL + CgenSupport.INTTAG);
	str.println(CgenSupport.GLOBAL + CgenSupport.BOOLTAG);
	str.println(CgenSupport.GLOBAL + CgenSupport.STRINGTAG);

	// We also need to know the tag of the Int, String, and Bool classes
	// during code generation.

	str.println(CgenSupport.INTTAG + CgenSupport.LABEL 
		    + CgenSupport.WORD + intclasstag);
	str.println(CgenSupport.BOOLTAG + CgenSupport.LABEL 
		    + CgenSupport.WORD + boolclasstag);
	str.println(CgenSupport.STRINGTAG + CgenSupport.LABEL 
		    + CgenSupport.WORD + stringclasstag);

    }

    /** Emits code to start the .text segment and to
     * declare the global names.
     * */
    private void codeGlobalText() {
	str.println(CgenSupport.GLOBAL + CgenSupport.HEAP_START);
	str.print(CgenSupport.HEAP_START + CgenSupport.LABEL);
	str.println(CgenSupport.WORD + 0);
	str.println("\t.text");
	str.print(CgenSupport.GLOBAL);
	CgenSupport.emitInitRef(TreeConstants.Main, str);
	str.println("");
	str.print(CgenSupport.GLOBAL);
	CgenSupport.emitInitRef(TreeConstants.Int, str);
	str.println("");
	str.print(CgenSupport.GLOBAL);
	CgenSupport.emitInitRef(TreeConstants.Str, str);
	str.println("");
	str.print(CgenSupport.GLOBAL);
	CgenSupport.emitInitRef(TreeConstants.Bool, str);
	str.println("");
	str.print(CgenSupport.GLOBAL);
	CgenSupport.emitMethodRef(TreeConstants.Main, TreeConstants.main_meth, str);
	str.println("");
    }

    /** Emits code definitions for boolean constants. */
    private void codeBools(int classtag) {
	BoolConst.falsebool.codeDef(classtag, str);
	BoolConst.truebool.codeDef(classtag, str);
    }

    /** Generates GC choice constants (pointers to GC functions) */
    private void codeSelectGc() {
	str.println(CgenSupport.GLOBAL + "_MemMgr_INITIALIZER");
	str.println("_MemMgr_INITIALIZER:");
	str.println(CgenSupport.WORD 
		    + CgenSupport.gcInitNames[Flags.cgen_Memmgr]);

	str.println(CgenSupport.GLOBAL + "_MemMgr_COLLECTOR");
	str.println("_MemMgr_COLLECTOR:");
	str.println(CgenSupport.WORD 
		    + CgenSupport.gcCollectNames[Flags.cgen_Memmgr]);

	str.println(CgenSupport.GLOBAL + "_MemMgr_TEST");
	str.println("_MemMgr_TEST:");
	str.println(CgenSupport.WORD 
		    + ((Flags.cgen_Memmgr_Test == Flags.GC_TEST) ? "1" : "0"));
    }

    /** Emits code to reserve space for and initialize all of the
     * constants.  Class names should have been added to the string
     * table (in the supplied code, is is done during the construction
     * of the inheritance graph), and code for emitting string constants
     * as a side effect adds the string's length to the integer table.
     * The constants are emmitted by running through the stringtable and
     * inttable and producing code for each entry. */
    private void codeConstants() {
	// Add constants that are required by the code generator.
	AbstractTable.stringtable.addString("");
	AbstractTable.inttable.addString("0");

	AbstractTable.stringtable.codeStringTable(stringclasstag, str);
	AbstractTable.inttable.codeStringTable(intclasstag, str);
	codeBools(boolclasstag);
    }


    /** Creates data structures representing basic Cool classes (Object,
     * IO, Int, Bool, String).  Please note: as is this method does not
     * do anything useful; you will need to edit it to make if do what
     * you want.
     * */
    private void installBasicClasses() {
	AbstractSymbol filename 
	    = AbstractTable.stringtable.addString("<basic class>");
	
	// A few special class names are installed in the lookup table
	// but not the class list.  Thus, these classes exist, but are
	// not part of the inheritance hierarchy.  No_class serves as
	// the parent of Object and the other special classes.
	// SELF_TYPE is the self class; it cannot be redefined or
	// inherited.  prim_slot is a class known to the code generator.

	addId(TreeConstants.No_class,
	      new CgenNode(new class_c(0,
				      TreeConstants.No_class,
				      TreeConstants.No_class,
				      new Features(0),
				      filename),
			   CgenNode.Basic, this));

	addId(TreeConstants.SELF_TYPE,
	      new CgenNode(new class_c(0,
				      TreeConstants.SELF_TYPE,
				      TreeConstants.No_class,
				      new Features(0),
				      filename),
			   CgenNode.Basic, this));
	
	addId(TreeConstants.prim_slot,
	      new CgenNode(new class_c(0,
				      TreeConstants.prim_slot,
				      TreeConstants.No_class,
				      new Features(0),
				      filename),
			   CgenNode.Basic, this));

	// The Object class has no parent class. Its methods are
	//        cool_abort() : Object    aborts the program
	//        type_name() : Str        returns a string representation 
	//                                 of class name
	//        copy() : SELF_TYPE       returns a copy of the object

	class_c Object_class = 
	    new class_c(0, 
		       TreeConstants.Object_, 
		       TreeConstants.No_class,
		       new Features(0)
			   .appendElement(new method(0, 
					      TreeConstants.cool_abort, 
					      new Formals(0), 
					      TreeConstants.Object_, 
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.type_name,
					      new Formals(0),
					      TreeConstants.Str,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.copy,
					      new Formals(0),
					      TreeConstants.SELF_TYPE,
					      new no_expr(0))),
		       filename);

	installClass(new CgenNode(Object_class, CgenNode.Basic, this));
	
	// The IO class inherits from Object. Its methods are
	//        out_string(Str) : SELF_TYPE  writes a string to the output
	//        out_int(Int) : SELF_TYPE      "    an int    "  "     "
	//        in_string() : Str            reads a string from the input
	//        in_int() : Int                "   an int     "  "     "

	class_c IO_class = 
	    new class_c(0,
		       TreeConstants.IO,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new method(0,
					      TreeConstants.out_string,
					      new Formals(0)
						  .appendElement(new formalc(0,
								     TreeConstants.arg,
								     TreeConstants.Str)),
					      TreeConstants.SELF_TYPE,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.out_int,
					      new Formals(0)
						  .appendElement(new formalc(0,
								     TreeConstants.arg,
								     TreeConstants.Int)),
					      TreeConstants.SELF_TYPE,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.in_string,
					      new Formals(0),
					      TreeConstants.Str,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.in_int,
					      new Formals(0),
					      TreeConstants.Int,
					      new no_expr(0))),
		       filename);

	CgenNode IO_node = new CgenNode(IO_class, CgenNode.Basic, this);
	installClass(IO_node);

	// The Int class has no methods and only a single attribute, the
	// "val" for the integer.

	class_c Int_class = 
	    new class_c(0,
		       TreeConstants.Int,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new attr(0,
					    TreeConstants.val,
					    TreeConstants.prim_slot,
					    new no_expr(0))),
		       filename);

	installClass(new CgenNode(Int_class, CgenNode.Basic, this));

	// Bool also has only the "val" slot.
	class_c Bool_class = 
	    new class_c(0,
		       TreeConstants.Bool,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new attr(0,
					    TreeConstants.val,
					    TreeConstants.prim_slot,
					    new no_expr(0))),
		       filename);

	installClass(new CgenNode(Bool_class, CgenNode.Basic, this));

	// The class Str has a number of slots and operations:
	//       val                              the length of the string
	//       str_field                        the string itself
	//       length() : Int                   returns length of the string
	//       concat(arg: Str) : Str           performs string concatenation
	//       substr(arg: Int, arg2: Int): Str substring selection

	class_c Str_class =
	    new class_c(0,
		       TreeConstants.Str,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new attr(0,
					    TreeConstants.val,
					    TreeConstants.Int,
					    new no_expr(0)))
			   .appendElement(new attr(0,
					    TreeConstants.str_field,
					    TreeConstants.prim_slot,
					    new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.length,
					      new Formals(0),
					      TreeConstants.Int,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.concat,
					      new Formals(0)
						  .appendElement(new formalc(0,
								     TreeConstants.arg, 
								     TreeConstants.Str)),
					      TreeConstants.Str,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.substr,
					      new Formals(0)
						  .appendElement(new formalc(0,
								     TreeConstants.arg,
								     TreeConstants.Int))
						  .appendElement(new formalc(0,
								     TreeConstants.arg2,
								     TreeConstants.Int)),
					      TreeConstants.Str,
					      new no_expr(0))),
		       filename);

	installClass(new CgenNode(Str_class, CgenNode.Basic, this));
    }
	
    // The following creates an inheritance graph from
    // a list of classes.  The graph is implemented as
    // a tree of `CgenNode', and class names are placed
    // in the base class symbol table.
    
    private void installClass(CgenNode nd) {
	AbstractSymbol name = nd.getName();
	if (probe(name) != null) return;
	nds.addElement(nd);
	addId(name, nd);
    }

    private void installClasses(Classes cs) {
        for (Enumeration e = cs.getElements(); e.hasMoreElements(); ) {
	    installClass(new CgenNode((Class_)e.nextElement(), 
				       CgenNode.NotBasic, this));
        }
    }

    private void buildInheritanceTree() {
	for (Enumeration e = nds.elements(); e.hasMoreElements(); ) {
	    setRelations((CgenNode)e.nextElement());
	}
    }

    private void setRelations(CgenNode nd) {
	CgenNode parent = (CgenNode)probe(nd.getParent());
	nd.setParentNd(parent);
	parent.addChild(nd);
    }

    /** Constructs a new class table and invokes the code generator */
    public CgenClassTable(Classes cls, PrintStream str) {
	nds = new Vector<CgenNode>();

	this.str = str;

	enterScope();
	if (Flags.cgen_debug) System.out.println("Building CgenClassTable");
	
	installBasicClasses();
	installClasses(cls);
	buildInheritanceTree();
	setClassTags();
	installAllClassFeatures();

	stringclasstag = ((CgenNode) this.lookup(TreeConstants.Str)).getClassTag(); /* Change to your String class tag here */;
	intclasstag =   ((CgenNode) this.lookup(TreeConstants.Int)).getClassTag();  /* Change to your Int class tag here */;
	boolclasstag =    ((CgenNode) this.lookup(TreeConstants.Bool)).getClassTag();/* Change to your Bool class tag here */;

	code();

	exitScope();
    }

    /** This method is the meat of the code generator.  It is to be
        filled in programming assignment 5 */
    public void code() {
	if (Flags.cgen_debug) System.out.println("coding global data");
	codeGlobalData();

	if (Flags.cgen_debug) System.out.println("choosing gc");
	codeSelectGc();

	if (Flags.cgen_debug) System.out.println("coding constants");
	codeConstants();

	//                 Add your code to emit
	//                   - prototype objects
	//                   - class_nameTab
	//                   - dispatch tables

	codeClassNameTable();
	codeClassObjTable();
	codeDispatchTables();

	//emit code for prototype objects
	codeProtObjects();

	if (Flags.cgen_debug) System.out.println("coding global text");
	codeGlobalText();

	//                 Add your code to emit
	//                   - object initializer
	//                   - the class methods
	//                   - etc...
	codeInitializers();

    }

    /** Gets the root of the inheritance tree */
    public CgenNode root() {
	return (CgenNode)probe(TreeConstants.Object_);
    }

    //get the next available label number
    public int nextLabel(){
      currentLabel++;
      return currentLabel;
    }

    public void setCurrentClass(CgenNode node){
      currentClass = node;
    }

    public CgenNode getCurrentClass(){
      if (currentClass == null) Utilities.fatalError("returning null value from CgenClassTable.getCurrentClass");
      return currentClass;
    }

    //called on method entrance; set spFromfp to 1
    public void resetSpFromFp(){
      spFromfp = 1;
    }

    //get the next available stack location offset relative to fp; stack grows to lower address, so this method returns a negative number
    public int getSpFromFp(){
      return -spFromfp;
    }

    //push the content in reg to stack; increase spFromfp accordingly
    public void emitPush(String reg, PrintStream s) {
      spFromfp++;
      CgenSupport.emitStore(reg, 0, CgenSupport.SP, s);
      CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, -4, s);
    }

   //pop the counter number of arguments from stack; decrease spFromfp accordingly
    public void emitPop(PrintStream s, int counter) {
      spFromfp = spFromfp - counter;
      if(spFromfp < 1) Utilities.fatalError("sp same or below fp in method call; pop too much in CgenClassTable.emitPop");
      CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4 * counter, s);
 
    }

    //store default value of clas into destRegister; used in let variable initialization
    public void emitStoreDefaultValue(String destRegister, AbstractSymbol clas, PrintStream str){
      if(clas.equals(TreeConstants.Int)) {
        IntSymbol defaultInt = (IntSymbol) AbstractTable.inttable.lookup("0");
        CgenSupport.emitLoadInt(destRegister, defaultInt, str);
      } else if (clas.equals(TreeConstants.Bool)) {
        CgenSupport.emitLoadBool(destRegister, BoolConst.falsebool, str);
      } else if (clas.equals(TreeConstants.Str)) {
        StringSymbol defaultString = (StringSymbol) AbstractTable.stringtable.lookup("");
        CgenSupport.emitLoadString(destRegister, defaultString, str);
      } else {
        CgenSupport.emitMove(destRegister, CgenSupport.ZERO, str); // void
      }
    }

    //pop the top of stack into destRegister; decrease spFromfp accordingly
    public void emitPopFromTop(String destRegister, PrintStream s) {
      CgenSupport.emitLoad(destRegister, 1, CgenSupport.SP, s);
      emitPop(s, 1);
    }

}
			  
    

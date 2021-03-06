// -*- mode: java -*- 
//
// file: cool-tree.m4
//
// This file defines the AST
//
//////////////////////////////////////////////////////////



import java.util.Enumeration;
import java.io.PrintStream;
import java.util.Vector;

import java.util.HashSet;
import java.util.ArrayList;


/** Defines simple phylum Program */
abstract class Program extends TreeNode {
    protected Program(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void semant();

}


/** Defines simple phylum Class_ */
abstract class Class_ extends TreeNode {
    protected Class_(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract AbstractSymbol getName();
    public abstract AbstractSymbol getParent();
    public abstract AbstractSymbol getFilename();
    public abstract Features getFeatures();
    public abstract void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c);

}


/** Defines list phylum Classes
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Classes extends ListNode {
    public final static Class elementClass = Class_.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Classes(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Classes" list */
    public Classes(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Class_" element to this list */
    public Classes appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Classes(lineNumber, copyElements());
    }
}


/** Defines simple phylum Feature */
abstract class Feature extends TreeNode {
    protected Feature(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c);
    public abstract AbstractSymbol getName();

}


/** Defines list phylum Features
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Features extends ListNode {
    public final static Class elementClass = Feature.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Features(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Features" list */
    public Features(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Feature" element to this list */
    public Features appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Features(lineNumber, copyElements());
    }
}


/** Defines simple phylum Formal */
abstract class Formal extends TreeNode {
    protected Formal(int lineNumber) {
        super(lineNumber);
    }
    public abstract AbstractSymbol getTypeDecl();
    public abstract AbstractSymbol getName();
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c);
}


/** Defines list phylum Formals
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Formals extends ListNode {
    public final static Class elementClass = Formal.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Formals(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Formals" list */
    public Formals(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Formal" element to this list */
    public Formals appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Formals(lineNumber, copyElements());
    }
}


/** Defines simple phylum Expression */
abstract class Expression extends TreeNode {
    protected Expression(int lineNumber) {
        super(lineNumber);
    }
    private AbstractSymbol type = null;                                 
    public AbstractSymbol get_type() { return type; }           
    public Expression set_type(AbstractSymbol s) { type = s; return this; } 
    public abstract void dump_with_types(PrintStream out, int n);
    public void dump_type(PrintStream out, int n) {
        if (type != null)
            { out.println(Utilities.pad(n) + ": " + type.getString()); }
        else
            { out.println(Utilities.pad(n) + ": _no_type"); }
    }

    public abstract void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c);

}


/** Defines list phylum Expressions
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Expressions extends ListNode {
    public final static Class elementClass = Expression.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Expressions(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Expressions" list */
    public Expressions(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Expression" element to this list */
    public Expressions appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Expressions(lineNumber, copyElements());
    }
}


/** Defines simple phylum Case */
abstract class Case extends TreeNode {
    protected Case(int lineNumber) {
        super(lineNumber);
    }
    public abstract AbstractSymbol getTypeDecl();
    public abstract AbstractSymbol getExprType();
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c);
}


/** Defines list phylum Cases
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Cases extends ListNode {
    public final static Class elementClass = Case.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Cases(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Cases" list */
    public Cases(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Case" element to this list */
    public Cases appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Cases(lineNumber, copyElements());
    }
}


/** Defines AST constructor 'programc'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class programc extends Program {
    protected Classes classes;
    /** Creates "programc" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for classes
      */
    public programc(int lineNumber, Classes a1) {
        super(lineNumber);
        classes = a1;
    }
    public TreeNode copy() {
        return new programc(lineNumber, (Classes)classes.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "programc\n");
        classes.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_program");
        for (Enumeration e = classes.getElements(); e.hasMoreElements(); ) {
	    ((Class_)e.nextElement()).dump_with_types(out, n + 2);
        }
    }
    /** This method is the entry point to the semantic checker.  You will
        need to complete it in programming assignment 4.
	<p>
        Your checker should do the following two things:
	<ol>
	<li>Check that the program is semantically correct
	<li>Decorate the abstract syntax tree with type information
        by setting the type field in each Expression node.
        (see tree.h)
	</ol>
	<p>
	You are free to first do (1) and make sure you catch all semantic
    	errors. Part (2) can be done in a second stage when you want
	to test the complete compiler.
    */
    public void semant() {
	/* ClassTable constructor may do some semantic analysis */

    //first pass of all classes; validate existence of classes and parents and check for cycles in inheritance graph
	ClassTable classTable = new ClassTable(classes);
	
	/* some semantic analysis code may go here */

	if (classTable.errors()) {
	    System.err.println("Compilation halted due to static semantic errors.");
	    System.exit(1);
	}

    classTable.isMainDefined();
    SymbolTable symbolTable = new SymbolTable();

    //second pass is a depth-first-search type checking on all features of all classes
    class_c c;
    for (Enumeration e = classes.getElements(); e.hasMoreElements(); ) {
      c = ((class_c)e.nextElement());
      c.checkType(symbolTable, classTable, c);
    }

    if (classTable.errors()) {
        System.err.println("Compilation halted due to static semantic errors.");
        System.exit(1);
    }

    }

}


/** Defines AST constructor 'class_c'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class class_c extends Class_ {
    protected AbstractSymbol name;
    protected AbstractSymbol parent;
    protected Features features;
    protected AbstractSymbol filename;
    /** Creates "class_c" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for parent
      * @param a2 initial value for features
      * @param a3 initial value for filename
      */
    public class_c(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Features a3, AbstractSymbol a4) {
        super(lineNumber);
        name = a1;
        parent = a2;
        features = a3;
        filename = a4;
    }
    public TreeNode copy() {
        return new class_c(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(parent), (Features)features.copy(), copy_AbstractSymbol(filename));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "class_c\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, parent);
        features.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, filename);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_class");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, parent);
        out.print(Utilities.pad(n + 2) + "\"");
        Utilities.printEscapedString(out, filename.getString());
        out.println("\"\n" + Utilities.pad(n + 2) + "(");
        for (Enumeration e = features.getElements(); e.hasMoreElements();) {
	    ((Feature)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
    }
    public AbstractSymbol getName()     { return name; }
    public AbstractSymbol getParent()   { return parent; }
    public AbstractSymbol getFilename() { return filename; }
    public Features getFeatures()       { return features; }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c){
        symbolTable.enterScope();
        symbolTable.addId(TreeConstants.self, TreeConstants.SELF_TYPE);
        //checking existence of main method
        HashSet<String> attributes = new HashSet<String>();
        HashSet<String> methods = new HashSet<String>();

        
        for (Enumeration e = features.getElements(); e.hasMoreElements();) {
            Feature feature= ((Feature)e.nextElement());
            if (feature instanceof method) {
                if (!methods.add(feature.getName().getString())) {
                    classTable.semantError(c, feature).println("Method " + feature.getName().getString() + " is redefined in class " + name.getString());
                }
            } else if (feature instanceof attr) {
                if (!attributes.add(feature.getName().getString())) {
                    classTable.semantError(c, feature).println("Attribute " + feature.getName().getString() + " is redefined in class " + name.getString());
                }
            }
            feature.checkType(symbolTable, classTable, c);

        }

        if (name.equals(TreeConstants.Main) && (!methods.contains(TreeConstants.main_meth.getString()))) {
            classTable.semantError(c).println("Class Main doesn't contain main() method.");
        }
        symbolTable.exitScope();
    }

}


/** Defines AST constructor 'method'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class method extends Feature {
    protected AbstractSymbol name;
    protected Formals formals;
    protected AbstractSymbol return_type;
    protected Expression expr;
    /** Creates "method" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for formals
      * @param a2 initial value for return_type
      * @param a3 initial value for expr
      */
    public method(int lineNumber, AbstractSymbol a1, Formals a2, AbstractSymbol a3, Expression a4) {
        super(lineNumber);
        name = a1;
        formals = a2;
        return_type = a3;
        expr = a4;
    }

    public AbstractSymbol getReturnType(){
        return return_type;
    }

    public Formals getFormals() {
        return formals;
    }

    public AbstractSymbol getName() {
        return name;
    }

    public TreeNode copy() {
        return new method(lineNumber, copy_AbstractSymbol(name), (Formals)formals.copy(), copy_AbstractSymbol(return_type), (Expression)expr.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "method\n");
        dump_AbstractSymbol(out, n+2, name);
        formals.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, return_type);
        expr.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_method");
        dump_AbstractSymbol(out, n + 2, name);
        for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
	    ((Formal)e.nextElement()).dump_with_types(out, n + 2);
        }
        dump_AbstractSymbol(out, n + 2, return_type);
	expr.dump_with_types(out, n + 2);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c){
        if (c.getName().equals(TreeConstants.Main) && name.equals(TreeConstants.main_meth)) {
            if (formals.getLength() > 0){
                classTable.semantError(c, this).println("Main method should have no formal parameters");
            }
        }
        class_c parent = classTable.lookupImmediateParent(c.getName().getString());
        if (parent != null) {
            Formals parentFormals = classTable.methodFormals(parent, name);
            if (parentFormals != null) {
                if (formals.getLength() != parentFormals.getLength()) {
                    classTable.semantError(c, this).println("Number of formal parameters for method " + name.getString() + " is differernt from that of inherited method signature");

                } else {
                    int i = 0;
                    for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
                        formalc f1 = ((formalc) e.nextElement());
                        formalc f2 = ((formalc) parentFormals.getNth(i));
                        if (!f1.getTypeDecl().equals(f2.getTypeDecl())) {
                            classTable.semantError(c, this).println("Declared type of formal parameter " + f1.getTypeDecl().getString() + " of method " + name.getString() + " is not the same as the inherited type " + f2.getTypeDecl().getString());
                        }
                        i++;
                    }
                }
            

                AbstractSymbol parentReturnType = classTable.returnType(parent, name);
                if (!parentReturnType.equals(return_type)){
                    classTable.semantError(c, this).println("Declared return type " + return_type.getString() + " of method " + name.getString() + " is not the same as the inherited return type " + parentReturnType.getString());
                }
            }
        }
        symbolTable.enterScope();
        //check formal parameters
        for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
            formalc f1 = ((formalc) e.nextElement());
            f1.checkType(symbolTable, classTable, c);
        }
        expr.checkType(symbolTable, classTable, c);

        if (!classTable.isClassDefined(return_type.getString())) {
            classTable.semantError(c, this).println("Return type " + return_type.getString() + " of method " + name.getString() + " is not defined.");
        } else if (!classTable.isSubclassOf(expr.get_type(), return_type, c)) {
            classTable.semantError(c, this).println("Inferred return type " + expr.get_type().getString() + " of method " + name.getString() + " doesn't conform to declared return type " + return_type.getString());
        }

        symbolTable.exitScope();

    }

}


/** Defines AST constructor 'attr'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class attr extends Feature {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    protected Expression init;
    /** Creates "attr" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      * @param a2 initial value for init
      */
    public attr(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
        init = a3;
    }

    public AbstractSymbol getName() {
        return name;
    }

    public AbstractSymbol getTypeDecl() {
        return type_decl;
    }

    public TreeNode copy() {
        return new attr(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl), (Expression)init.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "attr\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
        init.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_attr");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
	init.dump_with_types(out, n + 2);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c){
        class_c parent = classTable.lookupImmediateParent(c.getName().getString());
        if (parent != null) {
             AbstractSymbol parentAttrType = classTable.attrType(parent, name);
             if (parentAttrType != null) {
                classTable.semantError(c, this).println("Attribute " + name.getString() + " is inherited and thus cannot be redefined.");
             }
        } 

        if (name.equals(TreeConstants.self)) {
             classTable.semantError(c, this).println("Attribute name can't be self");
        }

        init.checkType(symbolTable, classTable, c);

        if (!classTable.isClassDefined(type_decl.getString())) {
            classTable.semantError(c, this).println("Type " + type_decl.getString() + " for attribute " + name.getString() + " is not defined.");
        } else if ((!init.get_type().equals(TreeConstants.No_type)) && (!classTable.isSubclassOf(init.get_type(), type_decl, c))) {
            classTable.semantError(c, this).println("Inferred type " + init.get_type().getString() + " of initialization of attribute " + name.getString() + " doesn't conform to declared attribute type " + type_decl.getString());
        }

    }

}


/** Defines AST constructor 'formalc'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class formalc extends Formal {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    /** Creates "formalc" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      */

    public AbstractSymbol getTypeDecl() {
        return type_decl;
    }

    public AbstractSymbol getName() {
        return name;
    }

    public formalc(int lineNumber, AbstractSymbol a1, AbstractSymbol a2) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
    }
    public TreeNode copy() {
        return new formalc(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "formalc\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_formal");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
    }

     public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c){

        if (name.equals(TreeConstants.self)) {
            classTable.semantError(c, this).println("self cannot be formal parameter name.");
        }else if (symbolTable.probe(name) != null){
            classTable.semantError(c, this).println("Duplicate formal parameter name: " + name.getString());
        }else if (type_decl.equals(TreeConstants.SELF_TYPE)){
            symbolTable.addId(this.name, this.type_decl);
            classTable.semantError(c, this).println("Typef of formal parameter " + name.getString() + " cannot be SELF_TYPE");
        }else if (!classTable.isClassDefined(type_decl.getString())) {
            symbolTable.addId(this.name, this.type_decl);
            classTable.semantError(c, this).println("Declared type " + type_decl.getString() + " of formal parameter " + name.getString() + " is not defined.");
        } else {
            symbolTable.addId(this.name, this.type_decl);
        }
     }

}


/** Defines AST constructor 'branch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class branch extends Case {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    protected Expression expr;
    /** Creates "branch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      * @param a2 initial value for expr
      */
    public branch(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
        expr = a3;
    }
    public AbstractSymbol getTypeDecl() {
        return type_decl;
    }

    public AbstractSymbol getExprType() {
        return expr.get_type();
    }

    public TreeNode copy() {
        return new branch(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl), (Expression)expr.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "branch\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
        expr.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_branch");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
	expr.dump_with_types(out, n + 2);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c){
        symbolTable.enterScope();
        if (name.equals(TreeConstants.self)) {
            classTable.semantError(c, this).println("Cannot use self as identifier name in case branch binding.");
        } else {
            symbolTable.addId(name, type_decl);
        }
        if (type_decl.equals(TreeConstants.SELF_TYPE)) {
            classTable.semantError(c, this).println("Identifier " + name.getString() + " in case branch binding cannot have SELF_TYPE.");
        } else if (!(classTable.isClassDefined(type_decl.getString()))) {
            classTable.semantError(c, this).println("Type " + type_decl.getString() + " for identifier " + name.getString() + " in case branch binding is undefined");
        }

        expr.checkType(symbolTable, classTable, c);
        symbolTable.exitScope();
    }
}


/** Defines AST constructor 'assign'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class assign extends Expression {
    protected AbstractSymbol name;
    protected Expression expr;
    /** Creates "assign" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for expr
      */
    public assign(int lineNumber, AbstractSymbol a1, Expression a2) {
        super(lineNumber);
        name = a1;
        expr = a2;
    }
    public TreeNode copy() {
        return new assign(lineNumber, copy_AbstractSymbol(name), (Expression)expr.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "assign\n");
        dump_AbstractSymbol(out, n+2, name);
        expr.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_assign");
        dump_AbstractSymbol(out, n + 2, name);
	expr.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        if (name.equals(TreeConstants.self)) {
            classTable.semantError(c, this).println("self cannot be reassigned to a new value");
        }
        //if the identifier is not defined in symbolTable, check if it's a class attribute
        AbstractSymbol type = (AbstractSymbol) symbolTable.lookup(name);
        if (type == null) {
            type = classTable.attrType(c, name);
        }

        expr.checkType(symbolTable, classTable, c);
        if (type == null) {
            classTable.semantError(c, this).println("Assignment to undefined identifier " + name.getString());
        } else if (!classTable.isSubclassOf(expr.get_type(), type, c)) {
            classTable.semantError(c, this).println("Inferred type " + expr.get_type().getString() + " of assignment to identifer " + name.getString() + " doesn't conform to its declared type " + type.getString());
        }
        this.set_type(expr.get_type());

    }

}


/** Defines AST constructor 'static_dispatch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class static_dispatch extends Expression {
    protected Expression expr;
    protected AbstractSymbol type_name;
    protected AbstractSymbol name;
    protected Expressions actual;
    /** Creates "static_dispatch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for type_name
      * @param a2 initial value for name
      * @param a3 initial value for actual
      */
    public static_dispatch(int lineNumber, Expression a1, AbstractSymbol a2, AbstractSymbol a3, Expressions a4) {
        super(lineNumber);
        expr = a1;
        type_name = a2;
        name = a3;
        actual = a4;
    }
    public TreeNode copy() {
        return new static_dispatch(lineNumber, (Expression)expr.copy(), copy_AbstractSymbol(type_name), copy_AbstractSymbol(name), (Expressions)actual.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "static_dispatch\n");
        expr.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, type_name);
        dump_AbstractSymbol(out, n+2, name);
        actual.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_static_dispatch");
	expr.dump_with_types(out, n + 2);
        dump_AbstractSymbol(out, n + 2, type_name);
        dump_AbstractSymbol(out, n + 2, name);
        out.println(Utilities.pad(n + 2) + "(");
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        expr.checkType(symbolTable, classTable, c);
        if (type_name.equals(TreeConstants.SELF_TYPE)) {
            classTable.semantError(c, this).println("Static dispatch to self_type");
        } else if (!classTable.isClassDefined(type_name.getString())) {
            classTable.semantError(c, this).println("Static dispatch to undefined class " + type_name.getString());
        } else if (!classTable.isSubclassOf(expr.get_type(), type_name, c)){
            classTable.semantError(c, this).println("Expression type " + expr.get_type().getString() + " doesn't conform to declared static dispatch type " + type_name.getString());
        } 

        ArrayList<AbstractSymbol> actualTypes = new ArrayList<AbstractSymbol>();
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
            Expression ex = ((Expression)e.nextElement());
            ex.checkType(symbolTable, classTable, c);
            actualTypes.add(ex.get_type());
        }
        class_c staticDispatchType = classTable.lookupClass(type_name);
        AbstractSymbol return_type = TreeConstants.Object_;
        if (staticDispatchType != null) {

            AbstractSymbol returnType = classTable.returnType(staticDispatchType, name);
            if (returnType == null) {
                classTable.semantError(c, this).println("Method " + name.getString() + " is undefined for static dispatch class " + type_name.getString());
            }else {
                Formals formals = classTable.methodFormals(staticDispatchType, name);
                if (formals.getLength() != actualTypes.size()) {
                    classTable.semantError(c, this).println("Method " + name.getString() + " of static dispatch class " + type_name.getString() + " is called with wrong number of arguments");

                } else {
                    int i = 0;
                    for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
                        formalc f1 = ((formalc) e.nextElement());
                        AbstractSymbol definedType = f1.getTypeDecl();
                        AbstractSymbol actualType = actualTypes.get(i);
                        if (!classTable.isSubclassOf(actualType, definedType, c)) {
                            classTable.semantError(c, this).println("Inferred parameter type " + actualType.getString() + " of method call " + name.getString() + " doesn't conform to declared type " + definedType.getString());
                        }
                        i++;
                    }
                    
                }

                if (returnType.equals(TreeConstants.SELF_TYPE)) {
                        return_type = expr.get_type();
                } else {
                        return_type = returnType;
                } 

            }
        }

        this.set_type(return_type);
    }

}


/** Defines AST constructor 'dispatch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class dispatch extends Expression {
    protected Expression expr;
    protected AbstractSymbol name;
    protected Expressions actual;
    /** Creates "dispatch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for name
      * @param a2 initial value for actual
      */
    public dispatch(int lineNumber, Expression a1, AbstractSymbol a2, Expressions a3) {
        super(lineNumber);
        expr = a1;
        name = a2;
        actual = a3;
    }
    public TreeNode copy() {
        return new dispatch(lineNumber, (Expression)expr.copy(), copy_AbstractSymbol(name), (Expressions)actual.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "dispatch\n");
        expr.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, name);
        actual.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_dispatch");
	expr.dump_with_types(out, n + 2);
        dump_AbstractSymbol(out, n + 2, name);
        out.println(Utilities.pad(n + 2) + "(");
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        expr.checkType(symbolTable, classTable, c);
        
        ArrayList<AbstractSymbol> actualTypes = new ArrayList<AbstractSymbol>();
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
            Expression ex = ((Expression)e.nextElement());
            ex.checkType(symbolTable, classTable, c);
            actualTypes.add(ex.get_type());
        }
        AbstractSymbol lookupType = expr.get_type();
        if (expr.get_type().equals(TreeConstants.SELF_TYPE)) {
            lookupType = c.getName();
        } 

        class_c dispatchType = classTable.lookupClass(lookupType);
        AbstractSymbol return_type = TreeConstants.Object_;
        if (dispatchType == null) {
            //this should never happen
            classTable.semantError(c, this).println("Dispatch to undefined class " + lookupType.getString());

        } else  {

            AbstractSymbol returnType = classTable.returnType(dispatchType, name);
            if (returnType == null) {
                classTable.semantError(c, this).println("Method " + name.getString() + " is undefined for class " + lookupType.getString());
            }else {
                Formals formals = classTable.methodFormals(dispatchType, name);
                if (formals.getLength() != actualTypes.size()) {
                    classTable.semantError(c, this).println("Method " + name.getString() + " of class " + lookupType.getString() + " is called with wrong number of arguments.");

                } else {
                    int i = 0;
                    for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
                        formalc f1 = ((formalc) e.nextElement());
                        AbstractSymbol definedType = f1.getTypeDecl();
                        AbstractSymbol actualType = actualTypes.get(i);
                        if (!classTable.isSubclassOf(actualType, definedType, c)) {
                            classTable.semantError(c, this).println("Inferred parameter type " + actualType.getString() + " of method call " + name.getString() + " doesn't conform to declared type " + definedType.getString());
                        }
                        i++;
                    }
                    
                }

                if (returnType.equals(TreeConstants.SELF_TYPE)) {
                        return_type = expr.get_type();
                } else {
                        return_type = returnType;
                } 

            }

        }

        this.set_type(return_type);

    }


}


/** Defines AST constructor 'cond'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class cond extends Expression {
    protected Expression pred;
    protected Expression then_exp;
    protected Expression else_exp;
    /** Creates "cond" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for pred
      * @param a1 initial value for then_exp
      * @param a2 initial value for else_exp
      */
    public cond(int lineNumber, Expression a1, Expression a2, Expression a3) {
        super(lineNumber);
        pred = a1;
        then_exp = a2;
        else_exp = a3;
    }
    public TreeNode copy() {
        return new cond(lineNumber, (Expression)pred.copy(), (Expression)then_exp.copy(), (Expression)else_exp.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "cond\n");
        pred.dump(out, n+2);
        then_exp.dump(out, n+2);
        else_exp.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_cond");
	pred.dump_with_types(out, n + 2);
	then_exp.dump_with_types(out, n + 2);
	else_exp.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        pred.checkType(symbolTable, classTable, c);
        if (!pred.get_type().equals(TreeConstants.Bool)) {
            classTable.semantError(c, this).println("Predicate type for if conditional should be Bool");
        }

        then_exp.checkType(symbolTable, classTable, c);
        else_exp.checkType(symbolTable, classTable, c);
        this.set_type(classTable.joinType(then_exp.get_type(), else_exp.get_type(), c));
    }

}


/** Defines AST constructor 'loop'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class loop extends Expression {
    protected Expression pred;
    protected Expression body;
    /** Creates "loop" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for pred
      * @param a1 initial value for body
      */
    public loop(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        pred = a1;
        body = a2;
    }
    public TreeNode copy() {
        return new loop(lineNumber, (Expression)pred.copy(), (Expression)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "loop\n");
        pred.dump(out, n+2);
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_loop");
	pred.dump_with_types(out, n + 2);
	body.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        pred.checkType(symbolTable, classTable, c);
        if (!pred.get_type().equals(TreeConstants.Bool)) {
            classTable.semantError(c, this).println("Predicate type for while loop should be Bool");
        }

        body.checkType(symbolTable, classTable, c);
        this.set_type(TreeConstants.Object_);

    }


}


/** Defines AST constructor 'typcase'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class typcase extends Expression {
    protected Expression expr;
    protected Cases cases;
    /** Creates "typcase" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for cases
      */
    public typcase(int lineNumber, Expression a1, Cases a2) {
        super(lineNumber);
        expr = a1;
        cases = a2;
    }
    public TreeNode copy() {
        return new typcase(lineNumber, (Expression)expr.copy(), (Cases)cases.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "typcase\n");
        expr.dump(out, n+2);
        cases.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_typcase");
	expr.dump_with_types(out, n + 2);
        for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
	    ((Case)e.nextElement()).dump_with_types(out, n + 2);
        }
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        expr.checkType(symbolTable, classTable, c);
        HashSet<String> caseTypes = new HashSet<String>();
        ArrayList<AbstractSymbol> branchTypes = new ArrayList<AbstractSymbol>();
        for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
            branch b = ((branch)e.nextElement());

            if (!caseTypes.add(b.getTypeDecl().getString())) {
                classTable.semantError(c, this).println("Duplicate branch " + b.getTypeDecl().getString() + " in case expression");
            }
            b.checkType(symbolTable, classTable, c);
            branchTypes.add(b.getExprType());
        }

        this.set_type(classTable.joinType(branchTypes, c));
    }

}


/** Defines AST constructor 'block'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class block extends Expression {
    protected Expressions body;
    /** Creates "block" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for body
      */
    public block(int lineNumber, Expressions a1) {
        super(lineNumber);
        body = a1;
    }
    public TreeNode copy() {
        return new block(lineNumber, (Expressions)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "block\n");
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_block");
        for (Enumeration e = body.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        Expression expression = null;
        for (Enumeration e = body.getElements(); e.hasMoreElements();) {
            expression = ((Expression)e.nextElement());
            expression.checkType(symbolTable, classTable, c);
        }
        this.set_type(expression.get_type());
    }

}


/** Defines AST constructor 'let'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class let extends Expression {
    protected AbstractSymbol identifier;
    protected AbstractSymbol type_decl;
    protected Expression init;
    protected Expression body;
    /** Creates "let" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for identifier
      * @param a1 initial value for type_decl
      * @param a2 initial value for init
      * @param a3 initial value for body
      */
    public let(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3, Expression a4) {
        super(lineNumber);
        identifier = a1;
        type_decl = a2;
        init = a3;
        body = a4;
    }
    public TreeNode copy() {
        return new let(lineNumber, copy_AbstractSymbol(identifier), copy_AbstractSymbol(type_decl), (Expression)init.copy(), (Expression)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "let\n");
        dump_AbstractSymbol(out, n+2, identifier);
        dump_AbstractSymbol(out, n+2, type_decl);
        init.dump(out, n+2);
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_let");
	dump_AbstractSymbol(out, n + 2, identifier);
	dump_AbstractSymbol(out, n + 2, type_decl);
	init.dump_with_types(out, n + 2);
	body.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        init.checkType(symbolTable, classTable, c);

        if (!classTable.isClassDefined(type_decl.getString())) {
            classTable.semantError(c, this).println("Bind identifier " + identifier.getString() + " to undefined type " + type_decl.getString() + " in let expression");
        } else if ((!init.get_type().equals(TreeConstants.No_type)) && (!classTable.isSubclassOf(init.get_type(), type_decl, c))) {
            classTable.semantError(c, this).println("Inferred type " + init.get_type().getString() + " of initialization to identifier " + identifier.getString() + " in let expression doesn't conform to its declared type " + type_decl.getString());
        }
        symbolTable.enterScope();
        if (identifier.equals(TreeConstants.self)) {
            classTable.semantError(c, this).println("Cannot use self as identifier name in let expression binding.");
        } else {
            symbolTable.addId(identifier, type_decl);
        }
        body.checkType(symbolTable, classTable, c);
        this.set_type(body.get_type());
        symbolTable.exitScope();
    }

}


/** Defines AST constructor 'plus'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class plus extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "plus" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public plus(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new plus(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "plus\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_plus");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        e2.checkType(symbolTable, classTable, c);
        if ((!e1.get_type().equals(TreeConstants.Int)) || (!e2.get_type().equals(TreeConstants.Int))) {
            classTable.semantError(c, this).println("Illegal expression arguments: " + e1.get_type().getString() + " + " + e2.get_type().getString());
        }
        this.set_type(TreeConstants.Int);
    }

}


/** Defines AST constructor 'sub'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class sub extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "sub" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public sub(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new sub(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "sub\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_sub");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        e2.checkType(symbolTable, classTable, c);
        if ((!e1.get_type().equals(TreeConstants.Int)) || (!e2.get_type().equals(TreeConstants.Int))) {
            classTable.semantError(c, this).println("Illegal expression arguments: " + e1.get_type().getString() + " - " + e2.get_type().getString());
        }
        
        this.set_type(TreeConstants.Int);
    }

}


/** Defines AST constructor 'mul'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class mul extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "mul" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public mul(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new mul(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "mul\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_mul");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        e2.checkType(symbolTable, classTable, c);
        if ((!e1.get_type().equals(TreeConstants.Int)) || (!e2.get_type().equals(TreeConstants.Int))) {
            classTable.semantError(c, this).println("Illegal expression arguments: " + e1.get_type().getString() + " * " + e2.get_type().getString());
        }
        
        this.set_type(TreeConstants.Int);
    }

}


/** Defines AST constructor 'divide'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class divide extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "divide" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public divide(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new divide(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "divide\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_divide");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        e2.checkType(symbolTable, classTable, c);
        if ((!e1.get_type().equals(TreeConstants.Int)) || (!e2.get_type().equals(TreeConstants.Int))) {
            classTable.semantError(c, this).println("Illegal expression arguments: " + e1.get_type().getString() + " / " + e2.get_type().getString());
        }
        
        this.set_type(TreeConstants.Int);
    }

}


/** Defines AST constructor 'neg'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class neg extends Expression {
    protected Expression e1;
    /** Creates "neg" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public neg(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new neg(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "neg\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_neg");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        if (!e1.get_type().equals(TreeConstants.Int)) {
            classTable.semantError(c, this).println("Wrong type: " + e1.get_type().getString() + " for negation");
        }
        this.set_type(TreeConstants.Int);
    }

}


/** Defines AST constructor 'lt'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class lt extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "lt" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public lt(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new lt(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "lt\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_lt");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        e2.checkType(symbolTable, classTable, c);
        if ((!e1.get_type().equals(TreeConstants.Int)) || (!e2.get_type().equals(TreeConstants.Int))) {
            classTable.semantError(c, this).println("Illegal expression arguments: " + e1.get_type().getString() + " < " + e2.get_type().getString());
        }
        
        this.set_type(TreeConstants.Bool);
    }

}


/** Defines AST constructor 'eq'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class eq extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "eq" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public eq(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new eq(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "eq\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_eq");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        e2.checkType(symbolTable, classTable, c);
        HashSet<String> s = new HashSet<String>();
        s.add("String");
        s.add("Bool");
        s.add("Int");
        if (s.contains(e1.get_type().getString()) || s.contains(e2.get_type().getString())) {
            if (!e1.get_type().equals(e2.get_type())) {
                classTable.semantError(c, this).println("Cannot check equality for inconsistent types: " + e1.get_type().getString() + " = " + e2.get_type().getString());
            }
        }
        
        this.set_type(TreeConstants.Bool);
    }

}


/** Defines AST constructor 'leq'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class leq extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "leq" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public leq(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new leq(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "leq\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_leq");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        e2.checkType(symbolTable, classTable, c);
        if ((!e1.get_type().equals(TreeConstants.Int)) || (!e2.get_type().equals(TreeConstants.Int))) {
            classTable.semantError(c, this).println("Illegal expression arguments: " + e1.get_type().getString() + " <= " + e2.get_type().getString());
        }
        
        this.set_type(TreeConstants.Bool);
    }

}


/** Defines AST constructor 'comp'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class comp extends Expression {
    protected Expression e1;
    /** Creates "comp" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public comp(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new comp(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "comp\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_comp");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

     public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        if (!e1.get_type().equals(TreeConstants.Bool)) {
            classTable.semantError(c, this).println("Wrong type: " + e1.get_type().getString() + " for complement");
        }
        this.set_type(TreeConstants.Bool);
    }

}


/** Defines AST constructor 'int_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class int_const extends Expression {
    protected AbstractSymbol token;
    /** Creates "int_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for token
      */
    public int_const(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        token = a1;
    }
    public TreeNode copy() {
        return new int_const(lineNumber, copy_AbstractSymbol(token));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "int_const\n");
        dump_AbstractSymbol(out, n+2, token);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_int");
	dump_AbstractSymbol(out, n + 2, token);
	dump_type(out, n);
    }


    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        
        this.set_type(TreeConstants.Int);
    }
}


/** Defines AST constructor 'bool_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class bool_const extends Expression {
    protected Boolean val;
    /** Creates "bool_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for val
      */
    public bool_const(int lineNumber, Boolean a1) {
        super(lineNumber);
        val = a1;
    }
    public TreeNode copy() {
        return new bool_const(lineNumber, copy_Boolean(val));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "bool_const\n");
        dump_Boolean(out, n+2, val);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_bool");
	dump_Boolean(out, n + 2, val);
	dump_type(out, n);
    }


    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        
        this.set_type(TreeConstants.Bool);
    }

}


/** Defines AST constructor 'string_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class string_const extends Expression {
    protected AbstractSymbol token;
    /** Creates "string_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for token
      */
    public string_const(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        token = a1;
    }
    public TreeNode copy() {
        return new string_const(lineNumber, copy_AbstractSymbol(token));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "string_const\n");
        dump_AbstractSymbol(out, n+2, token);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_string");
	out.print(Utilities.pad(n + 2) + "\"");
	Utilities.printEscapedString(out, token.getString());
	out.println("\"");
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        
        this.set_type(TreeConstants.Str);
    }

}


/** Defines AST constructor 'new_'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class new_ extends Expression {
    protected AbstractSymbol type_name;
    /** Creates "new_" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for type_name
      */
    public new_(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        type_name = a1;
    }
    public TreeNode copy() {
        return new new_(lineNumber, copy_AbstractSymbol(type_name));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "new_\n");
        dump_AbstractSymbol(out, n+2, type_name);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_new");
	dump_AbstractSymbol(out, n + 2, type_name);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        if (classTable.isClassDefined(type_name.getString())) {
            this.set_type(type_name);
        } else {
            classTable.semantError(c, this).println("Initialize new object to undefined type " + type_name.getString());
            this.set_type(TreeConstants.Object_);
        }
    }

}


/** Defines AST constructor 'isvoid'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class isvoid extends Expression {
    protected Expression e1;
    /** Creates "isvoid" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public isvoid(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new isvoid(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "isvoid\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_isvoid");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        e1.checkType(symbolTable, classTable, c);
        this.set_type(TreeConstants.Bool);
    }

}


/** Defines AST constructor 'no_expr'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class no_expr extends Expression {
    /** Creates "no_expr" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      */
    public no_expr(int lineNumber) {
        super(lineNumber);
    }
    public TreeNode copy() {
        return new no_expr(lineNumber);
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "no_expr\n");
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_no_expr");
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
       
        this.set_type(TreeConstants.No_type);
    }

}


/** Defines AST constructor 'object'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class object extends Expression {
    protected AbstractSymbol name;
    /** Creates "object" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      */
    public object(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        name = a1;
    }
    public TreeNode copy() {
        return new object(lineNumber, copy_AbstractSymbol(name));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "object\n");
        dump_AbstractSymbol(out, n+2, name);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_object");
	dump_AbstractSymbol(out, n + 2, name);
	dump_type(out, n);
    }

    public void checkType(SymbolTable symbolTable, ClassTable classTable, class_c c) {
        //if the identifier is not defined in symbolTable, check if it's a class attribute
        AbstractSymbol result = (AbstractSymbol)symbolTable.lookup(name);
        if (result == null) {
            result = classTable.attrType(c, name);
            if (result == null) {
                classTable.semantError(c, this).println("undefined identifier " + name.getString());
                result = TreeConstants.Object_;
            }
        }
        this.set_type(result);
    }

}



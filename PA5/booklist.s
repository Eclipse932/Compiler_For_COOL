	.data
	.align	2
	.globl	class_nameTab
	.globl	Main_protObj
	.globl	Int_protObj
	.globl	String_protObj
	.globl	bool_const0
	.globl	bool_const1
	.globl	_int_tag
	.globl	_bool_tag
	.globl	_string_tag
_int_tag:
	.word	7
_bool_tag:
	.word	8
_string_tag:
	.word	9
	.globl	_MemMgr_INITIALIZER
_MemMgr_INITIALIZER:
	.word	_GenGC_Init
	.globl	_MemMgr_COLLECTOR
_MemMgr_COLLECTOR:
	.word	_GenGC_Collect
	.globl	_MemMgr_TEST
_MemMgr_TEST:
	.word	0
	.word	-1
str_const27:
	.word	9
	.word	5
	.word	String_dispTab
	.word	int_const1
	.byte	0	
	.align	2
	.word	-1
str_const26:
	.word	9
	.word	6
	.word	String_dispTab
	.word	int_const2
	.ascii	"Main"
	.byte	0	
	.align	2
	.word	-1
str_const25:
	.word	9
	.word	5
	.word	String_dispTab
	.word	int_const3
	.ascii	"Nil"
	.byte	0	
	.align	2
	.word	-1
str_const24:
	.word	9
	.word	6
	.word	String_dispTab
	.word	int_const2
	.ascii	"Cons"
	.byte	0	
	.align	2
	.word	-1
str_const23:
	.word	9
	.word	7
	.word	String_dispTab
	.word	int_const4
	.ascii	"BookList"
	.byte	0	
	.align	2
	.word	-1
str_const22:
	.word	9
	.word	6
	.word	String_dispTab
	.word	int_const5
	.ascii	"Article"
	.byte	0	
	.align	2
	.word	-1
str_const21:
	.word	9
	.word	6
	.word	String_dispTab
	.word	int_const2
	.ascii	"Book"
	.byte	0	
	.align	2
	.word	-1
str_const20:
	.word	9
	.word	6
	.word	String_dispTab
	.word	int_const6
	.ascii	"String"
	.byte	0	
	.align	2
	.word	-1
str_const19:
	.word	9
	.word	6
	.word	String_dispTab
	.word	int_const2
	.ascii	"Bool"
	.byte	0	
	.align	2
	.word	-1
str_const18:
	.word	9
	.word	5
	.word	String_dispTab
	.word	int_const3
	.ascii	"Int"
	.byte	0	
	.align	2
	.word	-1
str_const17:
	.word	9
	.word	5
	.word	String_dispTab
	.word	int_const7
	.ascii	"IO"
	.byte	0	
	.align	2
	.word	-1
str_const16:
	.word	9
	.word	6
	.word	String_dispTab
	.word	int_const6
	.ascii	"Object"
	.byte	0	
	.align	2
	.word	-1
str_const15:
	.word	9
	.word	7
	.word	String_dispTab
	.word	int_const8
	.ascii	"_prim_slot"
	.byte	0	
	.align	2
	.word	-1
str_const14:
	.word	9
	.word	7
	.word	String_dispTab
	.word	int_const9
	.ascii	"SELF_TYPE"
	.byte	0	
	.align	2
	.word	-1
str_const13:
	.word	9
	.word	7
	.word	String_dispTab
	.word	int_const9
	.ascii	"_no_class"
	.byte	0	
	.align	2
	.word	-1
str_const12:
	.word	9
	.word	8
	.word	String_dispTab
	.word	int_const10
	.ascii	"<basic class>"
	.byte	0	
	.align	2
	.word	-1
str_const11:
	.word	9
	.word	7
	.word	String_dispTab
	.word	int_const11
	.ascii	"PC Magazine"
	.byte	0	
	.align	2
	.word	-1
str_const10:
	.word	9
	.word	6
	.word	String_dispTab
	.word	int_const5
	.ascii	"Ulanoff"
	.byte	0	
	.align	2
	.word	-1
str_const9:
	.word	9
	.word	9
	.word	String_dispTab
	.word	int_const12
	.ascii	"The Top 100 CD_ROMs"
	.byte	0	
	.align	2
	.word	-1
str_const8:
	.word	9
	.word	10
	.word	String_dispTab
	.word	int_const13
	.ascii	"Aho, Sethi, and Ullman"
	.byte	0	
	.align	2
	.word	-1
str_const7:
	.word	9
	.word	16
	.word	String_dispTab
	.word	int_const14
	.ascii	"Compilers, Principles, Techniques, and Tools"
	.byte	0	
	.align	2
	.word	-1
str_const6:
	.word	9
	.word	12
	.word	String_dispTab
	.word	int_const15
	.ascii	"- dynamic type was Article -\n"
	.byte	0	
	.align	2
	.word	-1
str_const5:
	.word	9
	.word	11
	.word	String_dispTab
	.word	int_const16
	.ascii	"- dynamic type was Book -\n"
	.byte	0	
	.align	2
	.word	-1
str_const4:
	.word	9
	.word	8
	.word	String_dispTab
	.word	int_const10
	.ascii	"periodical:  "
	.byte	0	
	.align	2
	.word	-1
str_const3:
	.word	9
	.word	8
	.word	String_dispTab
	.word	int_const17
	.ascii	"author:     "
	.byte	0	
	.align	2
	.word	-1
str_const2:
	.word	9
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"\n"
	.byte	0	
	.align	2
	.word	-1
str_const1:
	.word	9
	.word	8
	.word	String_dispTab
	.word	int_const17
	.ascii	"title:      "
	.byte	0	
	.align	2
	.word	-1
str_const0:
	.word	9
	.word	8
	.word	String_dispTab
	.word	int_const17
	.ascii	"book_list.cl"
	.byte	0	
	.align	2
	.word	-1
int_const17:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	12
	.word	-1
int_const16:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	26
	.word	-1
int_const15:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	29
	.word	-1
int_const14:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	44
	.word	-1
int_const13:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	22
	.word	-1
int_const12:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	19
	.word	-1
int_const11:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	11
	.word	-1
int_const10:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	13
	.word	-1
int_const9:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	9
	.word	-1
int_const8:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	10
	.word	-1
int_const7:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	2
	.word	-1
int_const6:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	6
	.word	-1
int_const5:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	7
	.word	-1
int_const4:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	8
	.word	-1
int_const3:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	3
	.word	-1
int_const2:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	4
	.word	-1
int_const1:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	0
	.word	-1
int_const0:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	1
	.word	-1
bool_const0:
	.word	8
	.word	4
	.word	Bool_dispTab
	.word	0
	.word	-1
bool_const1:
	.word	8
	.word	4
	.word	Bool_dispTab
	.word	1
class_nameTab:
	.word	str_const16
	.word	str_const17
	.word	str_const21
	.word	str_const22
	.word	str_const23
	.word	str_const24
	.word	str_const25
	.word	str_const18
	.word	str_const19
	.word	str_const20
	.word	str_const26
class_objTab:
	.word	Object_protObj
	.word	Object_init
	.word	IO_protObj
	.word	IO_init
	.word	Book_protObj
	.word	Book_init
	.word	Article_protObj
	.word	Article_init
	.word	BookList_protObj
	.word	BookList_init
	.word	Cons_protObj
	.word	Cons_init
	.word	Nil_protObj
	.word	Nil_init
	.word	Int_protObj
	.word	Int_init
	.word	Bool_protObj
	.word	Bool_init
	.word	String_protObj
	.word	String_init
	.word	Main_protObj
	.word	Main_init
Object_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
IO_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
Book_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Book.initBook
	.word	Book.print
Article_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Book.initBook
	.word	Article.print
	.word	Article.initArticle
BookList_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	BookList.isNil
	.word	BookList.cons
	.word	BookList.car
	.word	BookList.cdr
	.word	BookList.print_list
Cons_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Cons.isNil
	.word	BookList.cons
	.word	Cons.car
	.word	Cons.cdr
	.word	Cons.print_list
	.word	Cons.init
Nil_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Nil.isNil
	.word	BookList.cons
	.word	BookList.car
	.word	BookList.cdr
	.word	Nil.print_list
Int_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
Bool_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
String_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	String.length
	.word	String.concat
	.word	String.substr
Main_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	Main.main
	.word	-1
Object_protObj:
	.word	0
	.word	3
	.word	Object_dispTab
	.word	-1
IO_protObj:
	.word	1
	.word	3
	.word	IO_dispTab
	.word	-1
Book_protObj:
	.word	2
	.word	5
	.word	Book_dispTab
	.word	str_const27
	.word	str_const27
	.word	-1
Article_protObj:
	.word	3
	.word	6
	.word	Article_dispTab
	.word	str_const27
	.word	str_const27
	.word	str_const27
	.word	-1
BookList_protObj:
	.word	4
	.word	3
	.word	BookList_dispTab
	.word	-1
Cons_protObj:
	.word	5
	.word	5
	.word	Cons_dispTab
	.word	0
	.word	0
	.word	-1
Nil_protObj:
	.word	6
	.word	3
	.word	Nil_dispTab
	.word	-1
Int_protObj:
	.word	7
	.word	4
	.word	Int_dispTab
	.word	0
	.word	-1
Bool_protObj:
	.word	8
	.word	4
	.word	Bool_dispTab
	.word	0
	.word	-1
String_protObj:
	.word	9
	.word	5
	.word	String_dispTab
	.word	int_const1
	.word	0
	.word	-1
Main_protObj:
	.word	10
	.word	4
	.word	Main_dispTab
	.word	0
	.globl	heap_start
heap_start:
	.word	0
	.text
	.globl	Main_init
	.globl	Int_init
	.globl	String_init
	.globl	Bool_init
	.globl	Main.main
Object_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
IO_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Book_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	IO_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Article_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Book_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
BookList_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	IO_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Cons_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	BookList_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Nil_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	BookList_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Int_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Bool_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
String_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Main_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Book.initBook:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	lw	$a0 16($fp)
	sw	$a0 12($s0)
	addiu	$a1 $s0 12
	jal	_GenGC_Assign
	lw	$a0 12($fp)
	sw	$a0 16($s0)
	addiu	$a1 $s0 16
	jal	_GenGC_Assign
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 20
	jr	$ra	
Book.print:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp -4
	la	$a0 str_const2
	sw	$a0 4($sp)
	addiu	$sp $sp -4
	lw	$a0 12($s0)
	sw	$a0 4($sp)
	addiu	$sp $sp -4
	la	$a0 str_const1
	sw	$a0 4($sp)
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label0
	la	$a0 str_const0
	li	$t1 17
	jal	_dispatch_abort
label0:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label1
	la	$a0 str_const0
	li	$t1 17
	jal	_dispatch_abort
label1:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label2
	la	$a0 str_const0
	li	$t1 17
	jal	_dispatch_abort
label2:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	addiu	$sp $sp -4
	la	$a0 str_const2
	sw	$a0 4($sp)
	addiu	$sp $sp -4
	lw	$a0 16($s0)
	sw	$a0 4($sp)
	addiu	$sp $sp -4
	la	$a0 str_const3
	sw	$a0 4($sp)
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label3
	la	$a0 str_const0
	li	$t1 18
	jal	_dispatch_abort
label3:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label4
	la	$a0 str_const0
	li	$t1 18
	jal	_dispatch_abort
label4:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label5
	la	$a0 str_const0
	li	$t1 18
	jal	_dispatch_abort
label5:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Article.print:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp 0
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label6
	la	$a0 str_const0
	li	$t1 38
	jal	_dispatch_abort
label6:
	la	$t1 Book_dispTab
	lw	$t1 32($t1)
	jalr	$t1
	addiu	$sp $sp 4
	addiu	$sp $sp -4
	la	$a0 str_const2
	sw	$a0 4($sp)
	addiu	$sp $sp -4
	lw	$a0 20($s0)
	sw	$a0 4($sp)
	addiu	$sp $sp -4
	la	$a0 str_const4
	sw	$a0 4($sp)
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label7
	la	$a0 str_const0
	li	$t1 39
	jal	_dispatch_abort
label7:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label8
	la	$a0 str_const0
	li	$t1 39
	jal	_dispatch_abort
label8:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label9
	la	$a0 str_const0
	li	$t1 39
	jal	_dispatch_abort
label9:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Article.initArticle:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp -8
	lw	$a0 20($fp)
	sw	$a0 8($sp)
	lw	$a0 16($fp)
	sw	$a0 4($sp)
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label10
	la	$a0 str_const0
	li	$t1 30
	jal	_dispatch_abort
label10:
	lw	$t1 8($a0)
	lw	$t1 28($t1)
	jalr	$t1
	addiu	$sp $sp 4
	lw	$a0 12($fp)
	sw	$a0 20($s0)
	addiu	$a1 $s0 20
	jal	_GenGC_Assign
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 24
	jr	$ra	
BookList.isNil:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp 0
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label11
	la	$a0 str_const0
	li	$t1 50
	jal	_dispatch_abort
label11:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr	$t1
	addiu	$sp $sp 4
	la	$a0 bool_const1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
BookList.cons:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	la	$a0 Cons_protObj
	jal	Object.copy
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	jal	Cons_init
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	addiu	$sp $sp -8
	lw	$a0 12($fp)
	sw	$a0 8($sp)
	move	$a0 $s0
	sw	$a0 4($sp)
	lw	$a0 -4($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label12
	la	$a0 str_const0
	li	$t1 54
	jal	_dispatch_abort
label12:
	lw	$t1 8($a0)
	lw	$t1 48($t1)
	jalr	$t1
	addiu	$sp $sp 4
	addiu	$sp $sp 4
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 16
	jr	$ra	
BookList.car:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp 0
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label13
	la	$a0 str_const0
	li	$t1 62
	jal	_dispatch_abort
label13:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr	$t1
	addiu	$sp $sp 4
	la	$a0 Book_protObj
	jal	Object.copy
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	jal	Book_init
	addiu	$sp $sp 4
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
BookList.cdr:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp 0
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label14
	la	$a0 str_const0
	li	$t1 68
	jal	_dispatch_abort
label14:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr	$t1
	addiu	$sp $sp 4
	la	$a0 BookList_protObj
	jal	Object.copy
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	jal	BookList_init
	addiu	$sp $sp 4
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
BookList.print_list:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp 0
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label15
	la	$a0 str_const0
	li	$t1 70
	jal	_dispatch_abort
label15:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr	$t1
	addiu	$sp $sp 4
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Cons.isNil:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	la	$a0 bool_const0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Cons.car:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	lw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Cons.cdr:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	lw	$a0 16($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Cons.print_list:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp 0
	lw	$a0 12($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label16
	la	$a0 str_const0
	li	$t1 95
	jal	_dispatch_abort
label16:
	lw	$t1 8($a0)
	lw	$t1 32($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$s1 0($sp)
	addiu	$sp $sp -4
	sw	$s2 0($sp)
	addiu	$sp $sp -4
	move	$s1 $a0
	bne	$s1 $zero label17
	la	$a0 str_const0
	li	$t1 95
	jal	_case_abort2
label17:
	lw	$s2 0($s1)
	li	$t1 3
	beq	$t1 $s2 label19
	b	label20
label19:
	sw	$s1 0($sp)
	addiu	$sp $sp -4
	addiu	$sp $sp -4
	la	$a0 str_const6
	sw	$a0 4($sp)
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label21
	la	$a0 str_const0
	li	$t1 97
	jal	_dispatch_abort
label21:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	addiu	$sp $sp 4
	b	label18
label20:
	li	$t1 3
	beq	$t1 $s2 label22
	li	$t1 2
	beq	$t1 $s2 label22
	b	label23
label22:
	sw	$s1 0($sp)
	addiu	$sp $sp -4
	addiu	$sp $sp -4
	la	$a0 str_const5
	sw	$a0 4($sp)
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label24
	la	$a0 str_const0
	li	$t1 96
	jal	_dispatch_abort
label24:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr	$t1
	addiu	$sp $sp 4
	addiu	$sp $sp 4
	b	label18
label23:
	move	$a0 $s1
	jal	_case_abort
label18:
	lw	$s2 4($sp)
	lw	$s1 8($sp)
	addiu	$sp $sp 8
	addiu	$sp $sp 0
	lw	$a0 16($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label25
	la	$a0 str_const0
	li	$t1 99
	jal	_dispatch_abort
label25:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr	$t1
	addiu	$sp $sp 4
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Cons.init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	lw	$a0 16($fp)
	sw	$a0 12($s0)
	addiu	$a1 $s0 12
	jal	_GenGC_Assign
	lw	$a0 12($fp)
	sw	$a0 16($s0)
	addiu	$a1 $s0 16
	jal	_GenGC_Assign
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 20
	jr	$ra	
Nil.isNil:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	la	$a0 bool_const1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Nil.print_list:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	la	$a0 bool_const1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Main.main:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	addiu	$sp $sp -8
	la	$a0 str_const7
	sw	$a0 8($sp)
	la	$a0 str_const8
	sw	$a0 4($sp)
	la	$a0 Book_protObj
	jal	Object.copy
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	jal	Book_init
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label26
	la	$a0 str_const0
	li	$t1 117
	jal	_dispatch_abort
label26:
	lw	$t1 8($a0)
	lw	$t1 28($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	addiu	$sp $sp -12
	la	$a0 str_const9
	sw	$a0 12($sp)
	la	$a0 str_const10
	sw	$a0 8($sp)
	la	$a0 str_const11
	sw	$a0 4($sp)
	la	$a0 Article_protObj
	jal	Object.copy
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	jal	Article_init
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label27
	la	$a0 str_const0
	li	$t1 121
	jal	_dispatch_abort
label27:
	lw	$t1 8($a0)
	lw	$t1 36($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	addiu	$sp $sp -4
	lw	$a0 -8($fp)
	sw	$a0 4($sp)
	addiu	$sp $sp -4
	lw	$a0 -4($fp)
	sw	$a0 4($sp)
	la	$a0 Nil_protObj
	jal	Object.copy
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	jal	Nil_init
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label28
	la	$a0 str_const0
	li	$t1 126
	jal	_dispatch_abort
label28:
	lw	$t1 8($a0)
	lw	$t1 32($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label29
	la	$a0 str_const0
	li	$t1 126
	jal	_dispatch_abort
label29:
	lw	$t1 8($a0)
	lw	$t1 32($t1)
	jalr	$t1
	addiu	$sp $sp 4
	sw	$a0 12($s0)
	addiu	$a1 $s0 12
	jal	_GenGC_Assign
	addiu	$sp $sp 0
	lw	$a0 12($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	bne	$a0 $zero label30
	la	$a0 str_const0
	li	$t1 127
	jal	_dispatch_abort
label30:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr	$t1
	addiu	$sp $sp 4
	addiu	$sp $sp 4
	addiu	$sp $sp 4
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
#ANN(COOLCLASS, "Object", "_no_class")
#ANN(COOLMETHOD, "Object", "abort", "Object")
#ANN(COOLMETHOD, "Object", "type_name", "String")
#ANN(COOLMETHOD, "Object", "copy", "SELF_TYPE")
#ANN(COOLCLASS, "String", "Object", "Int", "_prim_slot")
#ANN(COOLMETHOD, "String", "length", "Int")
#ANN(COOLMETHOD, "String", "concat", "String", "String")
#ANN(COOLMETHOD, "String", "substr", "Int", "Int", "String")
#ANN(COOLCLASS, "Bool", "Object", "_prim_slot")
#ANN(COOLCLASS, "Int", "Object", "_prim_slot")
#ANN(COOLCLASS, "IO", "Object")
#ANN(COOLMETHOD, "IO", "out_string", "String", "SELF_TYPE")
#ANN(COOLMETHOD, "IO", "out_int", "Int", "SELF_TYPE")
#ANN(COOLMETHOD, "IO", "in_string", "String")
#ANN(COOLMETHOD, "IO", "in_int", "Int")
#ANN(COOLCLASS, "Book","IO", "String", "String")
  #ANN(COOLMETHOD, "Book", "initBook", "String", "String", "Book")
  #ANN(COOLMETHOD, "Book", "print", "Book")
#ANN(COOLCLASS, "Article","Book", "String")
  #ANN(COOLMETHOD, "Article", "initArticle", "String", "String", "String", "Article")
  #ANN(COOLMETHOD, "Article", "print", "Book")
#ANN(COOLCLASS, "BookList","IO")
  #ANN(COOLMETHOD, "BookList", "isNil", "Bool")
  #ANN(COOLMETHOD, "BookList", "cons", "Book", "Cons")
  #ANN(COOLMETHOD, "BookList", "car", "Book")
  #ANN(COOLMETHOD, "BookList", "cdr", "BookList")
  #ANN(COOLMETHOD, "BookList", "print_list", "Object")
#ANN(COOLCLASS, "Cons","BookList", "Book", "BookList")
  #ANN(COOLMETHOD, "Cons", "isNil", "Bool")
  #ANN(COOLMETHOD, "Cons", "init", "Book", "BookList", "Cons")
  #ANN(COOLMETHOD, "Cons", "car", "Book")
  #ANN(COOLMETHOD, "Cons", "cdr", "BookList")
  #ANN(COOLMETHOD, "Cons", "print_list", "Object")
#ANN(COOLCLASS, "Nil","BookList")
  #ANN(COOLMETHOD, "Nil", "isNil", "Bool")
  #ANN(COOLMETHOD, "Nil", "print_list", "Object")
#ANN(COOLCLASS, "Main","Object", "BookList")
  #ANN(COOLMETHOD, "Main", "main", "Object")

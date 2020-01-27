grammar MuJs;

@header {
    package it.univr.main;
}

ASG: '=';

NAN: 'NaN'
	;

BOOL: 'true' 
	| 'false';

SEMICOLON: ';';

ID: [a-z]+
	;

SIGN: '+' | '-';

INT: SIGN? [0-9]+ 
	;

STRING: '"' ~('\r' | '\n' | '"')* '"'
	| 	'\'' ~('\r' | '\n' )* '\'';
	
LESS : '<'
	;	
	
program: stmt EOF 														#ProgramExecution
	;
	
	
aexp : INT													#Int
	|	ID													#IdAExp
	|	aexp '+' aexp										#Sum
	|	aexp '-' aexp										#Diff
	|	aexp '*' aexp										#Mul
	|	aexp '/' aexp										#Div
	| 	'toNum' '(' sexp ')'								#ToNum
	|	'(' aexp ')'										#AExpPar
	|	'length' '(' sexp ')'								#Length
	;

bexp: BOOL													#Bool
	|	ID													#IdBExp
	|	aexp '<' aexp										#Less
	|	aexp '==' aexp										#Equals	
	|	bexp '&&' bexp										#And
	|	bexp '||' bexp										#Or
	|	'!' bexp											#Not
	|	'(' bexp ')'										#BExpPar
	;

sexp: STRING												#Str
	|	ID													#IdSExp
	|	'concat(' sexp ',' sexp ')'							#Concat
	|	'(' sexp ')'										#SExpPar
	|	'charAt' '(' sexp ',' aexp ')'						#CharAt
	;

exp : aexp 													#AeExp
	| sexp 													#SeExp
	| bexp 													#BeExp
	;
	
stmt:
	   ID ASG exp SEMICOLON									#AssignmentStmt
	| 'if' '(' bexp ')' block 'else' block					#IfStmt
	| 'while' '(' bexp ')' block							#WhileStmt
	|  block												#BlockStmt
	|  stmt stmt											#Composition
	;
	
block:  '{' '}'													
	|	'{' stmt '}'											
	;	
	
WS: [ \r\n\t] + -> skip
   ;
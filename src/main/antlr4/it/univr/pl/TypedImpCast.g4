grammar TypedImpCast;

@header {
package it.univr.pl;
}

main : com EOF ;

com : TYPE ID (ASSIGN exp)?                                        # decl
    | ID ASSIGN exp                                                # assign
    | ID INC                                                       # postInc
    | INC ID                                                       # preInc
    | ID DECR                                                      # postDecr
    | DECR ID                                                      # preDecr
   | ID op=(ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN) exp # compAssign
    | IF LPAR exp RPAR LBRACE com RBRACE                           # if
    | IF LPAR exp RPAR LBRACE com RBRACE ELSE LBRACE com RBRACE    # ifElse
    | WHILE LPAR exp RPAR LBRACE com RBRACE                        # while
    | com SEMICOLON com                                            # seq
    | OUT exp                                                      # out
    | NOP                                                          # nop
    ;

exp : num                                 # numeric
    | BOOL                                # boolean
    | STRING                              # string
    | ID                                  # id
    | <assoc=right> exp POW exp           # pow
    | TOSTR LPAR exp RPAR                 # tostr
    | exp op=(MUL | DIV | MOD) exp        # mulDivMod
    | exp op=(ADD | SUB) exp              # addSub
    | exp op=(LT | LEQ | GEQ | GT) exp    # cmpExp
    | exp op=(EQQ | NEQ) exp              # eqExp
    | exp op=(AND | OR) exp               # andOr
    | <assoc=right> exp QUESTION exp CONCAT exp          # ternary
    | exp CONCAT exp                      # concat
    | NOT exp                             # not
    | LPAR exp RPAR                       # parExp
    | LPAR TYPE RPAR exp                  # cast
    ;

num : INT     # intNum
    | DEC     # decNum
    ;

ADD_ASSIGN : '+=' ;
SUB_ASSIGN : '-=' ;
MUL_ASSIGN : '*=' ;
DIV_ASSIGN : '/=' ;

INC : '++'  ;
ADD : '+'   ;
DECR : '--' ;
SUB : '-'   ;
MUL : '*'   ;
DIV : '/'   ;
MOD : 'mod' ;
POW : '^'   ;

EQQ : '=='  ;
NEQ : '!='  ;
LEQ : '<='  ;
GEQ : '>='  ;
LT  : '<'   ;
GT  : '>'   ;
NOT : 'not' ;
AND : 'and' ;
OR  : 'or'  ;

QUESTION  : '?' ;
CONCAT : ':' ;
TOSTR  : 'toStr' ;

IF     : 'if'    ;
ELSE   : 'else'  ;
WHILE  : 'while' ;
ASSIGN : '='     ;
OUT    : 'print' ;
NOP    : 'nop'   ;

LPAR      : '(' ;
RPAR      : ')' ;
LBRACE    : '{' ;
RBRACE    : '}' ;
SEMICOLON : ';' ;

BOOL   : 'true' | 'false'           ;
INT    : NAT | '-' POS              ;
DEC    : (INT | '-' '0') '.' DIGIT+ ;
STRING : '"' STRCHR* '"'            ;

fragment NAT      : '0' | POS        ;
fragment POS      : POSDIGIT DIGIT*  ;
fragment DIGIT    : '0' | POSDIGIT   ;
fragment POSDIGIT : [1-9]            ;
fragment STRCHR   : ~["\\\r\n] | ESC ;
fragment ESC      : '\\' [btnfr"'\\] ;

TYPE : 'int' | 'dec' | 'bool' | 'string' ;

ID : [a-z]+ ;

COMMENT : '//' ~[\r\n]* -> skip ;
WS      : [ \t\r\n]+ -> skip    ;
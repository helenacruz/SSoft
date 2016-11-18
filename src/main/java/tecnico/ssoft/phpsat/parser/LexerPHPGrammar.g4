lexer grammar LexerPHPGrammar;

ECHO : 'echo'
     ;

STAR : '*'
     ;

EQUAL : '='
      ;

DOUBLE_QUOTES : '"'
              ;

COMMA : ','
      ;

DOT : '.'
    ;

CODE_START : '<?php'
           ;

CODE_END : '?>'
         ;

LESS : '<'
     ;

GREATER : '>'
        ;

ID : [a-zA-Z][_a-zA-Z0-9]*
   ;

INT : [0-9]+
    ;

VAR : '$' [a-zA-Z_][a-zA-Z_0-9]*
    ;

SINGLE_QUOTE: '\''
            ;

WS : [ \t\n\r]+ -> skip
   ;

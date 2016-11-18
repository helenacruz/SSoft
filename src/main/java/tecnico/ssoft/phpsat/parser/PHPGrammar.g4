grammar PHPGrammar;

import LexerPHPGrammar;

prog : statements
     ;

statements : statements statement
           | statement
           ;

statement : assignment ';'
          | function ';'
          | html
          ;

assignment : variable '=' variable
           | variable '=' value
           | variable '=' function
           ;

function : regularFunction
         | echo
         ;

echo : ECHO arg
     ;

regularFunction : ID '(' args ')'
                | ID '(' ')'
                ;

variable : VAR '[' SINGLE_QUOTE ID SINGLE_QUOTE ']'
         | VAR '[' DOUBLE_QUOTES ID DOUBLE_QUOTES ']'
         | VAR
         ;

value : '"' stringValues '"'
      ;

stringValues : stringValues stringValue
              | stringValue
              ;

stringValue : ID
            | INT
            | DOT
            | STAR
            | EQUAL
            | COMMA
            | SINGLE_QUOTE
            | DOUBLE_QUOTES
            | variable
            ;

args : args COMMA arg
     | arg
     ;

arg : variable
    | value
    | function
    ;

html : html tag
     | tag
     ;

tag : LESS ID GREATER
    | LESS '/' ID GREATER
    | LESS ID option+ GREATER
    | LESS ID option+ '/' GREATER
    ;

option : ID '=' '"' CODE_START htmlStatements CODE_END '"'
       | ID '=' '"' CODE_START htmlStatement ';' CODE_END '"'
       | ID '=' '"' ID '"'
       ;

htmlStatements : htmlStatements ';' htmlStatement
               | htmlStatement
               ;

htmlStatement : assignment
              | function
              ;
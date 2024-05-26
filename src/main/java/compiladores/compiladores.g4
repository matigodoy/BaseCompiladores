grammar compiladores;

@header {
package compiladores;
}

// Definimos los tokens
PARIZQ : '(';
PARDER : ')';
fragment DIGITO : [0-9] ;
WS : [ \t\n\r]+ -> skip ;
COMILLA : '"';
COMSIMPLE : '\'';
fragment LETRA : [A-Za-z];
PUNTOCOMA : ';';
COMA : ',';
LLAVEIZQ : '{';
LLAVEDER : '}';
CORCHETEIZQ : '[';
CORCHETEDER : ']';

// Operadores
IGUAL : '=';
MAYOR : '>';
MENOR : '<';
MAYORIGUAL : '>=';
MENORIGUAL : '<=';
DIFERENTE : '!=';
IGUALDAD : '==';
AND : '&&';
OR : '||';
NOT : '!';
INCREMENTO : '++';
DECREMENTO : '--';

// Operaciones
SUMA : '+';
RESTA : '-';
MULTIPLICACION : '*';
fragment DIVISION : '/';
MODULO : '%';

// Palabras reservadas
IF : 'if';
ELSE : 'else';
WHILE : 'while';
FOR : 'for';
RETURN : 'return';
TDATO : 'int' | 'float' | 'char' | 'string' | 'bool' | 'double' | 'void' | 'long' | 'short';
MAIN : 'main';
PRINT : 'print';

OPERADOR : SUMA | RESTA | MULTIPLICACION | DIVISION | MODULO;
LOGICO : AND | OR | NOT;

NUMERO : DIGITO+;
ID : (LETRA | '_')(LETRA | DIGITO | '_')* ;

// Definimos la estructura del programa
programa : instrucciones EOF;

instrucciones : instruccion*;

// Definimos las instrucciones
instruccion : declaracion
            | asignacion
            | ciclo
            | if
            | for
            | funcion
            | llamadaFuncion
            | comentario
            | retorno
            ;

declaracion : TDATO ID IGUAL (NUMERO | 'true' | 'false') PUNTOCOMA?;

asignacion : ID IGUAL expresion
        | ID INCREMENTO PUNTOCOMA?
        | ID DECREMENTO PUNTOCOMA?
        ;

expresion : exp PUNTOCOMA expresion?
        ;

exp : termino t;

termino : factor f;

t : SUMA termino t
    | RESTA termino t
//    | MULTIPLICACION termino t
//    | DIVISION termino t
//    | MODULO termino t
    |
    ;

factor : NUMERO
        | ID
        | PARIZQ exp PARDER
        ;

f : OPERADOR factor f
    | INCREMENTO
    | DECREMENTO
    |
    ;

condicion : (ID | NUMERO) MAYOR (ID | NUMERO)
            | (ID | NUMERO) MENOR (ID | NUMERO)
            | (ID | NUMERO) MAYORIGUAL (ID | NUMERO)
            | (ID | NUMERO) MENORIGUAL (ID | NUMERO)
            | (ID | NUMERO) DIFERENTE (ID | NUMERO)
            | (ID | NUMERO) IGUALDAD (ID | NUMERO)
            | (ID | NUMERO) LOGICO (ID | NUMERO)
            | NOT (ID | NUMERO)
            | PARIZQ condicion PARDER
            ;

condiciones : condicion LOGICO condiciones
            | condicion
            ;

retorno : RETURN (ID | NUMERO) PUNTOCOMA
        | RETURN exp PUNTOCOMA
        | RETURN PUNTOCOMA
        ;

bloque : LLAVEIZQ instruccion* LLAVEDER;

ciclo : WHILE PARIZQ condicion PARDER (bloque | instruccion)
        ;

if : IF PARIZQ condicion PARDER (bloque | instruccion) else?;

else : ELSE (bloque | instruccion);

for : FOR PARIZQ ((declaracion | asignacion) | PUNTOCOMA) (condiciones) PUNTOCOMA asignacion? PARDER (bloque | instruccion);

declaracionParametros : declaracion (declaracion)*
                        |
                        ;

parametros : (ID | NUMERO) (COMA (ID | NUMERO))*
            |
            ;

funcion : TDATO MAIN PARIZQ PARDER (bloque | instruccion);

imprimir : PRINT PARIZQ (COMILLA .*? COMILLA | COMSIMPLE .*? COMSIMPLE) PARDER;

llamadaFuncion : ID PARIZQ parametros PARDER PUNTOCOMA;

comentario : '//' .*? '\n';
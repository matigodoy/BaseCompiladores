grammar compiladores;

 @header {
 package compiladores;
 }


// Definimos los tokens
PARIZQ : '(';
PARDER : ')';
NUMERO : '0'..'9'+;
WS : (' ' | '\t' | '\n' | '\r') -> skip;
COMILLA : '"';
COMSIMPLE : '\'';
ID : ('a'..'z' | 'A'..'Z')+;
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
DIVISION : '/';
MODULO : '%';

// Palabras reservadas
IF : 'if';
ELSE : 'else';
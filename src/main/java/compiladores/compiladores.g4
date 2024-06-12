grammar compiladores;

@header {
package compiladores;
}

// Definimos los tokens
PARIZQ: '(';
PARDER: ')';
fragment DIGITO: [0-9];
WS: [ \t\n\r]+ -> skip;
COMILLA: '"';
COMSIMPLE: '\'';
fragment LETRA: [A-Za-z];
PUNTOCOMA: ';';
COMA: ',';
LLAVEIZQ: '{';
LLAVEDER: '}';
CORCHETEIZQ: '[';
CORCHETEDER: ']';

// Operadores
IGUAL: '=';
MAYOR: '>';
MENOR: '<';
MAYORIGUAL: '>=';
MENORIGUAL: '<=';
DIFERENTE: '!=';
IGUALDAD: '==';
AND: '&&';
OR: '||';
NOT: '!';
INCREMENTO: '++';
DECREMENTO: '--';

// Operaciones
SUMA: '+';
RESTA: '-';
MULTIPLICACION: '*';
fragment DIVISION: '/';
MODULO: '%';

// Palabras reservadas
IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
RETURN: 'return';
TDATO:
	'int'
	| 'float'
	| 'char'
	| 'string'
	| 'bool'
	| 'double'
	| 'void'
	| 'long'
	| 'short';
PRINT: 'print';

OPERADOR: SUMA | RESTA | MULTIPLICACION | DIVISION | MODULO;
LOGICO: AND | OR | NOT;

NUMERO: DIGITO+;
ID: (LETRA | '_') (LETRA | DIGITO | '_')*;

// Definimos la estructura del programa
programa: instrucciones EOF;

instrucciones: instruccion*;

// Definimos las instrucciones
instruccion:
	declaracion
	| asignacion
	| bloque
	| ciclo
	| if
	| for
	| funcion
	| llamadaFuncion
	| comentario
	| retorno;

declaracion:
	tipo ID inicializacion_variable lista_identificadores PUNTOCOMA
	| tipo ID PUNTOCOMA;

tipo: TDATO;

inicializacion_variable: IGUAL NUMERO |;

lista_identificadores:
	COMA ID inicializacion_variable lista_identificadores
	|;

asignacion:
	ID IGUAL expresion
	| ID INCREMENTO PUNTOCOMA?
	| ID DECREMENTO PUNTOCOMA?;

expresion: exp PUNTOCOMA expresion?;

exp: termino t;

termino: factor f;

t:
	SUMA termino t
	| RESTA termino t
	| MULTIPLICACION termino t
	| DIVISION termino t
	| MODULO termino t
	|;

factor: NUMERO | ID | PARIZQ exp PARDER;

f: OPERADOR factor f | INCREMENTO | DECREMENTO |;

condicion: PARIZQ comparacion listado_comparacion PARDER;

comparacion: factor comparador factor;

comparador:
	MAYOR
	| MENOR
	| MAYORIGUAL
	| MENORIGUAL
	| IGUALDAD
	| DIFERENTE;

listado_comparacion: LOGICO comparacion listado_comparacion |;

retorno:
	RETURN (ID | NUMERO) PUNTOCOMA
	| RETURN exp PUNTOCOMA
	| RETURN PUNTOCOMA;

bloque: LLAVEIZQ instruccion LLAVEDER;

ciclo: WHILE PARIZQ condicion PARDER (bloque | instruccion);

if: IF condicion (bloque | instruccion) else?;

else: ELSE (bloque | instruccion);

for:
	FOR PARIZQ ((declaracion | asignacion) | PUNTOCOMA) (
		comparacion
	) PUNTOCOMA asignacion? PARDER (bloque | instruccion);

declaracionParametros: declaracion (declaracion)* |;

parametros: (ID | NUMERO) (COMA (ID | NUMERO))* |;

funcion:
	TDATO ID PARIZQ declaracionParametros PARDER (
		bloque
		| instruccion
	);

imprimir:
	PRINT PARIZQ (COMILLA .*? COMILLA | COMSIMPLE .*? COMSIMPLE) PARDER;

llamadaFuncion: ID PARIZQ parametros PARDER PUNTOCOMA;

comentario: '//' .*?;
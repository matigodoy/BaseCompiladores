# Proyecto de Análisis y Representación de Gramáticas con ANTLR

## Descripción

Este proyecto tiene como objetivo la creación de un conjunto de reglas gramaticales, sintácticas y analíticas para interpretar cadenas de texto como si fueran código de un lenguaje de programación. Utilizando ANTLR, desarrollamos una serie de métodos en Java que definen cómo interpretar las entradas de texto. Como resultado, el sistema es capaz de analizar y representar visualmente cómo se procesan las entradas.

Por ejemplo, para un lenguaje similar a C++, el sistema sabe que una declaración `if` debe comenzar con la palabra clave `if`, seguida de una condición entre paréntesis `()`, y puede opcionalmente contener llaves `{}` si es de una sola línea.

## Características

- Definición de reglas gramaticales y sintácticas utilizando ANTLR.
- Análisis de cadenas de texto basadas en las reglas definidas.
- Representación visual del proceso de análisis.
- Soporte para estructuras comunes de lenguajes de programación como `if`, `for`, `while`, entre otros.

## Requisitos

- Java 8 o superior.
- ANTLR 4.

## Objetivo del Proyecto

El objetivo de este proyecto es permitir la interpretación y análisis de cadenas de texto como código de un lenguaje de programación. El sistema debe ser capaz de:

1. Leer una cadena de texto de entrada.
2. Aplicar reglas gramaticales y sintácticas definidas.
3. Generar una representación visual del proceso de análisis, mostrando cómo se interpreta cada parte del texto según las reglas definidas.

## Instalación

1. Clona este repositorio:
   ```sh
   git clone https://github.com/matigodoy/BaseCompiladores.git

## Modo de Uso

1. El usuario introduce una cadena de texto que representa un fragmento de código.
2. El sistema utiliza ANTLR para analizar la cadena de texto de acuerdo con las reglas gramaticales y sintácticas definidas en el proyecto.
3. Durante el análisis, el sistema genera una representación visual del proceso, mostrando cómo se interpretan las diferentes partes del código.

### Ejemplo

- **Entrada**: `if (x > 0) y = 1;`
- **Salida**: Una representación visual del análisis que muestra la estructura del `if` con su condición y la sentencia que ejecuta.



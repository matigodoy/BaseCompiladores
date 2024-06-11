# Proyecto de Validación Sintáctica y Semántica con ANTLR4

## Descripción

Este proyecto tiene como objetivo desarrollar una herramienta que valide la sintaxis y la semántica de un input basado en reglas gramaticales definidas previamente. Utilizando ANTLR4, se genera un árbol de sintaxis para las reglas establecidas en un archivo .g4 y, mediante la implementación de un caminante, un visitor y una tabla de símbolos, se validan los errores presentes en el input proporcionado, señalando los errores de manera precisa.

## Objetivo del Proyecto

El objetivo principal de este proyecto es crear una herramienta similar a un compilador que sea capaz de identificar y reportar errores sintácticos y semánticos en un input dado. La herramienta debe ser capaz de:

- Analizar el input basado en reglas gramaticales.
- Construir un árbol de sintaxis utilizando ANTLR4.
- Utilizar una tabla de símbolos para gestionar y verificar las declaraciones.
- Reportar los errores encontrados indicando la línea y la indole del error.

## Características

- **Análisis Sintáctico**: Construcción de un árbol de sintaxis a partir de reglas gramaticales definidas en ANTLR4.
- **Validación Semántica**: Uso de un visitor y una tabla de símbolos para validar semánticamente el input.
- **Detección de Errores**: Identificación y reporte de errores sintácticos y semánticos con información detallada sobre el tipo de error y su ubicación.
- **Extensibilidad**: Fácilmente extensible para soportar nuevas reglas gramaticales y tipos de errores.

## Requisitos

Para poder ejecutar este proyecto, necesitas tener instalados los siguientes componentes:

- [Java JDK 8 o superior](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [ANTLR4](https://www.antlr.org/download.html)

## Instalación

Sigue estos pasos para configurar y ejecutar el proyecto:

1. **Clonar el repositorio**:
    ```bash
    git clone https://github.com/matigodoy/BaseCompiladores.git
    ```

## Modo de Uso

Para ejecutar la herramienta y validar un input, sigue estos pasos:

1. **Proporciona el input a validar**: Puedes hacerlo escribiendo directamente el input en un archivo de texto.

2. **Ejecuta la herramienta**:

3. **Revisa los errores**: La herramienta reportará cualquier error sintáctico o semántico encontrado.

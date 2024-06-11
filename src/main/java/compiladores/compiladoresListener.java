// Generated from c:/Users/Manu/OneDrive - UNIVERSIDAD BLAS PASCAL/Estudios/UBP/9no SEMESTRE/TC/Parciales/Parcial 2/BaseCompiladores/src/main/java/compiladores/compiladores.g4 by ANTLR 4.13.1

package compiladores;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link compiladoresParser}.
 */
public interface compiladoresListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(compiladoresParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(compiladoresParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(compiladoresParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(compiladoresParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(compiladoresParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(compiladoresParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(compiladoresParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(compiladoresParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(compiladoresParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(compiladoresParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(compiladoresParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(compiladoresParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(compiladoresParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(compiladoresParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(compiladoresParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(compiladoresParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#t}.
	 * @param ctx the parse tree
	 */
	void enterT(compiladoresParser.TContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#t}.
	 * @param ctx the parse tree
	 */
	void exitT(compiladoresParser.TContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(compiladoresParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(compiladoresParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(compiladoresParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(compiladoresParser.FContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(compiladoresParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(compiladoresParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#condiciones}.
	 * @param ctx the parse tree
	 */
	void enterCondiciones(compiladoresParser.CondicionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#condiciones}.
	 * @param ctx the parse tree
	 */
	void exitCondiciones(compiladoresParser.CondicionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(compiladoresParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(compiladoresParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(compiladoresParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(compiladoresParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#ciclo}.
	 * @param ctx the parse tree
	 */
	void enterCiclo(compiladoresParser.CicloContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#ciclo}.
	 * @param ctx the parse tree
	 */
	void exitCiclo(compiladoresParser.CicloContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(compiladoresParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(compiladoresParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(compiladoresParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(compiladoresParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(compiladoresParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(compiladoresParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#declaracionParametros}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionParametros(compiladoresParser.DeclaracionParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#declaracionParametros}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionParametros(compiladoresParser.DeclaracionParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(compiladoresParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(compiladoresParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(compiladoresParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(compiladoresParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#imprimir}.
	 * @param ctx the parse tree
	 */
	void enterImprimir(compiladoresParser.ImprimirContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#imprimir}.
	 * @param ctx the parse tree
	 */
	void exitImprimir(compiladoresParser.ImprimirContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamadaFuncion(compiladoresParser.LlamadaFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamadaFuncion(compiladoresParser.LlamadaFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladoresParser#comentario}.
	 * @param ctx the parse tree
	 */
	void enterComentario(compiladoresParser.ComentarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladoresParser#comentario}.
	 * @param ctx the parse tree
	 */
	void exitComentario(compiladoresParser.ComentarioContext ctx);
}
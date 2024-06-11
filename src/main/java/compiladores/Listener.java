package compiladores;

import compiladores.tools.Function;
import compiladores.tools.Symbol;
import compiladores.tools.Variable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import compiladores.compiladoresParser.*;

import java.util.ArrayList;

public class Listener extends compiladoresBaseListener {

    //region Variables

    private Integer declarations = 0;
    private Integer errors = 0;
    private Integer nodes = 0;
    private Integer tokens = 0;
    private final Symbol symbolTable = Symbol.getInstance();

    //endregion

    //region Methods

    @Override
    public void enterPrograma(ProgramaContext ctx) {
        System.out.println("Entering Programa");
        this.symbolTable.addScope();
    }

    @Override
    public void exitPrograma(ProgramaContext ctx) {
        System.out.println("Exiting Programa");
        this.symbolTable.removeScope();

        System.out.println("Declarations: " + this.declarations);
        System.out.println("Errors: " + this.errors);
        System.out.println("Nodes: " + this.nodes);
        System.out.println("Tokens: " + this.tokens);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        this.nodes++;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        this.tokens++;
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        this.errors++;
    }

    @Override
    public void exitDeclaracion(DeclaracionContext ctx) {
        this.declarations++;
        System.out.println("Exiting Declaracion");

        String name = ctx.ID().getText();

        if(this.symbolTable.containsSymbol(name)) {
            System.out.println("Error: Variable " + name + " already declared");
            this.errors++;
        } else {
            String type = ctx.getChild(0).getText();
            boolean isInitialized = !(ctx.getChild(2).getText().isBlank());
            Variable variable = new Variable(name, type, isInitialized, false);
            this.symbolTable.addSymbol(name, variable);
        }
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        System.out.println("Exiting Asignacion");

        if(ctx.ID() != null){
            Variable symbol =symbolTable.getSymbol(ctx.ID().getText()).orElse(null);

            if(symbol == null){
                System.out.println("Error: Variable " + ctx.ID().getText() + " not declared");
                this.errors++;
            }
            else if (!symbol.getInitialized()){
                System.out.println("Error: Variable " + ctx.ID().getText() + " not initialized");
                this.errors++;
            }
        }
    }

    @Override
    public void exitImprimir(ImprimirContext ctx) {
        System.out.println("Exiting Imprimir");
    }

    @Override
    public void exitLlamadaFuncion(LlamadaFuncionContext ctx) {
        if(ctx.ID() != null){
            Variable symbol =symbolTable.getSymbol(ctx.ID().getText()).orElse(null);

            if(symbol == null){
                System.out.println("Error: Variable " + ctx.ID().getText() + " not declared");
                this.errors++;
            }
            else if (!symbol.getInitialized()){
                System.out.println("Error: Variable " + ctx.ID().getText() + " not initialized");
                this.errors++;
            }
        }
        if(!ctx.getChild(ctx.getChildCount() - 1).getText().equals(";")){
            System.out.println("Error: Missing semicolon");
            this.errors++;
        }
    }

    @Override
    public void exitFuncion(FuncionContext ctx) {
        System.out.println("Exiting Funcion");

        String name = ctx.ID().getText();

        if(this.symbolTable.containsSymbol(name)) {
            System.out.println("Error: Function " + name + " already declared");
            this.errors++;
        } else {
            String type = ctx.getChild(0).getText();
            Function function = new Function(name, type, false, false, new ArrayList<>());
            this.symbolTable.addSymbol(name, function);
        }
    }
}

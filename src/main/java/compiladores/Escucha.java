package compiladores;

import compiladores.tools.Function;
import compiladores.tools.Symbol;
import compiladores.tools.Variable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import compiladores.compiladoresParser.*;

import java.util.ArrayList;

public class Escucha extends compiladoresBaseListener {

    // region Variables

    private Integer declarations = 0;
    private Integer errors = 0;
    private Integer nodes = 0;
    private Integer tokens = 0;
    private final Symbol symbolTable = Symbol.getInstance();

    // endregion

    // region Methods

    @Override
    public void enterPrograma(ProgramaContext ctx) {
        super.enterPrograma(ctx);
        symbolTable.addScope();
    }

    @Override
    public void exitPrograma(ProgramaContext ctx) {
        super.exitPrograma(ctx);
        symbolTable.removeScope();

        System.out.println("Errors: " + this.errors);
        System.out.println("Nodes: " + this.nodes);
        System.out.println("Tokens: " + this.tokens);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
        this.nodes++;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
        this.tokens++;
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        this.errors++;
    }

    @Override
    public void exitDeclaracion(DeclaracionContext ctx) {
        super.exitDeclaracion(ctx);

        if (ctx.ID() != null) {
            String name = ctx.ID().getText();
            String type = ctx.getChild(0).getText();
            boolean initialized = ctx.getChildCount() > 3;
            Variable variable = new Variable(name, type, false, initialized);

            if (symbolTable.containsSymbol(name)) {
                System.out.println("Error: Variable " + name + " already declared");
                this.errors++;
            } else {
                symbolTable.addSymbol(name, variable);
                this.declarations++;
            }
        }

    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        super.exitAsignacion(ctx);

        if (ctx.ID() != null) {
            Variable symbol = symbolTable.getSymbol(ctx.ID().getText()).orElse(null);

            if (symbol == null) {
                System.out.println("Error: Variable " + ctx.ID().getText() + " not declared");
                this.errors++;
            } else if (!symbol.getInitialized()) {
                System.out.println("Error: Variable " + ctx.ID().getText() + " not initialized");
                this.errors++;
            }
        }
    }

    @Override
    public void exitImprimir(ImprimirContext ctx) {
        super.exitImprimir(ctx);
    }

    @Override
    public void exitLlamadaFuncion(LlamadaFuncionContext ctx) {
        super.exitLlamadaFuncion(ctx);
        if (ctx.ID() != null) {
            Variable symbol = symbolTable.getSymbol(ctx.ID().getText()).orElse(null);

            if (symbol == null) {
                System.out.println("Error: Variable " + ctx.ID().getText() + " not declared");
                this.errors++;
            } else if (!symbol.getInitialized()) {
                System.out.println("Error: Variable " + ctx.ID().getText() + " not initialized");
                this.errors++;
            }
        }
        if (!ctx.getChild(ctx.getChildCount() - 1).getText().equals(";")) {
            System.out.println("Error: Missing semicolon");
            this.errors++;
        }
    }

    @Override
    public void exitFuncion(FuncionContext ctx) {
        super.exitFuncion(ctx);

        String name = ctx.ID().getText();

        if (symbolTable.containsSymbol(name)) {
            System.out.println("Error: Function " + name + " already declared");
            this.errors++;
        } else {
            String type = ctx.getChild(0).getText();
            Function function = new Function(name, type, false, false, new ArrayList<>());
            symbolTable.addSymbol(name, function);
        }
    }

    @Override
    public void enterBloque(BloqueContext ctx) {
        super.enterBloque(ctx);
        symbolTable.addScope();
    }

    @Override
    public void exitBloque(BloqueContext ctx) {
        super.exitBloque(ctx);
        symbolTable.removeScope();

        if (!ctx.getChild(0).getText().equals("{")) {
            System.out.println("Error: Missing opening curly brace");
            this.errors++;
        }
        if (!ctx.getChild(ctx.getChildCount() - 1).getText().equals("}")) {
            System.out.println("Error: Missing closing curly brace");
            this.errors++;
        }
    }

    @Override
    public void exitRetorno(RetornoContext ctx) {
        super.exitRetorno(ctx);

        if (!ctx.getChild(0).getText().equals("return")) {
            System.out.println("Error: Missing return keyword");
            this.errors++;
        }
        if (!ctx.getChild(ctx.getChildCount() - 1).getText().equals(";")) {
            System.out.println("Error: Missing semicolon");
            this.errors++;
        }
    }

    @Override
    public void exitCondicion(CondicionContext ctx) {
        super.exitCondicion(ctx);

        if (!ctx.getChild(0).getText().equals("(")) {
            System.out.println("Error: Missing opening parenthesis");
            this.errors++;
        }
        if (!ctx.getChild(3).getText().equals(")")) {
            System.out.println("Error: Missing closing parenthesis");
            this.errors++;
        }
    }

    @Override
    public void exitCiclo(CicloContext ctx) {
        super.exitCiclo(ctx);

        if (!ctx.getChild(0).getText().equals("while")) {
            System.out.println("Error: Missing while keyword");
            this.errors++;
        }
        if (!ctx.getChild(2).getText().equals(")")) {
            System.out.println("Error: Missing closing parenthesis");
            this.errors++;
        }
    }

    // endregion
}

package compiladores;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import compiladores.compiladoresParser.*;

public class Listener extends compiladoresBaseListener {

    //region Variables

    private Integer declarations = 0;
    private Integer errors = 0;
    private Integer nodes = 0;
    private Integer tokens = 0;

    //endregion

    //region Methods
}

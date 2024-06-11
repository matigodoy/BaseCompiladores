package compiladores.tools;

import java.util.List;

public class Function extends Variable {
    private final List<DataType> args;

    public Function(String name, String dataType, Boolean initialized, Boolean used, List<DataType> args) {
        super(name, dataType, initialized, used);
        this.args = args;
    }

    public List<DataType> getArgs() {
        return args;
    }
}
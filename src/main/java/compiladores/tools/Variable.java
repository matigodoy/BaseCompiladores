package compiladores.tools;

public class Variable {
    private final String name;
    private final String dataType;
    private final Boolean initialized;
    private final Boolean used;

    public Variable(String name, String dataType, Boolean initialized, Boolean used) {
        this.name = name;
        this.dataType = dataType;
        this.initialized = initialized;
        this.used = used;
    }

    public String getName() {
        return name;
    }

    public String getDataType() {
        return dataType;
    }

    public Boolean getInitialized() {
        return initialized;
    }

    public Boolean getUsed() {
        return used;
    }
}

package compiladores.tools;

import java.util.*;

public class Symbol {
    private static Symbol instance;
    private final List<Map<String, Variable>> symbolTable;

    private Symbol() {
        symbolTable = new LinkedList<>();
    }

    public static synchronized Symbol getInstance() {
        if (instance == null) {
            instance = new Symbol();
        }
        return instance;
    }

    public void addScope() {
        symbolTable.add(new HashMap<>());
    }

    public void removeScope() {
        if(!symbolTable.isEmpty()) {
            symbolTable.remove(symbolTable.size() - 1);
        }
    }

    public void addSymbol(String name , Variable id) {
        if(name == null || name.isEmpty() || id == null || symbolTable.isEmpty() || containsSymbol(name)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        Map<String, Variable> currentScope = symbolTable.get(symbolTable.size() - 1);
        currentScope.put(name, id);
    }

    public Optional<Variable> getSymbol(String name) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            Map<String, Variable> actualContext = symbolTable.get(i);
            if (actualContext.containsKey(name)) {
                return Optional.of(actualContext.get(name));
            }
        }
        return Optional.empty();
    }

    public boolean containsSymbol(String name) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            Map<String, Variable> actualContext = symbolTable.get(i);
            if (actualContext.containsKey(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateActualContext(String name) {
        Map<String, Variable> contextoActual = symbolTable.get(symbolTable.size() - 1);
        return contextoActual.containsKey(name);
    }
}


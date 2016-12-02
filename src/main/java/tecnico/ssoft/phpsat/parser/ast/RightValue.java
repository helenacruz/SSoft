package tecnico.ssoft.phpsat.parser.ast;

import java.util.*;

public abstract class RightValue extends Node
{
    private boolean tainted;
    private List<String> sanitizationFunctions;

    public RightValue()
    {
        tainted = true; // default is tainted
        sanitizationFunctions = new ArrayList<>();
    }

    public void taint()
    {
        tainted = true;
    }

    public void untaint()
    {
        tainted = false;
    }

    public boolean isTainted()
    {
        return tainted;
    }

    public void addSanitizationFunction(String sanitizationFunction)
    {
        if (!this.sanitizationFunctions.contains(sanitizationFunction)) {
            this.sanitizationFunctions.add(sanitizationFunction);
        }
    }

    public void addSanitizationFunction(List<String> sanitizationFunctions)
    {
        for (String sanitizationFunction : sanitizationFunctions) {
            if (!this.sanitizationFunctions.contains(sanitizationFunction)) {
                this.sanitizationFunctions.add(sanitizationFunction);
            }
        }
    }

    public List<String> getSanitizationFunctions()
    {
        return sanitizationFunctions;
    }

    public boolean isSanitized()
    {
        return !sanitizationFunctions.isEmpty();
    }

    public void resetSanitizationFunctions()
    {
        sanitizationFunctions.clear();
    }

    public String sanitizationFunctionsToString()
    {
        String result = "";

        for (String sanitizationFunction : sanitizationFunctions) {
            result += sanitizationFunction + ", ";
        }

        if (result.length() > 2) {
            result = result.substring(0, result.length() - 2);
        }

        return result;
    }

    public abstract boolean isVariable();
}

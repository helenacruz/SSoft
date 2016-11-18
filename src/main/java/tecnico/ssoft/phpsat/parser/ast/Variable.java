package tecnico.ssoft.phpsat.parser.ast;

import java.util.List;

public class Variable extends RightValue
{
    private String name;
    private boolean entryPoint;
    private String entryPointName;
    private Value value;

    public Variable()
    {
        super();
        name = null;
        entryPoint = false;
        entryPointName = null;
        value = null;
    }

    public Variable(String name)
    {
        super();
        this.name = name;
        this.entryPoint = false;
        this.entryPointName = null;
        this.value = null;
    }

    public Variable(String name, boolean entryPoint)
    {
        super();
        this.name = name;
        this.entryPoint = entryPoint;
        this.entryPointName = name;
        this.value = null;
    }

    public Variable(String name, boolean entryPoint, String entryPointName)
    {
        super();
        this.name = name;
        this.entryPoint = entryPoint;
        this.entryPointName = entryPointName;
        this.value = null;
    }

    public Variable(String name, String value)
    {
        super();
        this.name = name;
        this.entryPoint = false;
        this.entryPointName = null;
        this.value = new Value(value);
    }

    @Override
    public boolean isVariable()
    {
        return true;
    }

    public void setEntryPoint(boolean entryPoint)
    {
        this.entryPoint = entryPoint;
    }

    public String getEntryPointName()
    {
        return entryPointName;
    }

    public void setEntryPointName(String entryPointName)
    {
        this.entryPointName = entryPointName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Value getValue()
    {
        return value;
    }

    public void setValue(Value value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        String result = "Variable: " + name;

        if (value != null) {
            result += " Value: " + value.toString();
        }
        if (entryPointName != null) {
            result += " Global name: " + entryPointName;
        }
        if (entryPoint) {
            result += " Global: true";
        }
        else {
            result += " Global: false";
        }
        if (isTainted()) {
            result += " Tainted: true";
        }
        else {
            result += " Tainted: false";
        }
        if (isSanitized()) {
            result += " Sanitized by " + getSanitizationFunctions();
        }
        else {
            result += " Not sanitized.";
        }

        return result;
    }

    public boolean isEntryPoint(List<String> entryPoints)
    {
        for (String entryPoint : entryPoints) {
            if (entryPoint.equals(name)) {
                return true;
            }
        }

        return false;
    }

    public boolean comesFromEntryPoint(List<String> entryPoints)
    {
        for (String entryPoint : entryPoints) {
            if (entryPoint.equals(entryPointName)) {
                return true;
            }
        }

        return false;
    }

    public String getEntryPoint(List<String> entryPoints)
    {
        for (String entryPoint : entryPoints) {
            if (entryPoint.equals(name)) {
                return name;
            }
            else if (entryPointName != null) {
                if (entryPoint.equals(entryPointName)) {
                    return name;
                }
            }
        }

        return null;
    }
}

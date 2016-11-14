package tecnico.ssoft.phpsat.parser.ast;

public class Variable extends RightValue
{
    private String name;
    private boolean global;
    private String globalName;
    private Value value;

    public Variable()
    {
        super();
        name = null;
        global = false;
        value = null;
    }

    public Variable(String name)
    {
        super();
        this.name = name;
        this.global = false;
        this.value = null;
    }

    public Variable(String name, boolean global)
    {
        super();
        this.name = name;
        this.global = true;
        this.globalName = name;
        this.value = null;
    }

    public Variable(String name, String value)
    {
        super();
        this.name = name;
        this.global = false;
        this.value = new Value(value);
    }

    @Override
    public boolean isVariable()
    {
        return true;
    }

    public boolean isGlobal()
    {
        return global;
    }

    public void setGlobal(boolean global)
    {
        this.global = global;
    }

    public String getGlobalName()
    {
        return globalName;
    }

    public void setGlobalName(String globalName)
    {
        this.globalName = globalName;
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
        if (globalName != null) {
            result += " Global name: " + globalName;
        }
        if (global) {
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

        return result;
    }
}

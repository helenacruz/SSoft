package tecnico.ssoft.phpsat.parser.ast;

public class Variable extends RightValue
{
    private String _name;
    private Value _value;

    public Variable()
    {
        super();
        _name = null;
        _value = null;
    }

    public Variable(String name)
    {
        super();
        _name = name;
        _value = null;
    }

    public Variable(String name, String value)
    {
        super();
        _name = name;
        _value = new Value(value);
    }

    @Override
    public boolean isVariable()
    {
        return true;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public Value getValue()
    {
        return _value;
    }

    public void setValue(Value value)
    {
        _value = value;
    }

    @Override
    public String toString()
    {
        if (_value != null) {
            return "Variable: " + _name + "\nValue:\n" + _value.toString();
        }
        else {
            return "Variable: " + _name;
        }
    }
}

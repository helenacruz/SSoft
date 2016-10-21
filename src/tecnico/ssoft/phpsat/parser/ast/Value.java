package tecnico.ssoft.phpsat.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class Value extends RightValue
{
    private String _value;
    private List<Variable> _variables;

    public Value(String value)
    {
        _value = value.trim();
        _variables = new ArrayList<Variable>();
        super.untaint(); // value is the only one that starts untainted
    }

    public String getValue()
    {
        return _value;
    }

    public void setValue(String value)
    {
        _value = value;
    }

    public List<Variable> getVariables()
    {
        return _variables;
    }

    public void setVariables(List<Variable> variables)
    {
        _variables = variables;
    }

    public void addVariable(Variable variable)
    {
        _variables.add(variable);
        if (variable.isTainted())
            super.taint();
    }

    public boolean hasVariables()
    {
        return !_variables.isEmpty();
    }

    @Override
    public boolean isVariable()
    {
        return _value.charAt(0) == '$';
    }

    public void checkTaint()
    {
        for (Variable variable : _variables) {
            super.untaint();
            if (variable.isTainted()) {
                super.taint();
                break;
            }
        }
    }

    @Override
    public String toString()
    {
        String res = "Value: " + _value + "\nVars: ";

        for (RightValue variable : _variables) {
            res += variable.toString() + "\n";
        }

        return res;
    }
}

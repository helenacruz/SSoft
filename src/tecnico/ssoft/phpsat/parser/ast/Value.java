package tecnico.ssoft.phpsat.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class Value extends RightValue
{
    private String value;
    private List<Variable> variables;

    public Value(String value)
    {
        this.value = value.trim();
        this.variables = new ArrayList<>();
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        value = value;
    }

    public List<Variable> getVariables()
    {
        return variables;
    }

    public void setVariables(List<Variable> variables)
    {
        this.variables = variables;
    }

    public void addVariable(Variable variable)
    {
        variables.add(variable);
        if (variable.isTainted())
            super.taint();
    }

    public boolean hasVariables()
    {
        return !variables.isEmpty();
    }

    @Override
    public boolean isVariable()
    {
        return value.charAt(0) == '$';
    }

    public void checkTaint()
    {
        for (Variable variable : variables) {
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
        String res = "Value: " + value;

        if (isTainted()) {
            res += " Tainted: true\nArgs:\n";
        }
        else {
            res += " Tainted: false\nArgs:\n";
        }

        for (RightValue variable : variables) {
            res += variable.toString() + "\n";
        }

        return res;
    }
}

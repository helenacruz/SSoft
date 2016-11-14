package tecnico.ssoft.phpsat.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class Function extends RightValue
{
    private String name;
    private List<RightValue> args;

    public Function()
    {
        super();
        name = null;
        args = new ArrayList<>();
    }

    public Function(String name)
    {
        super();
        this.name = name;
        this.args = new ArrayList<>();
    }

    public Function(String name, List<RightValue> args)
    {
        super();
        this.name = name;
        this.args = args;

    }

    @Override
    public boolean isVariable()
    {
        return false;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<RightValue> getArgs()
    {
        return args;
    }

    public void setArgs(List<RightValue> args)
    {
        this.args = args;
    }

    public void addArg(RightValue arg)
    {
        this.args.add(arg);
    }

    public boolean hasArgs()
    {
        return !args.isEmpty();
    }

    public void checkTaint()
    {
        for (RightValue arg : args) {
            super.untaint();
            if (arg.isTainted()) {
                super.taint();
                break;
            }
        }
    }

    public boolean isThisFunction(List<String> functions)
    {
        for (String function : functions) {
            if (function.equals(name)) {
                return true;
            }
        }

        return false;
    }


    @Override
    public String toString()
    {
        String res = "Function: " + name + "\nArgs: ";

        for (RightValue arg : args) {
            res += arg.toString() + " ";
        }

        return res;
    }

}

package tecnico.ssoft.phpsat.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class Function extends RightValue
{
    private String _name;
    private List<RightValue> _args;

    public Function()
    {
        super();
        _name = null;
        _args = new ArrayList<RightValue>();
    }

    public Function(String name)
    {
        super();
        _name = name;
        _args = new ArrayList<RightValue>();
    }

    public Function(String name, List<RightValue> args)
    {
        super();
        _name = name;
        _args = args;

    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public List<RightValue> getArgs()
    {
        return _args;
    }

    public void setArgs(List<RightValue> args)
    {
        _args = args;
    }

    public void addArg(RightValue arg)
    {
        _args.add(arg);
    }

    public boolean hasArgs()
    {
        return !_args.isEmpty();
    }

    public void checkTaint()
    {
        for (RightValue arg : _args) {
            super.untaint();
            if (arg.isTainted()) {
                super.taint();
                break;
            }
        }
    }

    @Override
    public String toString()
    {
        String res = "Function: " + _name + "\nArgs: ";

        for (RightValue arg : _args) {
            res += arg.toString() + " ";
        }

        return res;
    }
}

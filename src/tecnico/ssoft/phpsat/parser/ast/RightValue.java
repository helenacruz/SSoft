package tecnico.ssoft.phpsat.parser.ast;

public abstract class RightValue extends Node
{
    private boolean _tainted;

    public RightValue()
    {
        _tainted = true; // default is tainted
    }

    public void taint()
    {
        _tainted = true;
    }

    public void untaint()
    {
        _tainted = false;
    }

    public boolean isTainted()
    {
        return _tainted;
    }

    public abstract boolean isVariable();
}

package tecnico.ssoft.phpsat.parser.ast;

public abstract class RightValue extends Node
{
    private boolean tainted;

    public RightValue()
    {
        tainted = true; // default is tainted
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

    public abstract boolean isVariable();
}

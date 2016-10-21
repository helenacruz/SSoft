package tecnico.ssoft.phpsat.parser.ast;

public class Assignment extends Node
{
    private Variable _left;
    private RightValue _right;

    public Assignment()
    {
        _left = new Variable();
        _right = null;
    }

    public Assignment(Variable left, RightValue right)
    {
        _left = left;
        _right = right;
    }

    public Variable getLeft()
    {
        return _left;
    }

    public RightValue getRight()
    {
        return _right;
    }

    public void setLeft(Variable left)
    {
        _left = left;
    }

    public void setRight(RightValue right)
    {
        _right = right;
    }

    @Override
    public String toString()
    {
        return "ASSIGNMENT: \n" + getLeft().toString() + "\n" + getRight().toString() + "\n";
    }
}

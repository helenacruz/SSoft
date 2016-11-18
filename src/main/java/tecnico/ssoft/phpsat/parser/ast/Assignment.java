package tecnico.ssoft.phpsat.parser.ast;

public class Assignment extends Node
{
    private Variable left;
    private RightValue right;

    public Assignment()
    {
        left = new Variable();
        right = null;
    }

    public Assignment(Variable left)
    {
        this.left = left;
        this.right = null;
    }

    public Assignment(Variable left, RightValue right)
    {
        this.left = left;
        this.right = right;
    }

    public Variable getLeft()
    {
        return left;
    }

    public RightValue getRight()
    {
        return right;
    }

    public void setLeft(Variable left)
    {
        this.left = left;
    }

    public void setRight(RightValue right)
    {
        this.right = right;
    }

    @Override
    public String toString()
    {
        return "Assignment: " + left.toString() + "\n= " + right.toString() + "\n";
    }
}

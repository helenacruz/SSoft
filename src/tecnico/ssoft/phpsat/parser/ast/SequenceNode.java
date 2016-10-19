package tecnico.ssoft.phpsat.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class SequenceNode extends Node
{
    private List<Node> _list;

    public SequenceNode(Node node)
    {
        _list = new ArrayList<Node>();
    }

    public SequenceNode(SequenceNode sequenceNode, Node node)
    {
        _list = sequenceNode.getList();
        _list.add(node);
    }

    public List<Node> getList()
    {
        return _list;
    }
}

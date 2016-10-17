package tecnico.ssoft.phpsat.parser;

import java.util.List;

public class CodeParser implements Parser
{
    private String _file;
    private List _result;

    public CodeParser(String file)
    {
        _file = file;
    }

    @Override
    public List result()
    {
        return _result;
    }

    @Override
    public void parse()
    {
       /*
       * TODO: Isolar entry points
       * TODO: Isolar sensible sinks
       * TODO: Isolar santiazionFunctions
       * */
    }
}

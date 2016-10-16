package tecnico.ssoft.phpsat.parser;


import tecnico.ssoft.phpsat.core.Vulnerability;

import java.util.ArrayList;
import java.util.List;

/*
* Cria uma lista de vulnerabilidades presentes no codigo alvo
* */
public class CodeParser implements Parser
{


    private List<Vulnerability> _vulnerabilities;

    private String targetCode;

    public CodeParser(String targetCode)
    {
        _vulnerabilities = new ArrayList<Vulnerability>();
        this.targetCode=targetCode;
    }

    /*
    * Retorna o conjunto de vulnerabilidades do codigo alvo
    * */
    @Override
    public List result()
    {
        return _vulnerabilities;
    }

    /*
    * Isola os entry points, sensible sinks e sanitazion functions
    * */
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

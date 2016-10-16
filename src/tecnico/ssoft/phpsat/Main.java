package tecnico.ssoft.phpsat;

import tecnico.ssoft.phpsat.core.Vulnerability;
import tecnico.ssoft.phpsat.parser.CodeParser;
import tecnico.ssoft.phpsat.parser.Parser;
import tecnico.ssoft.phpsat.parser.VulnerabilitiesParser;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {


        Parser vulnetabilitieDictionary = new VulnerabilitiesParser();
        vulnetabilitieDictionary.parse();

        List<Vulnerability> result = vulnetabilitieDictionary.result();

        for (Vulnerability v : result) {
            System.out.println(v.toString());
            System.out.println(" ");
        }

        Parser targetCode = new CodeParser(args[0]);

        /*
        *  List<Vulnerability> result = targetCode.result();
        *
        *  VulnerabilitieAnalyser vul = new VulnerabilitieAnalyser(result);
        * */
    }
}

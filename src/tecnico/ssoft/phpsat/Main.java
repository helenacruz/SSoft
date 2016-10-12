package tecnico.ssoft.phpsat;

import tecnico.ssoft.phpsat.core.Vulnerability;
import tecnico.ssoft.phpsat.parser.Parser;
import tecnico.ssoft.phpsat.parser.VulnerabilitiesParser;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Parser parser = new VulnerabilitiesParser();
        parser.parse();

        List<Vulnerability> result = parser.result();

        for (Vulnerability v : result) {
            System.out.println(v.toString());
            System.out.println(" ");
        }
    }
}

package tecnico.ssoft.phpsat;

import tecnico.ssoft.phpsat.core.Vulnerability;
import tecnico.ssoft.phpsat.parser.CodeParser;
import tecnico.ssoft.phpsat.parser.VulnerabilitiesParser;
import tecnico.ssoft.phpsat.parser.ast.Node;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        /*
        if (args.length > 0) {
            Analyser analyser = new Analyser(args[0]);
            analyser.analyse();
            System.out.println(analyser.result());

        }
        else {
            System.out.println("Missing input file.");
        }
        */

        VulnerabilitiesParser parser = new VulnerabilitiesParser();
        parser.parse();

        List<Vulnerability> result = parser.result();

        CodeParser codeParser = new CodeParser("tests/sqli_05.txt");
        codeParser.parse();

        List<Node> result2 = codeParser.result();

        for (Node node : result2) {
            System.out.println(node.toString());
        }

    }
}

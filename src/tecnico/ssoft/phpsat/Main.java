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
        VulnerabilitiesParser parser = new VulnerabilitiesParser();
        parser.parse();

        List<Vulnerability> result = parser.result();

        CodeParser codeParser = new CodeParser("tests/xss_01.txt");
        codeParser.parse();

        List<Node> result2 = codeParser.result();

        for (Node node : result2) {
            System.out.println(node.toString());
        }

    }
}

package tecnico.ssoft.phpsat;

import tecnico.ssoft.phpsat.core.Analyser;

public class Main
{
    public static void main(String[] args)
    {
        if (args.length > 0) {
            Analyser analyser = new Analyser(args[0]);
            analyser.analyse();
            System.out.println(analyser.result());

        }
        else {
            System.out.println("Missing input file.");
        }
    }
}


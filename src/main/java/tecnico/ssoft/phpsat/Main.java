package tecnico.ssoft.phpsat;

import tecnico.ssoft.phpsat.core.Analyser;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try {
            Analyser analyser = new Analyser(args[0]);
            analyser.analyse();
            System.out.println();
            System.out.println("-> " + analyser.result());
            System.out.println();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            System.out.println("-> Missing an argument - please input the name of a file.");
            System.out.println();
            System.exit(1);
        }
        catch (IOException e) {
            System.out.println();
            System.out.println("-> File not found: " + args[0]);
            System.out.println();
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("-> " + e.getMessage());
            System.out.println();
            System.exit(1);
        }
    }
}


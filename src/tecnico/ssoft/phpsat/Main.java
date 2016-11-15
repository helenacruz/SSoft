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
            System.out.println(analyser.result());
        }
        catch (IOException e) {
            System.out.println("File not found: arg[0]");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Missing an argument - please input the name of a file.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


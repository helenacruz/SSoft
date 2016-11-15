package tecnico.ssoft.phpsat.parser;

import tecnico.ssoft.phpsat.core.SQLInjectionVulnerability;
import tecnico.ssoft.phpsat.core.Vulnerability;
import tecnico.ssoft.phpsat.core.XSSVulnerability;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VulnerabilitiesParser implements Parser
{
    private static final String SQL_INJECTION_DIR = "docs/sql_injection.txt";
    private static final String XSS_DIR = "docs/xss.txt";

    private List<Vulnerability> vulnerabilities;
    private List<String> entryPoints;
    private List<String> sanitizationFunctions;
    private List<String> sinks;

    public VulnerabilitiesParser()
    {
        vulnerabilities = new ArrayList<>();
        entryPoints = new ArrayList<>();
        sanitizationFunctions = new ArrayList<>();
        sinks = new ArrayList<>();
    }

    public List<String> getEntryPoints()
    {
        return entryPoints;
    }

    @Override
    public List result()
    {
        return vulnerabilities;
    }

    @Override
    public void parse()
            throws IOException
    {
        try {
            BufferedReader SQLInjectionFIle = new BufferedReader(new FileReader(SQL_INJECTION_DIR));
            BufferedReader XSSFile = new BufferedReader(new FileReader(XSS_DIR));

            while (SQLInjectionFIle.readLine() != null) {
                Vulnerability vulnerability = new SQLInjectionVulnerability();
                parseVulnerability(vulnerability, SQLInjectionFIle);
            }
            SQLInjectionFIle.close();

            while (XSSFile.readLine() != null) {
                Vulnerability vulnerability = new XSSVulnerability();
                parseVulnerability(vulnerability, XSSFile);
            }
            XSSFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getLocalizedMessage());
            System.exit(1); // if the program can't find the files than won't work - it ends
        }
        catch (IOException e) {
            System.out.println("Error while reading the files.");
            System.exit(1);
        }
    }

    private void parseVulnerability(Vulnerability vulnerability, BufferedReader file)
            throws java.io.IOException
    {
        String entryPoints = file.readLine().replaceAll("\\s", ""); // deletes spaces
        String sanitizationFunctions = file.readLine().replaceAll("\\s", "");
        String sinks = file.readLine().replaceAll("\\s", "");
        file.readLine(); // reads the \n between vulnerabilities

        String[] entryPointsArray = entryPoints.split(",");
        String[] sanitizationFunctionsArray = sanitizationFunctions.split(",");
        String[] sinksArray = sinks.split(",");

        for (String entryPoint : entryPointsArray) {
            vulnerability.addEntryPoint(entryPoint);
            if (!this.entryPoints.contains(entryPoint)) {
                this.entryPoints.add(entryPoint);
            }
        }

        for (String sanitizationFunction : sanitizationFunctionsArray) {
            vulnerability.addSanitizationFunction(sanitizationFunction);
            if (!this.sanitizationFunctions.contains(sanitizationFunction)) {
                this.sanitizationFunctions.add(sanitizationFunction);
            }
        }

        for (String sink : sinksArray) {
            vulnerability.addSink(sink);
            if (!this.sinks.contains(sink)) {
                this.sinks.add(sink);
            }
        }

        vulnerabilities.add(vulnerability);
    }
}

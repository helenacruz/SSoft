package tecnico.ssoft.phpsat.core;

import java.util.List;

/**
 * Created by Bernardo on 16/10/2016.
 * Recebe uma lista de vulnerabilidades do codigo alvo.
 * Determina se o codigo é realmente vulneravel
 */
public class VulnerabilitieAnalyser {

    private List<Vulnerability> codeResult;

    public VulnerabilitieAnalyser(List<Vulnerability> codeResult)
    {
        this.codeResult=codeResult;
        isVulnerable();
    }



    /*
    * Analisa o dicionario de vulnerabilidades para decidir para cada vulnerabilidade
    * Emite resultado final
    * */
    public void isVulnerable()
    {

    }



}

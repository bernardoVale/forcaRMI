package utfpr.edu.br.util;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 15/09/12
 * Time: 18:49
 */
public enum Properties {
    SERVICO("ForcaRMIService");

    private final String name;

    private Properties(String name) {
        this.name = name;
    }

    public String nome() {
        return name;
    }
}

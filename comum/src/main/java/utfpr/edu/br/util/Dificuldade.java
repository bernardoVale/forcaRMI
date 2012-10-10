package utfpr.edu.br.util;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 09/10/12
 * Time: 22:46
 */
public enum Dificuldade {
    FACIL("Fácil"),
    NORMAL("Normal"),
    MAGAYVER("Magayver"),
    FILHO_DE_OSIRIS("Filho de Osíris");

    private final String d;

    private Dificuldade(String d) {
        this.d = d;
    }

    public String d(){
        return d;
    }
}

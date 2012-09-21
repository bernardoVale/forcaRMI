package utfpr.edu.br.model.bean;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 20/09/12
 * Time: 21:12
 */

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Bernardo Vale
 */

@Embeddable
public class PalavrasDoJogoID implements Serializable {

    private int palavra_id;
    private long jogo_id;

    public PalavrasDoJogoID(int palavra_id, long jogo_id) {
        this.palavra_id = palavra_id;
        this.jogo_id = jogo_id;
    }

    public PalavrasDoJogoID() {}

    public int getPalavra_id() {
        return palavra_id;
    }

    public void setPalavra_id(int palavra_id) {
        this.palavra_id = palavra_id;
    }

    public long getJogo_id() {
        return jogo_id;
    }

    public void setJogo_id(long jogo_id) {
        this.jogo_id = jogo_id;
    }
}

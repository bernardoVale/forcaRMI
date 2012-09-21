package utfpr.edu.br.model.bean;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 13:15
 */

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Bernardo Vale
 */
@Embeddable
public class JogadoresdoJogoID implements Serializable {

    private long jogador_id;
    private int jogo_id;

    public JogadoresdoJogoID() {
    }

    public JogadoresdoJogoID(long jogador_id, int jogo_id) {
        this.jogador_id = jogador_id;
        this.jogo_id = jogo_id;
    }

    public long getJogador_id() {
        return jogador_id;
    }

    public void setJogador_id(long jogador_id) {
        this.jogador_id = jogador_id;
    }

    public int getJogo_id() {
        return jogo_id;
    }

    public void setJogo_id(int jogo_id) {
        this.jogo_id = jogo_id;
    }
}

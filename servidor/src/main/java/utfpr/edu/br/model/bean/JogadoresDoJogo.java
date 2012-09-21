package utfpr.edu.br.model.bean;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 13:14
 */

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Bernardo Vale
 */
@Entity
public class JogadoresDoJogo implements IBean{

    @EmbeddedId
    JogadoresdoJogoID id;
    Long pontuacao;

    public JogadoresDoJogo(long jogador_id,int jogo_id,Long pontuacao) {
        this.id = new JogadoresdoJogoID(jogador_id,jogo_id);
        this.pontuacao = pontuacao;
    }

    public JogadoresDoJogo() {
    }

    public Long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Long pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public Long getId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

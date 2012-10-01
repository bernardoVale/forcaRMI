package utfpr.edu.br.model.bean;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 20:24
 */

import javax.persistence.*;

/**
 * @author Bernardo Vale
 */
@Entity
@Table(name = "PalavrasDoJogo")
public class PalavrasDoJogo implements IBean{

    @EmbeddedId
    PalavrasDoJogoID id;

    //Quando termina a rodada, efetua um update e add a id do jogador que acertou a palavra
    @ManyToOne
    @JoinColumn(name = "vencedor_id")
    private Jogo vencedor_id;

    public PalavrasDoJogo() {}

    public PalavrasDoJogo(int palavra_id,long jogo_id,Jogo vencedor_id) {
        this.id = new PalavrasDoJogoID(palavra_id,jogo_id);
        this.vencedor_id = vencedor_id;
    }
    public PalavrasDoJogo(int palavra_id,long jogo_id){
        this.id = new PalavrasDoJogoID(palavra_id,jogo_id);
    }
    public Jogo getVencedor_id() {
        return vencedor_id;
    }

    public void setVencedor_id(Jogo vencedor_id) {
        this.vencedor_id = vencedor_id;
    }
    @Override
    public Long getId() {
        return null;
    }
}

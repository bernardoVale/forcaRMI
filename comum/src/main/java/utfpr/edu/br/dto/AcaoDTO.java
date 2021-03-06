package utfpr.edu.br.dto;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 08/10/12
 * Time: 11:25
 */

import utfpr.edu.br.util.Acao;

import java.io.Serializable;

/**
 * @author Bernardo Vale
 * Dto que identifica quem mandou os dados para o servidor
 * e o que ele quer que o servidor faça
 */
public class AcaoDTO implements Serializable {

    private JogadorDTO jogador;
    private Acao acao;
    private PalavraDTO palavra;

    public AcaoDTO() {
    }

    public AcaoDTO(Acao acao, JogadorDTO jogador) {
        this.acao = acao;
        this.jogador = jogador;
    }

    public AcaoDTO(JogadorDTO jogador, Acao acao, PalavraDTO palavra) {
        this.jogador = jogador;
        this.acao = acao;
        this.palavra = palavra;
    }

    public JogadorDTO getJogador() {
        return jogador;
    }

    public void setJogador(JogadorDTO jogador) {
        this.jogador = jogador;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public PalavraDTO getPalavra() {
        return palavra;
    }

    public void setPalavra(PalavraDTO palavra) {
        this.palavra = palavra;
    }
}

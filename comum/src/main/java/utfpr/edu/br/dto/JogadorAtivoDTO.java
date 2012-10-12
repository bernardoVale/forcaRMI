package utfpr.edu.br.dto;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 05/10/12
 * Time: 16:49
 */

import java.io.Serializable;

/**
 * DTO que possui um jogador que esta jogando um jogo. Essa classe
 * tem a adicao de dois parametros. Se e a rodada do jogador
 * e quantas vezes ele ja errou
 * @author Bernardo Vale
 */
public class JogadorAtivoDTO implements Serializable {

    private JogadorDTO jogador;
    private boolean meuTurno;
    private int quantidadeErros;
    private int pontuacao;

    public JogadorAtivoDTO(JogadorDTO jogador, boolean meuTurno, int quantidadeErros) {
        this.jogador = jogador;
        this.meuTurno = meuTurno;
        this.quantidadeErros = quantidadeErros;
    }

    public JogadorAtivoDTO(JogadorDTO jogador, boolean meuTurno, int quantidadeErros, int pontuacao) {
        this.jogador = jogador;
        this.meuTurno = meuTurno;
        this.quantidadeErros = quantidadeErros;
        this.pontuacao = pontuacao;
    }

    public JogadorAtivoDTO(JogadorDTO jogador, int quantidadeErros, int pontuacao) {
        this.jogador = jogador;
        this.quantidadeErros = quantidadeErros;
        this.pontuacao = pontuacao;
    }

    public JogadorAtivoDTO(JogadorDTO jogador, int quantidadeErros) {
        this.jogador = jogador;
        this.quantidadeErros = quantidadeErros;
    }

    public JogadorDTO getJogador() {
        return jogador;
    }

    public void setJogador(JogadorDTO jogador) {
        this.jogador = jogador;
    }

    public boolean isMeuTurno() {
        return meuTurno;
    }

    public void setMeuTurno(boolean meuTurno) {
        this.meuTurno = meuTurno;
    }

    public int getQuantidadeErros() {
        return quantidadeErros;
    }

    public void setQuantidadeErros(int quantidadeErros) {
        this.quantidadeErros = quantidadeErros;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JogadorAtivoDTO)) return false;

        JogadorAtivoDTO that = (JogadorAtivoDTO) o;

        if (meuTurno != that.meuTurno) return false;
        if (pontuacao != that.pontuacao) return false;
        if (quantidadeErros != that.quantidadeErros) return false;
        if (jogador != null ? !jogador.equals(that.jogador) : that.jogador != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jogador != null ? jogador.hashCode() : 0;
        result = 31 * result + (meuTurno ? 1 : 0);
        result = 31 * result + quantidadeErros;
        result = 31 * result + pontuacao;
        return result;
    }

    @Override
    public String toString() {
        return "JogadorAtivoDTO{" +
                "jogador=" + jogador +
                ", meuTurno=" + meuTurno +
                ", quantidadeErros=" + quantidadeErros +
                ", pontuacao=" + pontuacao +
                '}';
    }
}

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

    public JogadorAtivoDTO(JogadorDTO jogador, boolean meuTurno, int quantidadeErros) {
        this.jogador = jogador;
        this.meuTurno = meuTurno;
        this.quantidadeErros = quantidadeErros;
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

    @Override
    public String toString() {
        return "JogadorAtivoDTO{" +
                "jogador=" + jogador +
                ", meuTurno=" + meuTurno +
                ", quantidadeErros=" + quantidadeErros +
                '}';
    }
}

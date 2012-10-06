package utfpr.edu.br.dto;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 05/10/12
 * Time: 16:46
 */

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

/**
 * DTO responsavel pelo jogo
 * Mantem todos os dados de jogada dos jogadores, o jogo, o painel das letras erradas
 * e a instancia de como esta a palavra populada
 * @author Bernardo Vale
 *
 */
public class JogoAtivoDTO implements Serializable{

    private JogadorAtivoDTO jogador1;
    private JogadorAtivoDTO jogador2;
    private DadosDoJogoDTO jogoDTO;
    private List<String> letrasErradas;
    private List<JLabel> palavraAtualPopulada;

    public JogoAtivoDTO() {
    }

    public JogoAtivoDTO(JogadorAtivoDTO jogador1, JogadorAtivoDTO jogador2
            , DadosDoJogoDTO jogoDTO, List<String> letrasErradas) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogoDTO = jogoDTO;
        this.letrasErradas = letrasErradas;
    }

    public JogoAtivoDTO(JogadorAtivoDTO jogador1,
                        JogadorAtivoDTO jogador2,
                        DadosDoJogoDTO jogoDTO, List<String>
            letrasErradas, List<JLabel> palavraAtualPopulada) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogoDTO = jogoDTO;
        this.letrasErradas = letrasErradas;
        this.palavraAtualPopulada = palavraAtualPopulada;
    }

    public List<JLabel> getPalavraAtualPopulada() {
        return palavraAtualPopulada;
    }

    public void setPalavraAtualPopulada(List<JLabel> palavraAtualPopulada) {
        this.palavraAtualPopulada = palavraAtualPopulada;
    }

    public JogadorAtivoDTO getJogador1() {
        return jogador1;
    }

    public void setJogador1(JogadorAtivoDTO jogador1) {
        this.jogador1 = jogador1;
    }

    public JogadorAtivoDTO getJogador2() {
        return jogador2;
    }

    public void setJogador2(JogadorAtivoDTO jogador2) {
        this.jogador2 = jogador2;
    }
    public List<String> getLetrasErradas() {
        return letrasErradas;
    }

    public void setLetrasErradas(List<String> letrasErradas) {
        this.letrasErradas = letrasErradas;
    }

    public DadosDoJogoDTO getJogoDTO() {
        return jogoDTO;
    }

    public void setJogoDTO(DadosDoJogoDTO jogoDTO) {
        this.jogoDTO = jogoDTO;
    }
}

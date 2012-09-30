package utfpr.edu.br.view.telas.jogo;

import utfpr.edu.br.dto.JogadorDTO;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 27/09/12
 * Time: 19:36
 */
public interface JogoView {

    public JLabel P1_nome();
    public JLabel P2_nome();
    public JLabel lbPontuacaoP1();
    public JLabel lbPontuacaoP2();
    public JLabel lbX();
    public JLabel lbCarregando();
    public JLabel lbPlacar();
    public JPanel pLetrasErradas();
    public JogadorDTO jogador();
    public JogadorDTO adversario();
    public void setAdversario(JogadorDTO adversario);
    /**
     * Organiza e mostra a tela
     */
    public void packAndShow(JogadorDTO jogador);

    /**
     * Limpa os campos da tela
     */
    public void clearFields();

    /**
     * Metodo inicial da tela, onde o jogador aguarda o oponente
     */
   // public void aguardandoJogador();

    /**
     * Metodo que tem a thread que fica cutucando o servidor ate que ele retorne
     * um dto com os dados do jogadorAdversario. Isto e, quando ele entrar no jogo.
     * @return  JogadorAdversario
     */
    //public JogadorDTO aguardarAdversario();


}
package utfpr.edu.br.view.telas.jogo;

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.dto.PalavraDTO;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 27/09/12
 * Time: 19:36
 */
public interface JogoView {

    public void setDadosJogo(JogoAtivoDTO dadosJogo);
    public JogoAtivoDTO dadosJogo();
    public List<JLabel> palavraAtualPopulada();
    public void setPalavraAtualPopulada(List<JLabel> palavraAtualPopulada);
    public JFormattedTextField jtfEnviar();
    public MaskFormatter setMascara(String mascara);
    public void addChutarLetraListener(ActionListener listener);
    public void addMascaraTextoListener(ActionListener listener);
    public void setJtfEnviar(JFormattedTextField jtfEnviar);
    public JRadioButton rbChutar();
    public JRadioButton rbLetra();
    public JLabel P1_nome();
    public JLabel P2_nome();
    public JLabel lbPontuacaoP1();
    public JLabel lbPontuacaoP2();
    public JLabel lbX();
    public JLabel lbCarregando();
    public JLabel lbPlacar();
    public JPanel pLetrasErradas();
    public JPanel pEnviar();
    public JPanel pLetras();
    public JPanel pPalavras();
    public JPanel pJogador1();
    public JLabel lbErroJogador1();
    public JLabel lbErroJogador2();
    public JPanel pJogador2();
    public JogadorDTO jogador();
    public JogadorDTO adversario();
    public JogoDTO jogo();
    public void setJogo(JogoDTO jogo);
    public List<PalavraDTO> palavras();
    public void setPalavras(List<PalavraDTO> palavras);
    public void setAdversario(JogadorDTO adversario);
    public boolean meuTurno();
    public void setMeuTurno(boolean meuTurno);
    public JFrame root();
    public int rodadaAtual();
    public void setRodadaAtual(int rodadaAtual);
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



}
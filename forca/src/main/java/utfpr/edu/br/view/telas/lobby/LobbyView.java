package utfpr.edu.br.view.telas.lobby;

import utfpr.edu.br.dto.JogadorDTO;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 10/10/12
 * Time: 15:41
 */
public interface LobbyView {

     public JPanel pJogos();
     public JogadorDTO jogador();
     public void setJogador(JogadorDTO jogador);
     public JLabel lbJogador();
     public JButton btCriarSala();
     public JButton btAtualizar();
     public void addCriarSalaListener(ActionListener listener);
     public void addAtualizarSalaListener(ActionListener listener);
     public void packAndShow();
     public JFrame root();
     public void destroy();

}
package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 10/10/12
 * Time: 09:43
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.builder.MensagemDirector;
import utfpr.edu.br.builder.MensagemError;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.presenter.LobbyPresenter;
import utfpr.edu.br.presenter.SalvarJogoPresenter;
import utfpr.edu.br.spring.SpringFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 */
public class SalvarJogoActionListener {

    public static class SalvarJogoAction implements ActionListener {
        private final SalvarJogoPresenter presenter;
        private final JogadorDTO jogador;
        private JDialog container;
        private MensagemDirector mensagem;
        private RetornoValidacao rv;
        private LobbyPresenter lobby;
        private JogoPresenter jogoPresenter;

        public SalvarJogoAction(SalvarJogoPresenter presenter, JogadorDTO jogador,LobbyPresenter lobby) {
            this.presenter = presenter;
            this.jogador = jogador;
            this.lobby = lobby;
            jogoPresenter = (JogoPresenter) SpringFactory.getFactory().getBean("JogoPresenter");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JogoDTO jogo = new JogoDTO();
            jogo.setDificuldade(
                    (String) presenter.getView().cbDificuldade().getSelectedItem()
            );
            jogo.setNumRodadas(
                    new Long((Integer) presenter.getView().spRodadas().getValue())
            );
            if(jogo.getNumRodadas()<=0){
                mensagem = new MensagemDirector(new MensagemError("Número de Rodadas inválida"));
                container = mensagem.construirDialogMensagem();
                //Seta a posicao do container de uma maneira nao tao bela
                int x = presenter.getView().getJFrame().getX() + presenter.getView().getJFrame().getWidth()/2;
                int y = presenter.getView().getJFrame().getY() +
                        presenter.getView().getJFrame().getHeight()/2 - container.getHeight();
                container.setLocation(x,y);
                container.setVisible(true);
            }else{
                   lobby.destroy();
                   jogoPresenter.createView(jogador,jogo);
                   presenter.destroy();
                    //abre a tela do jogo com o jogador
                    //fecha essa tela
                    //todo fechar o lobby

            }
        }
    }
}

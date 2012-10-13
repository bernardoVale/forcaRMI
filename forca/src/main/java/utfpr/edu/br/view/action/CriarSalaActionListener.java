package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 10/10/12
 * Time: 16:32
 */

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.presenter.LobbyPresenter;
import utfpr.edu.br.presenter.SalvarJogoPresenter;
import utfpr.edu.br.spring.SpringFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 */
public class CriarSalaActionListener {

    public static class CriarSalaAction implements ActionListener{
        private SalvarJogoPresenter salvarJogoPresenter;
        private JogadorDTO jogador;
        private final LobbyPresenter lobby;

        public CriarSalaAction(JogadorDTO jogador,LobbyPresenter lobby) {
            this.salvarJogoPresenter = (SalvarJogoPresenter)
                    SpringFactory.getFactory().getBean("SalvarJogoPresenter");
            this.jogador = jogador;
            this.lobby = lobby;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
              salvarJogoPresenter.createView(jogador,lobby);
        }
    }
}

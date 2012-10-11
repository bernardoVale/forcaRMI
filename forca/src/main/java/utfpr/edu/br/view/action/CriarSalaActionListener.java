package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 10/10/12
 * Time: 16:32
 */

import utfpr.edu.br.dto.JogadorDTO;
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

        public CriarSalaAction(JogadorDTO jogador) {
            this.salvarJogoPresenter = (SalvarJogoPresenter)
                    SpringFactory.getFactory().getBean("SalvarJogoPresenter");
            this.jogador = jogador;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
              salvarJogoPresenter.createView(jogador);
        }
    }
}

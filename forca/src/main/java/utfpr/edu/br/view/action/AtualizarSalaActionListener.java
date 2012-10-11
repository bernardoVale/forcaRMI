package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 10/10/12
 * Time: 22:57
 */

import utfpr.edu.br.presenter.LobbyPresenter;
import utfpr.edu.br.presenter.worker.ListarJogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 */
public class AtualizarSalaActionListener {

    public static class AtualizarSalaAction implements ActionListener{
        private final LobbyPresenter presenter;

        public AtualizarSalaAction(LobbyPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ListarJogo worker = new ListarJogo(presenter);
            try {
                worker.execute();
            } catch (Exception ee) {
                ee.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}

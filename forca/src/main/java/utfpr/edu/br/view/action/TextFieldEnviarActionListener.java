package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 13/10/12
 * Time: 15:50
 */

import utfpr.edu.br.presenter.JogoPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 * Listener para limpara a porra do textfield
 */
public class TextFieldEnviarActionListener {

    public static class LimparTextFieldAction implements ActionListener{
        private final JogoPresenter presenter;

        public LimparTextFieldAction(JogoPresenter presenter) {
            this.presenter = presenter;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.getView().jtfEnviar().setText("");
            presenter.getView().jtfEnviar().revalidate();
            presenter.getView().root().validate();
        }
    }
}

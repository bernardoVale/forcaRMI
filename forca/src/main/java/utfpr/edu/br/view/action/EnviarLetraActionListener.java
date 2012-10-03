package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 03/10/12
 * Time: 11:07
 */

import utfpr.edu.br.presenter.JogoPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 */
public class EnviarLetraActionListener implements ActionListener {
    private final JogoPresenter presenter;

    public EnviarLetraActionListener(JogoPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        doEnviarLetra();
    }

    /**
     * Metodo onde eu verifico qual foi a letra que me enviaste e se ela costa na palavra.
     */
    private void doEnviarLetra(){

    }
}

package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 27/09/12
 * Time: 19:39
 */

import utfpr.edu.br.view.telas.jogo.JogoView;

/**
 * @author Bernardo Vale
 */
public class JogoPresenter {
    private JogoView jogoView;

    public JogoPresenter() {
    }

    public void createView() {
        this.setUpViewListeners();
        jogoView.packAndShow();
    }
    //Adiciona os listeners
    public void setUpViewListeners() {}

    public JogoView getJogoView() {
        return jogoView;
    }

    public void setJogoView(JogoView jogoView) {
        this.jogoView = jogoView;
    }
}

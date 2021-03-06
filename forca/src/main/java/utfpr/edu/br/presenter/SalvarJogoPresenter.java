package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 09/10/12
 * Time: 22:41
 */

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.view.action.SalvarJogoActionListener;
import utfpr.edu.br.view.telas.lobby.salvarJogo.SalvarJogoView;

/**
 * @author Bernardo Vale
 */
public class SalvarJogoPresenter {
    private SalvarJogoView view;
    private JogadorDTO jogador;
    private LobbyPresenter lobby;

    public SalvarJogoPresenter(SalvarJogoView view) {
        this.view = view;
    }

    public SalvarJogoPresenter() {
    }

    public void createView(JogadorDTO jogador,LobbyPresenter lobby) {
        this.jogador = jogador;
        this.lobby = lobby;
        this.setUpViewListeners();
        view.packAndShow();
    }
    public void setUpViewListeners(){
        view.addSalvarListener(new SalvarJogoActionListener.SalvarJogoAction(this,jogador,lobby));
    }

    public void setView(SalvarJogoView view) {
        this.view = view;
    }
    public void destroy(){
        view.destroy();
    }
    public SalvarJogoView getView() {
        return view;
    }
}

package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 09/10/12
 * Time: 22:41
 */

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.view.action.SalvarJogoActionListener;
import utfpr.edu.br.view.telas.lobby.SalvarJogoView;

/**
 * @author Bernardo Vale
 */
public class SalvarJogoPresenter {
    private SalvarJogoView view;

    public SalvarJogoPresenter(SalvarJogoView view) {
        this.view = view;
    }

    public SalvarJogoPresenter() {
    }

    public void createView() {
        this.setUpViewListeners();
        view.packAndShow();
    }
    public void setUpViewListeners(){                //todo Quando lobby estiver pronto passar jogador dinamico
        view.addSalvarListener(new SalvarJogoActionListener.SalvarJogoAction(this,
                new JogadorDTO(71L,"joao","160147162158000000000000")));
    }

    public void setView(SalvarJogoView view) {
        this.view = view;
    }

    public SalvarJogoView getView() {
        return view;
    }
}

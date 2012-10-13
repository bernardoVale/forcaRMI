package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 10/10/12
 * Time: 16:10
 */

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.view.action.AtualizarSalaActionListener;
import utfpr.edu.br.view.action.CriarSalaActionListener;
import utfpr.edu.br.view.telas.lobby.LobbyView;
import utfpr.edu.br.view.telas.lobby.painelPartida.PainelPartida;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class LobbyPresenter {
    private LobbyView view;
    private List<JogoDTO> jogos = new ArrayList<JogoDTO>();


    public LobbyPresenter(LobbyView LobbyView) {
        this.view = LobbyView;
    }

    public LobbyPresenter() {

    }

    public void createView(JogadorDTO jogador) {
        view.setJogador(jogador);
        view.packAndShow();
        view.lbJogador().setText(jogador.getNome());
        this.setUpViewListeners();
    }

    public void setUpViewListeners() {
       view.addCriarSalaListener(new CriarSalaActionListener.CriarSalaAction(view.jogador(),this));
       view.addAtualizarSalaListener(new AtualizarSalaActionListener.AtualizarSalaAction(this));
    }

    public void setView(LobbyView View) {
        view = View;
    }

    public LobbyView getView() {
        return view;
    }

    public void exibirJogos(List<JogoDTO> jogos){
        int i=1; //Numero da sala
        if(this.jogos!=jogos){
            this.jogos = jogos;
            view.pJogos().removeAll();
            view.pJogos().revalidate();
            view.root().validate();
            for (JogoDTO jogo : this.jogos) {
                view.pJogos().add(new PainelPartida(jogo,i,view.jogador(),this));
                view.pJogos().revalidate();
                view.root().validate();
                i++;
            }
        }
    }
    public void destroy(){
        view.destroy();
    }
}

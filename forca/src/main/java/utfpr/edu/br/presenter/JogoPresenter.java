package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 27/09/12
 * Time: 19:39
 */

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.presenter.worker.BuscarDadosJogo;
import utfpr.edu.br.presenter.worker.FindAdversario;
import utfpr.edu.br.view.telas.jogo.JogoView;

import java.awt.*;

/**
 * @author Bernardo Vale
 */
public class JogoPresenter {
    private JogoView jogoView;

    public JogoPresenter() {
    }

    public void createView(JogadorDTO jogador) {
        this.setUpViewListeners();
        jogoView.packAndShow(jogador);
        moldarTelaInicial();
        aguardarAdversario();
        buscarDadosDoJogo();
    }
    /**
     * Metodo inicial da tela, onde o jogador aguarda o oponente
     */
    public void moldarTelaInicial(){
        jogoView.P1_nome().setText(jogoView.jogador().getNome());
        jogoView.lbPontuacaoP1().setVisible(false);
        jogoView.lbPontuacaoP2().setVisible(false);
        jogoView.pLetrasErradas().setVisible(false);
        jogoView.lbX().setVisible(false);
        jogoView.lbCarregando().setVisible(true);
        jogoView.lbPlacar().setBounds(370, 74, 288, 73);
        jogoView.lbPlacar().setText("Aguardando Oponente...");
        jogoView.lbPlacar().setFont(new Font("Tahoma", 0, 23));
        jogoView.pEnviar().setVisible(false);
    }
    public void aguardarAdversario(){
        FindAdversario f = new FindAdversario(jogoView,this);
        try {
            f.execute();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void buscarDadosDoJogo() {
         BuscarDadosJogo worker = new BuscarDadosJogo(jogoView);
        try {
            worker.execute();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    //Adiciona os listeners
    public void setUpViewListeners() {}

    public JogoView getView() {
        return jogoView;
    }

    public void setJogoView(JogoView jogoView) {
        this.jogoView = jogoView;
    }
}

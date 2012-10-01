package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 27/09/12
 * Time: 19:39
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.rmi.RMIClient;
import utfpr.edu.br.view.telas.jogo.JogoView;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

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
        FindAdversario f = new FindAdversario();
        try {
            f.execute();
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

    /**
     * Classe que tem a thread que fica cutucando o servidor ate que ele retorne
     * um dto com os dados do jogadorAdversario. Isto e, quando ele entrar no jogo.
     * @return  JogadorAdversario
     */
    private class FindAdversario extends SwingWorker<JogadorDTO,Void>{
        RetornoValidacao rv = new RetornoValidacao(false);
        @Override
        protected JogadorDTO doInBackground() throws Exception {
            while (!rv.isOk()){
                rv = RMIClient.getInstance().provider().retornaAdversario(jogoView.jogador());
                Thread.sleep(2000);
            }
            return (JogadorDTO) rv.getObjeto();
        }

        @Override
        protected void done() {
            super.done();
            try {
                jogoView.setAdversario(get());
                jogoView.P2_nome().setText(get().getNome());
                habilitaCampos();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExecutionException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        private void habilitaCampos(){
            jogoView.lbPlacar().setVisible(true);
            jogoView.lbCarregando().setVisible(false);
            jogoView.lbPontuacaoP1().setVisible(true);
            jogoView.lbPontuacaoP2().setVisible(true);
            jogoView.lbPlacar().setFont(new java.awt.Font("Tahoma", 0, 55)); // NOI18N
            jogoView.lbPlacar().setBounds(414, 74, 288, 73);
            jogoView.lbPlacar().setText("Placar");
            jogoView.lbPlacar().setVisible(true);
            jogoView.lbX().setVisible(true);
            jogoView.pLetrasErradas().setVisible(true);
            jogoView.pEnviar().setVisible(true);
        }
    }
}

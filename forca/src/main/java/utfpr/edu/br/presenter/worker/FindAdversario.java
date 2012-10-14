package utfpr.edu.br.presenter.worker;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 19:23
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.rmi.RMIClient;
import utfpr.edu.br.util.GetImagemForca;
import utfpr.edu.br.view.telas.jogo.JogoView;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

/**
 * @author Bernardo Vale
 * Classe que tem a thread que fica cutucando o servidor ate que ele retorne
 * um dto com os dados do jogadorAdversario. Isto e, quando ele entrar no jogo.
 * @return  JogadorAdversario
 */
public class FindAdversario extends SwingWorker<JogadorDTO,Void> {

    private final JogoView jogoView;
    private final JogoPresenter presenter;
    public FindAdversario(JogoView jogoView, JogoPresenter presenter) {
        this.jogoView = jogoView;
        this.presenter = presenter;
    }

    RetornoValidacao rv = new RetornoValidacao(false);
    @Override
    protected JogadorDTO doInBackground() throws Exception {
        while (!rv.isOk()){
            rv = RMIClient.getInstance().provider().retornaAdversario(jogoView.jogador(),jogoView.jogo());
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
            presenter.buscarDadosDoJogo();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void habilitaCampos(){
        jogoView.pJogador1().setVisible(true);
        jogoView.pJogador2().setVisible(true);
        jogoView.lbErroJogador1().setIcon(new GetImagemForca().getImagem(0));
        jogoView.lbErroJogador2().setIcon(new GetImagemForca().getImagem(0));
        jogoView.lbPlacar().setVisible(true);
        jogoView.lbCarregando().setVisible(false);
        jogoView.pPont().setVisible(true);
        jogoView.lbPontuacaoP1().setVisible(true);
        jogoView.lbPontuacaoP2().setVisible(true);
        jogoView.lbPlacar().setFont(new java.awt.Font("Tahoma", 0, 55)); // NOI18N
        jogoView.lbPlacar().setBounds(414, 37, 288, 73);
        jogoView.lbPlacar().setText("Placar");
        jogoView.lbPlacar().setVisible(true);
        jogoView.lbX().setVisible(true);
        jogoView.pLetrasErradas().setVisible(true);
        jogoView.pEnviar().setVisible(true);
    }
}

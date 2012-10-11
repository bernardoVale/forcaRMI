package utfpr.edu.br.presenter.worker;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 11/10/12
 * Time: 10:08
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.rmi.RMIClient;

import javax.swing.*;

/**
 * @author Bernardo Vale
 */
public class PopularJogador extends SwingWorker<RetornoValidacao, Void> {

    private final JogoPresenter presenter;
    private RetornoValidacao rv = new RetornoValidacao(false);

    public PopularJogador(JogoPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected RetornoValidacao doInBackground() throws Exception {
        while (!rv.isOk()){
            rv = RMIClient.getInstance().provider().criarJogo(presenter.getView().jogador()
                    ,presenter.getView().jogo());
            Thread.sleep(1000);
        }
        return rv;
    }

    @Override
    protected void done() {
        super.done();    //To change body of overridden methods use File | Settings | File Templates.
        presenter.getView().setJogo((JogoDTO) rv.getObjeto());
        presenter.aguardarAdversario();
    }
}

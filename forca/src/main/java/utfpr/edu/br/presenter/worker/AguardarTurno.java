package utfpr.edu.br.presenter.worker;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 06/10/12
 * Time: 19:13
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.rmi.RMIClient;

import javax.swing.*;

/**
 * @author Bernardo Vale
 */
public class AguardarTurno extends SwingWorker<JogoAtivoDTO,Void>{
    private RetornoValidacao rv;
    private final JogoPresenter presenter;

    public AguardarTurno(JogoPresenter presenter) {
        this.presenter = presenter;
        rv = new RetornoValidacao(false);
    }

    @Override
    protected JogoAtivoDTO doInBackground() throws Exception {
        while (!rv.isOk()){
            rv = RMIClient.getInstance().provider().eMeuTurno(presenter.getView().jogador(),
                    presenter.getView().dadosJogo().getJogoDTO().getJogo());
            Thread.sleep(2000);
        }
        return (JogoAtivoDTO) rv.getObjeto();
    }

    @Override
    protected void done() {
        super.done();
        JogoAtivoDTO antigo = presenter.getView().dadosJogo();
        presenter.getView().setDadosJogo((JogoAtivoDTO) rv.getObjeto());
        presenter.atualizarTela();
    }
}

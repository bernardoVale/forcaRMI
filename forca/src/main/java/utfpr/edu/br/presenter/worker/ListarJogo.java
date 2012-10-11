package utfpr.edu.br.presenter.worker;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 10/10/12
 * Time: 19:51
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.presenter.LobbyPresenter;
import utfpr.edu.br.rmi.RMIClient;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Bernardo Vale
 * Worker para buscar os dados dos jogos persistidos
 * tambem traz a quantidade de jogadores no jogo.
 */
public class ListarJogo extends SwingWorker<List<JogoDTO>,Void> {
    private RetornoValidacao rv = new RetornoValidacao(false);
    private final LobbyPresenter presenter;

    public ListarJogo(LobbyPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected List<JogoDTO> doInBackground() throws Exception {
        while (!rv.isOk()){
            rv = RMIClient.getInstance().provider().listarJogos();
            Thread.sleep(10000);
            if(rv.getErro()!=null){
                JOptionPane.showMessageDialog(presenter.getView().root(),rv.getErro());
            }
        }
        return (List<JogoDTO>) rv.getObjeto();
    }

    @Override
    protected void done() {
        try {
            presenter.exibirJogos(get());
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        super.done();    //To change body of overridden methods use File | Settings | File Templates.
    }
}

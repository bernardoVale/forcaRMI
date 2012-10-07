package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 03/10/12
 * Time: 11:07
 */

import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.presenter.template.efetuarJogada.EfetuarJogadaTemplate;
import utfpr.edu.br.presenter.template.efetuarJogada.JogadaLetra;
import utfpr.edu.br.presenter.template.efetuarJogada.JogadaPalavra;
import utfpr.edu.br.rmi.RMIClient;
import utfpr.edu.br.view.telas.jogo.JogoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * @author Bernardo Vale
 */
public class RealizarJogadaActionListener implements ActionListener {
    private final JogoPresenter presenter;
    private JogoView view;

    public RealizarJogadaActionListener(JogoPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EfetuarJogadaTemplate jogada = null;
            if(view.rbLetra().isSelected()){
                    jogada = new JogadaLetra();
                    jogada.efetuarJogada(presenter);
            }
            else if(view.rbChutar().isSelected()){
                jogada = new JogadaPalavra();
                jogada.efetuarJogada(presenter);
            }
        //Atualizo o servidor para que o outro jogador receba as modificaçoes
        try {
            RMIClient.getInstance().provider().efetuarJogada(jogada.getJogo());
            presenter.getView().setDadosJogo(jogada.getJogo());
            presenter.verificarTurno();
        } catch (RemoteException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

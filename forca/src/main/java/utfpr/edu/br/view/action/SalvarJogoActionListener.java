package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 10/10/12
 * Time: 09:43
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.builder.MensagemDirector;
import utfpr.edu.br.builder.MensagemError;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.presenter.SalvarJogoPresenter;
import utfpr.edu.br.rmi.RMIClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * @author Bernardo Vale
 */
public class SalvarJogoActionListener {

    public static class SalvarJogoAction implements ActionListener {
        private final SalvarJogoPresenter presenter;
        private final JogadorDTO jogador;
        private JDialog container;
        private MensagemDirector mensagem;
        private RetornoValidacao rv;

        public SalvarJogoAction(SalvarJogoPresenter presenter, JogadorDTO jogador) {
            this.presenter = presenter;
            this.jogador = jogador;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JogoDTO jogo = new JogoDTO();
            jogo.setDificuldade(
                    (String) presenter.getView().cbDificuldade().getSelectedItem()
            );
            jogo.setNumRodadas(
                    new Long((Integer) presenter.getView().spRodadas().getValue())
            );
            if(jogo.getNumRodadas()<=0){
                mensagem = new MensagemDirector(new MensagemError("Número de Rodadas inválida"));
                container = mensagem.construirDialogMensagem();
                //Seta a posicao do container de uma maneira nao tao bela
                int x = presenter.getView().getJFrame().getX() + presenter.getView().getJFrame().getWidth()/2;
                int y = presenter.getView().getJFrame().getY() +
                        presenter.getView().getJFrame().getHeight()/2 - container.getHeight();
                container.setLocation(x,y);
                container.setVisible(true);
            }else{
                try {
                    rv = RMIClient.getInstance().provider().criarJogo(jogador,jogo);
                } catch (RemoteException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                if(!rv.isOk()){
                    mensagem = new MensagemDirector(new MensagemError(rv.getErro()));
                    container = mensagem.construirDialogMensagem();
                    //Seta a posicao do container de uma maneira nao tao bela
                    int x = presenter.getView().getJFrame().getX() + presenter.getView().getJFrame().getWidth()/2;
                    int y = presenter.getView().getJFrame().getY() +
                            presenter.getView().getJFrame().getHeight()/2 - container.getHeight();
                    container.setLocation(x,y);
                    container.setVisible(true);
                }else{
                    //abre a tela do jogo com o jogador
                    //fecha essa tela
                }
            }
        }
    }
}

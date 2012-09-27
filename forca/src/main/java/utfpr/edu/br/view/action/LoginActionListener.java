package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 21:19
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.builder.MensagemDirector;
import utfpr.edu.br.builder.MensagemError;
import utfpr.edu.br.builder.MensagemOK;
import utfpr.edu.br.md5.CriptografiaLogix;
import utfpr.edu.br.presenter.LoginPresenter;
import utfpr.edu.br.rmi.RMIClient;
import utfpr.edu.br.view.telas.login.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * @author Bernardo Vale
 */
public class LoginActionListener {

    public static class AutenticarActionListener implements ActionListener {
        private LoginPresenter presenter;
        private MensagemDirector mensagem;
        private JDialog container;

        public AutenticarActionListener(LoginPresenter presenter) {
            this.presenter = presenter;
        }

        public void actionPerformed(ActionEvent evt) {
            LoginView view = presenter.getLoginView();
            if(view.getNome().equals("") || view.getSenha().equals("")){
                mensagem = new MensagemDirector(new MensagemError("Preencha todos os campos!"));
                container = mensagem.construirDialogMensagem();
                //Seta a posicao do container de uma maneira nao tao bela
                int x = view.getJFrame().getX() + view.getJFrame().getWidth()/2;
                int y = view.getJFrame().getY() + view.getJFrame().getHeight()/2 - container.getHeight();
                container.setLocation(x,y);
                container.setVisible(true);
                return ;
            }
             try {
                 CriptografiaLogix cripto = new CriptografiaLogix(view.getNome(),view.getSenha());
                RetornoValidacao rv =
                        RMIClient.getInstance().provider().iniciarJogo(view.getNome(),cripto.getSenhaCriptografada());
                if(rv.isOk()){
                    mensagem = new MensagemDirector(new MensagemOK("Jogador pronto para jogar!"));
                    container = mensagem.construirDialogMensagem();
                    //Seta a posicao do container de uma maneira nao tao bela
                    int x = view.getJFrame().getX() + view.getJFrame().getWidth()/2;
                    int y = view.getJFrame().getY() + view.getJFrame().getHeight()/2 - container.getHeight();
                    container.setLocation(x,y);
                    container.setVisible(true);

                }else{
                    mensagem = new MensagemDirector(new MensagemError(rv.getErro()));
                    container = mensagem.construirDialogMensagem();
                    int x = view.getJFrame().getX() + view.getJFrame().getWidth()/2;
                    int y = view.getJFrame().getY() + view.getJFrame().getHeight()/2 - container.getHeight();
                    container.setLocation(x,y);
                    container.setVisible(true);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
             }

        }
    }
}

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
import utfpr.edu.br.md5.Md5;
import utfpr.edu.br.presenter.LoginPresenter;
import utfpr.edu.br.rmi.RMIClient;
import utfpr.edu.br.view.telas.login.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

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
            LoginView view = presenter.getView();
            if(view.getNome().getText().equals("")){
                mensagem = new MensagemDirector(new MensagemError("Insira um apelido(Nickname)"));
                container = mensagem.construirDialogMensagem();
                //Seta a posicao do container de uma maneira nao tao bela
                int x = view.getJFrame().getX() + view.getJFrame().getWidth()/2;
                int y = view.getJFrame().getY() + view.getJFrame().getHeight()/2 - container.getHeight();
                container.setLocation(x,y);
                container.setVisible(true);
                return ;
            }
             try {
                RetornoValidacao rv =
                        RMIClient.getInstance().provider().autenticarJogador(view.getNome().getText()
                                ,Md5.MD5(view.getNome().getText()));
                 System.out.println(rv.isOk());
                if(rv.isOk()){
                    mensagem = new MensagemDirector(new MensagemOK("Inserido com Sucesso"));
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
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            view.clearFields();

        }
    }
}

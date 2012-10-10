package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 21:19
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.builder.MensagemDirector;
import utfpr.edu.br.builder.MensagemError;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.md5.CriptografiaLogix;
import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.presenter.LoginPresenter;
import utfpr.edu.br.presenter.SalvarJogoPresenter;
import utfpr.edu.br.rmi.RMIClient;
import utfpr.edu.br.spring.SpringFactory;
import utfpr.edu.br.view.telas.login.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;

/**
 * @author Bernardo Vale
 */
public class LoginActionListener {

    public static class AutenticarActionListener implements ActionListener,KeyListener {
        private LoginPresenter presenter;
        private JogoPresenter jogoPresenter;
        private MensagemDirector mensagem;
        private JDialog container;
        private SalvarJogoPresenter salvarJogoPresenter;

        public AutenticarActionListener(LoginPresenter presenter) {
            this.presenter = presenter;
            this.jogoPresenter = (JogoPresenter) SpringFactory.getFactory().getBean("JogoPresenter");
            this.salvarJogoPresenter = (SalvarJogoPresenter) SpringFactory.getFactory().getBean("SalvarJogoPresenter");
        }

        public void actionPerformed(ActionEvent evt) {
            doAutenticar();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                doAutenticar();
            }
        }

        private void doAutenticar(){
            salvarJogoPresenter.createView();
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
                    //Ta tudo ok entao tem que chamar a view do jogo e destruir a view de login
                    view.destroy();

                    jogoPresenter.createView((JogadorDTO) rv.getObjeto());

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

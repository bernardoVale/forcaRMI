package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 20:45
 */

import utfpr.edu.br.view.telas.login.LoginView;

import static utfpr.edu.br.view.action.LoginActionListener.AutenticarActionListener;

/**
 * @author Bernardo Vale
 */
public class LoginPresenter{
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }
    public LoginPresenter() {

    }

    public void createView() {
        this.setUpViewListeners();
        loginView.packAndShow();
    }
    public void destroyView(){
        loginView.destroy();
    }
    public void setUpViewListeners() {
       loginView.addAutenticarListener(new AutenticarActionListener(this));
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }



}

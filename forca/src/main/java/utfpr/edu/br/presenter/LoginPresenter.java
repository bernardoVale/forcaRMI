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
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }
    public LoginPresenter() {

    }

    public void createView() {
        this.setUpViewListeners();
        view.packAndShow();
    }

    public void setUpViewListeners() {
       view.addAutenticarListener(new AutenticarActionListener(this));
    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }
}

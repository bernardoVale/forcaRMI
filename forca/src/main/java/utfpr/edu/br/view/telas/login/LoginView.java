package utfpr.edu.br.view.telas.login;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 */
public interface LoginView {
    JButton getBotaoLogin();
    String getNome();
    String getSenha();
    void addAutenticarListener(ActionListener listener);
    java.awt.Component getJFrame();

    /**
     * Organiza e mostra a tela
     */
    public void packAndShow();

    /**
     * Limpa os campos da tela
     */
    public void clearFields();



}
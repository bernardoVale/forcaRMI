package utfpr.edu.br.builder;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 17/09/12
 * Time: 14:26
 */

import javax.swing.*;

/**
 * @author Bernardo Vale
 */
public abstract class MensagemBuilder {
    protected JOptionPane pane;
    protected JDialog dialog;
    protected String mensagem;

    protected MensagemBuilder(String mensagem) {
        this.mensagem = mensagem;
        this.pane = new JOptionPane();
    }

    public abstract void comIcon();
    public abstract void comTitulo();
    public abstract void comTipo();
    public abstract void comCor();

    public JOptionPane getPane(){
        return pane;
    }
    public JDialog getDialog(){
        return dialog;
    }
}

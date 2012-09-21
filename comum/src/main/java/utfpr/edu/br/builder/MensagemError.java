package utfpr.edu.br.builder;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 17/09/12
 * Time: 21:04
 */

import java.awt.*;

/**
 * @author Bernardo Vale
 */
public class MensagemError extends MensagemBuilder{

    public MensagemError(String mensagem) {
        super(mensagem);
        super.pane.setMessage(mensagem);
    }

    @Override
    public void comIcon() {
        super.pane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/errorIcon.png")));

    }

    @Override
    public void comTitulo() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void comTipo() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void comCor() {
        super.pane.setBackground(Color.RED);
    }
}

package utfpr.edu.br.builder;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 17/09/12
 * Time: 20:33
 */

import java.awt.*;

/**
 * @author Bernardo Vale
 */
public class MensagemOK extends MensagemBuilder{


    public MensagemOK(String mensagem) {
        super(mensagem);
        super.pane.setMessage(mensagem);
    }

    @Override
    public void comIcon() {
        super.pane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/okIcon.png")));
    }

    @Override
    public void comTitulo() {
        //n to afim n;
    }

    @Override
    public void comTipo() {
        //nao quero implementar.
    }

    @Override
    public void comCor() {
        super.pane.setBackground(Color.cyan);
    }

}

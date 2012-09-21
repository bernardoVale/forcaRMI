package utfpr.edu.br.builder;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 17/09/12
 * Time: 20:39
 */

import javax.swing.*;

/**
 * @author Bernardo Vale
 */
public class MensagemDirector {
    protected MensagemBuilder construtor;

    public MensagemDirector(MensagemBuilder construtor) {
        this.construtor = construtor;
    }

    public JDialog construirDialogMensagem(){
        construtor.comIcon();
        construtor.comTipo();
        construtor.comTitulo();
        return construtor.pane.createDialog(null);
    }
}

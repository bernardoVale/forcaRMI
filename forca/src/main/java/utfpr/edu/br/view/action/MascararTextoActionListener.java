package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 03/10/12
 * Time: 13:55
 */

import utfpr.edu.br.presenter.JogoPresenter;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

/**
 * Classe que mascara o JFormattedTextField de acordo com os listeners dos RadioButton
 * @author Bernardo Vale
 */
public class MascararTextoActionListener implements ActionListener{
    private final JogoPresenter presenter;

    public MascararTextoActionListener(JogoPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (presenter.getView().rbChutar().isSelected()) {
            doMascararTexto("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        } else {
           doMascararTexto("U");
        }
    }
    private void doMascararTexto(String mascara){
        JFormattedTextField.AbstractFormatter ab = null;
        try {
            ab = new MaskFormatter(mascara);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(ab);
        presenter.getView().jtfEnviar().setFormatterFactory(factory);
    }
}

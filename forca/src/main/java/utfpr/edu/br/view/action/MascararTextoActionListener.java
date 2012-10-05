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

            doMascararTexto(buscarQuantidadeLetra());

        } else{
           doMascararTexto("U");
        }
    }

    /**
     * Metodo que busca seta uma string com o "U" x vezes, onde x e o total de letras da palavra populada
     * U = e o caracter que representa SOMENTE LETRAS MAIUSCULAS no maskformatter
     * a quantidade de "U" e a quantidade de letras que podera ser digitada naquele campo
     * @return  por ex "UUUUU" o usuario podera digitar ate 5 letras maiusculas
     */
    private String buscarQuantidadeLetra() {
        String mascara = "";
        char[] caracteres =  //Gambia que seta a mascara para o numero de letras que tem na palavra
                presenter.getView().palavras().get(presenter.getView().rodadaAtual()-1).getNome().toCharArray();
        for(int i=0;i<caracteres.length;i++){
            mascara += "U";
        }
        return mascara;
    }

    /**
     * Adiciona a mascara ao campo JTFEnviar, o campo onde o usuario digita a letra ou a palavra que quer chutar
     *
     * @param mascara String com a quantidade de letras que podera ser digitada
     */
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

package utfpr.edu.br.util;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 13/10/12
 * Time: 14:48
 */

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

/**
 * @author Bernardo Vale
 */
public class MascararUtil {


    /**
     * Metodo que busca seta uma string com o "U" x vezes, onde x e o total de letras da palavra populada
     * U = e o caracter que representa SOMENTE LETRAS MAIUSCULAS no maskformatter
     * a quantidade de "U" e a quantidade de letras que podera ser digitada naquele campo
     * @return  por ex "UUUUU" o usuario podera digitar ate 5 letras maiusculas
     */
    private static String buscarQuantidadeLetra(String palavra) {
        String mascara = "";
        char[] caracteres = palavra.toCharArray();  //Gambia que seta a mascara para o numero de letras que tem na palavra
                //presenter.getView().palavras().get(presenter.getView().rodadaAtual()-1).getNome().toCharArray();
        for(int i=0;i<caracteres.length;i++){
            mascara += "U";
        }
        return mascara;
    }

    /**
     * Adiciona a mascara ao campo JTFEnviar, o campo onde o usuario digita a letra ou a palavra que quer chutar
     *
     */
    public static DefaultFormatterFactory doMascararTexto(String palavra){

        JFormattedTextField.AbstractFormatter ab = null;
        try {
            ab = new MaskFormatter(buscarQuantidadeLetra(palavra));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(ab);
        return factory;
    }
}

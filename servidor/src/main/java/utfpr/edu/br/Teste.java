package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.facade.Jogador;
import utfpr.edu.br.facade.JogadorFacade;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        JogadorFacade j = Jogador.getInstance();
        j.saveJogador("Tiao bengala");
        System.out.println(j.findJogador("tiao bengala"));
    }
}

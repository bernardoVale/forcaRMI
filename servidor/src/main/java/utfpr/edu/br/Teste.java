package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.controller.ControladorJogo;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.inject.Getinjector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        ControladorJogo cv = Getinjector.getInstance().getInstance(ControladorJogo.class);
        List<JogoDTO> jogos = new ArrayList<JogoDTO>();
        jogos = (List<JogoDTO>) cv.listaJogos().getObjeto();
        for (JogoDTO jogo : jogos) {
            System.out.println(jogo.toString());
        }

    }

}

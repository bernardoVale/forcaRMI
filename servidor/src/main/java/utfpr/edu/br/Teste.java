package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.controller.ControladorPalavra;
import utfpr.edu.br.dto.CategoriaDTO;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.inject.Getinjector;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        ControladorPalavra cv = Getinjector.getInstance().getInstance(ControladorPalavra.class);
        cv.salvarPalavraCorreta(
                new JogadorDTO(5L,"Tiao","111164169133097099101102"),
                new PalavraDTO(9L,"hipérbole",new CategoriaDTO(1L,"Adjetivo")),
                new JogoDTO(40L,3L,new CategoriaDTO(1L,"Adjetivo"))
        );

    }

}

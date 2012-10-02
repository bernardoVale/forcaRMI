package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.controller.ControladorPalavra;
import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.inject.Getinjector;

import java.util.List;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
       RetornoValidacao rv =
               Getinjector.getInstance().getInstance(ControladorPalavra.class).getPalavrasDoJogo(1L);
        if(rv.isOk()){
            List<PalavraDTO> palavras = (List<PalavraDTO>) rv.getObjeto();
            for (PalavraDTO palavra : palavras) {
                System.out.println("Palavra:"+palavra.getNome());
            }

        }else{
            System.out.println(rv.getErro());
        }

    }

}

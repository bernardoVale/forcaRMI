package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.bean.Palavra;
import utfpr.edu.br.model.dao.PalavraDao;

import java.util.List;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        PalavraDao p = Getinjector.getInstance().getInstance(PalavraDao.class);
        List<Palavra> palavras = p.getPalavrasSorteadas(new Categoria(1L,"Adjetivo"),2,"Magayver");

        for (Palavra palavra : palavras) {
            System.out.println(palavra.getNome());
        }

    }

}

package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Palavra;
import utfpr.edu.br.model.dao.CategoriaDao;
import utfpr.edu.br.model.dao.PalavraDao;

import java.util.List;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        CategoriaDao daoc = Getinjector.getInstance().getInstance(CategoriaDao.class);
        PalavraDao dao = Getinjector.getInstance().getInstance(PalavraDao.class);
        List<Palavra> palavraList = dao.getPalavrasSorteadas(daoc.findByID(1L),3);
        for (Palavra palavra : palavraList) {
            System.out.println(palavra.getNome());
        }

    }

}

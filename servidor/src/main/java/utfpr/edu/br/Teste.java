package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.controller.ControladorCategoria;
import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.dao.CategoriaDao;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        Categoria c = Getinjector.getInstance().getInstance(CategoriaDao.class).save(new Categoria("Mascote"));
        Getinjector.getInstance().getInstance(ControladorCategoria.class).save(c);
        }
}

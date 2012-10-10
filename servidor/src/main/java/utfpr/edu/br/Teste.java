package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.bean.JogadoresDoJogo;
import utfpr.edu.br.model.bean.Jogo;
import utfpr.edu.br.model.dao.JogadoresDoJogoDao;
import utfpr.edu.br.model.dao.JogoDao;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        JogadoresDoJogoDao dao = Getinjector.getInstance().getInstance(JogadoresDoJogoDao.class);
        Jogo j = new Jogo();
        j.setCategoria(new Categoria(1L,"Adjetivo"));
        j.setNumRodadas(3L);
        dao.save(new JogadoresDoJogo(71L,
                Getinjector.getInstance().getInstance(JogoDao.class).save(j).getId().intValue(),null));
    }

}

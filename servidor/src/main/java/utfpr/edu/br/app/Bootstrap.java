package utfpr.edu.br.app;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 15:27
 */

import com.google.inject.Injector;
import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.*;
import utfpr.edu.br.model.dao.*;

/**
 * @author Bernardo Vale
 * Classe com a responsabilidade de chamar o inicio da aplicacao e startar a primeira instancia do Guice
 */
public class Bootstrap {
    public static void main(String[] args) {
            //ServidorViewImpl app = new ServidorViewImpl();
            //app.run();
            Injector injector = Getinjector.getInstance();
            Categoria c = new Categoria("Apetrechos");
            Jogador j = new Jogador("Jhones");
            Palavra p1 = new Palavra("Banana",c);
            Palavra p2 = new Palavra("Maça",c);
            Jogo jogo = new Jogo(c,5L);
            injector.getInstance(CategoriaDao.class).save(c);
            j = injector.getInstance(JogadorDao.class).save(j);
            injector.getInstance(JogoDao.class).save(jogo);
            p1 = injector.getInstance(PalavraDao.class).save(p1);
            p2 = injector.getInstance(PalavraDao.class).save(p2);
            injector.getInstance
                    (PalavrasDoJogoDao.class).update(new PalavrasDoJogo(2,2,jogo));
            injector.getInstance
                (PalavrasDoJogoDao.class).save(new PalavrasDoJogo(p2.getId().intValue(),j.getId(),null));
            injector.getInstance(JogadoresDoJogoDao.class).save(new JogadoresDoJogo(
                j.getId(),jogo.getId().intValue(),null));
            injector.getInstance(JogadoresDoJogoDao.class).update(new JogadoresDoJogo(
                j.getId(),jogo.getId().intValue(),15L));
    }
}

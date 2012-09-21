package utfpr.edu.br.model.dao;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 13:56
 */

import utfpr.edu.br.model.bean.Jogo;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * @author Bernardo Vale
 */
public class JogoDao extends AbstractDao<Jogo> {


    @Inject
    public JogoDao(Provider<EntityManager> emp) {
        super(emp, Jogo.class);
    }
}

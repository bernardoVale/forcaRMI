package utfpr.edu.br.model.dao;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 16:59
 */

import utfpr.edu.br.model.bean.JogadoresDoJogo;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * @author Bernardo Vale
 */
public class JogadoresDoJogoDao extends AbstractDao<JogadoresDoJogo> {
    /**
     * Implemente este construtor na sua classe específica sem receber o parametro clazz.
     * O Guice não consegue injetar Class de objetos, então você terá de fazê-lo manualmente.
     *
     * @param emp
     */
    @Inject
    public JogadoresDoJogoDao(Provider<EntityManager> emp) {
        super(emp, JogadoresDoJogo.class);
    }
}

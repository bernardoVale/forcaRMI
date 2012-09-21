package utfpr.edu.br.model.dao;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 20:09
 */

import utfpr.edu.br.model.bean.Palavra;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * @author Bernardo Vale
 */
public class PalavraDao extends AbstractDao<Palavra>{

    @Inject
    public PalavraDao(Provider<EntityManager> emp) {
        super(emp,Palavra.class);
    }
}

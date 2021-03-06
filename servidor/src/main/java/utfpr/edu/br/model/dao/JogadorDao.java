package utfpr.edu.br.model.dao;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 20:15
 */

import utfpr.edu.br.model.bean.Jogador;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * @author Bernardo Vale
 */
public class JogadorDao extends AbstractDao<Jogador>{
    /**
     * Implemente este construtor na sua classe específica sem receber o parametro clazz.
     * O Guice não consegue injetar Class de objetos, então você terá de fazê-lo manualmente.
     *
     * @param emp
     */
    @Inject
    public JogadorDao(Provider<EntityManager> emp) {
        super(emp,Jogador.class);
    }

    public Jogador findByNome(String nome){
        try{
            return em().createQuery("SELECT j from Jogador j where " +
                    "j.nome=?1",Jogador.class).setParameter(1,nome).getSingleResult();
        }catch (NoResultException e){
            System.out.println("No result");
            return null;
        }
    }
}

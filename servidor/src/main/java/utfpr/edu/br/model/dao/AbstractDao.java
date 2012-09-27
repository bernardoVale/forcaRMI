package utfpr.edu.br.model.dao;

import com.google.inject.persist.Transactional;
import utfpr.edu.br.model.bean.IBean;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.inject.Provider;
import java.util.List;

/**
 * Dao abstrato.
 *
 * @author Bernardo Vale
 */
public abstract class AbstractDao<T extends IBean> {

  private final Provider<EntityManager> emp;
  private final Class<T> clazz;

  /**
   * Implemente este construtor na sua classe específica sem receber o parametro clazz.
   * O Guice não consegue injetar Class de objetos, então você terá de fazê-lo manualmente.
   *
   * @param emp
   * @param clazz
   */
  public AbstractDao(Provider<EntityManager> emp, Class<T> clazz) {
    this.clazz = clazz;
    this.emp = emp;
  }

  /**
   * Pega a instancia do entity manager.
   *
   * @return instance de EM.
   */
  protected final EntityManager em() {
    return emp.get();
  }

  /**
   * Salva o objeto no banco.
   * Trata internamente o Persist/Update.
   *
   * @param t objeto a ser salvo.
   * @return objeto atualizado.
   */
  @Transactional
  public T save(T t) {
    if (t != null && t.getId() != null) {
      t = em().merge(t);
      em().flush();
      return t;
    }
    em().persist(t);
    return t;
  }
    @Transactional
    public T findByKeyAtribute(String key,String keyValue){
      return (T) em().createQuery("Select t from " +
              "" + clazz.getSimpleName() + " t where t."+key+"='"+keyValue+"'",clazz)
        .getSingleResult();
    }

    /**
     * Metodo so para atualizaçao. Foi necessario utiliza-lo fora do save para que
     * as classes que sao tabelas associativas pudessem atiliza-los sem que precisassem
     * ter uma id unica.
     * @param t objeto
     * @return objeto atualizado
     */
  @Transactional
  public T update(T t) {
      t = em().merge(t);
      em().flush();
      return t;
  }


  /**
   * Carrega um objeto do banco a partir de seu ID.
   *
   * @param id id do objeto
   * @return objeto carregado.
   */
  @Transactional
  public T findByID(Long id) {
    return em().find(clazz, id);
  }

  /**
   * Apaga um registro do banco.
   *
   * @param t Objeto a ser excluido.
   */
  @Transactional
  public void remove(T t) {
    em().remove(t.getId() != null ? em().merge(t) : t);
  }

  /**
   * Retorna uma lista com todos os objetos do tipo T do banco.
   *
   * @return
   */
  @Transactional
  public List<T> findAll() {
    TypedQuery<T> query = em().createQuery("select e from " + clazz.getSimpleName() + " e", clazz);
    return query.getResultList();
  }
}

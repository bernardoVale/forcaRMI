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

    /**
     * Metodo que retorna quantos jogadores estao em um determinado jogo
     * @param idJogo
     * @return Quatidade
     */
    public Long quantidadeDeJogadores(Long idJogo){
        return  (Long) em().createQuery("SELECT COUNT(j.id.jogo_id) FROM JogadoresDoJogo j " +
                "where j.id.jogo_id = ?1").setParameter(1,idJogo).getSingleResult();
    }

    public Long idAdversario(Long idJogador,Long idJogo){
        return (Long) em().createQuery("SELECT j.id.jogador_id from JogadoresDoJogo j " +
                "where  j.id.jogo_id=?2 and not j.id.jogador_id =?1")
        .setParameter(1,idJogador).setParameter(2,idJogo).getSingleResult();
    }

    /**
     * Retorna a id do jogo em que os jogadores estao
     * @param jogador
     * @param adversario
     * @return
     */
    public Integer getJogo(Long jogador,Long adversario){
        return (Integer) em().createQuery("SELECT distinct j.id.jogo_id from JogadoresDoJogo j" +
                " where j.id.jogador_id=?1 and j.id.jogo_id = (SELECT distinct j.id.jogo_id " +
                "from JogadoresDoJogo j where j.id.jogador_id=?2)").
                setParameter(1,jogador).setParameter(2,adversario).getSingleResult();
    }
}

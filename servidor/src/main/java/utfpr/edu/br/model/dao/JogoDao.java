package utfpr.edu.br.model.dao;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 13:56
 */

import utfpr.edu.br.converter.JogoConverter;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.model.bean.Jogo;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class JogoDao extends AbstractDao<Jogo> {
     private JogoConverter cv;

    @Inject
    public JogoDao(Provider<EntityManager> emp) {
        super(emp, Jogo.class);
    }
    public List<JogoDTO> listaJogo()throws NoResultException,Exception{
       List<JogoDTO> lista = new ArrayList<JogoDTO>();
       List<Jogo> jogoList =  em().createQuery("SELECT j from Jogo j").getResultList();
        for (Jogo jogo : jogoList) {
            JogoDTO dto = cv.toDTO(jogo);
            dto.setNum_Jogadores((Long) em().createQuery("Select count(a) from JogadoresDoJogo a where a.id.jogo_id=?1")
                    .setParameter(1,jogo.getId()).getSingleResult());
            lista.add(dto);
        }
       return lista;
    }
}

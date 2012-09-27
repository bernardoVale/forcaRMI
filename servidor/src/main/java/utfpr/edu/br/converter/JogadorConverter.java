package utfpr.edu.br.converter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 20:42
 */

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.model.bean.Jogador;

/**
 * @author Bernardo Vale
 */
public class JogadorConverter extends AbstractConverter<Jogador,JogadorDTO>{
    @Override
    public Jogador toBean(JogadorDTO dto) {
          return new Jogador(dto.getId(),dto.getNome(),dto.getSenha());
    }

    @Override
    public JogadorDTO toDTO(Jogador bean) {
        return new JogadorDTO(bean.getId(),bean.getNome(),bean.getSenha());  //To change body of implemented methods use File | Settings | File Templates.
    }
}

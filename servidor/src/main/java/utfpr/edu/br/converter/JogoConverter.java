package utfpr.edu.br.converter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 24/09/12
 * Time: 19:30
 */

import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.model.bean.Jogo;

/**
 * @author Bernardo Vale
 */
public class JogoConverter extends AbstractConverter<Jogo,JogoDTO>{
     private CategoriaConverter catConv;

    @Override
    public Jogo toBean(JogoDTO dto) {
        catConv = new CategoriaConverter();
        return new Jogo(dto.getId(),dto.getNumRodadas(),catConv.toBean(dto.getCategoria()));
    }

    @Override
    public JogoDTO toDTO(Jogo bean) {
        catConv = new CategoriaConverter();
        return new JogoDTO(bean.getId(),bean.getNumRodadas(),catConv.toDTO(bean.getCategoria()));
    }
}

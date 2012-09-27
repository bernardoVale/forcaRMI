package utfpr.edu.br.converter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 24/09/12
 * Time: 19:23
 */

import utfpr.edu.br.dto.CategoriaDTO;
import utfpr.edu.br.model.bean.Categoria;

/**
 * @author Bernardo Vale
 */
public class CategoriaConverter extends AbstractConverter<Categoria,CategoriaDTO>{
    @Override
    public Categoria toBean(CategoriaDTO dto) {
        return new Categoria(dto.getId(),dto.getNome());
    }

    @Override
    public CategoriaDTO toDTO(Categoria bean) {
        return new CategoriaDTO(bean.getId(),bean.getNome());
    }
}

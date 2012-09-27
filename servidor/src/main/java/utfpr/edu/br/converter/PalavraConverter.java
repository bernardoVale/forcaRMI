package utfpr.edu.br.converter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 24/09/12
 * Time: 19:38
 */

import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.model.bean.Palavra;

/**
 * @author Bernardo Vale
 */
public class PalavraConverter extends AbstractConverter<Palavra,PalavraDTO>{
    private CategoriaConverter cv;
    @Override
    public Palavra toBean(PalavraDTO dto) {
        cv = new CategoriaConverter();
        return new Palavra(dto.getId(),dto.getNome(),cv.toBean(dto.getCategoria()));
    }

    @Override
    public PalavraDTO toDTO(Palavra bean) {
        cv = new CategoriaConverter();
        return new PalavraDTO(bean.getId(),bean.getNome(),cv.toDTO(bean.getCategoria()));
    }
}

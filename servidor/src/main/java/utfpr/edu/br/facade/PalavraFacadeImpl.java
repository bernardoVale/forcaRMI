package utfpr.edu.br.facade;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 14:03
 */

import utfpr.edu.br.converter.CategoriaConverter;
import utfpr.edu.br.converter.PalavraConverter;
import utfpr.edu.br.dto.CategoriaDTO;
import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.model.dao.PalavraDao;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class PalavraFacadeImpl implements PalavraFacade{

    private final PalavraDao dao;
    private final PalavraConverter cvPalavra;
    private final CategoriaConverter cv;

    @Inject
    public PalavraFacadeImpl(PalavraDao dao, PalavraConverter cvPalavra, CategoriaConverter cv) {
        this.dao = dao;

        this.cvPalavra = cvPalavra;
        this.cv = cv;
    }

    @Override
    public List<PalavraDTO> sortearPalavras(Long quantidade, CategoriaDTO categoriaPalavra) {
        return cvPalavra.toDTOList(dao.getPalavrasSorteadas(cv.toBean(categoriaPalavra),quantidade.intValue()));
    }
}

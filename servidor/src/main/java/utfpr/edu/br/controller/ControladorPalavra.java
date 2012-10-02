package utfpr.edu.br.controller;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 20:09
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.converter.PalavraConverter;
import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.model.bean.Palavra;
import utfpr.edu.br.model.dao.PalavraDao;
import utfpr.edu.br.util.Erros;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class ControladorPalavra extends AbstractControlador<Palavra,PalavraDTO,PalavraDao>{
    private final PalavraDao dao;
    private final PalavraConverter converter;
    /**
     * Mesmo caso do Dao, tem que tirar o clazz e colocar a classe manualmente
     *
     * @param dao
     * @param converter
     */
    @Inject
    public ControladorPalavra(PalavraDao dao, PalavraConverter converter) {
        super(dao,Palavra.class, converter);
        this.dao = dao;
        this.converter = converter;
    }

    public RetornoValidacao getPalavrasDoJogo(Long jogo_id){
        List<PalavraDTO> palavras;
        try{
            palavras = converter.toDTOList(dao.getPalavrasDoJogo(jogo_id));
        }catch (Exception e){
            return new RetornoValidacao(Erros.PALAVRA_NAO_ENCONTRADAS.nome());
        }
        return new RetornoValidacao(palavras);
    }
}

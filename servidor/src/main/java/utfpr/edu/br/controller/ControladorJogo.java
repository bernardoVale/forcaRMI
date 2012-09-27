package utfpr.edu.br.controller;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.converter.JogoConverter;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.model.bean.Jogo;
import utfpr.edu.br.model.dao.JogoDao;
import utfpr.edu.br.util.Erros;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 22/09/12
 * Time: 14:30
 */
public class ControladorJogo extends AbstractControlador<Jogo,JogoDTO,JogoDao>{
    private final JogoDao dao;
    private final JogoConverter converter;
    /**
     * Mesmo caso do Dao, tem que tirar o clazz e colocar a classe manualmente
     *
     * @param dao
     * @param converter
     */
    @Inject
    public ControladorJogo(JogoDao dao, JogoConverter converter) {
        super(dao,Jogo.class, converter);
        this.dao = dao;
        this.converter = converter;
    }

    public RetornoValidacao listaJogos(){
        RetornoValidacao rv = new RetornoValidacao();
        try {
            rv.setObjeto(dao.listaJogo());
        } catch (Exception e) {
            rv.setErro(Erros.PERSISTENCIA.nome());
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return rv;
    }
}
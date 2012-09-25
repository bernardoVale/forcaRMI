package utfpr.edu.br.controller;

import utfpr.edu.br.converter.CategoriaConverter;
import utfpr.edu.br.dto.CategoriaDTO;
import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.dao.CategoriaDao;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 15:14
 */
public class ControladorCategoria extends AbstractControlador<Categoria,CategoriaDTO,CategoriaDao>{
    private final CategoriaConverter converter;
    private final CategoriaDao dao;

    @Inject
    public ControladorCategoria(CategoriaDao dao, CategoriaConverter converter) {
        super(dao,Categoria.class,converter);
        this.dao = dao;
        this.converter = converter;
    }

}
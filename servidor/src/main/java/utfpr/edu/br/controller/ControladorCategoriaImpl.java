package utfpr.edu.br.controller;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 15:15
 */

import com.google.inject.Inject;
import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.dao.CategoriaDao;

/**
 * @author Bernardo Vale
 */
public class ControladorCategoriaImpl implements ControladorCategoria{
    private final CategoriaDao dao;

    @Inject
    public ControladorCategoriaImpl(CategoriaDao dao) {
        this.dao = dao;
    }

    @Override
    public RetornoValidacao salvar(Categoria c) {
        dao.save(c);
        return new RetornoValidacao();
    }
}

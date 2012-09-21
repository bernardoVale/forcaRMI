package utfpr.edu.br.model.dao;


import com.google.inject.Inject;
import utfpr.edu.br.model.bean.Categoria;

import javax.inject.Provider;
import javax.persistence.EntityManager;

public class CategoriaDao extends AbstractDao<Categoria> {

    @Inject
    public CategoriaDao(Provider<EntityManager> emp) {
        super(emp, Categoria.class);
    }
}

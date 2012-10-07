package utfpr.edu.br.model.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utfpr.edu.br.model.bean.Jogo;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2012-10-07T18:59:35")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Long> id;
    public static volatile CollectionAttribute<Categoria, Jogo> jogo;
    public static volatile SingularAttribute<Categoria, String> nome;

}
package utfpr.edu.br.model.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utfpr.edu.br.model.bean.Categoria;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2012-10-07T18:59:35")
@StaticMetamodel(Palavra.class)
public class Palavra_ { 

    public static volatile SingularAttribute<Palavra, Long> id;
    public static volatile SingularAttribute<Palavra, Categoria> categoria;
    public static volatile SingularAttribute<Palavra, String> nome;

}
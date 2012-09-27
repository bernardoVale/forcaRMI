package utfpr.edu.br.model.bean;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 13:24
 */

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Bernardo Vale
 */
@Entity
@Table(name = "categoria")
public class Categoria implements IBean {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
    @SequenceGenerator(allocationSize = 1, name = "seq_categoria", sequenceName = "seq_categoria")
    private Long id;

    @Column(name = "nome")
    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        if (id != null ? !id.equals(categoria.id) : categoria.id != null) return false;
        if (nome != null ? !nome.equals(categoria.nome) : categoria.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoria")
    private Collection<Jogo> jogo;

    public Collection<Jogo> getJogo() {
        return jogo;
    }

    public void setJogo(Collection<Jogo> jogo) {
        this.jogo = jogo;
    }
}

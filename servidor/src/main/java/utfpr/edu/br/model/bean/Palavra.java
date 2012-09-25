package utfpr.edu.br.model.bean;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 19:24
 */

import javax.persistence.*;

/**
 * @author Bernardo Vale
 */
@Entity
public class Palavra implements IBean{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_palavra")
    @SequenceGenerator(allocationSize = 1, name = "seq_palavra", sequenceName = "seq_palavra")
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Palavra() {
    }

    public Palavra(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public Palavra(Long id, String nome, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Palavra)) return false;

        Palavra palavra = (Palavra) o;

        if (categoria != null ? !categoria.equals(palavra.categoria) : palavra.categoria != null) return false;
        if (id != null ? !id.equals(palavra.id) : palavra.id != null) return false;
        if (nome != null ? !nome.equals(palavra.nome) : palavra.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        return result;
    }
}

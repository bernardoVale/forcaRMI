package utfpr.edu.br.model.bean;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 18/09/12
 * Time: 21:14
 */

import javax.persistence.*;

/**
 * @author Bernardo Vale
 */
@Entity
public class Jogo implements IBean{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jogo")
    @SequenceGenerator(allocationSize = 1, name = "seq_jogo", sequenceName = "seq_jogo")
    private Long id;
    private Long numRodadas;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Jogo() {
    }

    public Jogo(Categoria categoria, Long numRodadas) {
        this.categoria = categoria;
        this.numRodadas = numRodadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumRodadas() {
        return numRodadas;
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
        if (!(o instanceof Jogo)) return false;

        Jogo jogo = (Jogo) o;

        if (categoria != null ? !categoria.equals(jogo.categoria) : jogo.categoria != null) return false;
        if (id != null ? !id.equals(jogo.id) : jogo.id != null) return false;
        if (numRodadas != null ? !numRodadas.equals(jogo.numRodadas) : jogo.numRodadas != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (numRodadas != null ? numRodadas.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        return result;
    }
}

package utfpr.edu.br.model.bean;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 20:13
 */

import javax.persistence.*;

/**
 * @author Bernardo Vale
 */
@Entity
public class Jogador implements IBean{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jogador")
    @SequenceGenerator(allocationSize = 1, name = "seq_jogador", sequenceName = "seq_jogador")
    private Long id;
    private String nome;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public Jogador(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Jogador() {
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

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

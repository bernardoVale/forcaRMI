package utfpr.edu.br.dto;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 20:29
 */

/**
 * @author Bernardo Vale
 */
public class JogadorDTO implements DTO {

    private Long id;
    private String nome;
    private String senha;

    public JogadorDTO() {
    }

    public JogadorDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public JogadorDTO(Long id, String nome,String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }
    public JogadorDTO(String nome,String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "JogadorDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

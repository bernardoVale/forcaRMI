package utfpr.edu.br.dto;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 24/09/12
 * Time: 19:21
 */

/**
 * @author Bernardo Vale
 */
public class PalavraDTO implements DTO{

    private Long id;
    private String nome;
    private CategoriaDTO categoria;
    private String nomeMascarado;

    public PalavraDTO() {
    }

    public PalavraDTO(Long id, String nome, CategoriaDTO categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public PalavraDTO(Long id, String nome, CategoriaDTO categoria, String nomeMascarado) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.nomeMascarado = nomeMascarado;
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

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public String getNomeMascarado() {
        return nomeMascarado;
    }

    public void setNomeMascarado(String nomeMascarado) {
        this.nomeMascarado = nomeMascarado;
    }
}

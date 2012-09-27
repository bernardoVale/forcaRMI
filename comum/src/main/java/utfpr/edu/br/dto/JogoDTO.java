package utfpr.edu.br.dto;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 22/09/12
 * Time: 14:32
 */

/**
 * @author Bernardo Vale
 */
public class JogoDTO implements DTO{

    private Long id;
    private Long numRodadas;
    private CategoriaDTO categoria;
    private Long num_Jogadores;

    public JogoDTO(Long id, Long numRodadas, CategoriaDTO categoria) {
        this.id = id;
        this.numRodadas = numRodadas;
        this.categoria = categoria;
    }

    public JogoDTO(Long id, Long numRodadas, CategoriaDTO categoria, Long num_Jogadores) {
        this.id = id;
        this.numRodadas = numRodadas;
        this.categoria = categoria;
        this.num_Jogadores = num_Jogadores;
    }

    public JogoDTO() {
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

    public void setNumRodadas(Long numRodadas) {
        this.numRodadas = numRodadas;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JogoDTO)) return false;

        JogoDTO jogoDTO = (JogoDTO) o;

        if (categoria != null ? !categoria.equals(jogoDTO.categoria) : jogoDTO.categoria != null) return false;
        if (id != null ? !id.equals(jogoDTO.id) : jogoDTO.id != null) return false;
        if (numRodadas != null ? !numRodadas.equals(jogoDTO.numRodadas) : jogoDTO.numRodadas != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (numRodadas != null ? numRodadas.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JogoDTO{" +
                "id=" + id +
                ", numRodadas=" + numRodadas +
                ", categoria=" + categoria +
                '}';
    }

    public Long getNum_Jogadores() {
        return num_Jogadores;
    }

    public void setNum_Jogadores(Long num_Jogadores) {
        this.num_Jogadores = num_Jogadores;
    }
}

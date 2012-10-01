package utfpr.edu.br.dto;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 17:08
 */


import java.io.Serializable;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class DadosDoJogoDTO implements Serializable {

    private JogoDTO jogo;
    private List<PalavraDTO> palavras;

    public DadosDoJogoDTO(JogoDTO jogo, List<PalavraDTO> palavras) {
        this.jogo = jogo;
        this.palavras = palavras;
    }

    public DadosDoJogoDTO() {
    }

    public JogoDTO getJogo() {
        return jogo;
    }

    public void setJogo(JogoDTO jogo) {
        this.jogo = jogo;
    }

    public List<PalavraDTO> getPalavras() {
        return palavras;
    }

    public void setPalavras(List<PalavraDTO> palavras) {
        this.palavras = palavras;
    }
}

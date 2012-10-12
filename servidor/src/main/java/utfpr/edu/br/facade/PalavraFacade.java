package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.CategoriaDTO;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.dto.PalavraDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 14:03
 */
public interface PalavraFacade {

     List<PalavraDTO> sortearPalavras(Long quantidade,CategoriaDTO categoriaPalavra);
     RetornoValidacao getPalavrasDoJogo(Long jogo_id);

    void salvarPalavraCorreta(JogadorDTO jogador, PalavraDTO palavra, JogoDTO jogo);
}
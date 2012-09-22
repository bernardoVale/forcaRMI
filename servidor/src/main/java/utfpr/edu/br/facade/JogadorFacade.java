package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogadorDTO;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:19
 */
public interface JogadorFacade {
    public JogadorDTO saveJogador(String nome);
    public RetornoValidacao autenticar(String nome);

}
package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:19
 */
public interface JogadorFacade {
    public RetornoValidacao saveJogador(String nome,String senha);
    public RetornoValidacao autenticar(String nome,String senha);
    public RetornoValidacao adversario(JogadorDTO j,JogoDTO jogo);

}
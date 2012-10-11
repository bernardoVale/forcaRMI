package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.dto.JogoDTO;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 19:52
 */
public interface JogoFacade {
     public RetornoValidacao iniciarJogo(JogadorDTO j);
     public RetornoValidacao listaJogos();
     public RetornoValidacao iniciarPartida(JogadorDTO jogador,JogadorDTO adversario);
     public RetornoValidacao efetuarJogada(JogoAtivoDTO jogo);
     public RetornoValidacao eMeuTurno(JogadorDTO jogador, JogoDTO jogo);
     public RetornoValidacao criarJogo(JogadorDTO jogador, JogoDTO jogo);
     public RetornoValidacao listarJogos();

}
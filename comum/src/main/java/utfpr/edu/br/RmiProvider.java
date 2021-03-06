package utfpr.edu.br;

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.dto.JogoDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface provedora dos metodos de comunicação entre cliente e servidor
 * 
 *
 *  @author Bernardo Vale
 */
public interface RmiProvider extends Remote{
	String mensagem(String mensagem)throws RemoteException;
    //loga no sistema e cria o jogo e as palavras
    RetornoValidacao iniciarJogo(String nome,String senha)throws RemoteException;
    RetornoValidacao popularJogos() throws RemoteException;
    RetornoValidacao retornaAdversario(JogadorDTO jogador,JogoDTO jogo)throws RemoteException;

    //recebe a lista das palavras
    RetornoValidacao iniciarPartida(JogadorDTO jogador,JogadorDTO adversario,JogoDTO jogo)throws RemoteException;
    RetornoValidacao efetuarJogada(JogoAtivoDTO jogo)throws RemoteException;

    //Retorno um jogoativoDTO atualizado caso seja o turno do jogadorpassado caso contrario retorna nulo
    RetornoValidacao eMeuTurno(JogadorDTO jogador,JogoDTO jogo)throws RemoteException;
    //Cria um novo jogo e adiciona o o jogador a aquele jogo
    RetornoValidacao criarJogo(JogadorDTO jogador, JogoDTO jogo) throws RemoteException;

    //Retorna todos os jogos e a quantidade de jogadores neles contido
    RetornoValidacao listarJogos() throws RemoteException;
}

package utfpr.edu.br;

import utfpr.edu.br.dto.JogadorDTO;

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
    RetornoValidacao iniciarJogo(String nome,String senha)throws RemoteException;
    RetornoValidacao popularJogos() throws RemoteException;
    RetornoValidacao retornaAdversario(JogadorDTO jogador)throws RemoteException;
}

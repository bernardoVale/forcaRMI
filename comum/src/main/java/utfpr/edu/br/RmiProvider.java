package utfpr.edu.br;

import utfpr.edu.br.dto.JogoDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface provedora dos metodos de comunicação entre cliente e servidor
 * 
 *
 *  @author Bernardo Vale
 */
public interface RmiProvider extends Remote{
	String mensagem(String mensagem)throws RemoteException;
    RetornoValidacao iniciarJogo(String nome)throws RemoteException;
    RetornoValidacao popularJogos() throws RemoteException;
}

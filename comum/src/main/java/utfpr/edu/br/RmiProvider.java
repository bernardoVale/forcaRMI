package utfpr.edu.br;

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
    RetornoValidacao autenticarJogador(String nome,String md5)throws RemoteException;
}

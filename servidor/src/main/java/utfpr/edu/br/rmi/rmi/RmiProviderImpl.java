package utfpr.edu.br.rmi.rmi;

import utfpr.edu.br.RmiProvider;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiProviderImpl extends UnicastRemoteObject implements RmiProvider {

    private static final long serialVersionUID = 1L;

    protected RmiProviderImpl() throws RemoteException {
        super();
    }

    @Override
    public String mensagem(String mensagem) throws RemoteException {
        return "Testando o servidor para: "+mensagem;
    }

    @Override
    public String autenticarJogador(String nome) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

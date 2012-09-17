package utfpr.edu.br.rmi;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.RmiProvider;
import utfpr.edu.br.facade.Jogador;
import utfpr.edu.br.facade.JogadorFacade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiProviderImpl extends UnicastRemoteObject implements RmiProvider {

    private static final long serialVersionUID = 1L;
    private JogadorFacade facade;

    protected RmiProviderImpl() throws RemoteException {
        super();
        facade = Jogador.getInstance();
    }

    @Override
    public String mensagem(String mensagem) throws RemoteException {
        return "Testando o servidor para: "+mensagem;
    }

    @Override
    public RetornoValidacao autenticarJogador(String nome,String md5) throws RemoteException {
       return facade.autenticar(nome,md5);
    }
}

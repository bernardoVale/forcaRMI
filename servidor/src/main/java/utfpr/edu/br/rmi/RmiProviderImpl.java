package utfpr.edu.br.rmi;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.RmiProvider;
import utfpr.edu.br.controller.ControladorCategoria;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.facade.JogadorFacade;
import utfpr.edu.br.facade.JogadorFacadeImpl;
import utfpr.edu.br.facade.JogoFacade;
import utfpr.edu.br.facade.JogoFacadeImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiProviderImpl extends UnicastRemoteObject implements RmiProvider {

    private static final long serialVersionUID = 1L;
    private JogadorFacade facadeJogador;
    private JogoFacade facadeJogo;
    private ControladorCategoria categoria;

    protected RmiProviderImpl() throws RemoteException {
        super();
        facadeJogador = new JogadorFacadeImpl();
        facadeJogo = new JogoFacadeImpl();
    }

    @Override
    public String mensagem(String mensagem) throws RemoteException {
        return "Testando o servidor para: "+mensagem;
    }

    @Override
    public RetornoValidacao iniciarJogo(String nome) throws RemoteException {
        RetornoValidacao rv = facadeJogador.autenticar(nome);
       if(rv.isOk()){
           facadeJogo.iniciarJogo((JogadorDTO) rv.getObjeto());
       }
       return rv;
    }
}

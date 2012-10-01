package utfpr.edu.br.rmi;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.RmiProvider;
import utfpr.edu.br.controller.ControladorCategoria;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.facade.JogadorFacade;
import utfpr.edu.br.facade.JogadorFacadeImpl;
import utfpr.edu.br.facade.JogoFacade;
import utfpr.edu.br.facade.JogoFacadeImpl;
import utfpr.edu.br.inject.Getinjector;

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
        facadeJogo = Getinjector.getInstance().getInstance(JogoFacadeImpl.class);
    }

    @Override
    public String mensagem(String mensagem) throws RemoteException {
        System.out.println(mensagem);
        return "Testando o servidor para: "+mensagem;
    }

    @Override
    public RetornoValidacao iniciarJogo(String nome,String senha) throws RemoteException {
        RetornoValidacao rv = facadeJogador.autenticar(nome,senha);
       if(rv.isOk()){
           return facadeJogo.iniciarJogo((JogadorDTO) rv.getObjeto());
       }
       return rv;
    }

    @Override
    public RetornoValidacao popularJogos() throws RemoteException {
        //o objeto e uma lista de DTO de jogos.
        return facadeJogo.listaJogos();
    }

    @Override
    public RetornoValidacao retornaAdversario(JogadorDTO jogador) throws RemoteException {
        return facadeJogador.adversario(jogador);
    }

    @Override
    public RetornoValidacao iniciarPartida(JogadorDTO jogador, JogadorDTO adversario) throws RemoteException {
        return facadeJogo.iniciarPartida(jogador,adversario);
    }
}

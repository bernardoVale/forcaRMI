package utfpr.edu.br.rmi;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.RmiProvider;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.dto.JogoDTO;
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
       return rv;
    }

    @Override
    public RetornoValidacao popularJogos() throws RemoteException {
        //o objeto e uma lista de DTO de jogos.
        return facadeJogo.listaJogos();
    }

    @Override
    public RetornoValidacao retornaAdversario(JogadorDTO jogador,JogoDTO jogo) throws RemoteException {
        return facadeJogador.adversario(jogador,jogo);
    }

    @Override
    public RetornoValidacao iniciarPartida(JogadorDTO jogador, JogadorDTO adversario,JogoDTO jogo) throws RemoteException {
        return facadeJogo.iniciarPartida(jogador,adversario,jogo);
    }

    @Override
    public RetornoValidacao efetuarJogada(JogoAtivoDTO jogo) throws RemoteException {
        return facadeJogo.efetuarJogada(jogo);
    }

    @Override
    public RetornoValidacao eMeuTurno(JogadorDTO jogador, JogoDTO jogo) throws RemoteException {
        return facadeJogo.eMeuTurno(jogador,jogo);
    }

    @Override
    public RetornoValidacao criarJogo(JogadorDTO jogador, JogoDTO jogo) throws RemoteException {
        return facadeJogo.criarJogo(jogador,jogo);
    }

    @Override
    public RetornoValidacao listarJogos() throws RemoteException {
        return facadeJogo.listarJogos();
    }
}

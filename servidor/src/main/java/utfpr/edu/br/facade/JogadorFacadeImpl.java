package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.controller.ControladorJogador;
import utfpr.edu.br.controller.ControladorJogadorImpl;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.util.Erros;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 18:50
 */
public class JogadorFacadeImpl implements JogadorFacade{
    private ControladorJogador controlador;


    public JogadorFacadeImpl() {
        controlador = new ControladorJogadorImpl();
    }


    /**
     *  Metodo que inseri o jogador
     * @param nome Nome do jogador a inserir
     */
    @Override
    public JogadorDTO saveJogador(String nome){
        return controlador.salvar(new JogadorDTO(nome));
    }

    /**
     * Funçao que inseri o usuario no StringBuilder
     * @param nome Nome do JogadorFacadeImpl
     * @return A resultado da operacao
     */
    @Override
    public RetornoValidacao autenticar(String nome) {
        if(!controlador.jogadorExiste(new JogadorDTO(nome))){
            return new RetornoValidacao(saveJogador(nome));
        }
        return new RetornoValidacao(Erros.JOGADOREXISTE.nome());
    }
}

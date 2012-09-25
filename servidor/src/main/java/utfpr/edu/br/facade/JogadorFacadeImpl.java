package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.controller.ControladorJogador;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Jogador;
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
        controlador = Getinjector.getInstance().getInstance(ControladorJogador.class);
    }


    /**
     *  Metodo que inseri o jogador
     * @param nome Nome do jogador a inserir
     */
    @Override
    public RetornoValidacao saveJogador(String nome){
       return controlador.save(new Jogador(nome));
    }

    /**
     * Funçao que inseri o usuario no banco
     * @param nome Nome do JogadorFacadeImpl
     * @return Um retorno validaçao que podera ou nao ter erros.
     */
    @Override
    public RetornoValidacao autenticar(String nome) {
        if(!controlador.jogadorExiste(new JogadorDTO(nome))){
            return saveJogador(nome);
        }
        return new RetornoValidacao(Erros.JOGADOREXISTE.nome());
    }
}

package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.controller.ControladorJogador;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Jogador;
import utfpr.edu.br.util.Erros;
import utfpr.edu.br.util.JogadoresSession;

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
    public RetornoValidacao saveJogador(String nome,String senha){
       return controlador.save(new Jogador(nome,senha));
    }

    /**
     * Funçao que inseri o usuario no banco adiciona nos jogadores online e verifica
     * se as credenciais sao validas
     * @param nome Nome do JogadorFacadeImpl
     * @return Um retorno validaçao que podera ou nao ter erros.
     */
    @Override
    public RetornoValidacao autenticar(String nome,String senha) {
        if(!controlador.jogadorExiste(new JogadorDTO(nome,senha))){
            //Novas credenciais
            RetornoValidacao rv = saveJogador(nome,senha);
            //adiciono o fdp na sessao
            JogadoresSession.getJogadores().add(new JogadorDTO(nome,senha));
            return rv;
        }else{//Jogador existe, agora verifique se digitou corretamente
            if(controlador.credenciaisValidas(nome,senha)){
                JogadorDTO jogador = controlador.retornaJogador(nome);
                JogadoresSession.getJogadores().add(jogador);
                return new RetornoValidacao(jogador);
            }else{
                return new RetornoValidacao(Erros.CREDENCIAIS.nome());
            }
        }
    }
}

package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.controller.ControladorJogador;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Jogador;
import utfpr.edu.br.model.dao.JogadoresDoJogoDao;
import utfpr.edu.br.util.Erros;
import utfpr.edu.br.util.session.JogadoresSession;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public RetornoValidacao adversario(JogadorDTO j) {
        RetornoValidacao rv = new RetornoValidacao();
        JogadoresDoJogoDao daoJDJ = Getinjector.getInstance().getInstance(JogadoresDoJogoDao.class);
        Long quantidade = daoJDJ.quantidadeDeJogadores(1L);
        if(quantidade!=2){
            //Faço isso pra nao retorna NoResultException
            //Ou seja so procuro o idAdversario se houver adversario
           rv.setOk(false);
           return rv;
        }else{
            //todo tirar o jogo estatico e deixar dinamico
            Long idAdversario = daoJDJ.idAdversario(j.getId(),1L);
            rv = controlador.findById(idAdversario);
            //Antes de enviar o jogador adversario eu aproveio os dados e cadastro as palavras do jogo ;)

            return rv;
        }
    }
    private List<PalavraDTO> palavrasDoJogo(Long JogoId){
        RetornoValidacao rv = new RetornoValidacao();
        return new ArrayList<PalavraDTO>();
    }

    /*
    *        JogadoresDoJogoDao daoJDJ = Getinjector.getInstance().getInstance(JogadoresDoJogoDao.class);
        Integer jogo = daoJDJ.getJogo(jogador.getId(), adversario.getId());
        rv = control.findById(new Long(jogo)).getObjeto();
    */
}

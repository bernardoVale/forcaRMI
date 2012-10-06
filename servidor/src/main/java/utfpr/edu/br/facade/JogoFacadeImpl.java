package utfpr.edu.br.facade;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 19:54
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.controller.ControladorCategoria;
import utfpr.edu.br.controller.ControladorJogo;
import utfpr.edu.br.converter.AbstractConverter;
import utfpr.edu.br.dto.*;
import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.bean.JogadoresDoJogo;
import utfpr.edu.br.model.bean.Jogo;
import utfpr.edu.br.model.bean.PalavrasDoJogo;
import utfpr.edu.br.model.dao.JogadoresDoJogoDao;
import utfpr.edu.br.model.dao.PalavrasDoJogoDao;
import utfpr.edu.br.util.Erros;
import utfpr.edu.br.util.session.JogosSession;

import javax.inject.Inject;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class JogoFacadeImpl implements JogoFacade{
    private final ControladorJogo control;
    private final ControladorCategoria controlCat;
    private final AbstractConverter<Categoria,CategoriaDTO> cv;
    private final PalavraFacade facade;
    private RetornoValidacao rv;

    @Inject
    public JogoFacadeImpl(ControladorJogo control, ControladorCategoria controlCat, AbstractConverter<Categoria, CategoriaDTO> cv, PalavraFacade facade) {
        this.control = control;
        this.controlCat = controlCat;
        this.cv = cv;
        this.facade = facade;
        this.rv = new RetornoValidacao();
    }


    @Override
    public synchronized RetornoValidacao iniciarJogo(JogadorDTO j) {
        //todo aqui primeiramente sera criado uma categoria qualquer e um jogo qualquer so pra iniciar
        //rv = control.save(new Jogo(new Categoria("Adjetivo"),5L));
        rv = controlCat.findById(1L);
        //rv = controlCat.findByKey("nome","Adjetivo");
        if(!rv.isOk()){
            return rv;
        }
        JogadoresDoJogoDao daoJDJ = Getinjector.getInstance().getInstance(JogadoresDoJogoDao.class);
        Long quantidade = daoJDJ.quantidadeDeJogadores(1L);
        if(quantidade<2){     //pode salvar
          if(quantidade==0){
              sortearESalvarPalavras((CategoriaDTO)rv.getObjeto());
          }
          daoJDJ.save(new JogadoresDoJogo(j.getId(),
                  1,null));
          return new RetornoValidacao(j);
        }else{
            return new RetornoValidacao(Erros.JOGO_LOTADO.nome());
        }
    }

    private synchronized void sortearESalvarPalavras(CategoriaDTO categoria) {
        List<PalavraDTO> palavrasDoJogo;
        //traz o array das palavras sorteadas
        System.out.println(categoria);
        palavrasDoJogo = facade.sortearPalavras(3L,categoria);
        PalavrasDoJogoDao daoPalavaras = Getinjector.getInstance().getInstance(PalavrasDoJogoDao.class);
        for(int i=0;i<palavrasDoJogo.size();i++){
            //salva todas as palavras    //todo mudar para controlador
            daoPalavaras.save(new PalavrasDoJogo(palavrasDoJogo.get(i).getId().intValue(),1L));
        }
    }

    @Override
    public RetornoValidacao listaJogos() {
       return control.lista();
    }

    @Override
    public synchronized RetornoValidacao iniciarPartida(JogadorDTO jogador, JogadorDTO adversario) {
        RetornoValidacao rv;
        JogadoresDoJogoDao daoJDJ = Getinjector.getInstance().getInstance(JogadoresDoJogoDao.class);
        Integer jogoId = daoJDJ.getJogo(jogador.getId(), adversario.getId());
        rv = control.findById(new Long(jogoId));
        if(!rv.isOk()){
            return rv;
        }
        JogoDTO jogo = (JogoDTO) rv.getObjeto();
        rv = facade.getPalavrasDoJogo(jogoId.longValue());
        if(!rv.isOk()){
            return rv;
        }
        //Salvar na sessao e retorna os dados ao cliente
        return new RetornoValidacao(salvarJogoSessao
                (jogador,adversario,jogo, (List<PalavraDTO>) rv.getObjeto()));
    }

    @Override
    public synchronized RetornoValidacao efetuarJogada(JogoAtivoDTO jogo) {
        for (int i=0;i<JogosSession.getJogos().size();i++){
            System.out.println(JogosSession.getJogos().size());
           if(JogosSession.getJogos().get(i).getJogoDTO().getJogo().getId()
                   .equals(jogo.getJogoDTO().getJogo().getId())){
               JogoAtivoDTO antigo = JogosSession.getJogos().get(i);
               JogosSession.getJogos().remove(i);
               JogosSession.getJogos().add(i,jogo);
               break;
           }
        }
        return new RetornoValidacao(jogo);
    }

    @Override
    public synchronized RetornoValidacao eMeuTurno(JogadorDTO jogador, JogoDTO jogo) {
        for (int i=0;i<JogosSession.getJogos().size();i++){
            JogoAtivoDTO ativo = JogosSession.getJogos().get(i);
            System.out.println(JogosSession.getJogos().size());
            if(ativo.getJogoDTO().getJogo().getId()
                    .equals(jogo.getId())){
                if(ativo.getJogador1().getJogador().getId()
                        .equals(jogador.getId())){   //e o turno do cara, entao retorna o objeto atualizado
                    if(ativo.getJogador1().isMeuTurno()) return new RetornoValidacao(ativo);
                    return new RetornoValidacao(false);//ainda n e seu turno baby
                }else{//cai aqui pq quem requisitou foi o jogador2
                    if(ativo.getJogador2().isMeuTurno()) return new RetornoValidacao(ativo);
                    return new RetornoValidacao(false);
                }
            }
        }
        return new RetornoValidacao(false);
    }

    /**
     * Salva um jogo na sessao, um jogo ativo. A partir dele manipularemos todo um jogo
     * @param jogador   Jogador1
     * @param adversario  Jogador 2
     * @param jogo  Dados do Jogo
     * @param palavras Palavras daquele jogo
     */
    private synchronized JogoAtivoDTO salvarJogoSessao(JogadorDTO jogador, JogadorDTO adversario
            , JogoDTO jogo,List<PalavraDTO> palavras) {
        JogadorAtivoDTO jogador1 = new JogadorAtivoDTO(jogador,0);
        JogadorAtivoDTO jogador2 = new JogadorAtivoDTO(adversario,0);
        DadosDoJogoDTO dadosJogo = new DadosDoJogoDTO(jogo,palavras);
        for (JogoAtivoDTO jogoAtivoDTO : JogosSession.getJogos()) {
                //Primeiro jogador ja veio aqui e salvo meu filho, agora vai em paz
              if(jogoAtivoDTO.getJogoDTO().getJogo().getId().equals(dadosJogo.getJogo().getId())){
                  return jogoAtivoDTO;
              }
        }
        //A regra para o jogador que começa jogando e quem tem a menor(oldfag) id ;)
        if(jogador.getId()>adversario.getId()){
            jogador1.setMeuTurno(false);
            jogador2.setMeuTurno(true);
        }else{
            jogador1.setMeuTurno(true);
            jogador2.setMeuTurno(false);
        }
        JogoAtivoDTO jogoAtivo = new JogoAtivoDTO(jogador1, jogador2, dadosJogo, new ArrayList<String>(),
        new ArrayList<JLabel>());
        JogosSession.getJogos().add
                (jogoAtivo);
        System.out.println("Quantidade de jogos:" + JogosSession.getJogos().size());
        return jogoAtivo;
    }

    public RetornoValidacao criarNovoJogo(JogadorDTO j){
        rv = controlCat.findById(1L);
        if(!rv.isOk()){
            return rv;
        }//todo Quantidade de rodadas e categoria estatico. so vai rolar dinamico com lobby
        rv = control.save(new Jogo(cv.toBean((CategoriaDTO)rv.getObjeto()),3L));
        if(!rv.isOk()){
            return rv;
        }
        JogoDTO jogo = (JogoDTO) rv.getObjeto();
        //JogosSession.getJogos().add(jogo);
          //salvei e obtve a copia, agora gravo na "sessao"
        JogadoresDoJogo jdj = Getinjector.getInstance().     //fixme tratar exceçoes fazendo controladora
                getInstance(JogadoresDoJogoDao.class).save(new JogadoresDoJogo(j.getId(),
                jogo.getId().intValue(),null));

        return new RetornoValidacao();
    }
}

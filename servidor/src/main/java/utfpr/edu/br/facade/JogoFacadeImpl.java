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
    public RetornoValidacao iniciarJogo(JogadorDTO j) {
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
              sortearESalvarPalavras();
          }
          daoJDJ.save(new JogadoresDoJogo(j.getId(),
                  1,null));
          return new RetornoValidacao(j);
        }else{
            return new RetornoValidacao(Erros.JOGO_LOTADO.nome());
        }
    }

    private void sortearESalvarPalavras() {
        List<PalavraDTO> palavrasDoJogo;
        //traz o array das palavras sorteadas
        palavrasDoJogo = facade.sortearPalavras(3L,(CategoriaDTO) rv.getObjeto());
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
    public RetornoValidacao iniciarPartida(JogadorDTO jogador, JogadorDTO adversario) {
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
        return new RetornoValidacao(new DadosDoJogoDTO(jogo, (List<PalavraDTO>) rv.getObjeto()));
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
        JogosSession.getJogos().add(jogo);
          //salvei e obtve a copia, agora gravo na "sessao"
        JogadoresDoJogo jdj = Getinjector.getInstance().     //fixme tratar exceçoes fazendo controladora
                getInstance(JogadoresDoJogoDao.class).save(new JogadoresDoJogo(j.getId(),
                jogo.getId().intValue(),null));

        return new RetornoValidacao();
    }
}

package utfpr.edu.br.facade;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 19:54
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.controller.ControladorCategoria;
import utfpr.edu.br.controller.ControladorJogo;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.bean.JogadoresDoJogo;
import utfpr.edu.br.model.bean.Jogo;
import utfpr.edu.br.model.dao.JogadoresDoJogoDao;
import utfpr.edu.br.util.Erros;

import javax.inject.Inject;

/**
 * @author Bernardo Vale
 */
public class JogoFacadeImpl implements JogoFacade{
    private final ControladorJogo control;
    private final ControladorCategoria controlCat;
    private RetornoValidacao rv;

    @Inject
    public JogoFacadeImpl(ControladorJogo control, ControladorCategoria controlCat) {
        this.control = control;
        this.controlCat = controlCat;
        this.rv = new RetornoValidacao();
    }


    @Override
    public RetornoValidacao iniciarJogo(JogadorDTO j) {
        //todo aqui primeiramente sera criado uma categoria qualquer e um jogo qualquer so pra iniciar
        //rv = control.save(new Jogo(new Categoria("Adjetivo"),5L));
        rv = controlCat.findByKey("nome","Objeto");
        if(!rv.isOk()){
            return rv;
        }
        JogadoresDoJogoDao daoJDJ = Getinjector.getInstance().getInstance(JogadoresDoJogoDao.class);
        if(daoJDJ.quantidadeDeJogadores(1L)<2){     //pode salvar
          daoJDJ.save(new JogadoresDoJogo(j.getId(),
                  1,null));
          return new RetornoValidacao(j);
        }else{
            return new RetornoValidacao(Erros.JOGO_LOTADO.nome());
        }
    }

    @Override
    public RetornoValidacao listaJogos() {
       return control.lista();
    }


    public RetornoValidacao criarNovoJogo(JogadorDTO j){
        rv = control.save(new Jogo(new Categoria("Adjetivo"),5L));
        if(!rv.isOk()){
            return rv;
        }
        JogoDTO jogo = (JogoDTO) rv.getObjeto();
        Getinjector.getInstance().     //fixme tratar exceçoes fazendo controladora
                getInstance(JogadoresDoJogoDao.class).save(new JogadoresDoJogo(j.getId(),
                jogo.getId().intValue(),null));
        return new RetornoValidacao();
    }
}

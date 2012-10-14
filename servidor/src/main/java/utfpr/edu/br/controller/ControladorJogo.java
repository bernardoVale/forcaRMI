package utfpr.edu.br.controller;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.converter.JogoConverter;
import utfpr.edu.br.dto.JogadorAtivoDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.model.bean.JogadoresDoJogo;
import utfpr.edu.br.model.bean.Jogo;
import utfpr.edu.br.model.dao.JogadoresDoJogoDao;
import utfpr.edu.br.model.dao.JogoDao;
import utfpr.edu.br.util.Erros;

import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 22/09/12
 * Time: 14:30
 */
public class ControladorJogo extends AbstractControlador<Jogo,JogoDTO,JogoDao>{
    private final JogoDao dao;
    private final JogadoresDoJogoDao daoJogadores;
    private final JogoConverter converter;
    /**
     * Mesmo caso do Dao, tem que tirar o clazz e colocar a classe manualmente
     *
     * @param dao
     * @param daoJogadores
     * @param converter
     */
    @Inject
    public ControladorJogo(JogoDao dao, JogadoresDoJogoDao daoJogadores, JogoConverter converter) {
        super(dao,Jogo.class, converter);
        this.dao = dao;
        this.daoJogadores = daoJogadores;
        this.converter = converter;
    }

    public RetornoValidacao listaJogos(){
        RetornoValidacao rv = new RetornoValidacao();
        try {
            rv.setObjeto(dao.listaJogo());
        }catch (NoResultException e){
            rv.setErro(Erros.DADOSNAOENCONTRADOS.nome());
            e.printStackTrace();
        }
        catch (Exception e) {
            rv.setErro(Erros.PERSISTENCIA.nome());
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return rv;
    }

    public void cadastrarPontuacaoFinal(JogadorAtivoDTO jogador1, JogadorAtivoDTO jogador2, JogoDTO jogo) {
        daoJogadores.update(new JogadoresDoJogo(jogador1.getJogador().getId(),jogo.getId().intValue(),
                new Long(jogador1.getPontuacao())));
        daoJogadores.update(new JogadoresDoJogo(jogador2.getJogador().getId(),jogo.getId().intValue(),
                new Long(jogador2.getPontuacao())));
    }
}
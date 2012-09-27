package utfpr.edu.br.controller;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 18:56
 */

import utfpr.edu.br.converter.JogadorConverter;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.model.bean.Jogador;
import utfpr.edu.br.model.dao.JogadorDao;

import javax.inject.Inject;

/**
 * @author Bernardo Vale
 */
public class ControladorJogador extends AbstractControlador<Jogador,JogadorDTO,JogadorDao>{

       private final JogadorConverter converter;
       private JogadorDao dao;

    /**
     * Mesmo caso do Dao, tem que tirar o clazz e colocar a classe manualmente
     *
     * @param dao
     * @param converter
     *
     */
    @Inject
    public ControladorJogador(JogadorDao dao, JogadorConverter converter) {
        super(dao, Jogador.class, converter);
        this.dao = dao;
        this.converter = converter;
    }

    /**
     * Metodo que verifica se a senha do banco e igual a senha que que o cara me enviou
     * @param nome
     * @param senha
     * @return
     */
    public boolean credenciaisValidas(String nome,String senha){
        return senha.equals(dao.findByNome(nome).getSenha());
    }
    public boolean jogadorExiste(JogadorDTO j) {
         if(dao.findByNome(j.getNome())==null) return false;
         return true;
    }
    public JogadorDTO retornaJogador(String nome){
        return converter.toDTO(dao.findByNome(nome));
    }
}

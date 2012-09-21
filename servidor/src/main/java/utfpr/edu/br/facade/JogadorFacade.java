package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:19
 */
public interface JogadorFacade {
    public boolean findJogador(String nome);
    public void saveJogador(String nome);
    public RetornoValidacao autenticar(String nome,String md5);

}
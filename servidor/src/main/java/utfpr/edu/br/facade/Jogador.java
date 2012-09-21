package utfpr.edu.br.facade;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.md5.Md5;
import utfpr.edu.br.util.Erros;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 18:50
 */
public class Jogador implements JogadorFacade{
    private static Jogador ourInstance = new Jogador();
    private static StringBuilder jogadores;

    public static Jogador getInstance() {
        return ourInstance;
    }

    private Jogador() {
        jogadores = new StringBuilder();
    }

    /**
     * Metodo que verifica se existe algum jogador com certo nome.
     * @param nome Nome do jogador a procurar
     * @return True para existe tal jogador.
     */
    @Override
    public boolean findJogador(String nome){
       return (jogadores.lastIndexOf(nome)==-1 ? false : true);
    }

    /**
     *  Metodo que inseri o jogador
     * @param nome Nome do jogador a inserir
     */
    @Override
    public void saveJogador(String nome){
            jogadores.append(nome);
            System.out.println(jogadores.toString());
    }

    /**
     * Funçao que inseri o usuario no StringBuilder
     * @param nome Nome do Jogador
     * @param md5  Nome do Jogador criptografado para testar a veracidade dos dados
     * @return A resultado da operacao
     */
    @Override
    public RetornoValidacao autenticar(String nome, String md5) {
        System.out.println(nome);
        System.out.println(md5);
        try {
            String criptografa = Md5.MD5(nome);
            System.out.println(criptografa);
            if(criptografa.equals(md5)){ //tudo ok, so verificar se existe alguem com esse nome
                if(!findJogador(nome)){
                    saveJogador(nome);
                    return new RetornoValidacao();
                }else{
                    return new RetornoValidacao(Erros.JOGADOREXISTE.nome());
                }
            }
        } catch (NoSuchAlgorithmException e) {
            new RetornoValidacao(Erros.ALGORITMO.nome());
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            new RetornoValidacao(Erros.CARACTER_NAO_SUPORTADO.nome());
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return new RetornoValidacao(Erros.DESCONHECIDO.nome());
    }
}

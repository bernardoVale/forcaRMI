package utfpr.edu.br.util;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 08/10/12
 * Time: 11:25
 */
public enum Acao {

    PALAVRA_CORRETA, //Jogador ganhou, entao, salvar jogador que acertou a palavra
    DERROTA,  //Algum jogador perdeu.
    MODIFICAO;//Nao precisa fazer nada no servidor, so alterou o painel
}

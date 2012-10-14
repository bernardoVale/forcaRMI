package utfpr.edu.br.util;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 08/10/12
 * Time: 11:25
 */
public enum Acao {

    PALAVRA_CORRETA(1), //Jogador ganhou, entao, salvar jogador que acertou a palavra
    DERROTA(2),  //Algum jogador perdeu.
    MODIFICAO(3),//Nao precisa fazer nada no servidor, so alterou o painel
    FIM_JOGO(4),
    ERROU_LETRA(5),
    ACERTOU_LETRA(6),
    PALAVRA_ERRADA(7),
    ; //Nao existe mais palavras, o jogo acabou


    Acao(int i) {

    }
}

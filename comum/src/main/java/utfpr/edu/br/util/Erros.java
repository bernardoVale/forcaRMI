package utfpr.edu.br.util;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 18:59
 */
public enum Erros {
    JOGADOREXISTE("Já existe um jogador com este nome!"),
    ALGORITMO("Problemas no algoritmo de criptografia, tente novamente"),
    CARACTER_NAO_SUPORTADO("Digitastes algum caracter inválido"),
    DESCONHECIDO("ERRO,Tente novamente mais tarde"),
    CREDENCIAIS("Nome e/ou senha incorreto(s)"),
    DADOSNAOENCONTRADOS("Não foi encontrado nenhum resultado!"),
    JOGO_LOTADO("Jogo já esta lotado!"),
    PERSISTENCIA("Problemas na persistencia, tente novamente!");
    private final String erro;

    private Erros(String erro) {
        this.erro = erro;
    }
    public String nome(){
        return erro;
    }
}

package utfpr.edu.br.presenter.template.efetuarJogada;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 06/10/12
 * Time: 17:07
 */

/**
 * @author Bernardo Vale
 */
public class JogadaPalavra extends EfetuarJogadaTemplate{
    @Override
    protected void preEfetuarJogada() {
        token = presenter.getView().jtfEnviar().getText();
        //Pego a palavra que esta sendo jogada. A da rodada atual.
        palavraAtual = presenter.getView().palavras().get(presenter.getView().rodadaAtual()-1);

        if(token.equals(palavraAtual.getNomeMascarado().toUpperCase()) ||
                token.equals(palavraAtual.getNome().toUpperCase()))
            acertou = true;
        else acertou = false;
    }

    @Override
    protected void mudarPalavraPopulada() {
        if(acertou) presenter.atualizaPalavraCerta();
    }

    @Override
    protected void adicionarErro() {
        if(!acertou){ //Errou
            jogo.getJogador1().setQuantidadeErros(
                    jogo.getJogador1().getQuantidadeErros()
                            +1
            );
            //todo Adiciona parte do boneco
        }
    }

    @Override
    protected void adicionarLetrasErradas() {
        //Nao preciso desse metodo.
    }
}

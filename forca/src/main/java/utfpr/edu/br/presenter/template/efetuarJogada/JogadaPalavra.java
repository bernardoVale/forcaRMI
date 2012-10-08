package utfpr.edu.br.presenter.template.efetuarJogada;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 06/10/12
 * Time: 17:07
 */

import utfpr.edu.br.util.GetImagemForca;

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
            if(atual==1){
                jogo.getJogador1().setQuantidadeErros(
                        jogo.getJogador1().getQuantidadeErros()
                                +1
                );
                presenter.getView().lbErroJogador1().setIcon(new GetImagemForca().getImagem(
                        jogo.getJogador1().getQuantidadeErros()
                ));
            }else {
                jogo.getJogador2().setQuantidadeErros(
                        jogo.getJogador2().getQuantidadeErros()
                                +1
                );
                presenter.getView().lbErroJogador1().setIcon(new GetImagemForca().getImagem(
                        jogo.getJogador2().getQuantidadeErros()
                ));
            }
        }
    }

    @Override
    protected void adicionarLetrasErradas() {
        //Nao preciso desse metodo.
    }
}

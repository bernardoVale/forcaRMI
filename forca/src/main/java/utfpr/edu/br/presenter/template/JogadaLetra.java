package utfpr.edu.br.presenter.template;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 06/10/12
 * Time: 16:53
 */

import utfpr.edu.br.util.StringUtil;

/**
 * @author Bernardo Vale
 */
public class JogadaLetra extends EfetuarJogadaTemplate{

    @Override
    protected void preEfetuarJogada(){
        token = presenter.getView().jtfEnviar().getText();
        //Pego a palavra que esta sendo jogada. A da rodada atual.
        palavraAtual = presenter.getView().palavras().get(presenter.getView().rodadaAtual()-1);
        //Rodada atual nao tem a posicao 0 por isso -1
        posicoes =
                StringUtil.posicoesIguais(token, palavraAtual.getNomeMascarado());
        if(posicoes==null)acertou=false;
        else acertou=true;
    }
    @Override
    protected void mudarPalavraPopulada() {
        if(acertou) presenter.atualizaPosicoesPalavra(posicoes,token);
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
        if(!acertou){ //Errou
            jogo.getLetrasErradas().add(token);
        } return;
    }
}

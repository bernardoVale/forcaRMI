package utfpr.edu.br.presenter.template.efetuarJogada;/**
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
        if(posicoes==null){
            acertou=false;
            if(atual==1) { //Atribui pontuaçao -2 pois errou a letra
                jogo.getJogador1().setPontuacao((-2)+jogo
                        .getJogador1().getPontuacao());
            }else{
                jogo.getJogador2().setPontuacao((-2)+jogo
                        .getJogador2().getPontuacao());
            }
        }
        else {
            acertou=true;
            if(atual==1) { //Atribui pontuaçao +2 para cada letra correta
                jogo.getJogador1().setPontuacao((posicoes.size()*2)+jogo
                        .getJogador1().getPontuacao());
            }else{
                jogo.getJogador2().setPontuacao((posicoes.size()*2)+jogo
                        .getJogador2().getPontuacao());
            }
        }
    }
    @Override
    protected void mudarPalavraPopulada() {
        if(acertou) presenter.atualizaPosicoesPalavra(posicoes,token);
    }

    @Override
    protected void adicionarErro() {
        if(!acertou){ //Errou
            if(atual==1){
                jogo.getJogador1().setQuantidadeErros(
                        jogo.getJogador1().getQuantidadeErros()
                                +1
                );
            }else {
                jogo.getJogador2().setQuantidadeErros(
                        jogo.getJogador2().getQuantidadeErros()
                                +1
                );
            }

        }
        presenter.atualizarForca(atual);
    }

    @Override
    protected void adicionarLetrasErradas() {
        if(!acertou){ //Errou
            jogo.getLetrasErradas().add(token);
            presenter.atualizarLetrasErrada();
        } return;
    }

    @Override
    protected void verificaVitoria() {

    }

    @Override
    protected void verificaDerrota() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

package utfpr.edu.br.presenter.template.efetuarJogada;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 06/10/12
 * Time: 17:07
 */

import utfpr.edu.br.dto.AcaoDTO;
import utfpr.edu.br.util.Acao;

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
        //Nao preciso desse metodo.
    }

    @Override
    protected void verificaVitoria() {
        if(acertou){ //todo verificar se ja finalizou o jogo dps atualizar o placar
            //Mudo a orientaçao da jogada
            presenter.getView().setRodadaAtual(presenter.getView().rodadaAtual() + 1);
            //populo a nova palavra
            presenter.popularNovaPalavra();
            //Mando a acao para que o servidor intenda o que e necessario ser gravado
            if(atual==1){
                jogo.setAcao(new AcaoDTO(Acao.PALAVRA_CORRETA,jogo.getJogador1().getJogador()));
            }else{
                jogo.setAcao(new AcaoDTO(Acao.PALAVRA_CORRETA,jogo.getJogador2().getJogador()));
            }
        }
    }

    @Override
    protected void verificaDerrota() {
        if(atual==1){
            if(jogo.getJogador1().getQuantidadeErros()==5)
                jogo.setAcao(new AcaoDTO(Acao.DERROTA,jogo.getJogador1().getJogador()));
        }else{
            if(jogo.getJogador2().getQuantidadeErros()==5)
                jogo.setAcao(new AcaoDTO(Acao.DERROTA,jogo.getJogador2().getJogador()));
        }
    }
}

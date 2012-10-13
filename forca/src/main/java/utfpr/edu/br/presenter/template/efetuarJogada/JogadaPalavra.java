package utfpr.edu.br.presenter.template.efetuarJogada;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 06/10/12
 * Time: 17:07
 */

import utfpr.edu.br.dto.AcaoDTO;
import utfpr.edu.br.util.Acao;

import javax.swing.*;

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
                token.equals(palavraAtual.getNome().toUpperCase())){
            acertou = true;
            if(atual==1) { //Atribui pontuaçao +10, acertou a palavra. DPs tem que mudar
                jogo.getJogador1().setPontuacao((+10)+jogo
                        .getJogador1().getPontuacao());
            }else{
                jogo.getJogador2().setPontuacao((+10)+jogo
                        .getJogador2().getPontuacao());
            }
        }
        else{
            acertou = false;
            if(atual==1) { //Atribui pontuaçao -4 pois chutou palavra errada
                jogo.getJogador1().setPontuacao((-4)+jogo
                        .getJogador1().getPontuacao());
            }else{
                jogo.getJogador2().setPontuacao((-4)+jogo
                        .getJogador2().getPontuacao());
            }
        }
    }

    @Override
    protected void mudarPalavraPopulada() {
        JOptionPane.showMessageDialog(presenter.getView().root(),
                jogo.getJogoDTO().getPalavras().get(presenter.getView().rodadaAtual()-1).getNome()
                ,"Acertou",JOptionPane.INFORMATION_MESSAGE);
        if(acertou) presenter.popularNovaPalavra();
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
            if(!(jogo.getJogoDTO().getJogo().getNumRodadas()==(presenter.getView().rodadaAtual()+1))){
                //Mudo a orientaçao da jogada
                presenter.getView().setRodadaAtual(presenter.getView().rodadaAtual() + 1);
                //Mando a acao para que o servidor intenda o que e necessario ser gravado
                if(atual==1){
                    jogo.setAcao(new AcaoDTO(jogo.getJogador1().getJogador(),Acao.PALAVRA_CORRETA,palavraAtual));
                }else{
                    jogo.setAcao(new AcaoDTO(jogo.getJogador2().getJogador(),Acao.PALAVRA_CORRETA,palavraAtual));
                }
            }else{ //todo acabou o jogo
                if(atual==1){
                    jogo.setAcao(new AcaoDTO(Acao.FIM_JOGO,jogo.getJogador1().getJogador()));

                }else{
                    jogo.setAcao(new AcaoDTO(Acao.FIM_JOGO,jogo.getJogador1().getJogador()));
                }
                JOptionPane.showMessageDialog(presenter.getView().root(),"Fim do Jogo!");
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

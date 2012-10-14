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
                jogo.setAcao(new AcaoDTO(Acao.PALAVRA_CORRETA,jogo.getJogador1().getJogador()));
            }else{
                jogo.getJogador2().setPontuacao((+10)+jogo
                        .getJogador2().getPontuacao());
                jogo.setAcao(new AcaoDTO(Acao.PALAVRA_CORRETA,jogo.getJogador2().getJogador()));
            }
        }
        else{
            acertou = false;
            if(atual==1) { //Atribui pontuaçao -4 pois chutou palavra errada
                jogo.getJogador1().setPontuacao((-4)+jogo
                        .getJogador1().getPontuacao());
                jogo.setAcao(new AcaoDTO(Acao.PALAVRA_ERRADA,jogo.getJogador1().getJogador()));
            }else{
                jogo.getJogador2().setPontuacao((-4)+jogo
                        .getJogador2().getPontuacao());
                jogo.setAcao(new AcaoDTO(Acao.PALAVRA_ERRADA,jogo.getJogador2().getJogador()));
            }
        }
    }

    @Override
    protected void mudarPalavraPopulada() {
        if(acertou){
            JOptionPane.showMessageDialog(presenter.getView().root(),
                    jogo.getJogoDTO().getPalavras().get(presenter.getView().rodadaAtual()-1).getNome()
                    ,"Acertou",JOptionPane.INFORMATION_MESSAGE);
            //presenter.popularNovaPalavra();
        }
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
            if(!(jogo.getJogoDTO().getJogo().getNumRodadas()==(presenter.getView().rodadaAtual()))){
                //Mudo a orientaçao da jogada
                presenter.getView().setRodadaAtual(presenter.getView().rodadaAtual() + 1);
                jogo.setRodadaAtual(presenter.getView().rodadaAtual());
                presenter.popularNovaPalavra();
                limparDadosJogo();
                //Mando a acao para que o servidor intenda o que e necessario ser gravado
                if(atual==1){
                    jogo.setAcao(new AcaoDTO(jogo.getJogador1().getJogador(),Acao.PALAVRA_CORRETA,palavraAtual));
                }else{
                    jogo.setAcao(new AcaoDTO(jogo.getJogador2().getJogador(),Acao.PALAVRA_CORRETA,palavraAtual));
                }
            }else{ //todo acabou o jogo
                JOptionPane.showMessageDialog(presenter.getView().root(),"Fim do Jogo!");
                if(atual==1){
                    jogo.setAcao(new AcaoDTO(Acao.FIM_JOGO,jogo.getJogador1().getJogador()));
                    presenter.getView().voltarAoLobby(jogo.getJogador1().getJogador());
                }else{
                    jogo.setAcao(new AcaoDTO(Acao.FIM_JOGO,jogo.getJogador2().getJogador()));
                    presenter.getView().voltarAoLobby(jogo.getJogador2().getJogador());
                }
            }
        }
    }

    @Override
    protected void verificaDerrota() {
        if(!acertou){
            if(!(jogo.getJogoDTO().getJogo().getNumRodadas()==(presenter.getView().rodadaAtual()))){
                if(atual==1){
                    if(jogo.getJogador1().getQuantidadeErros()==5){
                        jogo.getJogador1().setPontuacao(  //perdeu e -5 fera
                                (jogo.getJogador2().getPontuacao() - 5)
                        );
                        JOptionPane.showMessageDialog(presenter.getView().root(),
                                "A Palavra era:"+palavraAtual.getNome()+"","Perdeu ;(",JOptionPane.INFORMATION_MESSAGE);
                        jogo.setAcao(new AcaoDTO(Acao.DERROTA,jogo.getJogador1().getJogador()));
                        presenter.getView().setRodadaAtual(presenter.getView().rodadaAtual() + 1);
                        presenter.atualizarPlacar(atual);
                        jogo.setRodadaAtual(presenter.getView().rodadaAtual());
                        presenter.popularNovaPalavra();
                        limparDadosJogo();
                    }
                }else{
                    if(jogo.getJogador2().getQuantidadeErros()==5) {
                        jogo.getJogador2().setPontuacao(  //perdeu e -5 fera
                                (jogo.getJogador2().getPontuacao() - 5)
                        );
                        JOptionPane.showMessageDialog(presenter.getView().root(),
                                "A Palavra era:" + palavraAtual.getNome() + "", "Perdeu ;(", JOptionPane.INFORMATION_MESSAGE);
                        jogo.setAcao(new AcaoDTO(Acao.DERROTA,jogo.getJogador2().getJogador()));
                        presenter.atualizarPlacar(atual);
                        presenter.getView().setRodadaAtual(presenter.getView().rodadaAtual() + 1);
                        jogo.setRodadaAtual(presenter.getView().rodadaAtual());
                        presenter.popularNovaPalavra();
                        limparDadosJogo();

                    }
                }
            }else{
                //todo Ta dando problema. Verificar, ele finaliza o jogo antes da hora
                //olha bem esse bagulho aqui seu indio
                if(atual==1){
                    if(jogo.getJogador1().getQuantidadeErros()==5){
                        jogo.getJogador1().setPontuacao(  //perdeu e -5 fera
                                (jogo.getJogador2().getPontuacao() - 5)
                        );
                        presenter.atualizarPlacar(atual);
                        jogo.setAcao(new AcaoDTO(Acao.FIM_JOGO,jogo.getJogador1().getJogador()));
                        JOptionPane.showMessageDialog(presenter.getView().root(), "Fim do Jogo!");
                        presenter.getView().voltarAoLobby(jogo.getJogador1().getJogador());
                    }
                }else{
                    if(jogo.getJogador2().getQuantidadeErros()==5) {
                        jogo.getJogador2().setPontuacao(  //perdeu e -5 fera
                                (jogo.getJogador2().getPontuacao() - 5)
                        );
                        presenter.atualizarPlacar(atual);
                        jogo.setAcao(new AcaoDTO(Acao.FIM_JOGO,jogo.getJogador1().getJogador()));
                        JOptionPane.showMessageDialog(presenter.getView().root(), "Fim do Jogo!");
                        presenter.getView().voltarAoLobby(jogo.getJogador2().getJogador());
                    }
                }
            }
        }
    }
}

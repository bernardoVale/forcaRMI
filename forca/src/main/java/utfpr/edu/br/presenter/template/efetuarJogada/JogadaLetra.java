package utfpr.edu.br.presenter.template.efetuarJogada;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 06/10/12
 * Time: 16:53
 */

import utfpr.edu.br.dto.AcaoDTO;
import utfpr.edu.br.util.Acao;
import utfpr.edu.br.util.StringUtil;

import javax.swing.*;

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
            if(atual==1) { //Atribui pontuaçao -1 pois errou a letra
                jogo.getJogador1().setPontuacao((-1)+jogo
                        .getJogador1().getPontuacao());
                jogo.setAcao(new AcaoDTO(Acao.ERROU_LETRA,jogo.getJogador1().getJogador()));
            }else{
                jogo.getJogador2().setPontuacao((-1)+jogo
                        .getJogador2().getPontuacao());
                jogo.setAcao(new AcaoDTO(Acao.ERROU_LETRA,jogo.getJogador2().getJogador()));
            }
        }
        else {
            acertou=true;
            if(atual==1) { //Atribui pontuaçao +2 para cada letra correta
                jogo.getJogador1().setPontuacao((posicoes.size()*2)+jogo
                        .getJogador1().getPontuacao());
                jogo.setAcao(new AcaoDTO(Acao.ACERTOU_LETRA,jogo.getJogador1().getJogador()));
            }else{
                jogo.getJogador2().setPontuacao((posicoes.size()*2)+jogo
                        .getJogador2().getPontuacao());
                jogo.setAcao(new AcaoDTO(Acao.ACERTOU_LETRA,jogo.getJogador2().getJogador()));
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
                        presenter.atualizarPlacar(atual);
                        presenter.getView().setRodadaAtual(presenter.getView().rodadaAtual() + 1);
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
                                "A Palavra era:" + palavraAtual.getNome() + "", "Perdeu ;(",
                                JOptionPane.INFORMATION_MESSAGE);
                        presenter.atualizarPlacar(atual);
                        jogo.setAcao(new AcaoDTO(Acao.DERROTA,jogo.getJogador2().getJogador()));
                        presenter.getView().setRodadaAtual(presenter.getView().rodadaAtual() + 1);
                        jogo.setRodadaAtual(presenter.getView().rodadaAtual());
                        presenter.popularNovaPalavra();
                        limparDadosJogo();
                    }
                }
            }else{
                //olha bem esse bagulho aqui seu indio
                if(atual==1){
                    if(jogo.getJogador1().getQuantidadeErros()==5){
                        jogo.getJogador1().setPontuacao(  //perdeu e -5 fera
                                (jogo.getJogador2().getPontuacao() - 5)
                        );
                        jogo.setAcao(new AcaoDTO(Acao.FIM_JOGO,jogo.getJogador1().getJogador()));
                        presenter.atualizarPlacar(atual);
                        JOptionPane.showMessageDialog(presenter.getView().root(), "Fim do Jogo!");
                        presenter.getView().voltarAoLobby(jogo.getJogador1().getJogador());
                    }
                }else{
                    if(jogo.getJogador2().getQuantidadeErros()==5) {
                        jogo.getJogador2().setPontuacao(  //perdeu e -5 fera
                                (jogo.getJogador2().getPontuacao() - 5)
                        );
                        jogo.setAcao(new AcaoDTO(Acao.FIM_JOGO,jogo.getJogador1().getJogador()));
                        presenter.atualizarPlacar(atual);
                        JOptionPane.showMessageDialog(presenter.getView().root(), "Fim do Jogo!");
                        presenter.getView().voltarAoLobby(jogo.getJogador2().getJogador());
                    }
                }
            }
        }
    }
}

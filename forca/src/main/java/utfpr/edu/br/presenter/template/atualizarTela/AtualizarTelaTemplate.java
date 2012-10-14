package utfpr.edu.br.presenter.template.atualizarTela;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 07/10/12
 * Time: 20:55
 */

import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.util.Acao;
import utfpr.edu.br.view.telas.jogo.JogoView;

import javax.swing.*;

/**
 * @author Bernardo Vale
 */
public abstract class AtualizarTelaTemplate {
    protected JogoPresenter presenter;
    protected int atual;

    public JogoView atualizarTela(JogoPresenter presenter){
        this.presenter = presenter;
        verAcao();
        pegaJogadorAtual();
        visualizarPaineis();
        atualizarLetrasErradas();
        atualizarPalavraPopulada();
        atualizarForca();
        atualizarPlacar();
        return this.presenter.getView();
    }

    private void verAcao() {
        if(!(presenter.getView().dadosJogo().getAcao()==null)){
            if(presenter.getView().dadosJogo().getAcao().getAcao() == Acao.DERROTA){
                JOptionPane.showMessageDialog(presenter.getView().root(),
                        "Palavra era:"+presenter.getView().palavras().get(
                                presenter.getView().rodadaAtual()-2
                        ).getNome(),"Oponente enforcou :D",JOptionPane.INFORMATION_MESSAGE);
            }
            if(presenter.getView().dadosJogo().getAcao().getAcao() == Acao.FIM_JOGO){
                JOptionPane.showMessageDialog(presenter.getView().root(),
                        "Acabou ;(","Fim do Jogo",JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    protected abstract void atualizarPlacar();
    protected abstract void atualizarLetrasErradas();
    protected abstract void atualizarPalavraPopulada();
    protected abstract void atualizarForca();


    /* protected void atualizarForca(){
      presenter.getView().
       if(atual==1){
           getView().lbErroJogador1().setIcon(new GetImagemForca().getImagem(
                   getView().dadosJogo().getJogador1().getQuantidadeErros()
           ));
       }else{
           getView().lbErroJogador1().setIcon(new GetImagemForca().getImagem(
                   getView().dadosJogo().getJogador2().getQuantidadeErros()
           ));
       }
       getView().pJogador1().revalidate();
       getView().root().validate();
   }

   /**
    * Habilita todos os paineis que n estavam visiveis
    */
    protected void visualizarPaineis(){
        presenter.getView().pEnviar().setVisible(true);
    }

    //Verica qual jogador no JogoAtivoDTO e o jogador que esta na tela
    protected void pegaJogadorAtual(){
        if(presenter.getView().dadosJogo()
                .getJogador1().getJogador().getId().equals(presenter.getView().jogador().getId())){
            atual = 1;
        }else{
            atual = 2;
        }
    }
}

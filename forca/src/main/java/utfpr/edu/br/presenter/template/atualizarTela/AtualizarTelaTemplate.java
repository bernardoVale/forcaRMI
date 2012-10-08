package utfpr.edu.br.presenter.template.atualizarTela;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 07/10/12
 * Time: 20:55
 */

import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.view.telas.jogo.JogoView;

/**
 * @author Bernardo Vale
 */
public abstract class AtualizarTelaTemplate {
    protected JogoPresenter presenter;
    protected int atual;

    public JogoView atualizarTela(JogoPresenter presenter){
        this.presenter = presenter;
        pegaJogadorAtual();
        visualizarPaineis();
        atualizarLetrasErradas();
        atualizarPalavraPopulada();
        atualizarForca();
        atualizarPlacar();
        return this.presenter.getView();
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

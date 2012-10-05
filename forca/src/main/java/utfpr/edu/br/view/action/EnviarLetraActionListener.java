package utfpr.edu.br.view.action;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 03/10/12
 * Time: 11:07
 */

import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.util.StringUtil;
import utfpr.edu.br.view.telas.jogo.JogoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class EnviarLetraActionListener implements ActionListener {
    private final JogoPresenter presenter;
    private JogoView view;

    public EnviarLetraActionListener(JogoPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.rbLetra().isSelected()){
            doEnviarLetra();
        }else if(view.rbChutar().isSelected()){
            doEnviarChute();
        }
    }

    /**
     * Metodo onde eu verifico qual foi a letra que me enviaste e se ela costa na palavra.
     */
    private void doEnviarLetra(){
       String letra = view.jtfEnviar().getText();
       //Pego a palavra que esta sendo jogada. A da rodada atual.
       PalavraDTO palavra = view.palavras().get(view.rodadaAtual()-1);//Rodada atual nao tem a posicao 0 por isso -1
       List<Integer> posicoes;
       posicoes = StringUtil.posicoesIguais(letra,palavra.getNomeMascarado());
       if(posicoes==null){
           //todo Adicionar parte do corpo ao jogador
           System.out.println("ERROU!");
           //errou a letra tem que atualizar o boneco
       }else{
           presenter.atualizaPosicoesPalavra(posicoes,letra);
       }
    }

    /**
     * Verifica se o jogador acertou o "chute" da palavra
     */
    private void doEnviarChute(){
       String chute = view.jtfEnviar().getText();
        System.out.println(view.jtfEnviar());
        System.out.println(view.jtfEnviar().getText());
       PalavraDTO palavra = view.palavras().get(view.rodadaAtual()-1);
       if(chute.equals(palavra.getNomeMascarado().toUpperCase()) ||
               chute.equals(palavra.getNome().toUpperCase())){
           presenter.atualizaPalavraCerta();
           //Acertou
       }else{
           //todo Adicionar parte do corpo ao jogador
           System.out.printf("Errou feio seu fdp");
       }
    }

}

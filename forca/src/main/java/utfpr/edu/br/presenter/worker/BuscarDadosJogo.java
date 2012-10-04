package utfpr.edu.br.presenter.worker;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 19:32
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.DadosDoJogoDTO;
import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.rmi.RMIClient;
import utfpr.edu.br.util.StringUtil;
import utfpr.edu.br.view.telas.jogo.JogoView;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

/**
 * @author Bernardo Vale
 */
public class BuscarDadosJogo extends SwingWorker<DadosDoJogoDTO,Void>{
    private final JogoView view;
    private final JogoPresenter presenter;

    public BuscarDadosJogo(JogoView view, JogoPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }
    RetornoValidacao rv = new RetornoValidacao(false);
    @Override
    protected DadosDoJogoDTO doInBackground() throws Exception {
        while (!rv.isOk()){
            rv = RMIClient.getInstance().provider().iniciarPartida(view.jogador(),view.adversario());
            Thread.sleep(500);
        }
        return (DadosDoJogoDTO) rv.getObjeto();
    }

    @Override
    protected void done() {
        super.done();
        try {
            view.setPalavras(get().getPalavras());
            view.setJogo(get().getJogo());
            popularPalavra();
            mascararPalavras();
            iniciarJogada();//Seta a vez do camarada

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * Adiciona os asterisco ao painel de acordo com o numero de letras
     */
    private void popularPalavra() {
        //JLabel letra;
        JLabel asterisco;
        char[] palavra =  view.palavras().get(0).getNome().toCharArray();
        int numLetras = palavra.length;
        for(int i=1;i<=numLetras;i++){
            //letra = new JLabel();
            asterisco = new JLabel();
            //letra.setText("<html><u>"+String.valueOf((palavra[i - 1])).toUpperCase()+"</u></html>");
            //letra.setFont(new Font("Tahoma", 0, 40));
            asterisco.setText("<html><u>*</u></html>");
            asterisco.setFont(new Font("Tahoma", 0, 50));
            view.palavraAtualPopulada().add(asterisco);//adiciona no vetor atual
            view.pLetras().add(asterisco);
            view.pLetras().revalidate();
            view.root().validate();
        }

    }
    public void mascararPalavras(){
        for(int i=0;i<view.palavras().size();i++){
              view.palavras().get(i).setNomeMascarado
                      (StringUtil.mascararTexto(view.palavras().get(i).getNome()));
            System.out.println("Nome:"+view.palavras().get(i).getNome());
            System.out.println("Mascara:"+view.palavras().get(i).getNomeMascarado());
        }
    }
    private void iniciarJogada() {
        //A regra para o jogador que começa jogando e quem tem a menor(oldfag) id ;)
        if(view.jogador().getId()>view.adversario().getId()){
            view.setMeuTurno(true);
        }
    }
}

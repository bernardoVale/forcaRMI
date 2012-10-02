package utfpr.edu.br.presenter.worker;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 19:32
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.DadosDoJogoDTO;
import utfpr.edu.br.rmi.RMIClient;
import utfpr.edu.br.view.telas.jogo.JogoView;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

/**
 * @author Bernardo Vale
 */
public class BuscarDadosJogo extends SwingWorker<DadosDoJogoDTO,Void>{
    private final JogoView view;

    public BuscarDadosJogo(JogoView view) {
        this.view = view;
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
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * Adiciona a palavra ao painel
     */
    private void popularPalavra() {
        JLabel letra;
        char[] palavra =  view.palavras().get(0).getNome().toCharArray();
        int numLetras = palavra.length;
        for(int i=1;i<=numLetras;i++){
            letra = new JLabel();
            letra.setText(String.valueOf((palavra[i - 1])).toUpperCase());
            letra.setFont(new Font("Tahoma", 0, 50));
            view.pLetras().add(letra);
            view.pLetras().revalidate();
            view.root().validate();
        }

    }
}

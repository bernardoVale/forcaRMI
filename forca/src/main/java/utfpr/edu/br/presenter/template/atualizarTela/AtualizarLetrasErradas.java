package utfpr.edu.br.presenter.template.atualizarTela;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 08/10/12
 * Time: 08:40
 */


import utfpr.edu.br.view.telas.jogo.JogoView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class AtualizarLetrasErradas extends AtualizarTelaTemplate{
    @Override
    protected void atualizarPlacar() {
        presenter.atualizarPlacar(atual);
        //A partida ainda nao acabou
    }

    @Override
    protected void atualizarLetrasErradas() {
        JogoView j = presenter.getView();
        List<String> pErradas = presenter.getView().dadosJogo().getLetrasErradas();
        //Remove tudo e atualiza a tela
        j.pLetrasErradas().removeAll();
        j.pLetrasErradas().revalidate();
        j.root().validate();
        for(int i=0;i< pErradas.size();i++){
            JLabel letra = new JLabel(pErradas.get(i));
            letra.setFont(new Font("SansSerif", Font.BOLD, 73));
            j.pLetrasErradas().add(letra);
            j.pLetrasErradas().revalidate();
            j.root().validate();
        }
        presenter.setJogoView(j);
    }

    @Override
    protected void atualizarPalavraPopulada() {
        //nao tem necessidade, se ele errou, a palavra populada e a mesma.
    }

    @Override
    protected void atualizarForca() {
       presenter.atualizarForca(atual);
    }
}

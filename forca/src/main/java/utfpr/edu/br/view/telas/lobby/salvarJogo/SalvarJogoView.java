package utfpr.edu.br.view.telas.lobby.salvarJogo;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;

/**
 * Interface para a a view do JDialog de criacao de um jogo
 */
public interface SalvarJogoView {

    public JSpinner spRodadas();
    public JComboBox cbDificuldade();
    public JButton btSalvar();
    public MaskFormatter setMascara(String mascara);
    public void addSalvarListener(ActionListener listener);
    public JFrame getJFrame();
    void destroy();
    /**
     * Organiza e mostra a tela
     */
    public void packAndShow();


}
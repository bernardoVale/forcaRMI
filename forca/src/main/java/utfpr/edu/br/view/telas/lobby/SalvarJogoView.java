package utfpr.edu.br.view.telas.lobby;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 * Interface para a a view do JDialog de criacao de um jogo
 */
public interface SalvarJogoView {

    public JSpinner spRodadas();
    public JComboBox cbDificuldade();
    public JButton btSalvar();
    public MaskFormatter setMascara(String mascara);
    /**
     * Organiza e mostra a tela
     */
    public void packAndShow();


}
/*
 * Created by JFormDesigner on Fri Oct 12 16:53:39 BRT 2012
 */

package utfpr.edu.br.view.telas.jogo.pontuacaoPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bernardo Vale
 */
public class PainelPontuacao extends JPanel {
    public PainelPontuacao() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bernardo Vale
        lbPontuacaoP1 = new JLabel();
        lbX = new JLabel();
        lbPontuacaoP2 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(264, 71));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

        //---- lbPontuacaoP1 ----
        lbPontuacaoP1.setText("0");
        lbPontuacaoP1.setFont(new Font("SansSerif", Font.PLAIN, 60));
        lbPontuacaoP1.setPreferredSize(new Dimension(42, 91));
        add(lbPontuacaoP1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 10), 0, 0));

        //---- lbX ----
        lbX.setText("x");
        lbX.setFont(new Font("SansSerif", Font.PLAIN, 60));
        add(lbX, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 10), 0, 0));

        //---- lbPontuacaoP2 ----
        lbPontuacaoP2.setText("0");
        lbPontuacaoP2.setFont(new Font("SansSerif", Font.PLAIN, 60));
        add(lbPontuacaoP2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bernardo Vale
    private JLabel lbPontuacaoP1;
    private JLabel lbX;
    private JLabel lbPontuacaoP2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JLabel getlbX(){
        return lbX;
    }
    public JLabel getLbPontuacaoP1(){
        return lbPontuacaoP1;
    }
    public JLabel getLbPontuacaoP2(){
        return lbPontuacaoP2;
    }
}

/*
 * Created by JFormDesigner on Fri Oct 12 16:34:19 BRT 2012
 */

package utfpr.edu.br.view.telas.lobby;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bernardo Vale
 */
public class Pontuacao extends JFrame {
    public Pontuacao() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bernardo Vale
        panel1 = new JPanel();
        lbPontuacaoP1 = new JLabel();
        lbX = new JLabel();
        lbPontuacaoP2 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setFocusable(false);
            panel1.setOpaque(false);

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //---- lbPontuacaoP1 ----
            lbPontuacaoP1.setText("-10");
            lbPontuacaoP1.setFont(new Font("SansSerif", Font.PLAIN, 60));
            lbPontuacaoP1.setOpaque(true);
            panel1.add(lbPontuacaoP1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));

            //---- lbX ----
            lbX.setText("x");
            lbX.setFont(new Font("SansSerif", Font.PLAIN, 60));
            lbX.setOpaque(true);
            panel1.add(lbX, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));

            //---- lbPontuacaoP2 ----
            lbPontuacaoP2.setText("-10");
            lbPontuacaoP2.setFont(new Font("SansSerif", Font.PLAIN, 60));
            lbPontuacaoP2.setOpaque(true);
            panel1.add(lbPontuacaoP2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1);
        panel1.setBounds(new Rectangle(new Point(160, 110), panel1.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bernardo Vale
    private JPanel panel1;
    private JLabel lbPontuacaoP1;
    private JLabel lbX;
    private JLabel lbPontuacaoP2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

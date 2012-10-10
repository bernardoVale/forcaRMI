/*
 * Created by JFormDesigner on Tue Oct 09 23:37:24 BRT 2012
 */

package utfpr.edu.br.view.telas.lobby;

import utfpr.edu.br.util.Dificuldade;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

import static utfpr.edu.br.util.Dificuldade.*;

/**
 * @author Bernardo Vale
 */
public class SalvarJogoViewImpl extends JFrame implements SalvarJogoView{

    public SalvarJogoViewImpl() {
        initComponents();
        setDificuldades();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bernardo Vale
        lbRodadas = new JLabel();
        lbRodadas2 = new JLabel();
        cbDificuldade = new JComboBox();
        btSalvar = new JButton();
        spRodadas = new JSpinner();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- lbRodadas ----
        lbRodadas.setFont(new Font("SansSerif", Font.PLAIN, 29));
        lbRodadas.setText("N\u00famero de Rodadas:");
        contentPane.add(lbRodadas);
        lbRodadas.setBounds(0, 5, 320, 50);

        //---- lbRodadas2 ----
        lbRodadas2.setFont(new Font("SansSerif", Font.PLAIN, 29));
        lbRodadas2.setText("Dificuldade:");
        contentPane.add(lbRodadas2);
        lbRodadas2.setBounds(0, 105, 300, 44);

        //---- cbDificuldade ----
        cbDificuldade.setFont(new Font("SansSerif", Font.PLAIN, 29));
        contentPane.add(cbDificuldade);
        cbDificuldade.setBounds(0, 155, 345, 50);

        //---- btSalvar ----
        btSalvar.setText("Salvar");
        btSalvar.setIcon(UIManager.getIcon("InternalFrame.minimizeIcon"));
        btSalvar.setFont(new Font("SansSerif", Font.PLAIN, 29));
        contentPane.add(btSalvar);
        btSalvar.setBounds(25, 230, 325, 45);

        //---- spRodadas ----
        spRodadas.setFont(new Font("SansSerif", Font.PLAIN, 30));
        contentPane.add(spRodadas);
        spRodadas.setBounds(0, 60, 120, 39);

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
    private JLabel lbRodadas;
    private JLabel lbRodadas2;
    private JComboBox cbDificuldade;
    private JButton btSalvar;
    private JSpinner spRodadas;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    @Override
    public JSpinner spRodadas() {
        return spRodadas;
    }

    @Override
    public JComboBox cbDificuldade() {
        return cbDificuldade;
    }

    @Override
    public JButton btSalvar() {
        return btSalvar;
    }


    @Override
    public MaskFormatter setMascara(String mascara) {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(mascara);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return mask;
    }

    @Override
    public void packAndShow() {
        this.pack();
        this.setVisible(true);
    }

    private void setDificuldades(){
        cbDificuldade.addItem(FACIL.d());
        cbDificuldade.addItem(Dificuldade.NORMAL.d());
        cbDificuldade.addItem(MAGAYVER.d());
        cbDificuldade.addItem(FILHO_DE_OSIRIS.d());
    }
}

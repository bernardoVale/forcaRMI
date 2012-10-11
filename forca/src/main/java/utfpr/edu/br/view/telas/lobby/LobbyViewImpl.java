/*
 * Created by JFormDesigner on Wed Oct 10 11:23:53 BRT 2012
 */

package utfpr.edu.br.view.telas.lobby;

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.view.telas.lobby.painelPartida.PainelPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 */
public class LobbyViewImpl extends JFrame implements LobbyView{
    private JogadorDTO jogador;
    public LobbyViewImpl() {
        initComponents();
        /*btCriarSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTentarPopular();
            }
        });  */
    }

    private void doTentarPopular() {
        JogoDTO jogo = new JogoDTO();
        jogo.setNumRodadas(3L);
        jogo.setDificuldade("Fácil");
        jogo.setId(15L);
        jogo.setNum_Jogadores(1L);
        PainelPartida p = new PainelPartida(jogo);
        pJogos.add(p);
        p.setVisible(true);
        pJogos.revalidate();
        this.validate();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bernardo Vale
        pTop = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        lbJogador = new JLabel();
        btCriarSala = new JButton();
        pJogos = new JPanel();

        //======== this ========
        setTitle("Forca 1.0 - Sala de Espera");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== pTop ========
        {
            pTop.setOpaque(false);

            // JFormDesigner evaluation mark
            pTop.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), pTop.getBorder())); pTop.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- label2 ----
            label2.setText("Sala de Espera");
            label2.setFont(new Font("SansSerif", Font.PLAIN, 70));

            //---- label3 ----
            label3.setText("Jogador: ");
            label3.setFont(new Font("SansSerif", Font.PLAIN, 36));

            //---- lbJogador ----
            lbJogador.setText("hogakii");
            lbJogador.setFont(new Font("SansSerif", Font.PLAIN, 36));

            //---- btCriarSala ----
            btCriarSala.setText("Criar Sala");

            GroupLayout pTopLayout = new GroupLayout(pTop);
            pTop.setLayout(pTopLayout);
            pTopLayout.setHorizontalGroup(
                pTopLayout.createParallelGroup()
                    .addGroup(pTopLayout.createSequentialGroup()
                        .addGroup(pTopLayout.createParallelGroup()
                            .addGroup(pTopLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(label2))
                            .addGroup(pTopLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbJogador))
                            .addGroup(pTopLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btCriarSala, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(287, Short.MAX_VALUE))
            );
            pTopLayout.setVerticalGroup(
                pTopLayout.createParallelGroup()
                    .addGroup(pTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2)
                        .addGroup(pTopLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(lbJogador))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(btCriarSala))
            );
        }
        contentPane.add(pTop);
        pTop.setBounds(0, 0, 1090, 175);

        //======== pJogos ========
        {
            pJogos.setLayout(new FlowLayout(FlowLayout.LEFT));
        }
        contentPane.add(pJogos);
        pJogos.setBounds(0, 175, 1090, 460);

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
    private JPanel pTop;
    private JLabel label2;
    private JLabel label3;
    private JLabel lbJogador;
    private JButton btCriarSala;
    private JPanel pJogos;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    @Override
    public JPanel pJogos() {
        return pJogos;
    }

    @Override
    public JogadorDTO jogador() {
        return jogador;
    }

    @Override
    public void setJogador(JogadorDTO jogador) {
        this.jogador = jogador;
    }

    @Override
    public JLabel lbJogador() {
        return lbJogador;
    }

    @Override
    public JButton btCriarSala() {
        return btCriarSala;
    }

    @Override
    public void addCriarSalaListener(ActionListener listener) {
        btCriarSala.addActionListener(listener);
    }

    @Override
    public void packAndShow() {
        this.pack();
        this.setVisible(true);
    }

    @Override
    public JFrame root() {
        return this;
    }
}
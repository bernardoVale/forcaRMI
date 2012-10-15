/*
 * Created by JFormDesigner on Wed Oct 10 11:23:53 BRT 2012
 */

package utfpr.edu.br.view.telas.lobby;

import utfpr.edu.br.dto.JogadorDTO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 */
public class LobbyViewImpl extends JFrame implements LobbyView{
    private JogadorDTO jogador;
    public LobbyViewImpl() {
        initComponents();
        btCriarSala.setPressedIcon(new ImageIcon(getClass().getResource("/icone_Novo_Jogo_click.png")));
        btCriarSala.setRolloverIcon(new ImageIcon(getClass().getResource("/icone_Novo_Jogo_Focus.png")));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bernardo Vale
        pTop = new JPanel();
        label3 = new JLabel();
        lbJogador = new JLabel();
        btCriarSala = new JButton();
        btAtualizar = new JButton();
        scrollPane1 = new JScrollPane();
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


            //---- label3 ----
            label3.setText("Jogador: ");
            label3.setFont(new Font("Garuda", Font.PLAIN, 36));

            //---- lbJogador ----
            lbJogador.setText("hogakii");
            lbJogador.setFont(new Font("Garuda", Font.PLAIN, 36));

            //---- btCriarSala ----
            btCriarSala.setIcon(new ImageIcon("/home/bernardo/forcaRMI/forca/src/main/resources/icone_Novo_Jogo.png"));
            btCriarSala.setFocusPainted(false);
            btCriarSala.setBorderPainted(false);
            btCriarSala.setOpaque(false);
            btCriarSala.setMaximumSize(new Dimension(130, 130));
            btCriarSala.setMinimumSize(new Dimension(130, 130));
            btCriarSala.setPreferredSize(new Dimension(130, 130));

            //---- btAtualizar ----
            btAtualizar.setText("Atualizar");

            GroupLayout pTopLayout = new GroupLayout(pTop);
            pTop.setLayout(pTopLayout);
            pTopLayout.setHorizontalGroup(
                pTopLayout.createParallelGroup()
                    .addGroup(pTopLayout.createSequentialGroup()
                        .addGroup(pTopLayout.createParallelGroup()
                            .addGroup(pTopLayout.createSequentialGroup()
                                .addGap(177, 808, Short.MAX_VALUE)
                                .addComponent(btAtualizar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(pTopLayout.createSequentialGroup()
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbJogador)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 648, Short.MAX_VALUE)))
                        .addComponent(btCriarSala, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            pTopLayout.setVerticalGroup(
                pTopLayout.createParallelGroup()
                    .addGroup(pTopLayout.createSequentialGroup()
                        .addGroup(pTopLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(lbJogador))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pTopLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, pTopLayout.createSequentialGroup()
                                .addComponent(btCriarSala, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(pTopLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btAtualizar)
                                .addContainerGap())))
            );
        }
        contentPane.add(pTop);
        pTop.setBounds(0, 0, 1090, 145);

        //======== scrollPane1 ========
        {
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            //======== pJogos ========
            {
                pJogos.setBorder(new TitledBorder(null, "Lista de Jogos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                    new Font("Garuda", Font.BOLD, 20), new Color(0, 169, 179)));
                pJogos.setLayout(new FlowLayout(FlowLayout.LEFT));
            }
            scrollPane1.setViewportView(pJogos);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 155, 1070, 475);

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
    private JLabel label3;
    private JLabel lbJogador;
    private JButton btCriarSala;
    private JButton btAtualizar;
    private JScrollPane scrollPane1;
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
    public JButton btAtualizar() {
        return btAtualizar;
    }

    @Override
    public void addCriarSalaListener(ActionListener listener) {
        btCriarSala.addActionListener(listener);
    }

    @Override
    public void addAtualizarSalaListener(ActionListener listener) {
        btAtualizar.addActionListener(listener);
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

    @Override
    public void destroy() {
        this.setVisible(false);
        this.dispose();
    }
}

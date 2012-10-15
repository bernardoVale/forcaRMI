/*
 * Created by JFormDesigner on Wed Oct 10 13:20:46 BRT 2012
 */

package utfpr.edu.br.view.telas.lobby.painelPartida;

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.presenter.JogoPresenter;
import utfpr.edu.br.presenter.LobbyPresenter;
import utfpr.edu.br.spring.SpringFactory;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bernardo Vale
 */
public class PainelPartida extends JPanel {
    private final JogoPresenter presenter;
    private final LobbyPresenter lobby;
    private JogoDTO jogo;
    private JogadorDTO jogador;
    public PainelPartida(JogoDTO jogo,int i,JogadorDTO jogador,LobbyPresenter lobby) {
        initComponents();
        popularJogo(jogo,i);
        setUpListener();
        presenter = (JogoPresenter) SpringFactory.getFactory().getBean("JogoPresenter");
        this.lobby = lobby;
        this.jogo = jogo;
        this.jogador = jogador;
        mudarBotao();
    }

    private void setUpListener() {
        btEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lobby.destroy();
                presenter.createView(jogador,jogo);
            }
        });
    }

    private void popularJogo(JogoDTO jogo,int i) {
        lbNumRodadas.setText(jogo.getNumRodadas().toString());
        lbDificuldade.setText(jogo.getDificuldade());
        lbId.setText(""+i);
        lbJogadores.setText(jogo.getNum_Jogadores()+"/"+"2");
    }
    private void mudarBotao(){
        if(jogo.getNum_Jogadores()==2){
            btEntrar.setText("Lotado");
            btEntrar.setEnabled(false);
        }else{
            btEntrar.setText("Entrar");
            btEntrar.setEnabled(true);
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bernardo Vale
        label1 = new JLabel();
        btEntrar = new JButton();
        label2 = new JLabel();
        lbNumRodadas = new JLabel();
        lb = new JLabel();
        label3 = new JLabel();
        lbDificuldade = new JLabel();
        lbId = new JLabel();
        lbJogadores = new JLabel();

        //======== this ========
        setBackground(new Color(153, 153, 255));
        setBorder(new MatteBorder(3, 3, 3, 3, Color.black));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- label1 ----
        label1.setText("Sala");
        label1.setFont(new Font("SansSerif", Font.BOLD, 15));

        //---- btEntrar ----
        btEntrar.setText("Entrar");
        btEntrar.setFont(new Font("SansSerif", Font.PLAIN, 20));

        //---- label2 ----
        label2.setText("Numero de Rodadas:");
        label2.setFont(new Font("SansSerif", Font.PLAIN, 14));

        //---- lbNumRodadas ----
        lbNumRodadas.setFont(new Font("SansSerif", Font.PLAIN, 14));

        //---- lb ----
        lb.setText("Jogadores:");
        lb.setFont(new Font("SansSerif", Font.PLAIN, 14));

        //---- label3 ----
        label3.setText("Dificuldade:");
        label3.setFont(new Font("SansSerif", Font.PLAIN, 14));

        //---- lbDificuldade ----
        lbDificuldade.setFont(new Font("SansSerif", Font.PLAIN, 14));

        //---- lbId ----
        lbId.setText("10");
        lbId.setFont(new Font("SansSerif", Font.BOLD, 16));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbId))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbNumRodadas))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lb)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbJogadores))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbDificuldade)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btEntrar, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbId))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(lbNumRodadas))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lb)
                        .addComponent(lbJogadores))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(lbDificuldade))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEntrar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bernardo Vale
    private JLabel label1;
    private JButton btEntrar;
    private JLabel label2;
    private JLabel lbNumRodadas;
    private JLabel lb;
    private JLabel label3;
    private JLabel lbDificuldade;
    private JLabel lbId;
    private JLabel lbJogadores;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

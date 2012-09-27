package utfpr.edu.br.view.jogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JogoViewImpl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoViewImpl frame = new JogoViewImpl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JogoViewImpl() {
		java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelLobby = new javax.swing.JPanel();
        lbP2 = new javax.swing.JLabel();
        lbP2.setBounds(672, 58, 66, 28);
        P2_nome = new javax.swing.JLabel();
        P2_nome.setBounds(784, 58, 93, 28);
        pJogador1 = new javax.swing.JPanel();
        pJogador1.setBounds(96, 87, 250, 387);
        P1_nome = new javax.swing.JLabel();
        P1_nome.setBounds(211, 58, 93, 28);
        lbP1 = new javax.swing.JLabel();
        lbP1.setBounds(99, 58, 66, 28);
        pJogador2 = new javax.swing.JPanel();
        pJogador2.setBounds(672, 92, 250, 387);
        lbPlacar = new javax.swing.JLabel();
        lbPlacar.setBounds(401, 84, 195, 73);
        lbPontuacaoP2 = new javax.swing.JLabel();
        lbPontuacaoP2.setBounds(558, 159, 38, 52);
        lbX = new javax.swing.JLabel();
        lbX.setBounds(467, 159, 36, 52);
        lbPontuacaoP1 = new javax.swing.JLabel();
        lbPontuacaoP1.setBounds(390, 159, 38, 52);
        pLetrasErradas = new javax.swing.JPanel();
        pLetrasErradas.setBounds(352, 223, 300, 263);
        letra4 = new javax.swing.JLabel();
        letra7 = new javax.swing.JLabel();
        letra1 = new javax.swing.JLabel();
        letra2 = new javax.swing.JLabel();
        letra5 = new javax.swing.JLabel();
        letra8 = new javax.swing.JLabel();
        letra6 = new javax.swing.JLabel();
        letra9 = new javax.swing.JLabel();
        letra3 = new javax.swing.JLabel();
        pLetras = new javax.swing.JPanel();
        pLetras.setBounds(96, 498, 814, 100);
        pEnviar = new javax.swing.JPanel();
        pEnviar.setBounds(96, 610, 514, 92);
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        lbBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelLobby.setOpaque(false);

        lbP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbP2.setText("Nome:");

        P2_nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        P2_nome.setText("João1234");

        javax.swing.GroupLayout pJogador1Layout = new javax.swing.GroupLayout(pJogador1);
        pJogador1.setLayout(pJogador1Layout);
        pJogador1Layout.setHorizontalGroup(
            pJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        pJogador1Layout.setVerticalGroup(
            pJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        P1_nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        P1_nome.setText("João1234");

        lbP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbP1.setText("Nome:");

        javax.swing.GroupLayout pJogador2Layout = new javax.swing.GroupLayout(pJogador2);
        pJogador2.setLayout(pJogador2Layout);
        pJogador2Layout.setHorizontalGroup(
            pJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        pJogador2Layout.setVerticalGroup(
            pJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        lbPlacar.setFont(new java.awt.Font("Tahoma", 0, 55)); // NOI18N
        lbPlacar.setText("Placar");

        lbPontuacaoP2.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        lbPontuacaoP2.setText("3");

        lbX.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        lbX.setText("x");

        lbPontuacaoP1.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        lbPontuacaoP1.setText("3");

        letra4.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra4.setText("J");
        letra4.setPreferredSize(new java.awt.Dimension(100, 14));

        letra7.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra7.setText("K");
        letra7.setPreferredSize(new java.awt.Dimension(100, 14));

        letra1.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra1.setText("A");
        letra1.setPreferredSize(new java.awt.Dimension(100, 14));

        letra2.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra2.setText("B");
        letra2.setPreferredSize(new java.awt.Dimension(100, 14));

        letra5.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra5.setText("R");
        letra5.setPreferredSize(new java.awt.Dimension(100, 14));

        letra8.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra8.setText("L");
        letra8.setPreferredSize(new java.awt.Dimension(100, 14));

        letra6.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra6.setText("Z");
        letra6.setPreferredSize(new java.awt.Dimension(100, 14));

        letra9.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra9.setText("U");
        letra9.setPreferredSize(new java.awt.Dimension(100, 14));

        letra3.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        letra3.setText("C");
        letra3.setPreferredSize(new java.awt.Dimension(100, 14));

        javax.swing.GroupLayout pLetrasErradasLayout = new javax.swing.GroupLayout(pLetrasErradas);
        pLetrasErradas.setLayout(pLetrasErradasLayout);
        pLetrasErradasLayout.setHorizontalGroup(
            pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLetrasErradasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(letra7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(letra8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(letra9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        pLetrasErradasLayout.setVerticalGroup(
            pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLetrasErradasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLetrasErradasLayout.createSequentialGroup()
                        .addGroup(pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(letra2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(letra3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(letra5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(letra6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(letra9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(pLetrasErradasLayout.createSequentialGroup()
                        .addComponent(letra1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(letra4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pLetrasErradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(letra7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(letra8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout pLetrasLayout = new javax.swing.GroupLayout(pLetras);
        pLetras.setLayout(pLetrasLayout);
        pLetrasLayout.setHorizontalGroup(
            pLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
        );
        pLetrasLayout.setVerticalGroup(
            pLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Enviar");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton1.setText("Letra");

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton2.setText("Chutar");

        javax.swing.GroupLayout pEnviarLayout = new javax.swing.GroupLayout(pEnviar);
        pEnviar.setLayout(pEnviarLayout);
        pEnviarLayout.setHorizontalGroup(
            pEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEnviarLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEnviarLayout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addGap(45, 45, 45)
                        .addComponent(jRadioButton1))
                    .addGroup(pEnviarLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        pEnviarLayout.setVerticalGroup(
            pEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEnviarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelLobby.setLayout(null);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(panelLobby, gridBagConstraints);
        panelLobby.add(pJogador1);
        panelLobby.add(lbP1);
        panelLobby.add(P1_nome);
        panelLobby.add(lbPontuacaoP1);
        panelLobby.add(lbX);
        panelLobby.add(lbPontuacaoP2);
        panelLobby.add(pLetrasErradas);
        panelLobby.add(lbPlacar);
        panelLobby.add(lbP2);
        panelLobby.add(P2_nome);
        panelLobby.add(pJogador2);
        panelLobby.add(pLetras);
        panelLobby.add(pEnviar);

        lbBackground.setIcon(new ImageIcon("/home/bernardo/forcaRMI/forca/src/main/resources/presentation_background.jpg")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(lbBackground, gridBagConstraints);

        pack();
	}
	 private javax.swing.JLabel P1_nome;
	    private javax.swing.JLabel P2_nome;
	    private javax.swing.ButtonGroup buttonGroup1;
	    private javax.swing.JButton jButton1;
	    private javax.swing.JRadioButton jRadioButton1;
	    private javax.swing.JRadioButton jRadioButton2;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JLabel lbBackground;
	    private javax.swing.JLabel lbP1;
	    private javax.swing.JLabel lbP2;
	    private javax.swing.JLabel lbPlacar;
	    private javax.swing.JLabel lbPontuacaoP1;
	    private javax.swing.JLabel lbPontuacaoP2;
	    private javax.swing.JLabel lbX;
	    private javax.swing.JLabel letra1;
	    private javax.swing.JLabel letra2;
	    private javax.swing.JLabel letra3;
	    private javax.swing.JLabel letra4;
	    private javax.swing.JLabel letra5;
	    private javax.swing.JLabel letra6;
	    private javax.swing.JLabel letra7;
	    private javax.swing.JLabel letra8;
	    private javax.swing.JLabel letra9;
	    private javax.swing.JPanel pEnviar;
	    private javax.swing.JPanel pJogador1;
	    private javax.swing.JPanel pJogador2;
	    private javax.swing.JPanel pLetras;
	    private javax.swing.JPanel pLetrasErradas;
	    private javax.swing.JPanel panelLobby;
}
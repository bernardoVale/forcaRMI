package utfpr.edu.br.view.telas.jogo;


import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.dto.PalavraDTO;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.util.List;

public class JogoViewImpl extends JFrame implements JogoView{

    private JogadorDTO jogador;
    private JogadorDTO adversario;
    private JogoDTO jogo;
    private List<PalavraDTO> palavras;
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
		GridBagConstraints gridBagConstraints;

        buttonGroup1 = new ButtonGroup();
        panelLobby = new JPanel();
        lbP2 = new JLabel();
        lbP2.setBounds(672, 58, 106, 28);
        P2_nome = new JLabel();
        P2_nome.setBounds(780, 58, 182, 28);
        pJogador1 = new JPanel();
        pJogador1.setBounds(96, 87, 250, 387);
        P1_nome = new JLabel();
        P1_nome.setBounds(162, 58, 184, 28);
        lbP1 = new JLabel();
        lbP1.setBounds(99, 58, 66, 28);
        pJogador2 = new JPanel();
        pJogador2.setBounds(682, 87, 250, 387);
        lbPlacar = new JLabel();
        lbPlacar.setBounds(414, 74, 288, 73);
        lbPontuacaoP2 = new JLabel();
        lbPontuacaoP2.setBounds(560, 141, 38, 52);
        lbX = new JLabel();
        lbX.setBounds(473, 137, 38, 60);
        lbPontuacaoP1 = new JLabel();
        lbPontuacaoP1.setBounds(400, 141, 38, 52);
        pLetrasErradas = new JPanel();
        pLetrasErradas.setBounds(360, 211, 300, 263);
        letra4 = new JLabel();
        letra7 = new JLabel();
        letra1 = new JLabel();
        letra2 = new JLabel();
        letra5 = new JLabel();
        letra8 = new JLabel();
        letra6 = new JLabel();
        letra9 = new JLabel();
        letra3 = new JLabel();
        pPalavras = new JPanel();
        pPalavras.setBounds(96, 498, 800, 100);
        pLetras = new JPanel();

        pEnviar = new JPanel();
        pEnviar.setBounds(96, 610, 514, 92);
        jButton1 = new JButton();
        jTextField1 = new JTextField();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        lbBackground = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        panelLobby.setOpaque(false);

        lbP2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        lbP2.setText("Oponente:");

        P2_nome.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        P2_nome.setText("");

        GroupLayout pJogador1Layout = new GroupLayout(pJogador1);
        pJogador1.setLayout(pJogador1Layout);
        pJogador1Layout.setHorizontalGroup(
            pJogador1Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        pJogador1Layout.setVerticalGroup(
            pJogador1Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        P1_nome.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        P1_nome.setText("");

        lbP1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        lbP1.setText("Nome:");

        GroupLayout pJogador2Layout = new GroupLayout(pJogador2);
        pJogador2.setLayout(pJogador2Layout);
        pJogador2Layout.setHorizontalGroup(
            pJogador2Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        pJogador2Layout.setVerticalGroup(
            pJogador2Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        lbPlacar.setFont(new Font("Tahoma", 0, 55)); // NOI18N
        lbPlacar.setText("Placar");

        lbPontuacaoP2.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        lbPontuacaoP2.setText("0");

        lbX.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        lbX.setText("x");

        lbPontuacaoP1.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        lbPontuacaoP1.setText("0");

        letra4.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra4.setText("");
        letra4.setPreferredSize(new Dimension(100, 14));

        letra7.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra7.setText("");
        letra7.setPreferredSize(new Dimension(100, 14));

        letra1.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra1.setText("");
        letra1.setPreferredSize(new Dimension(100, 14));

        letra2.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra2.setText("");
        letra2.setPreferredSize(new Dimension(100, 14));

        letra5.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra5.setText("");
        letra5.setPreferredSize(new Dimension(100, 14));

        letra8.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra8.setText("");
        letra8.setPreferredSize(new Dimension(100, 14));

        letra6.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra6.setText("");
        letra6.setPreferredSize(new Dimension(100, 14));

        letra9.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra9.setText("");
        letra9.setPreferredSize(new Dimension(100, 14));

        letra3.setFont(new Font("Tahoma", 0, 60)); // NOI18N
        letra3.setText("");
        letra3.setPreferredSize(new Dimension(100, 14));

        GroupLayout pLetrasErradasLayout = new GroupLayout(pLetrasErradas);
        pLetrasErradas.setLayout(pLetrasErradasLayout);
        pLetrasErradasLayout.setHorizontalGroup(
            pLetrasErradasLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(pLetrasErradasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pLetrasErradasLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(letra7, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(pLetrasErradasLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(letra8, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(pLetrasErradasLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(letra9, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(letra6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        pLetrasErradasLayout.setVerticalGroup(
            pLetrasErradasLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(pLetrasErradasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pLetrasErradasLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(pLetrasErradasLayout.createSequentialGroup()
                        .addGroup(pLetrasErradasLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(letra2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addComponent(letra3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pLetrasErradasLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(letra5, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addComponent(letra6, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(letra9, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(pLetrasErradasLayout.createSequentialGroup()
                        .addComponent(letra1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(letra4, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pLetrasErradasLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(letra7, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addComponent(letra8, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );

        jButton1.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Enviar");

        jTextField1.setFont(new Font("Tahoma", 0, 24)); // NOI18N

        jRadioButton1.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton1.setText("Letra");

        jRadioButton2.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton2.setText("Chutar");
        
        JButton btnDesistir = new JButton("Desistir");

        GroupLayout pEnviarLayout = new GroupLayout(pEnviar);
        pEnviarLayout.setHorizontalGroup(
        	pEnviarLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pEnviarLayout.createSequentialGroup()
        			.addGap(50)
        			.addGroup(pEnviarLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(pEnviarLayout.createSequentialGroup()
        					.addComponent(jRadioButton2)
        					.addGap(45)
        					.addComponent(jRadioButton1))
        				.addGroup(pEnviarLayout.createSequentialGroup()
        					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jButton1)
        					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
        					.addComponent(btnDesistir))))
        );
        pEnviarLayout.setVerticalGroup(
        	pEnviarLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(pEnviarLayout.createSequentialGroup()
        			.addGroup(pEnviarLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jRadioButton2)
        				.addComponent(jRadioButton1))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(pEnviarLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        		.addComponent(btnDesistir)
        );
        pEnviar.setLayout(pEnviarLayout);
        panelLobby.setLayout(null);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
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


        //Adiciono as propriedades do grid para a palavra
        GridBagLayout gbl_pPalavras = new GridBagLayout();
        gbl_pPalavras.columnWidths = new int[]{0, 0};
        gbl_pPalavras.rowHeights = new int[]{0, 0, 0};
        gbl_pPalavras.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_pPalavras.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        pPalavras.setLayout(gbl_pPalavras);

        //Adiciono o painel de letras
        GridBagConstraints gbc_pLetras = new GridBagConstraints();
        gbc_pLetras.insets = new Insets(0, 0, 5, 0);
        gbc_pLetras.fill = GridBagConstraints.BOTH;
        gbc_pLetras.gridx = 0;
        gbc_pLetras.gridy = 0;
        pPalavras.add(pLetras, gbc_pLetras);



        panelLobby.add(pEnviar);
        lbCarregando = new JLabel("");
        lbCarregando.setIcon(new ImageIcon(getClass().getResource("/carregando.gif")));
        lbCarregando.setBounds(447, 159, 128, 128);
        lbCarregando.setVisible(false);
        panelLobby.add(lbCarregando);

        lbBackground.setIcon(new ImageIcon("/home/bernardo/forcaRMI/forca/src/main/resources/presentation_background.jpg")); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(lbBackground, gridBagConstraints);

        panelLobby.add(pPalavras);
        pack();
	}
	 private JLabel P1_nome;
	    private JLabel P2_nome;
	    private ButtonGroup buttonGroup1;
	    private JButton jButton1;
	    private JRadioButton jRadioButton1;
	    private JRadioButton jRadioButton2;
	    private JTextField jTextField1;
	    private JLabel lbBackground;
	    private JLabel lbP1;
	    private JLabel lbP2;
	    private JLabel lbPlacar;
	    private JLabel lbPontuacaoP1;
	    private JLabel lbPontuacaoP2;
	    private JLabel lbX;
	    private JLabel letra1;
	    private JLabel letra2;
	    private JLabel letra3;
	    private JLabel letra4;
	    private JLabel letra5;
	    private JLabel letra6;
	    private JLabel letra7;
	    private JLabel letra8;
	    private JLabel letra9;
	    private JPanel pEnviar;
	    private JPanel pJogador1;
	    private JPanel pJogador2;
	    private JPanel pPalavras;
        private JPanel pLetras;
	    private JPanel pLetrasErradas;
	    private JPanel panelLobby;
        private JLabel lbCarregando;

    @Override
    public JLabel P1_nome() {
        return P1_nome;
    }

    @Override
    public JLabel P2_nome() {
        return P2_nome;
    }

    @Override
    public JLabel lbPontuacaoP1() {
        return lbPontuacaoP1;
    }

    @Override
    public JLabel lbPontuacaoP2() {
        return lbPontuacaoP2;
    }

    @Override
    public JLabel lbX() {
        return lbX;
    }

    @Override
    public JLabel lbCarregando() {
        return lbCarregando;
    }

    @Override
    public JLabel lbPlacar() {
        return lbPlacar;
    }

    @Override
    public JPanel pLetrasErradas() {
        return pLetrasErradas;
    }

    @Override
    public JPanel pEnviar() {
        return pEnviar;
    }

    @Override
    public JPanel pLetras() {
        return pLetras;
    }

    @Override
    public JPanel pPalavras() {
        return pPalavras;
    }
    @Override
    public JogadorDTO jogador() {
        return jogador;
    }

    @Override
    public JogadorDTO adversario() {
        return adversario;
    }

    @Override
    public JogoDTO jogo() {
        return jogo;
    }

    @Override
    public void setJogo(JogoDTO jogo) {
        this.jogo = jogo;
    }

    @Override
    public List<PalavraDTO> palavras() {
        return palavras;
    }

    @Override
    public void setPalavras(List<PalavraDTO> palavras) {
        this.palavras = palavras;
    }

    @Override
    public void setAdversario(JogadorDTO adversario) {
        this.adversario = adversario;
    }

    @Override
    public JFrame root() {
        return this;
    }

    @Override
    public void packAndShow(JogadorDTO jogador) {
        this.jogador = jogador;
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void clearFields() {
        Component[] componentes = this.getContentPane().getComponents();

        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                JTextField field = (JTextField)componentes[i];
                field.setText("");
            }
        }
    }
}

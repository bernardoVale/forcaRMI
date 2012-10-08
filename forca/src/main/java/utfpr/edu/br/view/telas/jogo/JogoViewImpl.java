package utfpr.edu.br.view.telas.jogo;


import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.dto.PalavraDTO;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JogoViewImpl extends JFrame implements JogoView{

    private JogoAtivoDTO dadosJogo;
    private JogadorDTO jogador;
    private JogadorDTO adversario;
    private List<JLabel> palavraAtualPopulada = new ArrayList<JLabel>();
    private JogoDTO jogo;
    private boolean meuTurno = false;
    private int rodadaAtual=1;
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

        bgRadioButton = new ButtonGroup();
        panelLobby = new JPanel();
        lbP2 = new JLabel();
        lbP2.setBounds(672, 58, 106, 28);
        P2_nome = new JLabel();
        P2_nome.setBounds(780, 58, 182, 28);
        pJogador1 = new JPanel();
        pJogador1.setBounds(96, 87, 250, 387);
        lbErroJogador1 = new JLabel("");
        lbErroJogador1.setBounds(0,0,250,387);
        P1_nome = new JLabel();
        P1_nome.setBounds(162, 58, 184, 28);
        lbP1 = new JLabel();
        lbP1.setBounds(99, 58, 66, 28);
        pJogador2 = new JPanel();
        pJogador2.setBounds(682, 87, 250, 387);
        lbErroJogador2 = new JLabel("");
        lbErroJogador2.setBounds(0,0,250,387);
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
        jButton1.setBounds(198, 45, 118, 34);
        jtfEnviar = new JFormattedTextField(setMascara("U"));
        jtfEnviar.setBounds(50, 45, 130, 34);

        rbLetra = new JRadioButton();
        rbLetra.setBounds(50, 0, 104, 33);
        rbChutar = new JRadioButton();
        rbChutar.setBounds(199, 0, 114, 33);
        rbLetra.setSelected(true);//padrao da letra
        btnDesistir = new JButton();
        btnDesistir.setBounds(417, 62, 97, 29);


        lbBackground = new JLabel();

        bgRadioButton.add(rbLetra);
        bgRadioButton.add(rbChutar);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        panelLobby.setOpaque(false);

        lbP2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        lbP2.setText("Oponente:");

        P2_nome.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        P2_nome.setText("");

        pJogador1.setLayout(null);
        pJogador1.add(lbErroJogador1);
        pJogador1.setVisible(false);

        P1_nome.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        P1_nome.setText("");

        lbP1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        lbP1.setText("Nome:");

        pJogador2.setLayout(null);
        pJogador2.add(lbErroJogador2);
        pJogador2.setVisible(false);

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

        pLetrasErradas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        jButton1.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Enviar");

        jtfEnviar.setFont(new Font("Tahoma", 0, 24)); // NOI18N

        rbLetra.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        rbLetra.setText("Letra");

        rbChutar.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        rbChutar.setText("Chutar");
        
        btnDesistir.setText("Desistir");




        pEnviar.setLayout(null);
        pEnviar.add(jButton1);
        pEnviar.add(jtfEnviar);
        pEnviar.add(rbChutar);
        pEnviar.add(rbLetra);
        pEnviar.add(btnDesistir);

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
	    private ButtonGroup bgRadioButton;
	    private JButton jButton1;
	    private JRadioButton rbLetra;
	    private JRadioButton rbChutar;
        private JButton btnDesistir;
	    private JFormattedTextField jtfEnviar;
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
        private JLabel lbErroJogador1;
        private JLabel lbErroJogador2;

    @Override
    public void setDadosJogo(JogoAtivoDTO dadosJogo) {
        this.dadosJogo = dadosJogo;
    }

    @Override
    public JogoAtivoDTO dadosJogo() {
        return dadosJogo;
    }

    @Override
    public List<JLabel> palavraAtualPopulada() {
        return palavraAtualPopulada;
    }

    @Override
    public void setPalavraAtualPopulada(List<JLabel> palavraAtualPopulada) {
        this.palavraAtualPopulada = palavraAtualPopulada;
        dadosJogo.setPalavraAtualPopulada(palavraAtualPopulada);
    }

    @Override
    public JFormattedTextField jtfEnviar() {
        return jtfEnviar;
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
    public void addChutarLetraListener(ActionListener listener) {
         jButton1.addActionListener(listener);
    }

    @Override
    public void addMascaraTextoListener(ActionListener listener) {
        rbChutar.addActionListener(listener);
        rbLetra.addActionListener(listener);
    }

    @Override
    public void setJtfEnviar(JFormattedTextField jtfEnviar) {
        this.jtfEnviar = jtfEnviar;
    }

    @Override
    public JRadioButton rbChutar() {
        return rbChutar;
    }

    @Override
    public JRadioButton rbLetra() {
        return rbLetra;
    }

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
    public JPanel pJogador1() {
        return pJogador1;
    }

    @Override
    public JLabel lbErroJogador1() {
        return lbErroJogador1;
    }

    @Override
    public JLabel lbErroJogador2() {
        return lbErroJogador2;
    }

    @Override
    public JPanel pJogador2() {
        return pJogador2;
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
    public boolean meuTurno() {
        return meuTurno;
    }

    @Override
    public void setMeuTurno(boolean meuTurno) {
        this.meuTurno = meuTurno;
    }

    @Override
    public JFrame root() {
        return this;
    }

    @Override
    public int rodadaAtual() {
        return rodadaAtual;
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

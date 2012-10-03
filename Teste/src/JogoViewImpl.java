import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pPalavra = new JPanel();
		pPalavra.setBounds(5, 5, 438, 55);
		contentPane.add(pPalavra);
		GridBagLayout gbl_pPalavra = new GridBagLayout();
		gbl_pPalavra.columnWidths = new int[]{438, 0};
		gbl_pPalavra.rowHeights = new int[]{25, 25, 0};
		gbl_pPalavra.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pPalavra.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pPalavra.setLayout(gbl_pPalavra);
		
		JPanel pLetras = new JPanel();
		GridBagConstraints gbc_pLetras = new GridBagConstraints();
		gbc_pLetras.fill = GridBagConstraints.BOTH;
		gbc_pLetras.insets = new Insets(0, 0, 5, 0);
		gbc_pLetras.gridx = 0;
		gbc_pLetras.gridy = 0;
		pPalavra.add(pLetras, gbc_pLetras);
		pLetras.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblA = new JLabel("<html><u>A</u></html>");
		
		pLetras.add(lblA);
		
		JPanel pAsteriscos = new JPanel();
		GridBagConstraints gbc_pAsteriscos = new GridBagConstraints();
		gbc_pAsteriscos.fill = GridBagConstraints.BOTH;
		gbc_pAsteriscos.gridx = 0;
		gbc_pAsteriscos.gridy = 1;
		pPalavra.add(pAsteriscos, gbc_pAsteriscos);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		pAsteriscos.add(lblNewLabel_1);
	}
}

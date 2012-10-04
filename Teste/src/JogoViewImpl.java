import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;


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
		pPalavra.setBounds(5, 5, 438, 167);
		contentPane.add(pPalavra);
		GridBagLayout gbl_pPalavra = new GridBagLayout();
		gbl_pPalavra.columnWidths = new int[]{438, 0};
		gbl_pPalavra.rowHeights = new int[]{25, 0, 25, 0, 0};
		gbl_pPalavra.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pPalavra.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		lblA.setFont(new Font("Dialog", Font.BOLD, 37));
		lblA.setForeground(UIManager.getColor("Button.foreground"));
		
		pLetras.add(lblA);
		
		JLabel label = new JLabel("_");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		pLetras.add(label);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 1;
		pPalavra.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 2;
		pPalavra.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		JFormattedTextField formattedTextField = new JFormattedTextField(
				setMascara("U"));
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 0;
		gbc_formattedTextField.gridy = 3;
		pPalavra.add(formattedTextField, gbc_formattedTextField);

	}
	
	private MaskFormatter setMascara(String mascara) {  
	    MaskFormatter mask = null;  
	    try {  
	        mask = new MaskFormatter(mascara);  
	    } catch (ParseException e) {  
	  
	        e.printStackTrace();  
	    }  
	    return mask;  
	}  
}

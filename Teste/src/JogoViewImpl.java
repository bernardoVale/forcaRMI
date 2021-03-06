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
import javax.swing.ImageIcon;


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
		setBounds(100, 100, 250, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,300,263);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 240, 268);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblH = new JLabel("H");
		lblH.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblH);
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblD);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblC);
		
		JLabel lblD_1 = new JLabel("D");
		lblD_1.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblD_1);
		
		JLabel lblA = new JLabel("D");
		lblA.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblA);
		
		JLabel lblD_2 = new JLabel("D");
		lblD_2.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblD_2);
		
		JLabel lblD_3 = new JLabel("D");
		lblD_3.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblD_3);
		
		JLabel lblD_4 = new JLabel("D");
		lblD_4.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblD_4);
		
		JLabel lblD_5 = new JLabel("D");
		lblD_5.setFont(new Font("SansSerif", Font.BOLD, 73));
		panel.add(lblD_5);
		
		ButtonGroup bg = new ButtonGroup();

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

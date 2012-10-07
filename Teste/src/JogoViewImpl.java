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
		setBounds(100, 100, 250, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,250,387);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 250, 387);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("/home/bernardo/forcaRMI/forca/src/main/resources/erro_0.png"));
		
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

package utfpr.edu.br.view.telas.lobby.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SalvarJogoViewImpl extends JDialog {

	private final JPanel contentPanel = new JPanel();
	/**
	 * @wbp.nonvisual location=207,267
	 */
	private final JButton button = new JButton("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SalvarJogoViewImpl dialog = new SalvarJogoViewImpl();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SalvarJogoViewImpl() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 448, 270);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
	}

}

package utfpr.edu.br.view.telas.login;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class LoginViewImpl extends JFrame implements LoginView{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginViewImpl frame = new LoginViewImpl();
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
	public LoginViewImpl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		GridBagConstraints gridBagConstraints;

        panelJogar = new JPanel();
        btJogar = new JButton();
        lbNome = new JLabel();
        jtfJogar1 = new JTextField();
        lbSenha = new JLabel();
        jPasswordField1 = new JPasswordField();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        panelJogar.setOpaque(false);

        btJogar.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        btJogar.setIcon(new ImageIcon(getClass().getResource("/BOTAO_NORMAL.png")));
         btJogar.setPressedIcon(new ImageIcon(getClass().getResource("/BOTAO_ON_FOCUS.png")));// NOI18N

        lbNome.setIcon(new ImageIcon(getClass().getResource("/LabelNome.png"))); // NOI18N
        lbNome.setName("lbName"); // NOI18N

        jtfJogar1.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        jtfJogar1.setName("jtfNome"); // NOI18N

        lbSenha.setIcon(new ImageIcon(getClass().getResource("/label_Senha.png"))); // NOI18N
        lbSenha.setName("lbSenha");


        jPasswordField1.setPreferredSize(new Dimension(6, 50));
        jPasswordField1.setFont(new Font("Tahoma", 0, 36)); // NOI18N

        GroupLayout panelJogarLayout = new GroupLayout(panelJogar);
        panelJogarLayout.setHorizontalGroup(
        	panelJogarLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelJogarLayout.createSequentialGroup()
        			.addGroup(panelJogarLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelJogarLayout.createParallelGroup(Alignment.TRAILING)
        					.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
        					.addGroup(panelJogarLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(panelJogarLayout.createSequentialGroup()
        							.addGap(104)
        							.addComponent(jtfJogar1, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE))
        						.addGroup(panelJogarLayout.createSequentialGroup()
        							.addGap(141)
        							.addComponent(btJogar, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
        						.addGroup(panelJogarLayout.createSequentialGroup()
        							.addGap(81)
        							.addComponent(lbNome))))
        				.addGroup(panelJogarLayout.createSequentialGroup()
        					.addGap(55)
        					.addComponent(lbSenha, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(249, Short.MAX_VALUE))
        );
        panelJogarLayout.setVerticalGroup(
        	panelJogarLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelJogarLayout.createSequentialGroup()
        			.addGap(209)
        			.addComponent(lbNome)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jtfJogar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(4)
        			.addComponent(lbSenha)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(25)
        			.addComponent(btJogar, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(80, Short.MAX_VALUE))
        );
        panelJogar.setLayout(panelJogarLayout);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(panelJogar, gridBagConstraints);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/forca.png"))); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(jLabel1, gridBagConstraints);

        pack();	}
	
	private JButton btJogar;
    private JLabel jLabel1;
    private JPasswordField jPasswordField1;
    private JTextField jtfJogar1;
    private JLabel lbNome;
    private JLabel lbSenha;
    private JPanel panelJogar;
    @Override
    public JButton getBotaoLogin() {
        return btJogar;
    }

    @Override
    public String getSenha() {
        return jPasswordField1.getText();
    }
    @Override
    public String getNome() {
        System.out.println(jtfJogar1.getText());
        return jtfJogar1.getText();
    }
    @Override
    public void addAutenticarListener(ActionListener listener,KeyListener listenerKey) {
       btJogar.addActionListener(listener);
       jPasswordField1.addKeyListener(listenerKey);
       jtfJogar1.addKeyListener(listenerKey);
    }

    @Override
    public Component getJFrame() {
        return this;
    }

    @Override
    public void destroy() {
        this.setVisible(false);
        this.dispose();
    }

    @Override
    public void packAndShow() {
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

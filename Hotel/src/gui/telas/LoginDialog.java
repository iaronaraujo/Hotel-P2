package gui.telas;

import gui.reusavel.Title;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import programa.documentos.DocumentFactory;
import programa.documentos.DoubleLock;

/**
 * Tela de login da interface. Apos autenticado, o usuario
 * entra como funcionario ou como administrador no programa.
 * 
 * @author WesleySilva
 *
 */
public class LoginDialog extends JDialog {
	private static final long serialVersionUID = 157896501501L;
	
	// Panels
	private JPanel contentPanel = new JPanel();
	private JPanel jpInformation;
	private Title jpTitle;
	
	// TextFields
	private JTextField jtfUsuario;
	
	// PasswordFields
	private JPasswordField jpfSenha;
	
	// Labels
	private JLabel lblUsuario;
	private JLabel lblSenha;
	
	// Buttons
	private JButton btnLogin;
	private JButton btnRecuperarSenha;
	
	// Colors
	private Color clrBtnLogin;
	
	public LoginDialog(final JFrame parentFrame) {
		// Configurando o dialog.
		this.setTitle("RHM - Tela de Login");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// Configurando o painel jpInformation.
		jpInformation = new JPanel();
		jpInformation.setBounds(12, 60, 426, 165);
		jpInformation.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPanel.add(jpInformation);
		jpInformation.setLayout(null);
		
		// Configurnado o campo de texto jtfUsuario.
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(12, 37, 151, 19);
		jtfUsuario.setDocument(DocumentFactory.createLengthedDocument(18));
		jtfUsuario.setColumns(19);
		jpInformation.add(jtfUsuario);
		
		// Configurando a label lblUsuario.
		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setBounds(12, 12, 70, 15);
		jpInformation.add(lblUsuario);
		
		// Configurando a label lblSenha.
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(12, 68, 70, 15);
		jpInformation.add(lblSenha);
		
		// Configurando o botão btnLogin.
		btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(getClass().getResource("../../LoginButton.png")));
		btnLogin.setVerticalTextPosition(JButton.BOTTOM);
		btnLogin.setBounds(257, 12, 125, 125);
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorder(BorderFactory.createRaisedBevelBorder());
		btnLogin.getModel().addChangeListener(new BtnLoginChangeListener());
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				parentFrame.setVisible(true);
			}
			
		});
		jpInformation.add(btnLogin);
		
		// Configurando o botão btnRecuperarSenha.
		btnRecuperarSenha = new JButton("Recuperar Senha");
		btnRecuperarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecuperarSenha.setForeground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
		btnRecuperarSenha.setBounds(12, 106, 151, 25);
		jpInformation.add(btnRecuperarSenha);
		btnRecuperarSenha.setFont(new Font("Courier 10 Pitch", Font.PLAIN, 11));
		btnRecuperarSenha.setOpaque(false);
		btnRecuperarSenha.setContentAreaFilled(false);
		btnRecuperarSenha.setBorderPainted(false);
		
		// Configurando o campo de senha jpfSenha.
		jpfSenha = new JPasswordField();
		jpfSenha.setBounds(12, 86, 151, 19);
		jpfSenha.setColumns(19);
		jpInformation.add(jpfSenha);
		
		// Configurando o painel jpTitle.
		jpTitle = new Title("../../LoginScreen.png");
		jpTitle.setBounds(0, 0, 450, 45);
		contentPanel.add(jpTitle);
	}
	
	private class BtnLoginChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent event) {
			ButtonModel closeModel = (ButtonModel) event.getSource();
			
			if (closeModel.isRollover() || closeModel.isPressed()) {
				if (closeModel.isRollover()){
					btnLogin.setBorder(BorderFactory.createRaisedBevelBorder());
					btnLogin.setBackground(Color.BLUE);
				}
				if (closeModel.isPressed()){
					btnLogin.setBorder(BorderFactory.createLoweredBevelBorder());
				}
			} else {
				btnLogin.setBorder(BorderFactory.createRaisedBevelBorder());
				btnLogin.setBackground(clrBtnLogin);
			}
		}
	}
}

package gui.telas;

import gui.reusavel.Title;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import programa.arquivos.CreateFile;
import programa.arquivos.Funcionario;

/**
 * Abre um novo dialogo que sera utilizado para o usuario inserir
 * as informacoes de um novo funcionario. Um icone marca a finalizacao 
 * da entrada de dados e a criacao do funcionario (caso tudo tenha sido
 * corretamente preenchido).
 * 
 * @author WesleySilva
 *
 */
public class NovoFuncionarioDialog extends JDialog {
	private static final long serialVersionUID = 157896500801L;
	
	// Panels
	private JPanel contentPanel = new JPanel();
	private JPanel jpTitle;
	
	// TextFields
	private JTextField jtfUsuario;
	private JTextField jtfEmail;
	
	// PasswordFields
	private JPasswordField jtfConfSenha;
	private JPasswordField jpfSenha;
	
	// Labels
	private JLabel lblConfirmarSenha;
	private JLabel lblCategoria;
	private JLabel lblSenha;
	private JLabel lblEmail;
	private JLabel lblNome;
	private JButton btnOk;
	
	// ComboBoxes
	private final JComboBox<String> jcbCategoria;
	String userCateg = "Funcionário";// NAO MT ORGANIZADO

	public NovoFuncionarioDialog(final JFrame parentFrame) {
		// Configurando o dialog.
		super(parentFrame);
		this.setTitle("RHM - Novo Funcionário");
		this.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 12));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 274);
		this.contentPanel.setLayout(new FlowLayout());
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// Configurando o painel jpTitle.
		jpTitle = new Title("../../NovoFuncionário.png");
		jpTitle.setBounds(0, 0, 450, 45);
		this.getContentPane().add(jpTitle);
		this.getContentPane().setLayout(null);

		// Configurando o campo de texto jtfUsuario.
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(25, 69, 170, 19);
		this.getContentPane().add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		// Configurando a label lblNome.
		lblNome = new JLabel("Usuário:");
		lblNome.setBounds(25, 55, 100, 15);
		lblNome.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 13));
		this.getContentPane().add(lblNome);
		
		// Configurando a label lblSenha.
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(25, 100, 100, 15);
		lblSenha.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 13));
		this.getContentPane().add(lblSenha);
		
		// Configurando o botão btnOk.
		btnOk = new JButton("");
		btnOk.setBounds(296, 112, 80, 80);
		btnOk.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnOk.setHorizontalTextPosition( SwingConstants.CENTER );
		btnOk.setIcon(new ImageIcon(getClass().getResource("../../create.png")));
		btnOk.setOpaque(false);
		btnOk.setContentAreaFilled(false);
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String userName = jtfUsuario.getText();
				String userEmail = jtfEmail.getText();
				Funcionario func = new Funcionario(userName, "123", userCateg, userEmail);
				CreateFile<Funcionario> create = new CreateFile<Funcionario>("funcs.ser");
				create.open();
				create.write(func);
				try{
					create.close();
				} catch (Exception ex) {
					
				}
				dispose();
				
			}
		});
		
		btnOk.setBackground(new Color(51, 153, 102));
		btnOk.setForeground(Color.WHITE);
		this.getContentPane().add(btnOk);
		
		// Configurando a label lblConfirmarSenha.
		lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 13));
		lblConfirmarSenha.setBounds(25, 145, 138, 15);
		this.getContentPane().add(lblConfirmarSenha);
		
		// Configurando a label lblEmail.
		lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 13));
		lblEmail.setBounds(244, 55, 100, 15);
		this.getContentPane().add(lblEmail);
		
		// Configurando o campo de texto jtfEmail.
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(244, 69, 170, 19);
		this.getContentPane().add(jtfEmail);
		
		// Configurando o campo de senha jpfSenha.
		jpfSenha = new JPasswordField();
		jpfSenha.setBounds(25, 114, 170, 19);
		this.getContentPane().add(jpfSenha);
		
		// Configurando o campo de texto jtfConfSenha.
		jtfConfSenha = new JPasswordField();
		jtfConfSenha.setBounds(25, 160, 170, 19);
		this.getContentPane().add(jtfConfSenha);
		
		// Configurando a combo boc jcbCategoria.
		jcbCategoria = 	new JComboBox<String>();
		jcbCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Funcionário", "Administrador"}));
		jcbCategoria.setBounds(25, 207, 170, 19);
		jcbCategoria.addItemListener(new Options());
		this.getContentPane().add(jcbCategoria);
		
		// Configurando a label lblCategoria.
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 13));
		lblCategoria.setBounds(25, 192, 138, 15);
		this.getContentPane().add(lblCategoria);
	}
	
	private class Options implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event){
			if (event.getStateChange() == ItemEvent.SELECTED) {
				switch (jcbCategoria.getSelectedIndex()) {
					case 0:
						userCateg = "Funcionário";
						break;
					case 1:
						userCateg = "Administrador";
						break;
				}
			}
		}
	}
}

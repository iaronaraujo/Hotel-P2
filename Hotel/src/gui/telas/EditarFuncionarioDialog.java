package gui.telas;

import gui.reusavel.Title;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Permite a modificação de informações a respeito dos funcionários,
 * incluindo a categoria, o nome e o e-mail.
 * 
 * @author WesleySilva
 *
 */
public class EditarFuncionarioDialog extends JDialog {
	private static final long serialVersionUID = 157896502101L;

	private JPanel contentPanel = new JPanel();
	private Title jpTitle = new Title("../../EditarFuncionário.png");
	private JButton btnSave;
	private JTextField jtfUsuario;
	private JTextField jtfEmail;
	private JLabel lblUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditarFuncionarioDialog dialog = new EditarFuncionarioDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditarFuncionarioDialog() {
		// Configurando o dialog.
		this.setTitle("RHM - Editar Funcionário");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 274);
		this.contentPanel.setLayout(new FlowLayout());
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		
		// Configurando o painel jpTitle;
		jpTitle = new Title("../../EditarFuncionário.png");
		jpTitle.setBounds(0, 0, 450, 45);
		this.getContentPane().add(jpTitle);
		getContentPane().setLayout(null);
		
		
		
		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblUsuario.setBounds(12, 69, 86, 15);
		getContentPane().add(lblUsuario);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(110, 67, 144, 19);
		jtfUsuario.setEditable(false);
		getContentPane().add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblCategoria.setBounds(12, 188, 86, 15);
		getContentPane().add(lblCategoria);
		
		JComboBox<String> jcbCategoria = new JComboBox<String>();
		jcbCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Funcionário"}));
		jcbCategoria.setBounds(110, 180, 144, 30);
		getContentPane().add(jcbCategoria);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblEmail.setBounds(12, 129, 86, 15);
		getContentPane().add(lblEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(110, 127, 144, 19);
		getContentPane().add(jtfEmail);
		
		btnSave = new JButton("");
		btnSave.setBounds(318, 97, 80, 80);
		btnSave.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnSave.setHorizontalTextPosition( SwingConstants.CENTER );
		btnSave.setIcon(new ImageIcon(getClass().getResource("../../save.png")));
		btnSave.setOpaque(false);
		btnSave.setContentAreaFilled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarFuncionarioDialog.this.dispose();
			}
		});
		getContentPane().add(btnSave);
	}
}

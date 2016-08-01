package gui.telas;

import gui.reusavel.Title;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;

import programa.documentos.DocumentFactory;

/**
 * Eh uma das visoes do painel "baralho" de TelaPrincipal.
 * Contem uma tabela de funcionarios e permite o registro
 * de um novo funcionario.
 * 
 * @author WesleySilva
 *
 */

public class FuncionariosPanel extends JPanel {
	private static final long serialVersionUID = 157896501901L;
	
	private final JPanel jpTitle;
	private final JPanel jpMenu;
	private final JPanel jpContent;
	private final JTable jtFuncionarios;
	private final JTextField jtfPesquisarFuncionario;
	private final JLabel lblPesquisarFuncionario;
	private final JButton btnNovoFuncionario;
	private NovoFuncionarioDialog novoFuncionarioDialog;
	
	public FuncionariosPanel(final TelaPrincipal telaPrincipal) {
		// Configurando o painel.
		this.setLayout(null);
		this.setOpaque(false);
		
		// Configurando o painel jpTitle.
		jpTitle = new Title("../../RegistrarFuncionarios.jpg");
		jpTitle.setBounds(0, 0, 800, 80);
		this.add(jpTitle);
		
		// Configurando o painel jpContent.
		jpContent = new JPanel();
		jpContent.setBounds(10, 202, 780, 386);
		jpContent.setLayout(null);
		jpContent.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.add(jpContent);
		
		// Configurando a tabela jtFuncionarios.
		jtFuncionarios = new JTable(new FuncionariosTableModel());
		jtFuncionarios.setBounds(12, 30, 756, 290);
		jtFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(1);
		jtFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(400);
		jpContent.add(jtFuncionarios);
		
		// Configurando o cabeçalho da tabela jtFuncionarios.getTableHeader().
		jtFuncionarios.getTableHeader().setBounds(12, 12, 756, 15);
		jpContent.add(jtFuncionarios.getTableHeader());
		
		
		// Configurando o campo de texto jtfPesquisarFuncionario.
		jtfPesquisarFuncionario = new JTextField();
		jtfPesquisarFuncionario.setBounds(12, 351, 204, 19);
		jtfPesquisarFuncionario.setDocument(DocumentFactory.createLengthedDocument(20));
		jpContent.add(jtfPesquisarFuncionario);
		
		// Configurando a label lblPesquisarFuncionario.
		lblPesquisarFuncionario = new JLabel("Pesquisar Funcionário:");
		lblPesquisarFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		lblPesquisarFuncionario.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblPesquisarFuncionario.setBounds(12, 332, 159, 15);
		jpContent.add(lblPesquisarFuncionario);
		
		// Configurando o botão btnNovoFuncionario.
		btnNovoFuncionario = new JButton("Novo Funcionário");
		btnNovoFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(FuncionariosPanel.this);
				novoFuncionarioDialog = new NovoFuncionarioDialog(parentFrame);
				novoFuncionarioDialog.setVisible(true);
			}
		});
		btnNovoFuncionario.setIcon(new ImageIcon(getClass().getResource("../../PlusButton.png")));
		btnNovoFuncionario.setBounds(563, 332, 205, 40);
		btnNovoFuncionario.setOpaque(false);
		btnNovoFuncionario.setContentAreaFilled(false);
		btnNovoFuncionario.setBorderPainted(false);
		jpContent.add(btnNovoFuncionario);
		
		
		// Configurando o painel jpMenu.
		jpMenu = new MenuPanel(telaPrincipal.jpPack);
		MenuPanel.btnRegistrarFuncionarios.setBackground(Color.RED);
		jpMenu.setBounds(0, 90, 800, 100);
		jpMenu.setLayout(null);
		this.add(jpMenu);
	}
	
	private class FuncionariosTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 157896502701L;
		
		private final String[] columnNames = {"Num", "Usuário", "Email", "Categoria"};
		private final Object[][] data = {{"1", "João", "joao@hotmail.com", "funcionário"}};

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		
		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		@Override
		public int getRowCount() {
			return data.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
		
		@Override
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
	}
}

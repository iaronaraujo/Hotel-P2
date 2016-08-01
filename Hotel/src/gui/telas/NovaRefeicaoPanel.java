package gui.telas;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Representa um painel que pode ser mostrado quando o usuario seleciona
 * refeicao na combo box do painel de adicionar servicos.
 * Contém o valor da refeicao a ser adicionada a conta.
 * 
 * @author WesleySilva
 *
 */
public class NovaRefeicaoPanel extends JPanel {
	private static final long serialVersionUID = 157896501201L;
	// TextFields
	private final JTextField jtfValorDaRefeicao;
	
	// Labels
	private final JLabel lblValorDaRefeicao;
	private final JLabel lblDescricao;
	
	// TextAreas
	private final JTextArea jtaDescricao;

	public NovaRefeicaoPanel() {
		// Configurando o painel.
		this.setLayout(null);
		
		// Configurando a área de texto jtaDescricao.
		jtaDescricao = new JTextArea();
		jtaDescricao.setBounds(12, 114, 402, 38);
		this.add(jtaDescricao);
		
		// Configurando a label lblDescricao. 
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(12, 97, 70, 15);
		lblDescricao.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(lblDescricao);
		
		// Configurando a label lblValorDaRefeicao.
		lblValorDaRefeicao = new JLabel("Valor da Refeição:");
		lblValorDaRefeicao.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblValorDaRefeicao.setBounds(12, 12, 130, 15);
		this.add(lblValorDaRefeicao);
		
		// Configurando a área de texto jtfValoDaRefeicao.
		jtfValorDaRefeicao = new JTextField();
		jtfValorDaRefeicao.setBounds(131, 10, 30, 19);
		jtfValorDaRefeicao.setColumns(10);
		this.add(jtfValorDaRefeicao);

	}
	
	public String getJtfValorDaRefeicao() {
		return jtfValorDaRefeicao.getText();
	}

	public String getJtaDescricao() {
		return jtaDescricao.getText();
	}
	
	public void setDescricao(String novaDescricao) {
		jtaDescricao.setText(novaDescricao);
	}
	
	public void setValorDaRefeicao(String novoValorDaRefeicao) {
		jtfValorDaRefeicao.setText(novoValorDaRefeicao);
	}
}

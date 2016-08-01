package gui.telas;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Representa um painel que pode ser mostrado quando o usuario seleciona
 * Babysitting na combo box do painel de adicionar servicos.
 * Contém a quantidade de horas normais e dobradas do servico de babysitting.
 * 
 * @author WesleySilva
 *
 */
public class NovoBabysittingPanel extends JPanel {
	private static final long serialVersionUID = 157896501001L;
	
	private final JTextField jtfHorasNormais;
	private final JTextField jtfHorasDobradas;
	private final JLabel lblHorasDobradas;
	private final JLabel lblDescricao;
	private final JTextArea jtaDescricao;
	private final JLabel lblHorasNormais;

	/**
	 * Create the panel.
	 */
	public NovoBabysittingPanel() {
		setLayout(null);
		
		lblHorasNormais = new JLabel("Horas Normais:");
		lblHorasNormais.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblHorasNormais.setBounds(22, 12, 98, 15);
		this.add(lblHorasNormais);
		
		jtaDescricao = new JTextArea();
		jtaDescricao.setBounds(12, 114, 402, 38);
		this.add(jtaDescricao);
		
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblDescricao.setBounds(12, 97, 70, 15);
		this.add(lblDescricao);
		
		jtfHorasNormais = new JTextField();
		jtfHorasNormais.setBounds(119, 10, 28, 19);
		this.add(jtfHorasNormais);
		
		lblHorasDobradas = new JLabel("Horas Dobradas:");
		lblHorasDobradas.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblHorasDobradas.setBounds(256, 12, 107, 15);
		this.add(lblHorasDobradas);
		
		jtfHorasDobradas = new JTextField();
		jtfHorasDobradas.setColumns(10);
		jtfHorasDobradas.setBounds(362, 10, 28, 19);
		this.add(jtfHorasDobradas);

	}
	
	public String getJtfHorasNormais() {
		return jtfHorasNormais.getText();
	}

	public String getJtfHorasDobradas() {
		return jtfHorasDobradas.getText();
	}

	public String getJtaDescricao() {
		return jtaDescricao.getText();
	}

	public void setJtfHorasNormais(String novoHorasNormais) {
		jtfHorasNormais.setText(novoHorasNormais);
	}

	public void setJtfHorasDobradas(String novoHorasDobradas) {
		jtfHorasDobradas.setText(novoHorasDobradas);
	}

	public void setJtaDescricao(String novaDescricao) {
		jtaDescricao.setText(novaDescricao);
	}

}

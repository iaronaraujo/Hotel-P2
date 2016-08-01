package gui.telas;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import logica.carros.Carro;
import logica.carros.CarroDeLuxo;
import logica.carros.CarroExecutivo;

/**
 * Representa um painel que pode ser mostrado quando o usuario seleciona
 * Aluguel de Carro na combo box do painel de adicionar servicos.
 * Contém o tipo do veiculo, se ele vira com tanque cheio e se tera 
 * seguro.
 * 
 * @author WesleySilva
 *
 */
public class NovoAluguelDeCarroPanel extends JPanel {
	private static final long serialVersionUID = 157896501101L;
	
	// Labels
	private final JLabel lblDescricao;
	private final JLabel lblTipo;
	
	// ComboBoxes
	private final JComboBox<String> jcbTipo;
	
	// CheckBoxes
	private final JCheckBox jkbTanqueCheio;
	private final JCheckBox jkbSeguro;
	
	// TextArea
	private final JTextArea jtaDescricao;
	
	// Array combobox
	String[] opcoes = new String[] {"Executivo", "Luxo"};
	
	public NovoAluguelDeCarroPanel() {
		// Configurando o painel.
		this.setLayout(null);
		
		// Configurando a combo box jcbTipo.
		jcbTipo = new JComboBox<String>();
		jcbTipo.setBounds(12, 29, 136, 24);
		jcbTipo.setModel(new DefaultComboBoxModel<String>(opcoes));
		this.add(jcbTipo);
		
		// Configurando a label lblTipo.
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblTipo.setBounds(12, 12, 70, 15);
		this.add(lblTipo);
		
		// Configurando a check box jkbTanqueCheio.
		jkbTanqueCheio = new JCheckBox("Tanque Cheio");
		jkbTanqueCheio.setBounds(289, 30, 129, 23);
		jkbTanqueCheio.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(jkbTanqueCheio);
		
		// Configurando a check box jkbSeguro.
		jkbSeguro = new JCheckBox("Seguro");
		jkbSeguro.setBounds(196, 30, 89, 23);
		jkbSeguro.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(jkbSeguro);
		
		// Configurando a área de texto jtaDescricao.
		jtaDescricao = new JTextArea();
		jtaDescricao.setBounds(12, 114, 402, 38);
		this.add(jtaDescricao);
		
		// Configurando a label lblDescricao.
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(12, 97, 70, 15);
		lblDescricao.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(lblDescricao);
		
	}
	
	public String getDescricao() {
		return jtaDescricao.getText();
	}
	
	public Carro getTipo() throws Exception {
		if (((String)jcbTipo.getSelectedItem()).equals("Executivo")) {
			Carro c = new CarroExecutivo("111111");
			return c;
		} else {
			Carro c2 = new CarroDeLuxo("11111");
			return c2;
		}
	}
	
	public boolean getSeguro() {
		return jkbSeguro.isSelected();
	}
	
	public boolean getTanqueCheio() {
		return jkbTanqueCheio.isSelected();
	}
	
	public void setTipo(String item) {
		jcbTipo.setSelectedItem(item);
	}
	
	public void setTanque(boolean selec) {
		jkbTanqueCheio.setSelected(selec);
	}
	
	public void setSeguro(boolean selec) {
		jkbSeguro.setSelected(selec);
	}
	
	public void setDescricao(String novaDescricao) {
		jtaDescricao.setText(novaDescricao);
	}
}

package gui.telas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Representa um painel que pode ser mostrado quando o usuario seleciona
 * um quarto que pode ter camas extras no painel de novo quarto.
 * Contém a quantidade de camas extras.
 * 
 * 
 * @author WesleySilva
 *
 */
public class QuartoExtensivelPanel extends JPanel {
	private static final long serialVersionUID = 157896500401L;
	
	private final JTextField jtfCamasExtras;
	private final JLabel lblCamasExtras;
	
	public QuartoExtensivelPanel() {
		setLayout(null);
		
		// Configurando o campo de texto jtfCamasExtras.
		jtfCamasExtras = new JTextField();
		jtfCamasExtras.setBounds(126, 0, 36, 19);
		jtfCamasExtras.setColumns(10);
		this.add(jtfCamasExtras);

		// Configurando a label lblCamasExtras.
		lblCamasExtras = new JLabel("Camas Extras:");
		lblCamasExtras.setBounds(12, 2, 100, 15);
		this.add(lblCamasExtras);	
	}
	
	public String getJtfCamasExtras() {
		return jtfCamasExtras.getText();
	}
	
	public void setCamasExtras(String novaCamasExtra) {
		jtfCamasExtras.setText(novaCamasExtra);
	}

}

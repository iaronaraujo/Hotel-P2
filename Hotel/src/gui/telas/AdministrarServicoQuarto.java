package gui.telas;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import programa.documentos.DocumentFactory;
import programa.documentos.DoubleLock;
import programa.documentos.IntegerLock;

/**
 * Representa um painel do "baralho" - de AdministrarServicosPanel - que
 * representa as informações de um tipo de quarto do hotel.
 * 
 * @author WesleySilva
 *
 */
public class AdministrarServicoQuarto extends JPanel {
	private static final long serialVersionUID = 157896502501L;
	
	// TextFields
	private JTextField jtfDiaria;
	private JTextField jtfQuantidade;
	
	// Labels
	private JLabel lblQuantidade;
	private JLabel lblDiaria;

	/**
	 * Create the panel.
	 */
	public AdministrarServicoQuarto() {
		// Configurando o painel.
		setLayout(null);
		
		// Configurando a label lblDiaria.
		lblDiaria = new JLabel("Diaria: R$");
		lblDiaria.setBounds(0, 31, 78, 15);
		lblDiaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaria.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(lblDiaria);
		
		// Configurando o campo de texto jtfDiaria.
		jtfDiaria = new JTextField();
		jtfDiaria.setBounds(84, 29, 113, 19);
		jtfDiaria.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		this.add(jtfDiaria);
		
		// Configurando a label lblQuantidade.
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(-120, 60, 198, 15);
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(lblQuantidade);
		
		// Configurando o campo de texto jtfQuantidade.
		jtfQuantidade = new JTextField();
		jtfQuantidade.setBounds(84, 58, 113, 19);
		jtfQuantidade.setDocument(DocumentFactory.createLengthedDocument(13, new IntegerLock()));
		this.add(jtfQuantidade);

	}

}

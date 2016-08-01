package gui.telas;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logica.quartos.tipos.Quarto;
import logica.quartos.tipos.QuartoExecutivoDuplo;
import logica.quartos.tipos.QuartoExecutivoSimples;
import logica.quartos.tipos.QuartoExecutivoTriplo;
import logica.quartos.tipos.QuartoLuxoDuplo;
import logica.quartos.tipos.QuartoLuxoSimples;
import logica.quartos.tipos.QuartoLuxoTriplo;
import logica.quartos.tipos.QuartoPresidencial;

/**
 * Representa um painel que pode ser mostrado quando o usuario seleciona
 * Quarto na combo box de NovoServicoDialog.
 * Contém a quantidade de camas extras, diárias e tipo de quarto.
 * 
 * 
 * @author WesleySilva
 *
 */
public class NovoQuartoPanel extends JPanel {
	private static final long serialVersionUID = 157896500601L;
	
	// Panels
	private final JPanel jpPackCamasExtras;
	private final QuartoExtensivelPanel jpQuartoExtensivel;
	
	// TextFields
	private final JTextField jtfQuantidadeDeDias;
	
	// TextAreas
	private final JTextArea jtaDescricao;
	
	// Labels
	private final JLabel lblQuantidadeDeDias;
	private final JLabel lblTipoDeQuarto;
	private final JLabel lblDescricao;
	
	// ComboBoxes
	private final JComboBox<String> jcbTipoDeQuarto;
	
	// Lista para a combobox
	String[] opcoesQuartos = new String[] {"Executivo Simples", "Luxo Simples", "Executivo Duplo",
	 										"Luxo Duplo", "Executivo Triplo", "Luxo Triplo",
	 										"Presidencial"};
	
	public NovoQuartoPanel() {
		// Configurando o painel.
		this.setLayout(null);
		
		// Configurando a label lblTipoDeQuarto.
		lblTipoDeQuarto = new JLabel("Tipos de Quartos:");
		lblTipoDeQuarto.setBounds(12, 12, 114, 15);
		lblTipoDeQuarto.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(lblTipoDeQuarto);
		
		// Configurando a área de texto jtaDescricao.
		jtaDescricao = new JTextArea();
		jtaDescricao.setBounds(12, 114, 402, 38);
		this.add(jtaDescricao);
		
		// Configurando a label lblDescricao.
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(12, 97, 70, 15);
		lblDescricao.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(lblDescricao);
		
		// Configurando a combo box jcbTipoDeQuarto.
		jcbTipoDeQuarto = new JComboBox<String>();
		jcbTipoDeQuarto.setBounds(12, 30, 162, 24);
		jcbTipoDeQuarto.setModel(new DefaultComboBoxModel<String>(opcoesQuartos));
		jcbTipoDeQuarto.addItemListener(new jcbTipoDeQuartoItemListener());
		this.add(jcbTipoDeQuarto);

		// Configurando a label lblQuantidadeDeDias.
		lblQuantidadeDeDias = new JLabel("Quantidade de Dias:");
		lblQuantidadeDeDias.setBounds(202, 12, 130, 15);
		lblQuantidadeDeDias.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		this.add(lblQuantidadeDeDias);
		
		// Configurando o campo de texto jtfQuantidadeDeDias.
		jtfQuantidadeDeDias = new JTextField();
		jtfQuantidadeDeDias.setBounds(329, 10, 30, 19);
		this.add(jtfQuantidadeDeDias);
		jtfQuantidadeDeDias.setColumns(10);
		
		// Configurando o painel jpPack CamasExtras.
		jpQuartoExtensivel = new QuartoExtensivelPanel();
		jpPackCamasExtras = new JPanel();
		jpPackCamasExtras.setLayout(new CardLayout(0, 0));
		jpPackCamasExtras.setBounds(202, 30, 156, 24);
		jpPackCamasExtras.add(jpQuartoExtensivel, "q");
		jpPackCamasExtras.add(new JPanel(), "null");
		this.add(jpPackCamasExtras);

	}
	
	public String getCamasExtras() {
		return jpQuartoExtensivel.getJtfCamasExtras();
	}

	public String getJtfQuantidadeDeDias() {
		return jtfQuantidadeDeDias.getText();
	}

	public String getJtaDescricao() {
		return jtaDescricao.getText();
	}
	
	public void setTipo(String item) {
		jcbTipoDeQuarto.setSelectedItem(item);
	}
	
	public void setDescricao(String novaDescricao) {
		jtaDescricao.setText(novaDescricao);
	}
	
	public void setQuantidadeDeDias(String novaQuantDias) {
		jtfQuantidadeDeDias.setText(novaQuantDias);
	}
	
	public void setCamasExtras(String novaCamasExtra) {
		jpQuartoExtensivel.setCamasExtras(novaCamasExtra);
	}
	
	public String getItem() {
		return (String) jcbTipoDeQuarto.getSelectedItem();
	}

	public Quarto getJcbTipoDeQuarto() {
		Quarto quartoExecSim = null;
		Quarto quartoLuxoSim = null;
		Quarto quartoExecDup = null;
		Quarto quartoLuxoDup = null;
		Quarto quartoExecTri = null;
		Quarto quartoLuxoTri = null;
		Quarto quartoPresidencial = null;
		
		if (((String)jcbTipoDeQuarto.getSelectedItem()).equals("Executivo Simples")) {
			try {
				quartoExecSim = new QuartoExecutivoSimples(Integer.parseInt(jpQuartoExtensivel.getJtfCamasExtras()));
				return quartoExecSim;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (((String)jcbTipoDeQuarto.getSelectedItem()).equals("Luxo Simples")) {
			try {
				quartoLuxoSim = new QuartoLuxoSimples(Integer.parseInt(jpQuartoExtensivel.getJtfCamasExtras()));
				return quartoLuxoSim;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (((String)jcbTipoDeQuarto.getSelectedItem()).equals("Executivo Duplo")) {
			try {
				quartoExecDup = new QuartoExecutivoDuplo(Integer.parseInt(jpQuartoExtensivel.getJtfCamasExtras()));
				return quartoExecDup;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (((String)jcbTipoDeQuarto.getSelectedItem()).equals("Luxo Duplo")){
			try {
				quartoLuxoDup = new QuartoLuxoDuplo(Integer.parseInt(jpQuartoExtensivel.getJtfCamasExtras()));
				return quartoLuxoDup;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (((String)jcbTipoDeQuarto.getSelectedItem()).equals("Executivo Triplo")) {
			try{
				quartoExecTri = new QuartoExecutivoTriplo();
				return quartoExecTri;
			} catch(Exception e){
				
			}
		} else if (((String)jcbTipoDeQuarto.getSelectedItem()).equals("Luxo Triplo")) {
			try {
			quartoLuxoTri = new QuartoLuxoTriplo();
			return quartoLuxoTri;
			} catch(Exception e){
				
			}
		} else if (((String)jcbTipoDeQuarto.getSelectedItem()).equals("Presidencial")) {
			try {
				quartoPresidencial = new QuartoPresidencial();
				return quartoPresidencial;
			} catch(Exception e){
				
			}
		}
		return quartoPresidencial; // so pra enganar o erro de compilacao, acho que eh isso
	}
	
	private class jcbTipoDeQuartoItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event){
			if (event.getStateChange() == ItemEvent.SELECTED) {
				CardLayout cardLayout = (CardLayout) jpPackCamasExtras.getLayout();
				System.out.println("foi2");
				switch(jcbTipoDeQuarto.getSelectedIndex()) {
			 		case 0:
			 			cardLayout.show(jpPackCamasExtras, "q");
			 			break;
			 		case 1:
			 			cardLayout.show(jpPackCamasExtras, "q");
			 			break;
			 		case 2:
			 			cardLayout.show(jpPackCamasExtras, "q");
			 			break;
			 		case 3:
			 			cardLayout.show(jpPackCamasExtras, "q");
			 			break;
			 		case 4:
			 			cardLayout.show(jpPackCamasExtras, "null");
			 		case 5:
			 			cardLayout.show(jpPackCamasExtras, "null");
			 			
			  		default:
			 			break;
				}
			}
		}
	}

}

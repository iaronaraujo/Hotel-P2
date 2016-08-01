package gui.telas;

import gui.reusavel.Title;

import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import logica.essenciais.Contrato;
import logica.servicos.AluguelDeCarro;
import logica.servicos.Babysitting;
import logica.servicos.DiariaQuarto;
import logica.servicos.Refeicao;
import logica.servicos.Servico;

/**
 * Abre um novo dialogo que sera utilizado para o usuario inserir
 * as informacoes de um novo servico. Um icone marca a finalizacao 
 * da entrada de dados e a adicao do servico (caso tudo tenha sido
 * corretamente preenchido).
 * 
 * @author WesleySilva
 *
 */
public class NovoServicoDialog extends JDialog {
	private static final long serialVersionUID = 157896500501L;
	
	// Panels
	private final NovoAluguelDeCarroPanel jpNovoAluguelDeCarro;
	private final NovoBabysittingPanel jpNovoBabysitting;
	private final JPanel contentPanel = new JPanel();
	private final NovaRefeicaoPanel jpNovaRefeicao;
	private final NovoQuartoPanel jpNovoQuarto;
	private final JPanel jpContent;
	private final JPanel jpTitle;
	
	// ComboBoxes
	private final JComboBox<String> jcbServicos;
	
	// Buttons
	private final JButton btnCriar;

	public NovoServicoDialog(final Contrato contrato) {
		// Configuração do dialog.
		this.setTitle("RHM - Novo Serviço");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 382);
		this.contentPanel.setLayout(new FlowLayout());
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// Configuração do painel jpTitle.
		jpTitle = new Title("../../NovoServico.png");
		jpTitle.setBounds(0, 0, 450, 45);
		this.getContentPane().add(jpTitle);
		this.getContentPane().setLayout(null);
		
		// Configurando "cartas".
		jpNovoAluguelDeCarro = new NovoAluguelDeCarroPanel();
		jpNovoBabysitting = new NovoBabysittingPanel();
		jpNovaRefeicao = new NovaRefeicaoPanel();
		jpNovoQuarto = new NovoQuartoPanel();
		
		
		// Configuração do painel jpContent.
		jpContent = new JPanel();
		jpContent.setBounds(12, 90, 426, 164);
		jpContent.setLayout(new CardLayout(0, 0));
		jpContent.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		jpContent.add(jpNovoAluguelDeCarro, "novo_aluguel_de_carro");
		jpContent.add(jpNovoBabysitting, "novo_babysitting");
		jpContent.add(jpNovaRefeicao, "nova_refeicao");
		jpContent.add(jpNovoQuarto, "novo_quarto");
		this.getContentPane().add(jpContent);
		
		// Configuração da combo box jcbServicos.
		jcbServicos = new JComboBox<String>();
		jcbServicos.setBounds(12, 63, 426, 24);
		jcbServicos.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jcbServicos.setModel(new DefaultComboBoxModel<String>(new String[] {"Aluguel De Carro", "Babysitting", "Quarto", "Refeição"}));
		jcbServicos.addItemListener(new jcbServicosItemListener());
		getContentPane().add(jcbServicos);
		
		// Configuração do botão btnCriar.
		btnCriar = new JButton("");
		btnCriar.setBounds(358, 266, 80, 80);
		btnCriar.setIcon(new ImageIcon(getClass().getResource("../../create.png")));
		btnCriar.setOpaque(false);
		btnCriar.setContentAreaFilled(false);
		btnCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Servico servicoAlugado = null;
					
					if (((String) jcbServicos.getSelectedItem()).equalsIgnoreCase("Aluguel de Carro")) {
						servicoAlugado = new AluguelDeCarro(jpNovoAluguelDeCarro.getTipo(), 254, jpNovoAluguelDeCarro.getTanqueCheio(), jpNovoAluguelDeCarro.getSeguro(), jpNovoAluguelDeCarro.getDescricao());
					} else if (((String) jcbServicos.getSelectedItem()).equals("Babysitting")) {
						//servicoAlugado = new Babysitting(Integer.parseInt(jpNovoBabysitting.getJtfHorasNormais()),  Integer.parseInt(jpNovoBabysitting.getJtfHorasDobradas()), jpNovoBabysitting.getJtaDescricao());
					} else if (((String) jcbServicos.getSelectedItem()).equals("Refeição")) {
						//servicoAlugado = new Refeicao(Double.parseDouble(jpNovaRefeicao.getJtfValorDaRefeicao()), jpNovaRefeicao.getJtaDescricao());
					} else if (((String) jcbServicos.getSelectedItem()).equals("Quarto")) {
						servicoAlugado = new DiariaQuarto(jpNovoQuarto.getJcbTipoDeQuarto(), Integer.parseInt(jpNovoQuarto.getJtfQuantidadeDeDias()), jpNovoQuarto.getJtaDescricao());
					}
					
					// Adiciona os servicos ao contrato
					System.out.println("Rodou");
					contrato.adicionaServico(servicoAlugado);
					ServicosPanel.jtmServicos.setData(contrato.getListaDeServicosContratados());
					//Grava Aqui
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				// Salvando no arquivo
				try {
					new FileOutputStream("hotel.ser").close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					UserProgram.saveFile = new ObjectOutputStream(new FileOutputStream("hotel.ser"));
					UserProgram.saveFileInput = new ObjectInputStream(new FileInputStream("hotel.ser"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					UserProgram.saveFile.writeObject(UserProgram.hotel);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					UserProgram.saveFile.close();
					UserProgram.saveFileInput.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		getContentPane().add(btnCriar);
	}
	
	private class jcbServicosItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event){
			if (event.getStateChange() == ItemEvent.SELECTED) {
				CardLayout cardLayout = (CardLayout) jpContent.getLayout();
				switch(jcbServicos.getSelectedIndex()) {
			 		case 0:
			 			cardLayout.show(jpContent, "novo_aluguel_de_carro");
			 			break;
			 		case 1:
			 			cardLayout.show(jpContent, "novo_babysitting");
			 			break;
			 		case 2:
			 			cardLayout.show(jpContent, "novo_quarto");
			 			break;
			 		case 3:
			 			cardLayout.show(jpContent, "nova_refeicao");
			 			break;
			  		default:
			 			break;
				}
			}
		}
	}
}

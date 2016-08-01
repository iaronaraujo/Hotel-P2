package gui.telas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import logica.carros.CarroDeLuxo;
import logica.carros.CarroExecutivo;
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
public class EditarServicoDialog extends JDialog {
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
	private JButton btnCriar;
	
	// Servico
	private final Servico servico;
	
	// Contrato
	private final Contrato contrato;

	public EditarServicoDialog(final Servico servico, final Contrato contrato) {
		// Configuração do dialog.
		this.setTitle("RHM - Editar Serviço");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 382);
		this.contentPanel.setLayout(new FlowLayout());
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.servico = servico;
		this.contrato = contrato;
		
		// Configuração do painel jpTitle.
		jpTitle = new Title("../../EditarServico.png");
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
		getContentPane().add(jcbServicos);
		
		// Checando card Layout
		CardLayout cardLayout = (CardLayout) jpContent.getLayout();
		if (servico instanceof AluguelDeCarro) {
			 cardLayout.show(jpContent, "novo_aluguel_de_carro");
			 jcbServicos.setModel(new DefaultComboBoxModel<String>(new String[] {"Aluguel De Carro"}));
			 jcbServicos.setEditable(false);
			 
			 // setando os valores
			 jpNovoAluguelDeCarro.setTipo(((AluguelDeCarro) servico).getTipo());
			 jpNovoAluguelDeCarro.setTanque(((AluguelDeCarro) servico).isTanqueCheio());
			 jpNovoAluguelDeCarro.setSeguro(((AluguelDeCarro) servico).temSeguro());
			 jpNovoAluguelDeCarro.setDescricao(servico.getDescricao());
		} else if (servico instanceof Babysitting) {
			 cardLayout.show(jpContent, "novo_babysitting");
			 jcbServicos.setModel(new DefaultComboBoxModel<String>(new String[] {"Babysitting"}));
			 jcbServicos.setEditable(false);
			 
			 // setando os valores
			 jpNovoBabysitting.setJtaDescricao(servico.getDescricao());
			 //jpNovoBabysitting.setJtfHorasDobradas((Integer.toString(((Babysitting) servico).getHorasEmValorDobrado())));
			 //jpNovoBabysitting.setJtfHorasNormais((Integer.toString(((Babysitting) servico).getHorasSolicitadas())));
		} else if (servico instanceof DiariaQuarto) {
			 cardLayout.show(jpContent, "novo_quarto");
			 jcbServicos.setModel(new DefaultComboBoxModel<String>(new String[] {"Quarto"}));
			 jcbServicos.setEditable(false);
			 
			 // setando os valores
			 jpNovoQuarto.setDescricao(servico.getDescricao());
			 //jpNovoQuarto.setQuantidadeDeDias(Integer.toString(((DiariaQuarto) servico).getQDeDias()));
			 jpNovoQuarto.setCamasExtras(Integer.toString(((DiariaQuarto) servico).getCamasExtras()));
			 jpNovoQuarto.setTipo(((DiariaQuarto) servico).getTipo());
		} else if (servico instanceof Refeicao) {
			 cardLayout.show(jpContent, "nova_refeicao");
			 jcbServicos.setModel(new DefaultComboBoxModel<String>(new String[] {"Refeição"}));
			 jcbServicos.setEditable(false);
			 
			 // setando os valores
			 jpNovaRefeicao.setDescricao(servico.getDescricao());
			 //jpNovaRefeicao.setValorDaRefeicao(Double.toString(((Refeicao) servico).getValorDaRefeicao()));
		}

		// Configurando o botão btnSave.
		JButton btnSave = new JButton("");
		btnSave.setBounds(358, 266, 80, 80);
		btnSave.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnSave.setHorizontalTextPosition( SwingConstants.CENTER );
		btnSave.setIcon(new ImageIcon(getClass().getResource("../../save.png")));
		btnSave.setOpaque(false);
		btnSave.setContentAreaFilled(false);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (servico instanceof AluguelDeCarro) {
					try {
						((AluguelDeCarro) servico).setDescricao(jpNovoAluguelDeCarro.getDescricao());
						((AluguelDeCarro) servico).setTanqueCheio(jpNovoAluguelDeCarro.getTanqueCheio());
						((AluguelDeCarro) servico).setTemSeguro(jpNovoAluguelDeCarro.getSeguro());
						if (jpNovoAluguelDeCarro.getClass().getName().equalsIgnoreCase("hotel.utilitarios.CarroDeLuxo")) {
							((AluguelDeCarro) servico).setCarroAlugado(new CarroDeLuxo("111111"));
						} else {
							((AluguelDeCarro) servico).setCarroAlugado(new CarroExecutivo("111111"));
						}
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (servico instanceof Babysitting) {
					try {
						((Babysitting) servico).setDescricao(jpNovoBabysitting.getJtaDescricao());
						//((Babysitting) servico).setHorasEmValorDobrado(Integer.parseInt(jpNovoBabysitting.getJtfHorasDobradas()));
						//((Babysitting) servico).setHorasSolicitadas(Integer.parseInt(jpNovoBabysitting.getJtfHorasNormais()));
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (servico instanceof Refeicao) {
					try {
						((Refeicao) servico).setDescricao(jpNovaRefeicao.getJtaDescricao());
						//((Refeicao) servico).setValorDaRefeicao(Double.parseDouble(jpNovaRefeicao.getJtfValorDaRefeicao()));
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				} else if (servico instanceof DiariaQuarto) {
					try {
						((DiariaQuarto) servico).setDescricao(jpNovoQuarto.getJtaDescricao());
						//((DiariaQuarto) servico).setQDeDias(Integer.parseInt(jpNovoQuarto.getJtfQuantidadeDeDias()));
						//((DiariaQuarto) servico).setQDeCamasExtras(jpNovoQuarto.getCamasExtras());
						((DiariaQuarto) servico).setTipo(jpNovoQuarto.getItem());
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				ServicosPanel.jtmServicos.setData(contrato.getListaDeServicosContratados());
				
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
		
		getContentPane().add(btnSave);
		
		// Configuração do botão btnRmvServico.
		JButton btnRmvServico = new JButton("Rmv Serviço");
		btnRmvServico.setBounds(230, 290, 143, 25);
		btnRmvServico.setForeground(new Color(51, 153, 0));
		btnRmvServico.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnRmvServico.setHorizontalTextPosition( SwingConstants.RIGHT );
		btnRmvServico.setIcon(new ImageIcon(getClass().getResource("../../rmv_service.png")));
		btnRmvServico.setOpaque(false);
		btnRmvServico.setContentAreaFilled(false);
		btnRmvServico.setBorderPainted(false);
		btnRmvServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contrato.getListaDeServicosContratados().remove(servico);
				
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
				
				ServicosPanel.jtmServicos.setData(contrato.getListaDeServicosContratados());
				
				dispose();
			}
		});
		this.add(btnRmvServico);
	}
	
	class Title extends JPanel{
		private static final long serialVersionUID = 157896500101L;
		private final Image image;
		
		public Title(String path) {
			this.image = new ImageIcon(getClass().getResource(path)).getImage();
		}
			
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}

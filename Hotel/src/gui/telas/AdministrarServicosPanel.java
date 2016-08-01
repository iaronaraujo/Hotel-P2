package gui.telas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import logica.utilitarios.GerenciadorDePrecos;
import programa.arquivos.CreateFile;
import programa.documentos.DocumentFactory;
import programa.documentos.DoubleLock;
import programa.documentos.IntegerLock;

/**
 * Gerencia as informações globais a respeito de preços de serviços e
 * informa dados valiosos parao hotel. A mudança no valor passarão a valer
 * a partir dos serviços criados após as alterações.
 * 
 * @author WesleySilva
 *
 */
public class AdministrarServicosPanel extends JPanel {
	private static final long serialVersionUID = 157896502401L;
	
	// Panels
	private final AdministrarServicoQuarto jpAsq0;
	private final AdministrarServicoQuarto jpAsq1;
	private final AdministrarServicoQuarto jpAsq2;
	private final AdministrarServicoQuarto jpAsq3;
	private final AdministrarServicoQuarto jpAsq4;
	private final AdministrarServicoQuarto jpAsq5;
	private final AdministrarServicoQuarto jpAsq6;
	private final JPanel jpBabysitting;
	private final JPanel jpRestaurante;
	private final JPanel jpEstrategia;
	private final JPanel jpExecutivo;
	private final MenuPanel jpMenu;
	private final JPanel jpContent;
	private final JPanel jpQuarto;
	private final Title jpTitle;
	private final JPanel jpPack;
	private final JPanel jpLuxo;
	
	// ComboBoxes
	private final JComboBox<String> jcbEstrategia;
	private final JComboBox<String> jcbQuartos;
	
	// TextFields
	private final JTextField jtfTanqueCheio2;
	private final JTextField jtfTanqueCheio;
	private final JTextField jtfQuantidade1;
	private final JTextField tjfQuantidade2;
	private final JTextField jtfHoraDobrada;
	private final JTextField jtfQuantidade3;
	private final JTextField jtfHoraNormal;
	private final JTextField jtfDiaria1;
	private final JTextField jtfSeguro1;
	private final JTextField jtfDiaria2;
	private final JTextField jtfSeguro2;
	private final JTextField jtfGarcom;
	private final JTextField jtfMusico;
	
	// Labels
	private final JLabel lblPorcentagemGarcom;
	private JLabel lblTanqueCheio1;
	private final JLabel lblPercDoMusico;
	private final JLabel lblTanqueCheio2;
	private final JLabel lblQuantidade1;
	private final JLabel lblHoraDobrada;
	private final JLabel lblQuantidade3;
	private final JLabel lblHoraNormal;
	private final JLabel lblSeguro1;
	private final JLabel lblDiaria1;	
	private final JLabel lblDiaria2;
	private final JLabel lblSeguro2;
	
	// Buttons
	private final JButton btnReport;
	private final JButton btnGraph;
	private final JButton btnSave;
	
	// JTextField mensagens default
	private final GerenciadorDePrecos gerencia = new GerenciadorDePrecos();
	
	// Arquivo
	private final CreateFile servicos = new CreateFile("servicos.ser");
	private final File arq = new File("servicos.ser");

	public AdministrarServicosPanel(final TelaPrincipal telaPrincipal) {
		/*
		// le do arquivo
		boolean temInfo;
		if (arq.length() == 0){
			temInfo = false;
		} else {
			gerencia = (GerenciadorDePrecos) servicos.read();
			temInfo = true;
		}
		*/
		// Configurando o painel.
		this.setLayout(null);
		this.setOpaque(false);
		
		// Configurando o painel do título.
		jpTitle = new Title();
		jpTitle.setBounds(0, 0, 800, 80);
		this.add(jpTitle);
		
		// Configurando o painel do menu.
		jpMenu = new MenuPanel(telaPrincipal.jpPack);
		jpMenu.setBounds(0, 90, 800, 100);
		jpMenu.setLayout(null);
		MenuPanel.btnAdministrarServicos.setBackground(Color.RED);
		this.add(jpMenu);
		
		jpAsq0 = new AdministrarServicoQuarto();
		jpAsq1 = new AdministrarServicoQuarto();
		jpAsq2 = new AdministrarServicoQuarto();
		jpAsq3 = new AdministrarServicoQuarto();
		jpAsq4 = new AdministrarServicoQuarto();
		jpAsq5 = new AdministrarServicoQuarto();
		jpAsq6 = new AdministrarServicoQuarto();
		
		// Configurando o painel de conteúdo.
		jpContent = new JPanel();
		jpContent.setBounds(10, 202, 780, 386);
		jpContent.setLayout(null);
		jpContent.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.add(jpContent);
		
		// Configurando o painel jpLuxo.
		jpLuxo = new JPanel();
		jpLuxo.setBounds(12, 97, 256, 146);
		jpLuxo.setLayout(null);
		jpLuxo.setBorder(new TitledBorder(new MatteBorder(3, 3, 1, 1, new Color(0, 0, 0)), "Carro de Luxo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 128)));
		jpContent.add(jpLuxo);
		
		// Configurando a label lblDiaria1.
		lblDiaria1 = new JLabel("Diária: R$");
		lblDiaria1.setBounds(0, 28, 123, 18);
		lblDiaria1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaria1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpLuxo.add(lblDiaria1);
		
		// Configurando o campo de texto jtfDiaria1.
		jtfDiaria1 = new JTextField();
		jtfDiaria1.setBounds(130, 28, 114, 19);
		jtfDiaria1.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		jpLuxo.add(jtfDiaria1);
		
		// Configurando o label lblTanqueCheio1.
		lblTanqueCheio1 = new JLabel("Tanque Cheio: R$");
		lblTanqueCheio1.setBounds(0, 58, 123, 18);
		lblTanqueCheio1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTanqueCheio1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpLuxo.add(lblTanqueCheio1);
		
		// Configurando o campo de texto jtfDiaria1.
		jtfTanqueCheio = new JTextField();
		jtfTanqueCheio.setBounds(130, 58, 114, 19);
		jtfTanqueCheio.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		jpLuxo.add(jtfTanqueCheio);
		
		// Configurando a label lblTanqueCheio1.
		lblTanqueCheio1 = new JLabel("Tanque Cheio: R$");
		lblTanqueCheio1.setBounds(0, 58, 123, 18);
		lblTanqueCheio1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTanqueCheio1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpLuxo.add(lblTanqueCheio1);
		
		// Configurando a label lblSeguro1.
		lblSeguro1 = new JLabel("Seguro: R$");
		lblSeguro1.setBounds(0, 89, 123, 18);
		lblSeguro1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeguro1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpLuxo.add(lblSeguro1);
		
		// Configurando o campo de texto jtfSeguro1.
		jtfSeguro1 = new JTextField();
		jtfSeguro1.setBounds(130, 89, 114, 19);
		jtfSeguro1.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		jpLuxo.add(jtfSeguro1);
		
		// Configurando a label lblQuantidade1.
		lblQuantidade1 = new JLabel("Quantidade:");
		lblQuantidade1.setBounds(0, 119, 123, 18);
		lblQuantidade1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpLuxo.add(lblQuantidade1);
		
		// Configurando o campo de texto jtfQuantidade1.
		jtfQuantidade1 = new JTextField();
		jtfQuantidade1.setBounds(130, 119, 114, 19);
		jtfQuantidade1.setDocument(DocumentFactory.createLengthedDocument(13, new IntegerLock()));
		jpLuxo.add(jtfQuantidade1);
		
		// Configurando o painel jpExecutivo.
		jpExecutivo = new JPanel();
		jpExecutivo.setBounds(12, 240, 256, 146);
		jpExecutivo.setLayout(null);
		jpExecutivo.setBorder(new TitledBorder(new MatteBorder(3, 3, 1, 1, new Color(0, 0, 0)), "Carro Executivo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 128)));
		jpContent.add(jpExecutivo);
		
		// Configurando a label lblDiaria2.
		lblDiaria2 = new JLabel("Diária: R$");
		lblDiaria2.setBounds(0, 28, 123, 18);
		lblDiaria2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaria2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpExecutivo.add(lblDiaria2);
		
		// Configurando o campo de texto jtfDiaria2.
		jtfDiaria2 = new JTextField();
		jtfDiaria2.setBounds(130, 28, 114, 19);
		jtfDiaria2.setColumns(10);
		jpExecutivo.add(jtfDiaria2);
		
		// Configurando o campo de texto jtfTanqueCheio2.
		jtfTanqueCheio2 = new JTextField();
		jtfTanqueCheio2.setBounds(130, 58, 114, 19);
		jtfTanqueCheio2.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		jpExecutivo.add(jtfTanqueCheio2);
		
		// Configurando a label lblTanqueCheio2.
		lblTanqueCheio2 = new JLabel("Tanque Cheio: R$");
		lblTanqueCheio2.setBounds(0, 58, 123, 18);
		lblTanqueCheio2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTanqueCheio2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpExecutivo.add(lblTanqueCheio2);
		
		// Configurando a label lblSeguro2.
		lblSeguro2 = new JLabel("Seguro: R$");
		lblSeguro2.setBounds(0, 89, 123, 18);
		lblSeguro2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeguro2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpExecutivo.add(lblSeguro2);
		
		// Configurando o campo de texto jtfSeguro2.
		jtfSeguro2 = new JTextField();
		jtfSeguro2.setBounds(130, 89, 114, 19);
		jtfSeguro2.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		jpExecutivo.add(jtfSeguro2);
		
		// Configurando a label lblQuantidade2.
		JLabel lblQuantidade2 = new JLabel("Quantidade:");
		lblQuantidade2.setBounds(0, 119, 123, 18);
		lblQuantidade2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpExecutivo.add(lblQuantidade2);
		
		// Configurando o campo de texto jtfQuantidade2.
		tjfQuantidade2 = new JTextField();
		tjfQuantidade2.setBounds(130, 119, 114, 19);
		tjfQuantidade2.setDocument(DocumentFactory.createLengthedDocument(3, new DoubleLock()));
		jpExecutivo.add(tjfQuantidade2);
		
		// Configurando o painel jpBabysitting.
		jpBabysitting = new JPanel();
		jpBabysitting.setBounds(290, 97, 256, 146);
		jpBabysitting.setLayout(null);
		jpBabysitting.setBorder(new TitledBorder(new MatteBorder(3, 3, 1, 1, new Color(0, 0, 0)), "Babysitting", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 128)));
		jpContent.add(jpBabysitting);
		
		// Configurando a label lblHoraNormal.
		lblHoraNormal = new JLabel("Hora Normal: R$");
		lblHoraNormal.setBounds(0, 28, 123, 18);
		lblHoraNormal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoraNormal.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpBabysitting.add(lblHoraNormal);
		
		// Configurando o campo de texto jtfHoraNormal.
		jtfHoraNormal = new JTextField();
		jtfHoraNormal.setBounds(130, 28, 114, 19);
		jtfHoraNormal.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		jpBabysitting.add(jtfHoraNormal);
		
		// Configurando o campo de texto jtfHoraDobrada.
		jtfHoraDobrada = new JTextField();
		jtfHoraDobrada.setBounds(130, 58, 114, 19);
		jtfHoraDobrada.setColumns(10);
		jpBabysitting.add(jtfHoraDobrada);
		
		// Configurando a label lblHoraDobrada.
		lblHoraDobrada = new JLabel("Hora Dobrada: R$");
		lblHoraDobrada.setBounds(0, 58, 123, 18);
		lblHoraDobrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoraDobrada.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpBabysitting.add(lblHoraDobrada);
		
		// Configurando a label lblQuantidade3.
		lblQuantidade3 = new JLabel("Quantidade:");
		lblQuantidade3.setBounds(0, 89, 123, 18);
		lblQuantidade3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpBabysitting.add(lblQuantidade3);
		
		// Configurando o campo de texto jtfQuantidade3.
		jtfQuantidade3 = new JTextField();
		jtfQuantidade3.setBounds(130, 89, 114, 19);
		jtfQuantidade3.setDocument(DocumentFactory.createLengthedDocument(13, new IntegerLock()));
		jpBabysitting.add(jtfQuantidade3);
		
		// Configurando o painel jpRestaurante.
		jpRestaurante = new JPanel();
		jpRestaurante.setBounds(290, 240, 256, 146);
		jpRestaurante.setLayout(null);
		jpRestaurante.setBorder(new TitledBorder(new MatteBorder(3, 3, 1, 1, new Color(0, 0, 0)), "Restaurante", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 128)));
		jpContent.add(jpRestaurante);
		
		// Configurando a label lblPorcentagemGarcom.
		lblPorcentagemGarcom = new JLabel("Perc. do Garçom:");
		lblPorcentagemGarcom.setBounds(0, 28, 123, 18);
		lblPorcentagemGarcom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPorcentagemGarcom.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpRestaurante.add(lblPorcentagemGarcom);
		
		// Configurando o campo de texto jtfGarcom.
		jtfGarcom = new JTextField();
		jtfGarcom.setBounds(130, 28, 114, 19);
		jtfGarcom.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		jpRestaurante.add(jtfGarcom);
		
		// Configurando o campo de texto jtfMusico.
		jtfMusico = new JTextField();
		jtfMusico.setBounds(130, 58, 114, 19);
		jtfMusico.setDocument(DocumentFactory.createLengthedDocument(13, new DoubleLock()));
		jpRestaurante.add(jtfMusico);
		
		// Configurando a label lblPeercDoMusico.
		lblPercDoMusico = new JLabel("Perc. do Músico:");
		lblPercDoMusico.setBounds(0, 58, 123, 18);
		lblPercDoMusico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPercDoMusico.setFont(new Font("Arial Black", Font.PLAIN, 12));
		jpRestaurante.add(lblPercDoMusico);
		
		// Configurando o painel jpQuarto.
		jpQuarto = new JPanel();
		jpQuarto.setLayout(null);
		jpQuarto.setBounds(548, 97, 220, 180);
		jpQuarto.setBorder(new TitledBorder(new MatteBorder(3, 3, 1, 1, new Color(0, 0, 0)), "Quarto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 128)));
		jpContent.add(jpQuarto);
		
		// Configurando o combo box jcbQuartos.
		jcbQuartos = new JComboBox<String>();
		jcbQuartos.setBounds(12, 23, 201, 24);
		jcbQuartos.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jcbQuartos.setModel(new DefaultComboBoxModel<String>(new String[] {"Executivo Simples", "Executivo Duplo", "Executivo Triplo",
																 "Luxo Simples", "Luxo Duplo", "Luxo Triplo", "Presidencial"}));
		jpQuarto.add(jcbQuartos);
	
		// Configurando o botão btnSave.
		btnSave = new JButton("");
		btnSave.setBounds(688, 12, 80, 80);
		btnSave.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnSave.setHorizontalTextPosition( SwingConstants.CENTER );
		btnSave.setIcon(new ImageIcon(getClass().getResource("../../save.png")));
		btnSave.setOpaque(false);
		btnSave.setContentAreaFilled(false);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String seguro1 = jtfSeguro1.getText();
				String diaria1 = jtfDiaria1.getText();
				String tanqueCheio1 = jtfTanqueCheio.getText();
				String quantidade1 = lblQuantidade1.getText();
				
				//gerencia.setPrecoDeSeguro(Double.parseDouble(seguro1));
				//gerencia.setPrecoDeDiariaCarroDeLuxo(Double.parseDouble(diaria1));
				//gerencia.setPrecoDeTanqueCheio(Double.parseDouble(tanqueCheio1));
				
				// PARTE DE SALVAR NO ARQUIVO
				
				try {
					new FileOutputStream("servicos.ser").close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				servicos.open();
				servicos.write(gerencia);
			}
		});
		jpContent.add(btnSave);
		
		// Configurando o botão btnGraph.
		btnGraph = new JButton("");
		btnGraph.setBounds(104, 12, 80, 80);
		btnGraph.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnGraph.setHorizontalTextPosition( SwingConstants.CENTER );
		btnGraph.setIcon(new ImageIcon(getClass().getResource("../../graphs.png")));
		btnGraph.setOpaque(false);
		btnGraph.setContentAreaFilled(false);
		jpContent.add(btnGraph);
		
		// Configurando o botão btnReport.
		btnReport = new JButton("");
		btnReport.setBounds(12, 12, 80, 80);
		btnReport.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnReport.setHorizontalTextPosition( SwingConstants.CENTER );
		btnReport.setIcon(new ImageIcon(getClass().getResource("../../report.png")));
		btnReport.setOpaque(false);
		btnReport.setContentAreaFilled(false);
		jpContent.add(btnReport);
		
		// Configurando o painel jpPack.
		jpPack = new JPanel();
		jpPack.setBounds(12, 59, 196, 108);
		jpPack.setLayout(new CardLayout(0, 0));
		jpPack.add(jpAsq0, "asq0");
		jpPack.add(jpAsq1, "asq1");
		jpPack.add(jpAsq2, "asq2");
		jpPack.add(jpAsq3, "asq3");
		jpPack.add(jpAsq4, "asq4");
		jpPack.add(jpAsq5, "asq5");
		jpPack.add(jpAsq6, "asq6");
		jcbQuartos.addItemListener(new jcbQuartosItemListener());
		jpQuarto.add(jpPack);
		
		// Configurando o painel jpEstrategia.
		jpEstrategia = new JPanel();
		jpEstrategia.setLayout(null);
		jpEstrategia.setBorder(new TitledBorder(new MatteBorder(3, 3, 1, 1, new Color(0, 0, 0)), "Estrat\u00E9gia", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 128)));
		jpEstrategia.setBounds(548, 303, 220, 83);
		jpContent.add(jpEstrategia);
		
		// Configurando a combo box jcbEstrategia.
		jcbEstrategia = new JComboBox();
		jcbEstrategia.setMaximumRowCount(2);
		jcbEstrategia.setModel(new DefaultComboBoxModel(new String[] {"Normal", "São João", "Natal e Revellion", "Baixa Estação"}));
		jcbEstrategia.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jcbEstrategia.setBounds(12, 22, 201, 24);
		jpEstrategia.add(jcbEstrategia);
		
		
	}
	
	private class Title extends JPanel {
		private final Image bg = new ImageIcon(getClass().getResource("../../AdministrarServicos.jpg")).getImage();
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	private class jcbQuartosItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event){
			if (event.getStateChange() == ItemEvent.SELECTED) {
				CardLayout cardLayout = (CardLayout) jpPack.getLayout();
				switch(jcbQuartos.getSelectedIndex()) {
			 		case 0:
			 			cardLayout.show(jpPack, "asq0");
			 			break;
			 		case 1:
			 			cardLayout.show(jpPack, "asq1");
			 			break;
			 		case 2:
			 			cardLayout.show(jpPack, "asq2");
			 			break;
			 		case 3:
			 			cardLayout.show(jpPack, "asq3");
			 			break;
			 		case 4:
			 			cardLayout.show(jpPack, "asq4");
			 			break;
			 		case 5:
			 			cardLayout.show(jpPack, "asq5");
			 			break;
			 		case 6:
			 			cardLayout.show(jpPack, "asq6");
			 			break;
			 		default:
			 			break;
				}
			}
		}
	}
}

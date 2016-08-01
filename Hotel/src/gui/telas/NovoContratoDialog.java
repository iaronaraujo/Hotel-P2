package gui.telas;

import gui.reusavel.InformationError;
import gui.reusavel.Title;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logica.clientes.HospedeRepresentante;
import logica.endereco.Endereco;
import logica.endereco.EnderecoApartamento;
import logica.endereco.EnderecoCasa;
import logica.essenciais.Contrato;
import logica.estrategias.SaoJoao;
import logica.quartos.tipos.QuartoExecutivoDuplo;
import logica.quartos.tipos.QuartoExecutivoSimples;
import logica.quartos.tipos.QuartoExecutivoTriplo;
import logica.quartos.tipos.QuartoLuxoDuplo;
import logica.quartos.tipos.QuartoLuxoSimples;
import logica.servicos.DiariaQuarto;
import logica.servicos.Servico;
import programa.arquivos.FileFactory;
import programa.documentos.DocumentFactory;
import programa.documentos.IntegerLock;
import programa.formatos.FormatFactory;

/**
 * Abre um novo dialogo que sera utilizado para o usuario inserir
 * as informacoes do contrato (incluindo as do contratante que sera
 * colocado na lista de hospedes). Um icone marca a finalizacao da
 * entrada de dados e a criacao do contrato (caso tudo tenha sido
 * corretamente preenchido).
 * 
 * @author WesleySilva
 *
 */
public class NovoContratoDialog extends JDialog {
	private static final long serialVersionUID = 157896500901L;
	
	// Panels
	private final JPanel contentPanel = new JPanel();
	private final JPanel jpInformation;
	private final JPanel jpContrator;
	private final JPanel jpTitle;
	
	// TextFields
	private final JFormattedTextField jftNascimento;
	private final JFormattedTextField jftCheckOut;
	private final JFormattedTextField jftCheckIn;
	private final JFormattedTextField jftCpf;
	private final JTextField jtfCamasExtras;
	private final JTextField jtfNumero;
	private final JTextField jtfCidade;
	private final JTextField jtfCartao;
	private final JTextField jtfNome;
	private final JTextField jtfRua;
	
	// ComboBoxes
	private final JComboBox jcbResidencia;
	private final JComboBox jcbQuarto;
	private final JComboBox jcbPais;
	
	// Labels
	private final JLabel lblDataDeNascimento;
	private final JLabel lblTipoDeResidncia;
	private final JLabel lblQuantDeCamas;
	private final JLabel lblDataCheckOut;
	private final JLabel lblDataCheckIn;
	private final JLabel lblNumero;
	private final JLabel lblBairro;
	private final JLabel lblQuarto;
	private final JLabel lblCartao;
	private final JLabel lblCidade;
	private final JLabel lblNome;
	private final JLabel lblPas;
	private final JLabel lblCpf;
	
	// Buttons
	private final JButton btnCriar;
	
	// Colors
	private final Color clrBtnCriar;
	private final JLabel lblNumeroDoApt;
	private final JTextField jtfNumApt;

	public NovoContratoDialog(final JFrame parentFrame) {
		// Configurando o dialog.
		super(parentFrame);
		
		this.setTitle("RHM - Novo Contrato");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 440, 534);
		this.contentPanel.setLayout(new FlowLayout());
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		// Configurando o painel jpTitle.
		jpTitle = new Title("../../NovoContrato.png");
		jpTitle.setBounds(0, 0, 450, 45);
		this.getContentPane().add(jpTitle);
		
		// Configurando o painel jpInformation.
		jpInformation = new JPanel();
		jpInformation.setBounds(12, 77, 428, 98);
		jpInformation.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		this.getContentPane().add(jpInformation);
		jpInformation.setLayout(null);
		
		// Configurando a label lblDataCheckIn.
		lblDataCheckIn = new JLabel("Data Check In:");
		lblDataCheckIn.setBounds(9, 12, 114, 15);
		lblDataCheckIn.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpInformation.add(lblDataCheckIn);
		
		// Configurando o campo de texto jftCheckIn.
		jftCheckIn = new JFormattedTextField(FormatFactory.createDateFactory());
		jftCheckIn.setBounds(9, 27, 114, 19);
		jpInformation.add(jftCheckIn);
		
		// Configurando o campo de texto jftCheckOut.
		jftCheckOut = new JFormattedTextField(FormatFactory.createDateFactory());
		jftCheckOut.setBounds(9, 72, 114, 19);
		jpInformation.add(jftCheckOut);
		
		// Configurando a label lblDataCheckOut.
		lblDataCheckOut = new JLabel("Data Check Out:");
		lblDataCheckOut.setBounds(9, 58, 125, 15);
		lblDataCheckOut.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpInformation.add(lblDataCheckOut);
		
		// Configurando o botão btnCriar.
		btnCriar = new JButton("");
		btnCriar.setBounds(320, 12, 80, 80);
		btnCriar.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnCriar.setHorizontalTextPosition( SwingConstants.CENTER );
		clrBtnCriar = btnCriar.getBackground();
		btnCriar.setToolTipText("Adicionar Contrato");
		btnCriar.setIcon(new ImageIcon(getClass().getResource("../../create.png")));
		btnCriar.setBorder(BorderFactory.createRaisedBevelBorder());
		btnCriar.setOpaque(false);
		btnCriar.setContentAreaFilled(false);
		btnCriar.setBorderPainted(true);
		btnCriar.getModel().addChangeListener(new BtnCriarChangeListener());
		btnCriar.addActionListener(new BtnCriarActionListener());
		btnCriar.setForeground(Color.WHITE);
		jpInformation.add(btnCriar);
		
		// Configurando a label lblQuarto.
		lblQuarto = new JLabel("Quarto:");
		lblQuarto.setBounds(135, 12, 120, 15);
		lblQuarto.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpInformation.add(lblQuarto);
		
		// Configurando a combo box jcbQuarto.
		jcbQuarto = new JComboBox(new String[] {"Executivo Simples", "Executivo Duplo", "Executivo Triplo",
				 "Luxo Simples", "Luxo Duplo", "Luxo Triplo", "Presidencial"});
		jcbQuarto.setBounds(135, 27, 155, 24);
		jcbQuarto.addItemListener(new jcbQuartoItemListener());
		jpInformation.add(jcbQuarto);
		
		// Configurando a label lblQuantDeCamas.
		lblQuantDeCamas = new JLabel("Quant. De  Camas Extras:");
		lblQuantDeCamas.setBounds(135, 58, 135, 15);
		lblQuantDeCamas.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 10));
		jpInformation.add(lblQuantDeCamas);
		
		// Configurando o campo de texto jtfCamasExtras.
		jtfCamasExtras = new JTextField();
		jtfCamasExtras.setBounds(135, 72, 27, 19);
		jtfCamasExtras.setDocument(DocumentFactory.createLengthedDocument(1, new IntegerLock()));
		jpInformation.add(jtfCamasExtras);
		
		// Configurando o painel jpContrator.
		jpContrator = new JPanel();
		jpContrator.setBounds(12, 212, 426, 282);
		jpContrator.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(jpContrator);
		jpContrator.setLayout(null);
		
		// Configurando o campo de texto jtfNome.
		jtfNome = new JTextField();
		jtfNome.setBounds(12, 26, 180, 19);
		jtfNome.setColumns(10);
		jpContrator.add(jtfNome);
		
		// Configurando a label lblNome.
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 11, 114, 15);
		lblNome.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblNome);
		
		// Configurando a label lblCpf.
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 57, 114, 15);
		lblCpf.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblCpf);
		
		// Configurando o campo de texto jftCpf.
		jftCpf = new JFormattedTextField(FormatFactory.createMaskFormatter("###.###.###-##"));
		jftCpf.setBounds(12, 72, 180, 19);
		jpContrator.add(jftCpf);
		
		// Configurando a label lblDataDeNascimento.
		lblDataDeNascimento = new JLabel("Data De Nascimento:");
		lblDataDeNascimento.setBounds(234, 11, 169, 15);
		lblDataDeNascimento.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblDataDeNascimento);
		
		// Configurando o campo de texto jtfNascimento.
		jftNascimento = new JFormattedTextField(FormatFactory.createDateFactory());
		jftNascimento.setBounds(234, 26, 180, 19);
		jpContrator.add(jftNascimento);
		
		// Configurando a check box jcbPais.
		jcbPais = new JComboBox<String>();
		jcbPais.setMaximumRowCount(7);
		jcbPais.setModel(new DefaultComboBoxModel(new String[] {"Afganistán ", "Akrotiri ", "Albania ", "Alemania ", "Andorra ", "Angola ", "Anguila ", "Antártida ", "Antigua y Barbuda ", "Antillas Neerlandesas ", "Arabia Saudí ", "Arctic Ocean ", "Argelia ", "Argentina ", "Armenia ", "Aruba ", "Ashmore andCartier Islands ", "Atlantic Ocean ", "Australia ", "Austria ", "Azerbaiyán ", "Bahamas ", "Bahráin ", "Bangladesh ", "Barbados ", "Bélgica ", "Belice ", "Benín ", "Bermudas ", "Bielorrusia ", "Birmania Myanmar ", "Bolivia ", "Bosnia y Hercegovina ", "Botsuana ", "Brasil ", "Brunéi ", "Bulgaria ", "Burkina Faso ", "Burundi ", "Bután ", "Cabo Verde ", "Camboya ", "Camerún ", "Canadá ", "Chad ", "Chile ", "China ", "Chipre ", "Clipperton Island ", "Colombia ", "Comoras ", "Congo ", "Coral Sea Islands ", "Corea del Norte ", "Corea del Sur ", "Costa de Marfil ", "Costa Rica ", "Croacia ", "Cuba ", "Dhekelia ", "Dinamarca ", "Dominica ", "Ecuador ", "Egipto ", "El Salvador ", "El Vaticano ", "Emiratos Árabes Unidos ", "Eritrea ", "Eslovaquia ", "Eslovenia ", "España ", "Estados Unidos ", "Estonia ", "Etiopía ", "Filipinas ", "Finlandia ", "Fiyi ", "Francia ", "Gabón ", "Gambia ", "Gaza Strip ", "Georgia ", "Ghana ", "Gibraltar ", "Granada ", "Grecia ", "Groenlandia ", "Guam ", "Guatemala ", "Guernsey ", "Guinea ", "Guinea Ecuatorial ", "Guinea-Bissau ", "Guyana ", "Haití ", "Honduras ", "Hong Kong ", "Hungría ", "India ", "Indian Ocean ", "Indonesia ", "Irán ", "Iraq ", "Irlanda ", "Isla Bouvet ", "Isla Christmas ", "Isla Norfolk ", "Islandia ", "Islas Caimán ", "Islas Cocos ", "Islas Cook ", "Islas Feroe ", "Islas Georgia del Sur y Sandwich del Sur ", "Islas Heard y McDonald ", "Islas Malvinas ", "Islas Marianas del Norte ", "IslasMarshall ", "Islas Pitcairn ", "Islas Salomón ", "Islas Turcas y Caicos ", "Islas Vírgenes Americanas ", "Islas Vírgenes Británicas ", "Israel ", "Italia ", "Jamaica ", "Jan Mayen ", "Japón ", "Jersey ", "Jordania ", "Kazajistán ", "Kenia ", "Kirguizistán ", "Kiribati ", "Kuwait ", "Laos ", "Lesoto ", "Letonia ", "Líbano ", "Liberia ", "Libia ", "Liechtenstein ", "Lituania ", "Luxemburgo ", "Macao ", "Macedonia ", "Madagascar ", "Malasia ", "Malaui ", "Maldivas ", "Malí ", "Malta ", "Man, Isle of ", "Marruecos ", "Mauricio ", "Mauritania ", "Mayotte ", "México ", "Micronesia ", "Moldavia ", "Mónaco ", "Mongolia ", "Montserrat ", "Mozambique ", "Namibia ", "Nauru ", "Navassa Island ", "Nepal ", "Nicaragua ", "Níger ", "Nigeria ", "Niue ", "Noruega ", "Nueva Caledonia ", "Nueva Zelanda ", "Omán ", "Pacific Ocean ", "Países Bajos ", "Pakistán ", "Palaos ", "Panamá ", "Papúa-Nueva Guinea ", "Paracel Islands ", "Paraguay ", "Perú ", "Polinesia Francesa ", "Polonia ", "Portugal ", "Puerto Rico ", "Qatar ", "Reino Unido ", "República Centroafricana ", "República Checa ", "República Democrática del Congo ", "República Dominicana ", "Ruanda ", "Rumania ", "Rusia ", "Sáhara Occidental ", "Samoa ", "Samoa Americana ", "San Cristóbal y Nieves ", "San Marino ", "San Pedro y Miquelón ", "San Vicente y las Granadinas ", "Santa Helena ", "Santa Lucía ", "Santo Tomé y Príncipe ", "Senegal ", "Seychelles ", "Sierra Leona ", "Singapur ", "Siria ", "Somalia ", "Southern Ocean ", "Spratly Islands ", "Sri Lanka ", "Suazilandia ", "Sudáfrica ", "Sudán ", "Suecia ", "Suiza ", "Surinam ", "Svalbard y Jan Mayen ", "Tailandia ", "Taiwán ", "Tanzania ", "Tayikistán ", "TerritorioBritánicodel Océano Indico ", "Territorios Australes Franceses ", "Timor Oriental ", "Togo ", "Tokelau ", "Tonga ", "Trinidad y Tobago ", "Túnez ", "Turkmenistán ", "Turquía ", "Tuvalu ", "Ucrania ", "Uganda ", "Unión Europea ", "Uruguay ", "Uzbekistán ", "Vanuatu ", "Venezuela ", "Vietnam ", "Wake Island ", "Wallis y Futuna ", "West Bank ", "World ", "Yemen ", "Yibuti ", "Zambia ", "Zimbabue "}));
		jcbPais.setBounds(12, 119, 180, 24);
		
		jpContrator.add(jcbPais);
		
		// Configurando a label lblPais.
		lblPas = new JLabel("País:");
		lblPas.setBounds(12, 104, 114, 15);
		lblPas.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblPas);
		
		// Configurando a label lblCidade.
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(234, 57, 169, 15);
		lblCidade.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblCidade);
		
		// Configurando o campo de texto jtfCidade.
		jtfCidade = new JTextField();
		jtfCidade.setBounds(234, 72, 180, 19);
		jtfCidade.setColumns(10);
		jpContrator.add(jtfCidade);
		
		// Configurando a label lblBairro.
		lblBairro = new JLabel("Rua:");
		lblBairro.setBounds(234, 109, 169, 15);
		lblBairro.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblBairro);
		
		// Configurando o campo de texto jtfRua.
		jtfRua = new JTextField();
		jtfRua.setBounds(234, 124, 180, 19);
		jtfRua.setColumns(10);
		jpContrator.add(jtfRua);
		
		// Configurando a label lblNumero.
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(234, 168, 169, 15);
		lblNumero.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblNumero);
		
		// Configurando o campo de texto jtfNumero.
		jtfNumero = new JTextField();
		jtfNumero.setDocument(DocumentFactory.createLengthedDocument(5, new IntegerLock()));
		jtfNumero.setBounds(234, 183, 180, 19);
		jtfNumero.setColumns(10);
		jpContrator.add(jtfNumero);
		
		// Configurando a label lblTipoDeResidencia.
		lblTipoDeResidncia = new JLabel("Tipo de Residência:");
		lblTipoDeResidncia.setBounds(12, 163, 143, 15);
		lblTipoDeResidncia.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblTipoDeResidncia);
		
		// Configurando o combo box jcbResidencia.
		jcbResidencia = new JComboBox<String>();
		jcbResidencia.setModel(new DefaultComboBoxModel(new String[] {"Casa", "Apartamento"}));
		jcbResidencia.setBounds(12, 178, 180, 24);
		jcbResidencia.addItemListener(new jcbResidenciaItemListener());
		jpContrator.add(jcbResidencia);
		
		// Configurando a label lblCartao.
		lblCartao = new JLabel("Número do Cartão:");
		lblCartao.setBounds(234, 214, 169, 15);
		lblCartao.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpContrator.add(lblCartao);
		
		// Configurando o campo de texto jtfCartao.
		jtfCartao = new JTextField();
		jtfCartao.setBounds(234, 229, 180, 19);
		jtfCartao.setDocument(DocumentFactory.createLengthedDocument(20, new IntegerLock()));
		jpContrator.add(jtfCartao);
		
		lblNumeroDoApt = new JLabel("Número do Apt.:");
		lblNumeroDoApt.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblNumeroDoApt.setBounds(12, 214, 143, 15);
		
		jtfNumApt = new JTextField();
		jtfNumApt.setColumns(10);
		jtfNumApt.setBounds(12, 229, 180, 19);
		jtfNumApt.setDocument(DocumentFactory.createLengthedDocument(5, new IntegerLock()));
	}
	
	private class jcbQuartoItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event){
			if (event.getStateChange() == ItemEvent.SELECTED) {
				switch(jcbQuarto.getSelectedIndex()) {
			 		case 0:
			 			jpInformation.add(jtfCamasExtras);
			 			jpInformation.add(lblQuantDeCamas);
			 			break;
			 		case 1:
			 			jpInformation.add(jtfCamasExtras);
			 			jpInformation.add(lblQuantDeCamas);
			 			break;
			 		case 2:
			 			jpInformation.remove(jtfCamasExtras);
			 			jpInformation.remove(lblQuantDeCamas);
			 			break;
			 		case 3:
			 			jpInformation.add(jtfCamasExtras);
			 			jpInformation.add(lblQuantDeCamas);
			 			break;
			 		case 4:
			 			jpInformation.add(jtfCamasExtras);
			 			jpInformation.add(lblQuantDeCamas);
			 			break;
			 		case 5:
			 			jpInformation.remove(jtfCamasExtras);
			 			jpInformation.remove(lblQuantDeCamas);
			 			break;
			 		case 6:
			 			jpInformation.remove(jtfCamasExtras);
			 			jpInformation.remove(lblQuantDeCamas);
			 			break;
			  		default:
			 			break;
				}
			}
		}
	}
	
	private class jcbResidenciaItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event){
			if (event.getStateChange() == ItemEvent.SELECTED) {
				switch(jcbResidencia.getSelectedIndex()) {
			 		case 0:
			 			jpContrator.remove(lblNumeroDoApt);
			 			jpContrator.remove(jtfNumApt);
			 			break;
			 		case 1:
			 			jpContrator.add(lblNumeroDoApt);
			 			jpContrator.add(jtfNumApt);
			 			break;
				}
			}
		}
	}
	
	private class BtnCriarChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent event) {
			ButtonModel closeModel = (ButtonModel) event.getSource();
			
			if (closeModel.isPressed() || closeModel.isRollover()) {
				if (closeModel.isRollover()){
					btnCriar.setBorder(BorderFactory.createRaisedBevelBorder());
					btnCriar.setBackground(new Color(100, 150, 100));
				}
				if (closeModel.isPressed()){
					btnCriar.setBorder(BorderFactory.createLoweredBevelBorder());
				}
			} else {
				btnCriar.setBorder(BorderFactory.createRaisedBevelBorder());
				btnCriar.setBackground(clrBtnCriar);
			}
		}
	}
	
	private class BtnCriarActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {				
				UserProgram.hotel.checkIn(getContrato());
				System.out.println(GerenciarContratosPanel.jtmContratos);
				GerenciarContratosPanel.jtmContratos.setData(UserProgram.hotel.getContratos());
				FileFactory.saveHotel(UserProgram.hotel, "hotel.ser");
				dispose();
			} catch(Exception exception) {
				exception.printStackTrace();
				InformationError.createDialog(jpInformation.getParent(), "Error ao criar o contrato, verifique se as informações são válidas.");
			}
		}
		
		private HospedeRepresentante getContratante() throws Exception {
			return new HospedeRepresentante(getNome(), getData((String) jftNascimento.getValue()), getCpf(), getEndereco());
		}
		
		private String getCpf() {
			return (String) jftCpf.getValue();
		}
		
		private Contrato getContrato() throws Exception {
			String checkin = (String) jftCheckIn.getValue();
			String checkout = (String) jftCheckOut.getValue();
			String numCartao = jtfCartao.getText();
			
			return new Contrato(getContratante(), getData(checkin), getData(checkout), new SaoJoao(), numCartao, (ArrayList<Servico>) UserProgram.hotel.getServicosOferecidos(), getAluguel(checkin, checkout));
		}
		
		private DiariaQuarto getAluguel(String checkin, String checkout) throws Exception {
			String selectedItem = (String) jcbQuarto.getSelectedItem();
			int qCamasExtras = Integer.parseInt(jtfCamasExtras.getText());
			int qDeDias = FormatFactory.calendarToDays(getData(checkin), getData(checkout));
			
			if (selectedItem.equalsIgnoreCase("executivo simples")) {
				return new DiariaQuarto(new QuartoExecutivoSimples(qCamasExtras), qDeDias, "Quarto Executivo Simples");
			}
			
			if (selectedItem.equalsIgnoreCase("executivo duplo")) {
				return new DiariaQuarto(new QuartoExecutivoDuplo(qCamasExtras), qDeDias, "Quarto Executivo Duplo");
			}
			
			if (selectedItem.equalsIgnoreCase("executivo triplo")) {
				return new DiariaQuarto(new QuartoExecutivoTriplo(), qDeDias, "Quarto Executivo Triplo");
			}
			
			if (selectedItem.equalsIgnoreCase("luxo simples")) {
				return new DiariaQuarto(new QuartoLuxoSimples(qCamasExtras), qDeDias, "Quarto Luxo Simples");
			}
			
			if (selectedItem.equalsIgnoreCase("luxo duplo")) {
				return new DiariaQuarto(new QuartoLuxoDuplo(qCamasExtras), qDeDias, "Quarto Luxo Duplo");
			}
			
			if (selectedItem.equalsIgnoreCase("luxo triplo")) {
				return new DiariaQuarto(new QuartoExecutivoTriplo(), qDeDias, "Quarto Luxo Triplo");
			}
			
			return new DiariaQuarto(new QuartoExecutivoDuplo(qCamasExtras), qDeDias, "Quarto Presidencial");
		}
		
		private String getNome() {
			return jtfNome.getText();
		}
		
		private GregorianCalendar getData(String texto) throws ParseException{
			return FormatFactory.stringToGregorianCalendar(texto);
		}
					
		private Endereco getEndereco() throws Exception { // REVER
			String pais = (String) jcbPais.getSelectedItem(), cidade = jtfCidade.getText(), rua = jtfRua.getText();
			int numero = Integer.parseInt(jtfNumero.getText());
			return (jcbResidencia.getSelectedIndex() == 1) ? (new EnderecoApartamento(pais, cidade, "Alto Branco", rua, numero, jtfNumApt.getText())) : (new EnderecoCasa(pais, cidade, "Alto Branco",rua, numero));
		}
	}
}

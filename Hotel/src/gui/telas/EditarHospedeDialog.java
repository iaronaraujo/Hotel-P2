package gui.telas;

import gui.reusavel.InformationError;
import gui.reusavel.Title;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import logica.clientes.Hospede;
import logica.clientes.HospedeRepresentante;
import logica.endereco.Endereco;
import logica.endereco.EnderecoCasa;
import logica.essenciais.Contrato;
import programa.arquivos.FileFactory;
import programa.formatos.FormatFactory;

public class EditarHospedeDialog extends JDialog {
	private static final long serialVersionUID = 157896502001L;

	private final JPanel contentPanel = new JPanel();
	private final JTextField jtfNome;
	private final JFormattedTextField jftNascimento;
	private final JLabel lblNome;
	private final JLabel lblNascimento;
	private final JPanel jpPersonalInfo;
	private final JTextField jtfCidade;
	private final JTextField jtfRua;
	private final JComboBox<String> jcbPais;
	private final JLabel lblPais;
	private final Title jpTitle;
	private final JFormattedTextField jftCpf;
	private final JLabel lblCpf;
	private final JLabel lblCidade;
	private final JLabel lblRua;
	private final JTextField jtfNumero;
	
	Hospede hospede;
	Contrato contrato;
	Endereco endereco;

	public EditarHospedeDialog(final Hospede hospede, final Contrato contrato) {
		this.hospede = hospede;
		this.contrato = contrato;
		
		setBounds(100, 100, 450, 392);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		jpTitle = new Title("../../EditarHospede.png");
		jpTitle.setBounds(0, 0, 450, 45);
		this.getContentPane().add(jpTitle);
		jpPersonalInfo = new JPanel();
		jpPersonalInfo.setBounds(12, 60, 426, 274);
		jpPersonalInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.getContentPane().add(jpPersonalInfo);
		jpPersonalInfo.setLayout(null);
		
		// Configurando o campo de texto jtfNome.
		jtfNome = new JTextField();
		jtfNome.setBounds(12, 28, 166, 19);
		jpPersonalInfo.add(jtfNome);
		jtfNome.setColumns(10);
				
		// Configurando a label lblNome.
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 70, 15);
		lblNome.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpPersonalInfo.add(lblNome);
			
		// Configurando a label lblCpf.
		lblNascimento = new JLabel("Data de Nascimento:");
		lblNascimento.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblNascimento.setBounds(12, 59, 141, 15);
		jpPersonalInfo.add(lblNascimento);
		
		// Configurando o campo de texto jtfDataDeNascimento.
		jftNascimento = new JFormattedTextField(FormatFactory.createDateFactory());
		jftNascimento.setBounds(12, 75, 166, 19);
		jftNascimento.setColumns(10);
		jpPersonalInfo.add(jftNascimento);
			
		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblCpf.setBounds(12, 105, 141, 15);
		jpPersonalInfo.add(lblCpf);
		
		jftCpf = new JFormattedTextField(FormatFactory.createMaskFormatter("###.###.###-##"));
		jftCpf.setBounds(12, 122, 166, 19);
		jpPersonalInfo.add(jftCpf);
				
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblCidade.setBounds(12, 153, 70, 15);
		jpPersonalInfo.add(lblCidade);
			
		jtfCidade = new JTextField();
		jtfCidade.setColumns(10);
		jtfCidade.setBounds(12, 169, 166, 19);
		jpPersonalInfo.add(jtfCidade);
		
		lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblRua.setBounds(12, 200, 70, 15);
		jpPersonalInfo.add(lblRua);
		
		jtfRua = new JTextField();
		jtfRua.setColumns(10);
		jtfRua.setBounds(12, 216, 166, 19);
		jpPersonalInfo.add(jtfRua);
		
		// Configurando a check box jcbPais.
		jcbPais = new JComboBox<String>();
		jcbPais.setMaximumRowCount(7);
		jcbPais.setModel(new DefaultComboBoxModel<String>(new String[] {"Afganistán ", "Akrotiri ", "Albania ", "Alemania ", "Andorra ", "Angola ", "Anguila ", "Antártida ", "Antigua y Barbuda ", "Antillas Neerlandesas ", "Arabia Saudí ", "Arctic Ocean ", "Argelia ", "Argentina ", "Armenia ", "Aruba ", "Ashmore andCartier Islands ", "Atlantic Ocean ", "Australia ", "Austria ", "Azerbaiyán ", "Bahamas ", "Bahráin ", "Bangladesh ", "Barbados ", "Bélgica ", "Belice ", "Benín ", "Bermudas ", "Bielorrusia ", "Birmania Myanmar ", "Bolivia ", "Bosnia y Hercegovina ", "Botsuana ", "Brasil ", "Brunéi ", "Bulgaria ", "Burkina Faso ", "Burundi ", "Bután ", "Cabo Verde ", "Camboya ", "Camerún ", "Canadá ", "Chad ", "Chile ", "China ", "Chipre ", "Clipperton Island ", "Colombia ", "Comoras ", "Congo ", "Coral Sea Islands ", "Corea del Norte ", "Corea del Sur ", "Costa de Marfil ", "Costa Rica ", "Croacia ", "Cuba ", "Dhekelia ", "Dinamarca ", "Dominica ", "Ecuador ", "Egipto ", "El Salvador ", "El Vaticano ", "Emiratos Árabes Unidos ", "Eritrea ", "Eslovaquia ", "Eslovenia ", "España ", "Estados Unidos ", "Estonia ", "Etiopía ", "Filipinas ", "Finlandia ", "Fiyi ", "Francia ", "Gabón ", "Gambia ", "Gaza Strip ", "Georgia ", "Ghana ", "Gibraltar ", "Granada ", "Grecia ", "Groenlandia ", "Guam ", "Guatemala ", "Guernsey ", "Guinea ", "Guinea Ecuatorial ", "Guinea-Bissau ", "Guyana ", "Haití ", "Honduras ", "Hong Kong ", "Hungría ", "India ", "Indian Ocean ", "Indonesia ", "Irán ", "Iraq ", "Irlanda ", "Isla Bouvet ", "Isla Christmas ", "Isla Norfolk ", "Islandia ", "Islas Caimán ", "Islas Cocos ", "Islas Cook ", "Islas Feroe ", "Islas Georgia del Sur y Sandwich del Sur ", "Islas Heard y McDonald ", "Islas Malvinas ", "Islas Marianas del Norte ", "IslasMarshall ", "Islas Pitcairn ", "Islas Salomón ", "Islas Turcas y Caicos ", "Islas Vírgenes Americanas ", "Islas Vírgenes Británicas ", "Israel ", "Italia ", "Jamaica ", "Jan Mayen ", "Japón ", "Jersey ", "Jordania ", "Kazajistán ", "Kenia ", "Kirguizistán ", "Kiribati ", "Kuwait ", "Laos ", "Lesoto ", "Letonia ", "Líbano ", "Liberia ", "Libia ", "Liechtenstein ", "Lituania ", "Luxemburgo ", "Macao ", "Macedonia ", "Madagascar ", "Malasia ", "Malaui ", "Maldivas ", "Malí ", "Malta ", "Man, Isle of ", "Marruecos ", "Mauricio ", "Mauritania ", "Mayotte ", "México ", "Micronesia ", "Moldavia ", "Mónaco ", "Mongolia ", "Montserrat ", "Mozambique ", "Namibia ", "Nauru ", "Navassa Island ", "Nepal ", "Nicaragua ", "Níger ", "Nigeria ", "Niue ", "Noruega ", "Nueva Caledonia ", "Nueva Zelanda ", "Omán ", "Pacific Ocean ", "Países Bajos ", "Pakistán ", "Palaos ", "Panamá ", "Papúa-Nueva Guinea ", "Paracel Islands ", "Paraguay ", "Perú ", "Polinesia Francesa ", "Polonia ", "Portugal ", "Puerto Rico ", "Qatar ", "Reino Unido ", "República Centroafricana ", "República Checa ", "República Democrática del Congo ", "República Dominicana ", "Ruanda ", "Rumania ", "Rusia ", "Sáhara Occidental ", "Samoa ", "Samoa Americana ", "San Cristóbal y Nieves ", "San Marino ", "San Pedro y Miquelón ", "San Vicente y las Granadinas ", "Santa Helena ", "Santa Lucía ", "Santo Tomé y Príncipe ", "Senegal ", "Seychelles ", "Sierra Leona ", "Singapur ", "Siria ", "Somalia ", "Southern Ocean ", "Spratly Islands ", "Sri Lanka ", "Suazilandia ", "Sudáfrica ", "Sudán ", "Suecia ", "Suiza ", "Surinam ", "Svalbard y Jan Mayen ", "Tailandia ", "Taiwán ", "Tanzania ", "Tayikistán ", "TerritorioBritánicodel Océano Indico ", "Territorios Australes Franceses ", "Timor Oriental ", "Togo ", "Tokelau ", "Tonga ", "Trinidad y Tobago ", "Túnez ", "Turkmenistán ", "Turquía ", "Tuvalu ", "Ucrania ", "Uganda ", "Unión Europea ", "Uruguay ", "Uzbekistán ", "Vanuatu ", "Venezuela ", "Vietnam ", "Wake Island ", "Wallis y Futuna ", "West Bank ", "World ", "Yemen ", "Yibuti ", "Zambia ", "Zimbabue "}));
		jcbPais.setBounds(210, 28, 180, 24);
		jpPersonalInfo.add(jcbPais);
			
		// Configurando a label lblPais.
		lblPais = new JLabel("País:");
		lblPais.setBounds(211, 12, 114, 15);
		lblPais.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpPersonalInfo.add(lblPais);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblNumero.setBounds(210, 59, 70, 15);
		jpPersonalInfo.add(lblNumero);
		
		jtfNumero = new JTextField();
		jtfNumero.setColumns(10);
		jtfNumero.setBounds(210, 75, 166, 19);
		jpPersonalInfo.add(jtfNumero);
		
		// Configurando o botão btnSave.
		JButton btnSave = new JButton("");
		btnSave.setBounds(296, 155, 80, 80);
		btnSave.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnSave.setHorizontalTextPosition( SwingConstants.CENTER );
		btnSave.setIcon(new ImageIcon(getClass().getResource("../../save.png")));
		btnSave.setOpaque(false);
		btnSave.setContentAreaFilled(false);
		btnSave.addActionListener(new BtnSaveActionListener());
		jpPersonalInfo.add(btnSave);
		
		// Configuração do botão btnRmvServico.
		JButton btnRmvHospede = new JButton("Rmv Servicos");
		btnRmvHospede.setBounds(270, 155, 80, 80);
		btnRmvHospede.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnRmvHospede.setHorizontalTextPosition( SwingConstants.CENTER );
		btnRmvHospede.setIcon(new ImageIcon(getClass().getResource("../../rmv_service.png")));
		btnRmvHospede.setOpaque(false);
		btnRmvHospede.setContentAreaFilled(false);
		btnRmvHospede.setBorderPainted(true);
		btnRmvHospede.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					contrato.getListaDeHospedesAssociados().remove(hospede);
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
						
				try {
					FileFactory.saveHotel(UserProgram.hotel, "hotel.ser");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
						
				try {
					HospedesPanel.jtmHospedes.setData(contrato.getListaDeHospedesAssociados());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
				dispose();
			}
		});
		this.add(btnRmvHospede);
		
		carregar();
	}
	
	private void carregar() {
		
		try {
			jtfNome.setText(hospede.getNome());
			jftNascimento.setValue(hospede.getDataDeNascimento());
			
			if (hospede instanceof HospedeRepresentante) {
				HospedeRepresentante tempHosp = (HospedeRepresentante) hospede;
				jtfRua.setText(tempHosp.getEndereco().getRua());
				jtfCidade.setText(tempHosp.getEndereco().getCidade());
				jftCpf.setText(tempHosp.getCpf());
				jcbPais.setSelectedItem(tempHosp.getEndereco().getPais());
				jtfNumero.setText(tempHosp.getEndereco().getNum() + "");
			} else {
				jtfRua.setEditable(false);
				jtfCidade.setEditable(false);
				jftCpf.setEditable(false);
				jtfNumero.setEditable(false);
				jcbPais.setEditable(false);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class BtnSaveActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				setNascimento();
				setNome();
				
				if (jftCpf.isEditable()) {
					HospedeRepresentante tempHosp = (HospedeRepresentante) hospede;
					setEndereco(tempHosp);
				}
				
				HospedesPanel.jtmHospedes.setData(contrato.getListaDeHospedesAssociados());
				GerenciarContratosPanel.jtmContratos.setData(UserProgram.hotel.getContratos());
				FileFactory.saveHotel(UserProgram.hotel, "hotel.ser");
				dispose();
			} catch(Exception ex) {
				ex.printStackTrace();
				InformationError.createDialog(jpPersonalInfo.getParent(), "Informações inválidas, verifique-as!");
			}
		}
		
		public void setCpf(HospedeRepresentante hospede) throws Exception {
			hospede.setCpf(jftCpf.getText());
		}
		
		public void setNome() throws Exception {
			hospede.setNome(jtfNome.getText());
		}
		
		public void setEndereco(HospedeRepresentante hospede) throws Exception{
			hospede.setEnderecoDeResidencia(new EnderecoCasa(getPais(), getCidade(), "Alto Branco", getRua(), getNumero()));
		}
		
		public void setNascimento() throws Exception {
			hospede.setDataDeNascimento(FormatFactory.stringToGregorianCalendar(jftNascimento.getText()));
		}
		
		public String getPais() {
			return (String) jcbPais.getSelectedItem();
		}
		
		public String getCidade() {
			return jtfCidade.getText();
		}
		
		public String getRua() {
			return jtfRua.getText();
		}
		
		public int getNumero() throws ParseException {
			return Integer.parseInt(jtfNumero.getText());
		}
	}
}
	
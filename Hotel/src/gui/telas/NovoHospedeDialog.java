package gui.telas;

import gui.reusavel.InformationError;
import gui.reusavel.Title;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import logica.clientes.Hospede;
import logica.essenciais.Contrato;
import programa.arquivos.FileFactory;
import programa.formatos.FormatFactory;

/**
 * Abre um novo dialogo que sera utilizado para o usuario inserir
 * as informacoes de um novo hospede. Um icone marca a finalizacao 
 * da entrada de dados e a criacao do hospede (caso tudo tenha sido
 * corretamente preenchido).
 * 
 * @author WesleySilva
 *
 */
public class NovoHospedeDialog extends JDialog {
	private static final long serialVersionUID = 157896500701L;

	// Panels
	private final JPanel contentPanel = new JPanel();
	private final JPanel jpPersonalInfo;
	private final JPanel jpTitle;
	
	// TextField
	private final JFormattedTextField jftDataDeNascimento;
	private final JTextField jtfNome;
	
	// Labels
	private final JLabel lblNome;
	private final JLabel lblCpf;
	
	// Buttons
	private final JButton btnCriar;

	public NovoHospedeDialog(final Contrato contrato) {
		// Configurando o dialog.
		this.setTitle("RHM - Novo Hospede");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 233);
		this.contentPanel.setLayout(new FlowLayout());
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		// Configurando o painel jpTitle.
		jpTitle = new Title("../../NovoHospede.jpg");
		jpTitle.setBounds(0, 0, 450, 45);
		this.getContentPane().add(jpTitle);

		// Configurando o painel jpPersonalInfo.
		jpPersonalInfo = new JPanel();
		jpPersonalInfo.setBounds(12, 60, 426, 112);
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
		lblCpf = new JLabel("Data de Nascimento:");
		lblCpf.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblCpf.setBounds(12, 59, 141, 15);
		jpPersonalInfo.add(lblCpf);
		
		// Configurando o campo de texto jtfDataDeNascimento.
		jftDataDeNascimento = new JFormattedTextField(FormatFactory.createDateFactory());
		jftDataDeNascimento.setBounds(12, 75, 166, 19);
		jftDataDeNascimento.setColumns(10);
		jpPersonalInfo.add(jftDataDeNascimento);
		
		// Configurando o botão btnCriar.
		btnCriar = new JButton("");
		btnCriar.setBounds(304, 14, 80, 80);
		btnCriar.setIcon(new ImageIcon(getClass().getResource("../../create.png")));
		btnCriar.setOpaque(false);
		btnCriar.setContentAreaFilled(false);
		btnCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Pegando os valores da interface.
					String nome = jtfNome.getText();
					Hospede hospede = new Hospede(nome, FormatFactory.stringToGregorianCalendar((String) jftDataDeNascimento.getValue()));
					contrato.adicionaHospede(hospede);
					HospedesPanel.jtmHospedes.setData(contrato.getListaDeHospedesAssociados());
					FileFactory.saveHotel(UserProgram.hotel, "hotel.ser");
					dispose();
				} catch(Exception ex) {
					InformationError.createDialog(jpPersonalInfo.getParent(), "Error ao criar o hospede, verifique se as informações são válidas.");
				}
			}
		});
		jpPersonalInfo.add(btnCriar);
	}
}

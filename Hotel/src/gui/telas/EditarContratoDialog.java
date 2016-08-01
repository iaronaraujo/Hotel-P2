package gui.telas;

import gui.reusavel.Title;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import logica.enumeracoes.EstadoContrato;
import logica.essenciais.Contrato;
import programa.arquivos.FileFactory;
import programa.formatos.FormatFactory;

/**
 * Permite a modificação de informações a respeito do contrato,
 * do fechamento e da administração do contratos, incluindo a 
 * adição de serviços e hospedes.
 * 
 * @author WesleySilva
 *
 */
public class EditarContratoDialog extends JDialog {
	private static final long serialVersionUID = 157896502201L;
	
	// Panels
	private final JPanel contentPanel = new JPanel();
	private final HospedesPanel jpHospedes;
	private final ServicosPanel jpServicos;
	protected static JPanel jpPack;
	private final JPanel jpContent;
	private final JPanel jpDates;
	private final Title jpTitle;
	
	// Labels
	private final JLabel lblDataCheckIn;
	private final JLabel lblDataCheckOut;
	
	// FormattedTextFields
	private final JFormattedTextField jftDataCheckIn;
	private final JFormattedTextField jftDataCheckOut;
	
	// Buttons
	private final JButton btnClose;
	
	// Colors
	private final Color clrBtnClose;
	
	public EditarContratoDialog(final JFrame parent, final Contrato contrato) {
		// Configurando o dialog.
		super(parent);
		this.setTitle("RHM - Editar Contrato");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 520);
		this.contentPanel.setLayout(new FlowLayout());
		this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		// Configurando o painel jpTitle.
		jpTitle = new Title("../../EditarContrato.jpg");
		jpTitle.setBounds(0, 0, 450, 45);
		getContentPane().add(jpTitle);
		
		// Configurando o painel jpContent.
		jpContent = new JPanel();
		jpContent.setBounds(12, 62, 426, 418);
		getContentPane().add(jpContent);
		jpContent.setLayout(null);
		
		// Configurando o painel jpDates.
		jpDates = new JPanel();
		jpDates.setBounds(0, 12, 426, 96);
		jpDates.setLayout(null);
		jpDates.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jpContent.add(jpDates);
		
		// Configurando a label lblDataCheckIn.
		lblDataCheckIn = new JLabel("Data Check In:");
		lblDataCheckIn.setBounds(12, 12, 130, 15);
		lblDataCheckIn.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpDates.add(lblDataCheckIn);
		
		// Configurando o campo formatável jtfDataCheckIn.
		jftDataCheckIn = new JFormattedTextField();
		jftDataCheckIn.setBounds(12, 26, 114, 19);
		try {
		jftDataCheckIn.setValue(contrato.getDataInicial().get(Calendar.DAY_OF_MONTH)  + "/"  
				   				+ (contrato.getDataInicial().get(Calendar.MONTH) + 1) + 
				   				"/" + contrato.getDataInicial().get(Calendar.YEAR));
		} catch(Exception e ) {
			e.printStackTrace();
		}
		jftDataCheckIn.setEditable(false);
		jpDates.add(jftDataCheckIn);
		
		// Configurando a label lblDataCheckOut.
		lblDataCheckOut = new JLabel("Data Check Out:\n");
		lblDataCheckOut.setBounds(12, 51, 130, 15);
		lblDataCheckOut.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		jpDates.add(lblDataCheckOut);
		
		// Configurando o campo formatável jtfDataCheckOut.
		jftDataCheckOut = new JFormattedTextField();
		jftDataCheckOut.setBounds(12, 65, 114, 19);
		try{
		jftDataCheckOut.setValue(FormatFactory.gregorianCalendarToString(contrato.getDataFinal()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jftDataCheckOut.setEditable(false);
		jftDataCheckOut.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 12));
		jpDates.add(jftDataCheckOut);
		
		// Configurando o botão btnClose.
		btnClose = new JButton("");
		btnClose.setBounds(325, 8, 80, 80);
		btnClose.setVerticalTextPosition( SwingConstants.BOTTOM );
		btnClose.setHorizontalTextPosition( SwingConstants.CENTER );
		btnClose.setIcon(new ImageIcon(getClass().getResource("../../close.png")));
		btnClose.setToolTipText("Fechar o contrato!");
		btnClose.setOpaque(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					contrato.setEstadoDoContrato(EstadoContrato.FECHADO);
					GerenciarContratosPanel.jtmContratos.setData(UserProgram.hotel.getContratos());
					EditarContratoDialog.this.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				try {
					UserProgram.hotel.getContratos().remove(contrato);
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				// Salvando no arquivo
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
					GerenciarContratosPanel.jtmContratos.setData(UserProgram.hotel.getContratos());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	    btnClose.getModel().addChangeListener(new BtnCloseChangeListener());
	    clrBtnClose = btnClose.getBackground();
		jpDates.add(btnClose);
		
		// Config o lbl de cartao de credito.
		JLabel lblNmeroDoCarto = new JLabel("Cartão de Crédito:");
		lblNmeroDoCarto.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		lblNmeroDoCarto.setBounds(154, 8, 130, 15);
		jpDates.add(lblNmeroDoCarto);
		
		JTextField jtfCartaoDeCredito = new JTextField();
		jtfCartaoDeCredito.setBounds(154, 26, 114, 19);
		try {
			jtfCartaoDeCredito.setText(contrato.getNumCartaoDeCredito() + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCartaoDeCredito.setEditable(false);
		jpDates.add(jtfCartaoDeCredito);
		
		// Configurando o painel jpHospedes.
		jpHospedes = new HospedesPanel(contrato);
		jpHospedes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpServicos = new ServicosPanel(contrato);
		
		// Configurando o painel jpPack.
		jpPack = new JPanel();
		jpPack.setBounds(0, 120, 426, 298);
		jpPack.setLayout(new CardLayout(0, 0));
		jpPack.add(jpHospedes, "hospedes");
		jpPack.add(jpServicos, "servicos");
		jpContent.add(jpPack);
		System.out.println("CHEGOU");
		// Carregando as tabelas.
		try {
			//TelaPrincipal.jtmHospedes.setData(contrato.getListaDeHospedesAssociados());
			contrato.getListaDeHospedesAssociados().size();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private class BtnCloseChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent event) {
			ButtonModel closeModel = (ButtonModel) event.getSource();
			
			if (closeModel.isPressed() || closeModel.isRollover()) {
				if (closeModel.isRollover()){
					btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
					btnClose.setBackground(Color.RED);
				}
				if (closeModel.isPressed()){
					btnClose.setBorder(BorderFactory.createLoweredBevelBorder());
				}
			} else {
				btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
				btnClose.setBackground(clrBtnClose);
			}
		}
		
	}
}

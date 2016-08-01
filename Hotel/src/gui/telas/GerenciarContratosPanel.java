package gui.telas;

import gui.reusavel.TableError;
import gui.reusavel.Title;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import logica.clientes.HospedeRepresentante;
import logica.endereco.EnderecoCasa;
import logica.enumeracoes.EstadoContrato;
import logica.essenciais.Contrato;
import logica.estrategias.Simples;
import logica.quartos.tipos.QuartoExecutivoDuplo;
import logica.servicos.DiariaQuarto;
import logica.servicos.Servico;
import programa.documentos.DocumentFactory;
import programa.formatos.FormatFactory;

/**
 * Eh uma das visoes do painel "baralho" de TelaPrincipal.
 * Contem uma tabela de contratos e permite a criacao de um novo
 * contrato.
 * 
 * @author WesleySilva
 *
 */
public class GerenciarContratosPanel extends JPanel {
	private static final long serialVersionUID = 157896501801L;
	
	// Panels.
	private final JPanel jpContent;
	private final JPanel jpTitle;
	private final JPanel jpMenu;
	
	// Tables.
	private final TableRowSorter<ContratosTableModel> sorter;
	protected static JTable jtContratos;
	protected static ContratosTableModel jtmContratos;
	
	// TextFields.
	private final JTextField jtfPesquisarContrato;
	
	// Buttons.
	private final JButton btnNovoContrato;
	
	// Labels.
	private final JLabel lblPesquisarContrato;
	
	// Dialogs.
	private NovoContratoDialog novoContratoDialog;
	private EditarContratoDialog editarContratoDialog;

	public GerenciarContratosPanel(final TelaPrincipal telaPrincipal) throws Exception {
		try {
			jtmContratos = new ContratosTableModel(UserProgram.hotel.getContratos());
		} catch(Exception e){
			e.printStackTrace();
		}
		
		// Configurando o painel.
		this.setLayout(null);
		 this.setOpaque(false);

		// Configurando o painel jpTitle.
		jpTitle = new Title("../../GerenciarContratos.jpg");
		jpTitle.setBounds(0, 0, 800, 80);
		this.add(jpTitle);
		
		// Configurando o painel jpContent.
		jpContent = new JPanel();
		jpContent.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpContent.setBounds(10, 202, 780, 386);
		this.add(jpContent);
		jpContent.setLayout(null);
		// Configurando a tabela jtContratos.
		sorter = new TableRowSorter<ContratosTableModel>(jtmContratos);
		jtContratos = new JTable(jtmContratos);
		jtContratos.setBounds(12, 30, 756, 290);
		jtContratos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtmContratos.setData(UserProgram.hotel.getContratos());
		jtContratos.setRowSorter(sorter);
		jtContratos.addMouseListener(new JtContratosMouseAdapter());
		jpContent.add(jtContratos);
		
		// Configurando o cabeçalho da tabela jtFuncionarios.getTableHeader().
		jtContratos.getTableHeader().setBounds(12, 12, 756, 15);
		jpContent.add(jtContratos.getTableHeader());
		
		// Configurando o campo de texto jtfPesquisarContrato.
		jtfPesquisarContrato = new JTextField();
		jtfPesquisarContrato.setBounds(12, 351, 204, 19);
		jtfPesquisarContrato.setDocument(DocumentFactory.createLengthedDocument(25));
		jtfPesquisarContrato.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
					public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    @Override
					public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    @Override
					public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
		jpContent.add(jtfPesquisarContrato);
		
		// Configurando a label lblPesquisarContrato.
		lblPesquisarContrato = new JLabel("Pesquisar Contrato:");
		lblPesquisarContrato.setHorizontalAlignment(SwingConstants.LEFT);
		lblPesquisarContrato.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblPesquisarContrato.setBounds(12, 332, 139, 15);
		jpContent.add(lblPesquisarContrato);
		
		// Configurando o botão btnNovoContrato.
		btnNovoContrato = new JButton("Novo Contrato");
		btnNovoContrato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(GerenciarContratosPanel.this);
				novoContratoDialog = new NovoContratoDialog(parentFrame);
				novoContratoDialog.setVisible(true);
			}
		});
		btnNovoContrato.setIcon(new ImageIcon(getClass().getResource("../../PlusButton.png")));
		btnNovoContrato.setBounds(570, 332, 170, 40);
		btnNovoContrato.setOpaque(false);
		btnNovoContrato.setContentAreaFilled(false);
		btnNovoContrato.setBorderPainted(false);
		jpContent.add(btnNovoContrato);
		
		// Configurando o painel jpMenu.
		jpMenu = new MenuPanel(telaPrincipal.jpPack);
		jpMenu.setBounds(0, 90, 800, 100);
		jpMenu.setLayout(null);
		MenuPanel.btnGerenciarContratos.setBackground(Color.RED);
		this.add(jpMenu);
	}
	
	private void newFilter() {
        RowFilter<ContratosTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(jtfPesquisarContrato.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
	
	class ContratosTableModel extends AbstractTableModel {
		private final String[] columnNames = {"CPF", "Contratante", "Estado", "CheckIn", "CheckOut"};
		private Object[][] data;

		public ContratosTableModel(List<Contrato> contratos) {
			setData(contratos);
		}
		
		public void setData(List<Contrato> contratos) {
			try {
				data = new Object[contratos.size()][5];
				
				for (int i = 0; i < contratos.size(); i++) {
					data[i][0] = (contratos.get(i).getRepresentante().getCpf());
					data[i][1] = (contratos.get(i).getRepresentante().getNome());
					data[i][2] = ((contratos.get(i).getEstadoDoContrato() == EstadoContrato.ABERTO) ? ("Aberto") : ("Fechado"));
					data[i][3] = (FormatFactory.gregorianCalendarToString(contratos.get(i).getDataInicial()));
					data[i][4] = (FormatFactory.gregorianCalendarToString(contratos.get(i).getDataFinal()));
				}
				
				jtContratos.repaint();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		
		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		@Override
		public int getRowCount() {
			return data.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
		
		@Override
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
	}
	
	public class JtContratosMouseAdapter extends MouseAdapter {
		private int selectedRow;
		private int selectedCol;
		
		@Override
	    public void mouseClicked(MouseEvent mouseEvent) {
	    	selectedRow = jtContratos.rowAtPoint(mouseEvent.getPoint());
	    	selectedCol = jtContratos.columnAtPoint(mouseEvent.getPoint());
	    	
	    	if (mouseEvent.getClickCount() >= 2 && selectedRow >= 0 && selectedCol >= 0) {
	        	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(GerenciarContratosPanel.this);
	        	
	        	try {
	        		Contrato contratoSentinela = UserProgram.hotel.pesquisaContrato(getContrato());
	        		if (contratoSentinela != null){
	        			editarContratoDialog = new EditarContratoDialog(parentFrame, contratoSentinela);
	        			editarContratoDialog.setVisible(true);
	        		}
	        		else {
	        			throw new Exception();
	        		}
	        	} catch(Exception e){
	        		e.printStackTrace();
	        		TableError.createDialog(jpContent.getParent(), "Erro ao ler os dados do contrato.");
	        	}	
	    	}
	    }
	    
	    public String getCpf() {
    		return (String) jtContratos.getModel().getValueAt(selectedRow, 0);
    	}
	    
	    public GregorianCalendar getData(String data) throws Exception {
	    	return FormatFactory.stringToGregorianCalendar(data);
	    }
	    
	    public HospedeRepresentante getHospede() throws Exception {
	    	return new HospedeRepresentante(FormatFactory.DEFAULT_STRING, new GregorianCalendar(FormatFactory.DEFAULT_INT, FormatFactory.DEFAULT_INT, FormatFactory.DEFAULT_INT), getCpf(), new EnderecoCasa(FormatFactory.DEFAULT_STRING, FormatFactory.DEFAULT_STRING, FormatFactory.DEFAULT_STRING, FormatFactory.DEFAULT_STRING, FormatFactory.DEFAULT_INT));
	    }
	    
	    public Contrato getContrato() throws Exception {
	    	String dataInicial = (String) jtContratos.getModel().getValueAt(selectedRow, 3);
	    	String dataFinal = (String) jtContratos.getModel().getValueAt(selectedRow, 4);
	    	return new Contrato(getHospede(), getData(dataInicial), getData(dataFinal), new Simples(), "23232", new ArrayList<Servico>(), new DiariaQuarto(new QuartoExecutivoDuplo(0), 2, "11213"));	
	    }
	}
}
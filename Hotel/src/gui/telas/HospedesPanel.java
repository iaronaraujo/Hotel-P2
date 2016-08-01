package gui.telas;

import gui.reusavel.TableError;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import logica.clientes.Hospede;
import logica.clientes.HospedeRepresentante;
import logica.endereco.Endereco;
import logica.essenciais.Contrato;
import programa.documentos.DocumentFactory;
import programa.formatos.FormatFactory;

/**
 * Eh uma das visoes do painel "baralho" de EditarContratoDialog.
 * Contem uma tabela de hospedes e permite a criacao de um novo
 * hospede.
 * 
 * @author WesleySilva
 *
 */
public class HospedesPanel extends JPanel {
	private static final long serialVersionUID = 157896501701L;
	
	// Tables
	private final JTable jtHospedes;
	protected static HospedesTableModel jtmHospedes;
	private final TableRowSorter<HospedesTableModel> sorter;
	
	// TextFields
	private final JTextField jtfPesquisar;
	
	// Buttons
	private final JButton btnAddHospede;
	private final JButton btnServicos;
	
	// Labels
	private final JLabel lblPesquisarHospede;
	
	// Dialogs
	private NovoHospedeDialog novoHospede;

	/**
	 * Create the panel.
	 */
	public HospedesPanel(final Contrato contrato) {
		// Configurando o painel.
		this.setLayout(null);
		
		try {
			jtmHospedes = new HospedesTableModel(contrato.getListaDeHospedesAssociados());
		} catch(Exception e){
			e.printStackTrace();
		}
		
		// Configurando o botão btnServicos.
		btnServicos = new JButton("Serviços ");
		btnServicos.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		btnServicos.setForeground(new Color(51, 153, 0));
		btnServicos.setIcon(new ImageIcon(getClass().getResource("../../double_arrow.png")));
		btnServicos.setOpaque(false);
		btnServicos.setContentAreaFilled(false);
		btnServicos.setHorizontalTextPosition( SwingConstants.LEFT );
		btnServicos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) EditarContratoDialog.jpPack.getLayout();
				cardLayout.show(EditarContratoDialog.jpPack, "servicos");
			}
		});
		btnServicos.setBounds(264, 261, 150, 25);
		this.add(btnServicos);
	
		// Configurando a tabela jtHospedes.
		sorter = new TableRowSorter<HospedesTableModel>(HospedesPanel.jtmHospedes);
		jtHospedes = new JTable(HospedesPanel.jtmHospedes);
		jtHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		try {
			HospedesPanel.jtmHospedes.setData(contrato.getListaDeHospedesAssociados());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jtHospedes.setRowSorter(sorter);
		jtHospedes.setBounds(12, 75, 402, 175);
		jtHospedes.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	int row = jtHospedes.rowAtPoint(evt.getPoint());
	        	int col = jtHospedes.columnAtPoint(evt.getPoint());
		    	if (evt.getClickCount() >= 2 && row >= 0 && col >= 0 ){
		        	try{
			        	String nome = (String) jtHospedes.getModel().getValueAt(row, 0);
			        	
		        		Hospede hospedeSentinela = new Hospede(nome, new GregorianCalendar(1, 1, 1));
		       
		        		hospedeSentinela = contrato.pesquisaHospede(hospedeSentinela);
		        		
		        		if (hospedeSentinela != null){
		        			EditarHospedeDialog editarHospedeDialog = new EditarHospedeDialog(hospedeSentinela, contrato);
		        			editarHospedeDialog.setVisible(true);
		        		} else {
		        			throw new Exception("Hospede inválido.");
		        		}
		        	} catch(Exception e){
		        		TableError.createDialog(HospedesPanel.this.getParent(), "Erro ao ler o hospede.");
		        		e.printStackTrace();
		        	}
		    	}
		    }
		});
		this.add(jtHospedes);
		
		// Configurando o cabeçalho da tabela jtHospedes.getTableHeader().
		jtHospedes.getTableHeader().setBounds(12, 58, 402, 15);
		this.add(jtHospedes.getTableHeader());

		
		// Configurando o campo de texto formatável jtfPesquisar.
		jtfPesquisar = new JTextField();
		jtfPesquisar.setBounds(12, 27, 170, 19);
		jtfPesquisar.setDocument(DocumentFactory.createLengthedDocument(18));
		jtfPesquisar.getDocument().addDocumentListener(
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
		
		this.add(jtfPesquisar);
		
		// Configurando o botão btnAddHospede.
		btnAddHospede = new JButton("Add Hospede");
		btnAddHospede.setBounds(0, 261, 143, 25);
		btnAddHospede.setForeground(new Color(51, 153, 0));
		btnAddHospede.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAddHospede.setHorizontalTextPosition( SwingConstants.RIGHT );
		btnAddHospede.setIcon(new ImageIcon(getClass().getResource("../../add_client.png")));
		btnAddHospede.setOpaque(false);
		btnAddHospede.setContentAreaFilled(false);
		btnAddHospede.setBorderPainted(false);
		btnAddHospede.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				novoHospede = new NovoHospedeDialog(contrato);
				novoHospede.setVisible(true);
			}
		});
		this.add(btnAddHospede);
		
		// Configurando a label lblPesquisarHospede.
		lblPesquisarHospede = new JLabel("Pesquisar Hospede:");
		lblPesquisarHospede.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblPesquisarHospede.setBounds(12, 12, 143, 15);
		this.add(lblPesquisarHospede);

	}
	
	private void newFilter() {
        RowFilter<HospedesTableModel, Object> rowFilter = null;
        
        try {
            rowFilter = RowFilter.regexFilter(jtfPesquisar.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        
        sorter.setRowFilter(rowFilter);
    }
	
	class HospedesTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 157896502601L;
		
		private final String[] columnNames = {"Nome", "Data de Nascimento", "Tipo"};
		private Object[][] data;

		public HospedesTableModel(List<Hospede> hospedes) {
			data = new Object[hospedes.size()][3];
			
			try{
				int index = 0;
			
				for (Hospede h : hospedes) {
					GregorianCalendar dataNascimento = h.getDataDeNascimento();
					String dataString = dataNascimento.get(Calendar.DAY_OF_MONTH)  + "/"  + (dataNascimento.get(Calendar.MONTH) + 1) + "/" + dataNascimento.get(Calendar.YEAR);
					
					data[index][0] = (h.getNome());
					data[index][1] = (dataString);
					data[index][2] = ((index == 0) ? ("Contratante") : ("Associado"));
					
					index++;
				}
				
				jtHospedes.repaint();
			} catch(Exception e) {
				
			}
		}
		
		public void setData(List<Hospede> hospedes) {
			try{
				data = new Object[hospedes.size()][3];
			
				int index = 0;
			
				for (Hospede h : hospedes) {
					GregorianCalendar dataNascimento = h.getDataDeNascimento();
					String dataString = dataNascimento.get(Calendar.DAY_OF_MONTH)  + "/"  + (dataNascimento.get(Calendar.MONTH) + 1) + "/" + dataNascimento.get(Calendar.YEAR);
					
					data[index][0] = (h.getNome());
					data[index][1] = (dataString);
					data[index][2] = ((index == 0) ? ("Contratante") : ("Associado"));
					
					index++;
				}				
				jtHospedes.repaint();
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


}

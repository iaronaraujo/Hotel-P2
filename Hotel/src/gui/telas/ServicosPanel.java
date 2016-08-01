package gui.telas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import logica.essenciais.Contrato;
import logica.servicos.Servico;
import programa.documentos.DocumentFactory;

/**
 * É uma das visões do painel "baralho" de EditarContratoDialog.
 * Contém uma tabela de serviços já contratados pelo cliente e
 * permite a adição de novos serviços.
 * 
 * 
 * @author WesleySilva
 *
 */
public class ServicosPanel extends JPanel {
	private static final long serialVersionUID = 157896500301L;
	
	private final JTextField jtfPesquisar;
	private final JTable jtServicos;
	private final JButton btnAddServico;
	private final JButton btnHospedes;
	private final JLabel lblPesquisarServico;
	private NovoServicoDialog novoServicoDialog;
	protected static ServicosTableModel jtmServicos;
	private final TableRowSorter<ServicosTableModel> sorter;
	
	public ServicosPanel(final Contrato contrato) {
		// Configuração do painel.
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.setLayout(null);
		
		// Configuração do botão btnHospedes.
		btnHospedes = new JButton(" Hospedes");
		btnHospedes.setBounds(264, 261, 150, 25);
		btnHospedes.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		btnHospedes.setForeground(new Color(51, 153, 0));
		btnHospedes.setIcon(new ImageIcon(getClass().getResource("../../double_arrow_inv.png")));
		btnHospedes.setOpaque(false);
		btnHospedes.setContentAreaFilled(false);
		btnHospedes.setHorizontalTextPosition( SwingConstants.RIGHT );
		btnHospedes.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) EditarContratoDialog.jpPack.getLayout();
				cardLayout.show(EditarContratoDialog.jpPack, "hospedes");
			}
		});
		this.add(btnHospedes);
		
		// Configuração da tabela jtServicos.
		jtmServicos = new ServicosTableModel(contrato.getListaDeServicosContratados());
		sorter = new TableRowSorter<ServicosTableModel>(jtmServicos);
		jtServicos = new JTable(jtmServicos);
		jtServicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ServicosPanel.jtmServicos.setData(contrato.getListaDeServicosContratados());
		jtServicos.setRowSorter(sorter);
		jtServicos.setBounds(12, 58, 402, 192);
		jtServicos.addMouseListener(new MouseAdapter() {
		    @Override
			public void mouseClicked(MouseEvent evt) {
		    	int row = jtServicos.rowAtPoint(evt.getPoint());
	        	int col = jtServicos.columnAtPoint(evt.getPoint());
		    	if (evt.getClickCount() >= 2 && row >= 0 && col >= 0 ){
		    		try{
		    			EditarServicoDialog editarServicoDialog = new EditarServicoDialog(contrato.getListaDeServicosContratados().get(row), contrato);
		    			editarServicoDialog.setVisible(true);
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    	}
		    }
		});
		this.add(jtServicos);

		
		// Configuração do campo de texto jtfPesquisar.
		jtfPesquisar = new JTextField();
		jtfPesquisar.setBounds(12, 27, 170, 19);
		jtfPesquisar.setDocument(DocumentFactory.createLengthedDocument(20));
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
		
		// Configuração do botão btnAddServico.
		btnAddServico = new JButton("Add Serviço");
		btnAddServico.setBounds(0, 261, 143, 25);
		btnAddServico.setForeground(new Color(51, 153, 0));
		btnAddServico.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAddServico.setHorizontalTextPosition( SwingConstants.RIGHT );
		btnAddServico.setIcon(new ImageIcon(getClass().getResource("../../add_servico.png")));
		btnAddServico.setOpaque(false);
		btnAddServico.setContentAreaFilled(false);
		btnAddServico.setBorderPainted(false);
		btnAddServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				novoServicoDialog = new NovoServicoDialog(contrato);
				novoServicoDialog.setVisible(true);
			}
		});	
		this.add(btnAddServico);
		
		// Configuração da label lblPesquisarServico.
		lblPesquisarServico = new JLabel("Pesquisar Serviço:");
		lblPesquisarServico.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblPesquisarServico.setBounds(12, 12, 143, 15);
		this.add(lblPesquisarServico);
	}
	
	private void newFilter() {
        RowFilter<ServicosTableModel, Object> rowFilter = null;
        
        try {
            rowFilter = RowFilter.regexFilter(jtfPesquisar.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        
        sorter.setRowFilter(rowFilter);
    }
	
	class ServicosTableModel extends AbstractTableModel {
		private final String[] columnNames = {"Nome", "Descrição"};
		private Object[][] data;
		
		public ServicosTableModel(List<Servico> servicos) {
			setData(servicos);
		}
		
		public void setData(List<Servico> servicos) {
			try{
				data = new Object[servicos.size()][2];
			
				int index = 0;
			
				for (Servico s : servicos) {
					String descricaoString = s.getDescricao();
					data[index][0] = (s.getClass().getSimpleName());
					data[index][1] = (descricaoString);
					index++;
				}
				System.out.println("TAMNANHO DO ARRAY");
				System.out.println(servicos.size());
				System.out.println("TAMANHO DO ARRAY");
				this.fireTableDataChanged();
				jtServicos.repaint();
			} catch(Exception e) {
				System.out.println(e.getMessage());
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

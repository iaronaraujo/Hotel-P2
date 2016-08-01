package gui.telas;

import gui.reusavel.TableError;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 * Eh o menu do programa. Eh mostrado em todos os paineis do painel "baralho"
 * na TelaPrincipal, cada um com um vermelho em um item diferente.
 * O painel do menu levara o usuario a outros paineis "cartas". Como:
 * 1. InicioPanel
 * 2. FuncionariosPanel
 * 3. GerenciarContratosPanel
 * 4. AdministrarServicosPanel
 * 
 * @author WesleySilva
 *
 */
public class MenuPanel extends JPanel {
	private static final long serialVersionUID = 157896501301L;
	
	// Buttons
	protected static JButton btnInicio;
	protected static JButton btnAdministrarServicos;
	protected static JButton btnRegistrarFuncionarios;
	protected static JButton btnGerenciarContratos;

	public MenuPanel(final JPanel jpPack) {
		// Configurando o painel.
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setLayout(null);
		
		// Configurando o botão btnInicio.
		btnInicio = new JButton("Início");
		btnInicio.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
		btnInicio.setHorizontalTextPosition ( SwingConstants.CENTER ) ;
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnInicio.setIcon(new ImageIcon(getClass().getResource("../../menu_inicio.png")));
		btnInicio.setBackground(Color.BLUE);
		btnInicio.setBounds(10, 12, 170, 76);
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				CardLayout cardLayout = (CardLayout) jpPack.getLayout();
				cardLayout.show(jpPack, "inicio");
			}
		});
		this.add(btnInicio);
		
		// Configurando o botão btnGerenciarContratos.
		btnGerenciarContratos = new JButton("Gerenciar Contratos");
		btnGerenciarContratos.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
		btnGerenciarContratos.setHorizontalTextPosition ( SwingConstants.CENTER ) ;
		btnGerenciarContratos.setIcon(new ImageIcon(getClass().getResource("../../menu_gerenciarcontratos.png")));
		btnGerenciarContratos.setForeground(Color.WHITE);
		btnGerenciarContratos.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnGerenciarContratos.setBackground(Color.BLUE);
		btnGerenciarContratos.setBounds(208, 12, 170, 76);
		btnGerenciarContratos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				CardLayout cardLayout = (CardLayout) jpPack.getLayout();
				cardLayout.show(jpPack, "gerenciar_contratos");
				try {
					GerenciarContratosPanel.jtmContratos.setData(UserProgram.hotel.getContratos());
				} catch(Exception e) {
					e.printStackTrace();
					TableError.createDialog(jpPack.getParent(), "Erro ao carregar a tabela de contratos. Fechando o programa.");
				}
			}
		});
		this.add(btnGerenciarContratos);
		
		// Configurando o botão btnAdministrarServicos.
		btnAdministrarServicos = new JButton("Administrar Serviços");
		btnAdministrarServicos.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
		btnAdministrarServicos.setHorizontalTextPosition ( SwingConstants.CENTER ) ;
		btnAdministrarServicos.setIcon(new ImageIcon(getClass().getResource("../../menu_administrarservicos.png")));
		btnAdministrarServicos.setForeground(Color.WHITE);
		btnAdministrarServicos.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnAdministrarServicos.setBackground(Color.BLUE);
		btnAdministrarServicos.setBounds(417, 12, 170, 76);
		btnAdministrarServicos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				CardLayout cardLayout = (CardLayout) jpPack.getLayout();
				cardLayout.show(jpPack, "administrar_servicos");
			}
		});
		this.add(btnAdministrarServicos);
		
		// Configurando o botão btnRegistrarFuncionarios.
		btnRegistrarFuncionarios = new JButton("Funcionários");
		btnRegistrarFuncionarios.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
		btnRegistrarFuncionarios.setHorizontalTextPosition ( SwingConstants.CENTER ) ;
		btnRegistrarFuncionarios.setIcon(new ImageIcon(getClass().getResource("../../menu_funcionarios.png")));
		btnRegistrarFuncionarios.setForeground(Color.WHITE);
		btnRegistrarFuncionarios.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnRegistrarFuncionarios.setBackground(Color.BLUE);
		btnRegistrarFuncionarios.setBounds(620, 12, 170, 76);
		btnRegistrarFuncionarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				CardLayout cardLayout = (CardLayout) jpPack.getLayout();
				cardLayout.show(jpPack, "funcionarios");
			}
		});
		this.add(btnRegistrarFuncionarios);
	}
}

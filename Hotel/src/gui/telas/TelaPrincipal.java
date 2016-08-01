package gui.telas;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * A TelaPrincipal é a classe raíz na interface com o usuário.
 * 
 * Contém um painel com CardLayout no qual estão adicionados paineis do tipo:
 * 1. InicioPanel;
 * 2. GerenciarContratosPanel;
 * 3. AdministrarServicosPanel;
 * 4. FuncionariosPanel.
 * 
 * Contém uma barra de menu.
 * 
 * @author WesleySilva.
 *
 */
public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 157896500201L;
	
	// Panels
	private final AdministrarServicosPanel jpAdministrarServicos;
	private final GerenciarContratosPanel jpGerenciarContratos;
	private final FuncionariosPanel jpFuncionarios;
	private final JPanel jpInvisibleBot;
	private final JPanel jpInvisibleTop;
	private final InicioPanel jpInicio;
	private final JPanel jpContent;
	protected JPanel jpPack;
	
	// Dialogs
	private final LoginDialog loginDialog;
	
	// MenuBars
	private final MenuBar menuBar;
	
	/**
	 * Cria uma nova tela principal.
	 * @throws Exception 
	 */
	public TelaPrincipal() throws Exception {
		// Configurando o dialog de login.
		loginDialog = new LoginDialog(this);
		loginDialog.setVisible(true);
		
		// Configurando a janela.
		this.setTitle("RHM - Tela Principal");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// Configurando a barra de menus.
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		// Configurando o contentPane.
		jpContent = new JPanel();
		jpContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		jpContent.setLayout(null);
		this.setContentPane(jpContent);
		
		// Configurando o painel "baralho".
		jpPack = new JPanel();
		jpPack.setBounds(0, 0, 800, 600);
		jpPack.setLayout(new CardLayout(0, 0));
		jpContent.add(jpPack);
		
		// Configurando as "cartas" do painel "baralho".
		jpAdministrarServicos = new AdministrarServicosPanel(this);
		jpFuncionarios = new FuncionariosPanel(this);
		jpGerenciarContratos = new GerenciarContratosPanel(this);
		jpInicio = new InicioPanel(this);
		jpPack.add(jpInicio, "inicio");
		jpPack.add(jpGerenciarContratos, "gerenciar_contratos");
		jpPack.add(jpAdministrarServicos, "administrar_servicos");
		jpPack.add(jpFuncionarios, "funcionarios");
		
		// Configurando a barra de menu menuBar.
		menuBar.setVisible(false);
		
		// Configurando o painel invisivel jpInvisibleTop.
		jpInvisibleTop = new JPanel();
		jpInvisibleTop.setBounds(0, 0, 800, 79);
		jpInvisibleTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent event){
				menuBar.setVisible(true);
			}
		});
		jpContent.add(jpInvisibleTop);
		
		// Configurando o painel invisivel jpInvisibleBot.
		jpInvisibleBot = new JPanel();
		jpInvisibleBot.setBounds(0, 0, 800, 629);
		jpInvisibleBot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent event){
				menuBar.setVisible(false);
			}
		});
		jpContent.add(jpInvisibleBot);
	}
}

package gui.telas;

import gui.reusavel.Title;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Eh uma das visoes do painel "baralho" de EditarContratoDialog.
 * Contem uma imagem que da informacoes uteis a respeito do programa.
 * 
 * @author WesleySilva
 *
 */
public class InicioPanel extends JPanel {
	private static final long serialVersionUID = 157896501601L;
	
	// Panels
	private JPanel jpTitle;
	private JPanel jpFolder;
	private JPanel jpMenu;
	
	// ScrollPane
	private JScrollPane scrollableFolderPicture;

	public InicioPanel(final TelaPrincipal telaPrincipal) {
		// Configurando o painel.
		this.setLayout(null);
		this.setOpaque(false);

		// Configurando o painel jpTitle.
		jpTitle = new Title("../../Início.jpg");
		jpTitle.setBounds(0, 0, 800, 80);
		this.add(jpTitle);
		
		// Configurando o painel jpFolder.
		jpFolder = new JPanel();
		jpFolder.setBounds(0, 200, 800, 388);
		this.add(jpFolder);
		
		// Configurando o painel jpMenu.
		jpMenu = new MenuPanel(telaPrincipal.jpPack);
		MenuPanel.btnInicio.setBackground(Color.RED);
		jpMenu.setBounds(0, 90, 800, 100);
		jpMenu.setLayout(null);
		this.add(jpMenu);
		
		// Configurando a imagem.
		ImageIcon folderIcon = new ImageIcon(getClass().getResource("../../Folder.png"));
		ScrollablePicture folderPicture = new ScrollablePicture(folderIcon, 10);
		scrollableFolderPicture = new JScrollPane(folderPicture);
		scrollableFolderPicture.setPreferredSize(new Dimension(780, 380));
		jpFolder.add(scrollableFolderPicture);
	}
}

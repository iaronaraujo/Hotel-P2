package gui.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Representa a barra de menus da tela principal.
 * Contem os menus Programa e Informacao.
 * 
 * @author WesleySilva
 *
 */
public class MenuBar extends JMenuBar{
	private static final long serialVersionUID = 157896501401L;
	
	public MenuBar(){
		JMenu mnPrograma = new JMenu("Programa");
		mnPrograma.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		add(mnPrograma);
		
		JMenuItem mntmSenha = new JMenuItem("Trocar Senha");
		mntmSenha.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 12));
		mnPrograma.add(mntmSenha);
	
		JMenuItem mntmStatus = new JMenuItem("Status");
		mntmStatus.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 12));
		mnPrograma.add(mntmStatus);
	
		JMenuItem mntmLogoff = new JMenuItem("Logoff");
		mntmLogoff.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 12));
		mnPrograma.add(mntmLogoff);
	
		JMenuItem mntmExit = new JMenuItem("Sair");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
			
		});
		mntmExit.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 12));
		mnPrograma.add(mntmExit);
	
		JMenu mnSobre = new JMenu("Informação");
		mnSobre.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		add(mnSobre);
	
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 12));
		mnSobre.add(mntmAbout);
	
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 12));
		mnSobre.add(mntmAjuda);
	}

}

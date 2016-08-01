package gui.reusavel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Title extends JPanel{
	private static final long serialVersionUID = 157896500101L;
	private Image image;
	
	public Title(String path) {
		this.image = new ImageIcon(getClass().getResource(path)).getImage();
	}
		
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}

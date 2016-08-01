package gui.reusavel;

import java.awt.Container;

import javax.swing.JOptionPane;


public class TableError {

	public static void createDialog(Container frame, String message){
		JOptionPane.showMessageDialog(frame, message, "Table Error", JOptionPane.ERROR_MESSAGE);
	}
}

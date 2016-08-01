package gui.reusavel;

import java.awt.Container;

import javax.swing.JOptionPane;


public class FileError {

	public static void createDialog(Container frame, String message){
		JOptionPane.showMessageDialog(frame, message, "File Error", JOptionPane.ERROR_MESSAGE);
	}
}

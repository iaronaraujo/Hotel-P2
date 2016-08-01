package gui.reusavel;

import java.awt.Container;

import javax.swing.JOptionPane;


public class InformationError {

	public static void createDialog(Container frame, String message){
		JOptionPane.showMessageDialog(frame, message, "Information Error", JOptionPane.ERROR_MESSAGE);
	}
}

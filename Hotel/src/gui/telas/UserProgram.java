package gui.telas;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logica.essenciais.Hotel;

public class UserProgram {
	protected static ObjectOutputStream saveFile;
	protected static ObjectInputStream saveFileInput;
	protected static Hotel hotel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try{
					inicializaHotel();
					TelaPrincipal frame = new TelaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void inicializaHotel() {
		File arq = new File("hotel.ser");
		
		if (arq.exists() == false){
			try {
				saveFile = new ObjectOutputStream(new FileOutputStream("hotel.ser"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				hotel = new Hotel("Riviera", "Campina Grande");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				saveFile.writeObject(hotel);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				saveFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				saveFileInput = new ObjectInputStream(new FileInputStream("hotel.ser"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				hotel = (Hotel) saveFileInput.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				saveFileInput.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

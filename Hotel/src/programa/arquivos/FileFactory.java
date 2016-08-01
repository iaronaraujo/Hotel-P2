package programa.arquivos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileFactory {
	public static void saveHotel(Object saveObject, String fileName) throws FileNotFoundException, IOException, Exception {
		ObjectOutputStream outputStream = null;
		
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(saveObject);
			outputStream.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (IOException e) {
			throw new IOException();
		} catch(Exception e) {
			throw new Exception();
		} finally {
			try {
				outputStream.close();
			} catch(NullPointerException e) {
				
			}
		}
	}
}

package programa.documentos;

public class DoubleLock implements Lockable {
	public boolean block(String text) {
		try {
			Double.parseDouble(text);
		} catch(NumberFormatException exception) {
			return true;
		}
		
		return false;
	}	
}

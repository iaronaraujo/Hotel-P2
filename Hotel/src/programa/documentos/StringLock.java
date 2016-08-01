package programa.documentos;

public class StringLock {
	public boolean block(String text) {
		try {
			Integer.parseInt(text);
			Double.parseDouble(text);
		} catch(NumberFormatException exception) {
			return false;
		}
		
		return true;
	}
}

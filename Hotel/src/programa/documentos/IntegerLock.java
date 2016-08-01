package programa.documentos;

public class IntegerLock implements Lockable{
	public boolean block(String text) {
		try {
			Integer.parseInt(text);
		} catch(NumberFormatException exception) {
			System.out.println("Hello world");
			return true;
		}
		
		return false;
	}
}

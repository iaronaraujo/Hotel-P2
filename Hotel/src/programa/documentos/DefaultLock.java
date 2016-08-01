package programa.documentos;

public class DefaultLock implements Lockable{
	public boolean block(String text) {
		return false;
	}
}

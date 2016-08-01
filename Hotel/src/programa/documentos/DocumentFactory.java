package programa.documentos;

/**
 * 
 * @author wesley
 *
 */
public class DocumentFactory {
	/**
	 * 
	 * @param textLimit
	 * @param lock
	 * @return
	 */
	public static LengthedDocument createLengthedDocument(int textLimit, Lockable lock) {
		return new LengthedDocument(textLimit, lock);
	}
	
	/**
	 * 
	 * @param textLimit
	 * @return
	 */
	public static LengthedDocument createLengthedDocument(int textLimit) {
		return new LengthedDocument(textLimit, new DefaultLock());
	}
}

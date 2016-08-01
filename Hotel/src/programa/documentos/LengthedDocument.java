package programa.documentos;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


/**
 * 
 * @author wesley
 *
 */
public class LengthedDocument extends PlainDocument {
	private static final long serialVersionUID = 152834948190488611L;
	
	private int textLimit;
	private Lockable docLock;
	private StringBuilder docText;
	
	/**
	 * 
	 * @param textLimit
	 * @param docLock
	 */
	public LengthedDocument(int textLimit, Lockable docLock) {
		this.textLimit = textLimit;
		this.docLock = docLock;
		this.docText = new StringBuilder();
	}
	
	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		docText.append(this.getText(0, getLength()));
		docText.insert(offset, str);
		int actualSize = this.getLength() + str.length();
		
		if (actualSize <= textLimit && !(docLock.block(docText.toString()))) {
			System.out.println("RODOU COMO?");
			super.insertString(offset, str, attr);
		}
	}
	
	@Override
	public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		docText = new StringBuilder();
		docText.append(this.getText(0, getLength()));
		docText.replace(offset, offset + length, text);
		int actualSize = this.getLength() + text.length();
		
		if (actualSize <= textLimit && !(docLock.block(docText.toString()))) {
			super.replace(offset, length, text, attrs);
		}
	}
}

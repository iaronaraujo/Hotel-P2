package programa.exceptions.entradainvalida;

public class NotaInvalidException extends Exception {
	private static final long serialVersionUID = -9178533722345502039L;

	public NotaInvalidException() {
		super("Nota inválida.");
	}
}

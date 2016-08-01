package programa.exceptions.entradainvalida;

public class DataInvalidException extends Exception {
	private static final long serialVersionUID = 6695216280996296856L;

	public DataInvalidException(String message) {
		super(message);
	}
	
	public DataInvalidException() {
		super("Há campos inválidos ou em branco, preencha-os corretamente antes de continuar.");
	}
}

package programa.exceptions.entradainvalida;

public class CartaoInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 2451650342426377733L;

	public CartaoInvalidException() {
		super("Número do cartão inválido.");
	}
}

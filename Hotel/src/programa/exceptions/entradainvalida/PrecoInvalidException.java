package programa.exceptions.entradainvalida;

public class PrecoInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 2451650342426377733L;

	public PrecoInvalidException() {
		super("O preco não pode ser negativo.");
	}
}

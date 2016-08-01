package programa.exceptions.entradainvalida;

public class EnderecoInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 8627804943536368517L;

	public EnderecoInvalidException() {
		super("Endereço invalido.");
	}
}

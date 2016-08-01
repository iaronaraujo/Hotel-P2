package programa.exceptions.entradainvalida;

public class PlacaInvalidException extends DataInvalidException {
	private static final long serialVersionUID = -2443414766550780479L;

	public PlacaInvalidException() {
		super("Identificação do carro vazia.");
	}
}

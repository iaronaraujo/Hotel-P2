package programa.exceptions.entradainvalida;

public class EstadoInvalidException extends DataInvalidException {
	private static final long serialVersionUID = -3481602725581625409L;

	public EstadoInvalidException() {
		super("Estado do contrato inválido.");
	}
}

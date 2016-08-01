package programa.exceptions.entradainvalida;

public class ServicoInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 8827689939774184356L;

	public ServicoInvalidException() {
		super("Serviço inválido.");
	}
}

package programa.exceptions.entradainvalida;

public class DescricaoInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 8827689939774184356L;

	public DescricaoInvalidException() {
		super("Descrição inválida.");
	}
}

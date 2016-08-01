package programa.exceptions.entradainvalida;

public class DateInvalidException extends DataInvalidException {
	private static final long serialVersionUID = -2443414766550780479L;

	public DateInvalidException() {
		super("Data inválida.");
	}
}

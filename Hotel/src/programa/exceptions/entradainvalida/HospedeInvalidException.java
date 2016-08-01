package programa.exceptions.entradainvalida;

public class HospedeInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 7426127883593410545L;

	public HospedeInvalidException() {
		super("Hospede inválido.");
	}
}

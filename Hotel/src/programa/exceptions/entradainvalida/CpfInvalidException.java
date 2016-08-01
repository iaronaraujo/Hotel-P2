package programa.exceptions.entradainvalida;

public class CpfInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 475851457192161431L;

	public CpfInvalidException() {
		super("Cpf Inválido.");
	}
}

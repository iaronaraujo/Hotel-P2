package programa.exceptions.entradainvalida;

public class NomeInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 7619310812567252572L;

	public NomeInvalidException() {
		super("Nome inválido.");
	}
}

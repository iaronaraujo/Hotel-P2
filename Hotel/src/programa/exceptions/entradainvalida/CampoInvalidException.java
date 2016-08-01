package programa.exceptions.entradainvalida;

public class CampoInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 7619310812567252572L;

	public CampoInvalidException() {
		super("Campo inválido.");
	}
}

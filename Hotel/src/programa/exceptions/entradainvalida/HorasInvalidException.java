package programa.exceptions.entradainvalida;

public class HorasInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 7619310812567252572L;

	public HorasInvalidException() {
		super("Quantidade de horas inválida.");
	}
}

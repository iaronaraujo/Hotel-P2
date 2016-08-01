package programa.exceptions.entradainvalida;

public class ContratoInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 4692551276852852375L;

	public ContratoInvalidException() {
		super("O Contrato Nao Pode Ser Vazio");
	}
}

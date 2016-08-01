package programa.exceptions.entradainvalida;

public class TarifaInvalidException extends DataInvalidException {
	private static final long serialVersionUID = 3427572602728055631L;

	public TarifaInvalidException() {
		super("Tarifa Nao Pode Ser Vazia");
	}
}

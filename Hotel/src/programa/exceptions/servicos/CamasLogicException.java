package programa.exceptions.servicos;


public class CamasLogicException extends ServicoLogicException {
	private static final long serialVersionUID = -9178533722345502039L;

	public CamasLogicException() {
		super("Número de camas extras inválido.");
	}
}

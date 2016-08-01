package programa.exceptions.servicos;

public class ServicoLogicException extends Exception {
	private static final long serialVersionUID = 3852938294840608794L;

	public ServicoLogicException(String message) {
		super(message);
	}
	
	public ServicoLogicException() {
		super("Erro lógico encontrado.");
	}
}	

package programa.exceptions.servicos;

public class BabaLogicException extends ServicoLogicException {
	private static final long serialVersionUID = 7619310812567252572L;

	public BabaLogicException() {
		super("Serviço de babás indisponível no horário especificado.");
	}
}

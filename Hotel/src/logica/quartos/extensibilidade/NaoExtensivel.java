package logica.quartos.extensibilidade;

import java.io.Serializable;

import programa.exceptions.servicos.CamasLogicException;

public class NaoExtensivel extends Extensibilidade implements Serializable {
	private static final long serialVersionUID = -3953349820095222434L;

	public NaoExtensivel() throws CamasLogicException {
		super(0);
	}
	
	@Override
	public void setQuantCamasExtras(int novaQuantidade) throws CamasLogicException {
		throw new CamasLogicException();
	}
}

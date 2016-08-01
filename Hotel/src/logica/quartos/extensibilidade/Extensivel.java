package logica.quartos.extensibilidade;

import java.io.Serializable;

import programa.exceptions.servicos.CamasLogicException;

public class Extensivel extends Extensibilidade implements Serializable {
	private static final long serialVersionUID = 5727061150427394001L;
	
	public Extensivel(int quantCamasExtras) throws CamasLogicException {
		super(quantCamasExtras);
	}
}

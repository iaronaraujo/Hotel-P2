package logica.quartos.tipos;

import java.io.Serializable;

import logica.quartos.extensibilidade.NaoExtensivel;
import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

/**
 * @author Iaron da Costa Araujo
 *
 */
public class QuartoPresidencial extends Quarto implements Serializable {	
	private static final long serialVersionUID = -3962472539709565586L;
	public static final String NOME_DO_QUARTO = "Quarto Presidencial";
	private static double preco = 1200.00;
	
	public QuartoPresidencial() throws CamasLogicException {
		super(4, preco, NOME_DO_QUARTO, new NaoExtensivel());
	}
	
	public static double getPreco() {
		return preco;
	}
	
	public static void setPreco(double novoPreco) throws PrecoInvalidException {
		if (novoPreco < 0) throw new PrecoInvalidException();
		preco = novoPreco;
	}
}

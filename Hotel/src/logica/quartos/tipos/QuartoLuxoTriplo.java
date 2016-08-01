package logica.quartos.tipos;

import java.io.Serializable;

import logica.quartos.extensibilidade.NaoExtensivel;
import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

/**
 * @author Iaron da Costa Araujo
 *
 */
public class QuartoLuxoTriplo extends Quarto implements Serializable {
	private static final long serialVersionUID = -7603826782066177783L;
	public static final String NOME_DO_QUARTO = "Quarto de Luxo Triplo";
	private static double preco = 620.00;
	
	public QuartoLuxoTriplo() throws CamasLogicException {
		super(3, preco, NOME_DO_QUARTO, new NaoExtensivel());
	}
	
	public static double getPreco() {
		return preco;
	}
	
	public static void setPreco(double novoPreco) throws PrecoInvalidException {
		if (novoPreco < 0) throw new PrecoInvalidException();
		preco = novoPreco;
	}
}

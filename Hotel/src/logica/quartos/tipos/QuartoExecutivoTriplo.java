package logica.quartos.tipos;

import java.io.Serializable;

import logica.quartos.extensibilidade.NaoExtensivel;
import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

/**
 * @author Iaron da Costa Araujo
 *
 */
public class QuartoExecutivoTriplo extends Quarto implements Serializable {
	private static final long serialVersionUID = -1366138756801190979L;
	public static final String NOME_DO_QUARTO = "Quarto Executivo Triplo";
	private static double preco = 440.00;
	
	public QuartoExecutivoTriplo()throws CamasLogicException {
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

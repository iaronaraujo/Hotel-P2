package logica.quartos.tipos;

import java.io.Serializable;

import logica.quartos.extensibilidade.Extensivel;
import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

/**
 * @author Iaron da Costa Araujo
 *
 */
public class QuartoLuxoSimples extends Quarto implements Serializable {
	private static final long serialVersionUID = 2831054516611721131L;
	public static final String NOME_DO_QUARTO = "Quarto de Luxo Simples";
	private static double preco = 520.00;
	
	public QuartoLuxoSimples(int qCamasExtras)throws CamasLogicException {
		super(1, preco, NOME_DO_QUARTO, new Extensivel(qCamasExtras));
	}
	
	public static double getPreco() {
		return preco;
	}
	
	public static void setPreco(double novoPreco) throws PrecoInvalidException {
		if (novoPreco < 0) throw new PrecoInvalidException();
		preco = novoPreco;
	}
	
}

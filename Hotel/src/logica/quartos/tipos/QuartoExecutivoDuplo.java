package logica.quartos.tipos;

import java.io.Serializable;

import logica.quartos.extensibilidade.Extensivel;
import programa.exceptions.entradainvalida.PrecoInvalidException;

/**
 * @author Iaron da Costa Araujo
 *
 */
public class QuartoExecutivoDuplo extends Quarto implements Serializable {
	private static final long serialVersionUID = -1023793066158475414L;
	public static final String NOME_DO_QUARTO = "Quarto Executivo Duplo";
	private static double preco = 385.00;
	
	public QuartoExecutivoDuplo(int qCamasExtras)throws Exception {
		super(2, preco, NOME_DO_QUARTO, new Extensivel(qCamasExtras));
	}
	
	public static double getPreco() {
		return preco;
	}
	
	public static void setPreco(double novoPreco) throws PrecoInvalidException {
		if (novoPreco < 0) throw new PrecoInvalidException();
		preco = novoPreco;
	}
}

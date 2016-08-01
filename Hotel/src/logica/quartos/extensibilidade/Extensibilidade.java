package logica.quartos.extensibilidade;

import java.io.Serializable;

import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

public abstract class Extensibilidade implements Serializable {  
	private static final long serialVersionUID = -464862187804296618L;
	public static final int MAXIMO_CAMAS_EXTRAS = 2;
	public static final int MINIMO_CAMAS_EXTRAS = 0;
	private static double precoCama = 100.00;
	
	private int quantCamasExtras;
	
	public Extensibilidade(int quantCamasExtras) throws CamasLogicException {
		checkQuantDeCamas(quantCamasExtras);
		this.quantCamasExtras = quantCamasExtras;
	}
	
	public void setQuantCamasExtras(int novaQuantidade) throws CamasLogicException {
		checkQuantDeCamas(novaQuantidade);
		this.quantCamasExtras = novaQuantidade;
	}
	
	public int getQuantCamasExtras() {
		return quantCamasExtras;
	}
	
	private void checkQuantDeCamas(int quantidade) throws CamasLogicException {
		if (quantidade < MINIMO_CAMAS_EXTRAS || quantidade > MAXIMO_CAMAS_EXTRAS) {
			throw new CamasLogicException();
		}
	}
	
	public static double getPrecoCamaExtra() {
		return precoCama;
	}
	
	public static void setPrecoCamaExtras(double novoPreco) throws PrecoInvalidException {
		if (novoPreco < 0) throw new PrecoInvalidException();
		precoCama = novoPreco;
	}
}

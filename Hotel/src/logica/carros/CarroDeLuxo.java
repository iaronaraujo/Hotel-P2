package logica.carros;

import java.io.Serializable;

import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.PrecoInvalidException;

public class CarroDeLuxo extends Carro implements Serializable {
	private static final long serialVersionUID = -1384509321721441835L;
	public static final String TIPO_DO_CARRO = "Carro de Luxo";
	private static double preco = 100.00;
	
	public CarroDeLuxo(String placa) throws DataInvalidException {
		super(placa, preco, TIPO_DO_CARRO);
	}
	
	public static double getPreco() {
		return preco;
	}
	
	public static void setPreco(double novoPreco) throws PrecoInvalidException {
		if (novoPreco < 0) throw new PrecoInvalidException();
		preco = novoPreco;
	}
}

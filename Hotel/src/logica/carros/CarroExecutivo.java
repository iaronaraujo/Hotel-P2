package logica.carros;

import java.io.Serializable;

import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.PrecoInvalidException;

/**
 * 
 * @author Iaron da Costa Araujo
 *
 */
public class CarroExecutivo extends Carro implements Serializable {
	private static final long serialVersionUID = -8806777390869363747L;
	public static final String TIPO_DO_CARRO = "Carro Executivo";
	private static double preco = 60.00;
	
	public CarroExecutivo(String placa) throws DataInvalidException {
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

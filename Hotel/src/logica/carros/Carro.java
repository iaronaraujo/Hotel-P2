package logica.carros;

import java.io.Serializable;

import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.PlacaInvalidException;
import programa.formatos.FormatFactory;

public abstract class Carro implements Serializable {
	private static final long serialVersionUID = 3183548408319998303L;
	
	private double diaria;
	private String tipoCarro;
	private String placa;

	public Carro(String placa, double preco, String tipoCarro) throws DataInvalidException {
		// Checando valores
		checkPlaca(placa);
		
		// Inicializando atributos
		this.tipoCarro = tipoCarro;
		this.diaria = preco;
		this.placa = placa;
	}
	
	public double getDiaria() {
		return diaria;
	}

	public String getTipo() {
		return tipoCarro;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	private void checkPlaca(String placa) throws PlacaInvalidException {
		if (!FormatFactory.validateString(placa)) throw new PlacaInvalidException();
	}
}

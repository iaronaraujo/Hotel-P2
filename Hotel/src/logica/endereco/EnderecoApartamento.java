package logica.endereco;

import java.io.Serializable;

import programa.exceptions.entradainvalida.EnderecoInvalidException;
import programa.formatos.FormatFactory;

public class EnderecoApartamento extends Endereco implements Serializable {
	private static final long serialVersionUID = -1883268987035432412L;
	
	private String apt;
	
	public EnderecoApartamento(String pais, String cidade, String bairro, String rua, int num, String apt) throws EnderecoInvalidException, EnderecoInvalidException {
		super(pais, cidade, bairro, rua, num);
		
		// Checando valores
		checkApt(apt);
		
		// Inicializando atributos
		this.apt = apt;
	}
	
	public String getApt() {
		return apt;
	}
	
	public void setApt(String novoApt) throws EnderecoInvalidException {
		checkApt(apt);
		this.apt = novoApt;
	}
	
	private void checkApt(String apt) throws EnderecoInvalidException {
		if (!FormatFactory.validateString(apt)) throw new EnderecoInvalidException();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EnderecoApartamento)) return false;
		EnderecoApartamento enderecoTemp = (EnderecoApartamento) obj;
		
		if (enderecoTemp.getApt().equals(this.apt) && super.equals(enderecoTemp)) return true; 
		return false;
	}
}

package logica.endereco;

import java.io.Serializable;

import programa.exceptions.entradainvalida.EnderecoInvalidException;

public class EnderecoCasa extends Endereco implements Serializable {
	private static final long serialVersionUID = -6740261146675214587L;

	public EnderecoCasa(String pais, String cidade, String bairro, String rua, int num) throws EnderecoInvalidException, EnderecoInvalidException {
		super(pais, cidade, bairro, rua, num);
	}


	@Override
	public String getApt() {
		return null;
	}


	@Override
	public void setApt(String novoApt) throws EnderecoInvalidException {
		throw new EnderecoInvalidException();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EnderecoCasa)) return false;
		EnderecoCasa enderecoTemp = (EnderecoCasa) obj;
		
		if (super.equals(enderecoTemp)) return true; 
		return false;
	}
	
	
}

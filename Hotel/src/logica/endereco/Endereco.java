package logica.endereco;

import java.io.Serializable;

import programa.exceptions.entradainvalida.EnderecoInvalidException;
import programa.formatos.FormatFactory;

public abstract class Endereco implements Serializable {
	private static final long serialVersionUID = -6740261146675214587L;
	
	private String cidade;
	private String bairro;
	private String pais;
	private String rua;
	private int num;
	
	public Endereco(String pais, String cidade, String bairro, String rua, int num) throws EnderecoInvalidException, EnderecoInvalidException {
		// Checando valores
		checkCampo(cidade);
		checkCampo(bairro);
		checkCampo(pais);
		checkCampo(rua);
		checkNum(num);
		
		// Inicializando os atributos
		this.cidade = cidade;
		this.pais = pais;
		this.bairro = bairro;
		this.rua = rua;
		this.num = num;
	}
	
	public String getPais(){
		return pais;
	}
	
	public void setPais(String novoPais)throws EnderecoInvalidException {
		checkCampo(novoPais);
		this.pais = novoPais;
	}
	
	public String getCidade(){
		return cidade;
	}
	
	public void setCidade(String novaCidade) throws EnderecoInvalidException {
		checkCampo(novaCidade);
		cidade = novaCidade;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String novaRua) throws Exception{
		checkCampo(novaRua);
		rua = novaRua;
	}
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int novoNum)throws Exception{
		checkNum(novoNum);
		num = novoNum;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String novoBairro) throws EnderecoInvalidException {
		checkCampo(novoBairro);
		this.bairro = novoBairro;
	}
	
	private void checkCampo(String campoEndereco) throws EnderecoInvalidException {
		if (!FormatFactory.validateString(campoEndereco)) throw new EnderecoInvalidException();
	}
	
	private void checkNum(int num) throws EnderecoInvalidException {
		if (num < 0) throw new EnderecoInvalidException();
	}
	
	public abstract String getApt();
	
	public abstract void setApt(String novoApt) throws EnderecoInvalidException;
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco)) return false;
		Endereco enderecoTemp = (Endereco) obj;
		
		if (enderecoTemp.getCidade().equals(this.cidade) &&
			enderecoTemp.getPais().equals(this.pais) &&
			enderecoTemp.getBairro().equals(this.bairro) &&
			enderecoTemp.getRua().equals(this.rua) &&
			enderecoTemp.getNum() == this.num) { 
			return true; 
		}
		
		return false;
	}
	
}

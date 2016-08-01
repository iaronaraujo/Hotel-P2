package logica.utilitarios;

import programa.exceptions.entradainvalida.NomeInvalidException;
import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.formatos.FormatFactory;

public class Prato {
	
	private String nome;
	private double preco;
	
	public Prato(String nome, double preco) throws Exception{
		// Checando valores
		checkNome(nome);
		checkPreco(preco);
		
		// Inicializando atributos
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String novoNome)throws NomeInvalidException {
		checkNome(novoNome);
		this.nome = novoNome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double novoPreco) throws PrecoInvalidException{
		checkPreco(novoPreco);
		this.preco = novoPreco;
	}
	
	private void checkNome(String nome) throws NomeInvalidException {
		if (!FormatFactory.validateString(nome)) throw new NomeInvalidException();
	}
	
	private void checkPreco(double preco) throws PrecoInvalidException {
		if (preco < 0) throw new PrecoInvalidException();
	}
}

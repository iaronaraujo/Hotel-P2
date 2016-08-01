package logica.quartos.tipos;

import java.io.Serializable;

import logica.quartos.extensibilidade.Extensibilidade;
import programa.exceptions.servicos.CamasLogicException;

/**
 * 
 * @author Iaron da Costa Araujo
 *
 */
public abstract class Quarto implements Serializable {
	private static final long serialVersionUID = -3407360600381870720L;
	
	private Extensibilidade extensibilidade;
	private String nomeDoQuarto;
	private double precoDiaria;
	private int capacidade;

	public Quarto(int capacidade, double preco, String nomeDoQuarto, Extensibilidade extensibilidade) {
		this.extensibilidade = extensibilidade;
		this.nomeDoQuarto = nomeDoQuarto;
		this.capacidade = capacidade;
		this.precoDiaria = preco;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public double getPrecoDiaria() {
		return precoDiaria + (extensibilidade.getQuantCamasExtras() * Extensibilidade.getPrecoCamaExtra());
	}

	public String getNome() {
		return nomeDoQuarto;
	}
	
	public int getQuantCamasExtras() {
		return extensibilidade.getQuantCamasExtras();
	}
	
	public void setQuantCamasExtras(int novaQuantidade) throws CamasLogicException {
		extensibilidade.setQuantCamasExtras(novaQuantidade);
	}
}

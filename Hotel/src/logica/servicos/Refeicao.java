package logica.servicos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import logica.utilitarios.Prato;
import programa.exceptions.entradainvalida.DescricaoInvalidException;
import programa.exceptions.entradainvalida.PratosInvalidException;
import programa.exceptions.entradainvalida.ServicoInvalidException;
import programa.formatos.FormatFactory;

public class Refeicao implements Servico, Serializable {
	private static final long serialVersionUID = 8250402736448036334L;
	public static final String TIPO_SERVICO = "Refeição";
	private static int quantidade = 0;
	
    private List<Prato> pratos;
    private String descricao;

    public Refeicao(ArrayList<Prato> pratos, String descricao) throws Exception {
    	// Checando valores
    	checkDescricao(descricao);
    	checkPratos(pratos);
    	
    	// Inicializando atributos
    	this.descricao = descricao;
    	this.pratos = pratos;
    	// Era pra quantidade ser incrementada aqui?
    }

    public double calculaPreco() {
    	double conta = 0.0;
        for(Prato p : pratos){
        	conta += p.getPreco();
        }
        return conta;
    }
    
    public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) throws DescricaoInvalidException {
		if (!FormatFactory.validateString(descricao)) throw new DescricaoInvalidException();
		this.descricao = descricao;
	}
	
	public String getTipo(){
		return TIPO_SERVICO;
	}

    @Deprecated
    public void addQuantidade(){
		quantidade++;
	}
    
    @Deprecated
	public int getQuantidade(){
		return quantidade;
	}
    
    @Deprecated
	public void decrementaQuantidade(){
		quantidade--;
	}
    
    private void checkPratos(List<Prato> pratos) throws PratosInvalidException {
    	if (pratos == null || pratos.isEmpty()) throw new PratosInvalidException();
    }
    
    private void checkDescricao(String descricao) throws ServicoInvalidException {
    	if (!FormatFactory.validateString(descricao)) throw new ServicoInvalidException();
    }
}

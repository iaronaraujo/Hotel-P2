package logica.servicos;

import java.io.Serializable;

import logica.carros.Carro;
import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.entradainvalida.ServicoInvalidException;
import programa.formatos.FormatFactory;

public class AluguelDeCarro implements Servico, Serializable {
	private static final long serialVersionUID = 7231864226531431436L;
	public static final String TIPO_SERVICO = "Aluguel de carro";
	private static double precoTanqueCheio = 150.00;
	private static double precoDeSeguro = 100.00;
	private static int quantidade = 0;

    private boolean isTanqueCheio;
    private Carro carroAlugado;
    private int diasDeAluguel;
    private boolean temSeguro;
	private String descricao;

	public AluguelDeCarro(Carro carroAlugado, int diasDeAluguel, boolean isTanqueCheio, boolean temSeguro, String descricao) throws ServicoInvalidException {
        // Checando valores
    	checkDiasDeAluguel(diasDeAluguel);
    	checkDescricao(descricao);
        checkCarro(carroAlugado); 

        // Inicializando atributos
        this.diasDeAluguel = diasDeAluguel;
        this.isTanqueCheio = isTanqueCheio;
        this.carroAlugado = carroAlugado;
        this.temSeguro = temSeguro;
        this.descricao = descricao;
    }

    public double calculaPreco() { // REVER
        double total = carroAlugado.getDiaria() * diasDeAluguel;
        if (isTanqueCheio) total += precoTanqueCheio;
        if (temSeguro) total += precoDeSeguro;
        return total;
    }

	public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String novaDescricao) throws ServicoInvalidException {
        checkDescricao(novaDescricao);
        this.descricao = novaDescricao;
    }

    public Carro getCarroAlugado() {
        return carroAlugado;
    }
    
    public void setCarroAlugado(Carro novoCarroAlugado) throws ServicoInvalidException {
    	checkCarro(novoCarroAlugado);
		this.carroAlugado = novoCarroAlugado;
	}

	public boolean isTanqueCheio() {
		return isTanqueCheio;
	}
	
	public void setTanqueCheio(boolean valor) {
		this.isTanqueCheio = valor;
	}

	public boolean temSeguro() {
		return temSeguro;
	}
	
	public void setTemSeguro(boolean valor) {
		this.temSeguro = valor;
	}
	
	public String getTipo() {
		return carroAlugado.getTipo();
	}
	
    private void checkCarro(Carro carro) throws ServicoInvalidException {
    	if (carro == null) throw new ServicoInvalidException();
    }
    
    private void checkDescricao(String campo) throws ServicoInvalidException {
    	if (!FormatFactory.validateString(campo)) throw new ServicoInvalidException();
    }
    
    private void checkDiasDeAluguel(int dias) throws ServicoInvalidException {
    	if (dias <= 0) throw new ServicoInvalidException();
    }
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof AluguelDeCarro)) return false;
		AluguelDeCarro a = (AluguelDeCarro)obj;
		
		if (a.getDescricao().equals(this.getDescricao()) && 
			a.getTipo().equals(this.getTipo())) {
			return true;
		}
		
		return false;
	}
	
	public static double getPrecoSeguro() {
		return precoDeSeguro;
	}
	
	public static void setPrecoSeguro(double novoPreco) throws PrecoInvalidException {
		if (novoPreco < 0) throw new PrecoInvalidException();
		precoDeSeguro = novoPreco;
	}
	
	public static double getPrecoTanqueCheio() {
		return precoTanqueCheio;
	}
	
	public static void setPrecoTanqueCheio(double novoPreco) throws PrecoInvalidException {
		if (novoPreco < 0) throw new PrecoInvalidException();
		precoTanqueCheio = novoPreco;
	}
	
	@Deprecated
	public void addQuantidade() {
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
}

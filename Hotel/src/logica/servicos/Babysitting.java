package logica.servicos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import logica.utilitarios.Baba;
import logica.utilitarios.GerenciadorDePrecos;
import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.DateInvalidException;
import programa.exceptions.entradainvalida.DescricaoInvalidException;
import programa.exceptions.entradainvalida.HorasInvalidException;
import programa.exceptions.servicos.BabaLogicException;
import programa.exceptions.servicos.ServicoLogicException;
import programa.formatos.FormatFactory;

public class Babysitting implements Servico, Serializable {
	private static final long serialVersionUID = 3620296217675383591L;
    public static final String TIPO_SERVICO = "Babysitting";
	private static int quantidade = 0;
    private static ArrayList<Baba> babas = new ArrayList<Baba>();
	
    private GregorianCalendar horaInicial;
    private GregorianCalendar horaFinal;
    private int quantidadeHoras;
    private String descricao;
    private Baba baba;

   
    public Babysitting(GregorianCalendar horaInicial, int quantidadeHoras, String descricao) throws DataInvalidException, ServicoLogicException {
    	// Checando valores
    	checkQuantHoras(quantidadeHoras);
    	checkHoraInicial(horaInicial);
    	checkDescricao(descricao);
    	
    	// Inicializando atributos
    	this.quantidadeHoras = quantidadeHoras;
    	this.horaInicial = horaInicial;
    	this.descricao = descricao;
    	this.baba = getBabaDisponivel();
    	this.horaFinal = new GregorianCalendar(horaInicial.get(Calendar.YEAR),
											   horaInicial.get(Calendar.MONTH), 
											   horaInicial.get(Calendar.DAY_OF_MONTH), 
											   horaInicial.get(Calendar.HOUR_OF_DAY) + quantidadeHoras, 
											   FormatFactory.DEFAULT_INT);
    }
    
    public static void addBaba(Baba baba){
    	babas.add(baba);
    }
    public static void removeBaba(Baba baba){
    	babas.remove(baba);
    }
     
	public String getDescricao() {
        return descricao;
    }
	
	public void setDescricao(String novaDescricao) throws DescricaoInvalidException {
		checkDescricao(novaDescricao);
        this.descricao = novaDescricao;
    }
    
    private Baba getBabaDisponivel() throws BabaLogicException {
    	for(Baba b : babas){
    		if(b.addHorario(horaInicial, quantidadeHoras)){
    			return b;  			
    		}
    	}
    	
    	throw new BabaLogicException();
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
	
    @Override
	public double calculaPreco() {
		int hora = horaInicial.get(Calendar.HOUR_OF_DAY);
		int horaFim;
		if((hora + quantidadeHoras) >= 24){
			horaFim = hora + quantidadeHoras - 24;
		} else{
			horaFim = hora + quantidadeHoras;
		}
		
		double totalPagar = 0.0;
		while(hora != horaFim){
			if(hora >= 7 && hora < 18){
				totalPagar += 25.00;
			} else {
				totalPagar += 50.00;
			}
			hora++;
			if(hora == 24) hora = 0;
		}
		
		return totalPagar;
		
	}
	
	public String getTipo(){
		return TIPO_SERVICO;
	}
	
	public String getNomeBaba(){
		return baba.getNome();
	}
	
    private void checkHoraInicial(GregorianCalendar hora) throws DateInvalidException {
    	if (hora == null) throw new DateInvalidException();
    }
    
    private void checkDescricao(String descricao) throws DescricaoInvalidException {
    	if (!FormatFactory.validateString(descricao)) throw new DescricaoInvalidException(); 
    }
    
    private void checkQuantHoras(int qHoras) throws HorasInvalidException {
    	if (qHoras <= 0 || qHoras > 12) throw new HorasInvalidException();
    }
	
	public boolean equals(Object obj){
		return obj instanceof Babysitting;
	}
}

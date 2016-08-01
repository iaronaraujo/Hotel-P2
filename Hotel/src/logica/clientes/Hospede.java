package logica.clientes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.DateInvalidException;
import programa.exceptions.entradainvalida.NomeInvalidException;
import programa.formatos.FormatFactory;

public class Hospede implements Serializable {
	private static final long serialVersionUID = 7147743590612866355L;
	private GregorianCalendar dataDeNascimento;
    private String nome;

    public Hospede(String nome, GregorianCalendar dataDeNascimento) throws DataInvalidException {
    	// Checando valores
    	checkNome(nome);
    	checkDataDeNascimento(dataDeNascimento);
    	
    	// Inicializando atributos
    	this.nome = nome;
    	this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String novoNome) throws NomeInvalidException {
    	checkNome(novoNome);
		this.nome = novoNome;
	}

    public GregorianCalendar getDataDeNascimento() {
        return new GregorianCalendar(dataDeNascimento.get(Calendar.YEAR), dataDeNascimento.get(Calendar.MONTH), dataDeNascimento.get(Calendar.DAY_OF_MONTH));
    }
    
	public void setDataDeNascimento(GregorianCalendar novaData) throws DateInvalidException {
		checkDataDeNascimento(novaData);		
		this.dataDeNascimento = novaData;
	}
	
	private void checkNome(String nome) throws NomeInvalidException {
    	if (!FormatFactory.validateString(nome)) throw new NomeInvalidException();
    }
    
    private void checkDataDeNascimento(GregorianCalendar dataDeNascimento) throws DateInvalidException {
    	if (dataDeNascimento == null) throw new DateInvalidException();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Hospede)) return false;
        Hospede hospTemp = (Hospede) obj;
        
        if (hospTemp.getNome().equals(nome)) return true;
        return false;
    }
}

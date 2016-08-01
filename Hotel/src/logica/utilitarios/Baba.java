package logica.utilitarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import programa.formatos.FormatFactory;

public class Baba implements Serializable {
	private static final long serialVersionUID = -7609245306170470337L;
	
	private List<GregorianCalendar> horariosInicio, horariosFins;
	private String nome;
	
	public Baba(String nome){
		this.nome = nome;
		horariosInicio = new ArrayList<GregorianCalendar>();
		horariosFins = new ArrayList<GregorianCalendar>();
	}
	
	public String getNome(){
		return nome;
	}
	public List<GregorianCalendar> getHorariosInicio() {
		return horariosInicio;
	}

	public List<GregorianCalendar> getHorariosFins() {
		return horariosFins;
	}
	
    private boolean isDisponivel(GregorianCalendar horaInicial, GregorianCalendar horaFinal){
    	for (int i = 0; i < this.getHorariosInicio().size(); i++) {    		
    		
    		if(horaInicial.compareTo(this.getHorariosFins().get(i)) >= 0 ||
    				horaFinal.compareTo(this.getHorariosInicio().get(i)) <= 0){
    			continue;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
    
    public boolean addHorario(GregorianCalendar horaInicial, int quantidadeHoras){
    	
    	GregorianCalendar horaFinal = new GregorianCalendar(horaInicial.get(Calendar.YEAR), 
				horaInicial.get(Calendar.MONTH), 
				horaInicial.get(Calendar.DAY_OF_MONTH), 
				horaInicial.get(Calendar.HOUR_OF_DAY) + quantidadeHoras,
				FormatFactory.DEFAULT_INT);
    	
    	if(isDisponivel(horaInicial, horaFinal)){
    		this.getHorariosInicio().add(horaInicial);
    		this.getHorariosFins().add(horaFinal);
    		return true;
    	} else{
    		return false;
    	}
    }
	
	public boolean equals(Object obj){
		if(!(obj instanceof Baba)) return false;
		Baba b =(Baba)obj;
		if(nome.equals(b.getNome())){
			return true;
		}else{
			return false;
		}
	}


}

package logica.utilitarios;

import java.io.Serializable;

import programa.exceptions.entradainvalida.NotaInvalidException;

public class Opiniao implements Serializable{
	private static final long serialVersionUID = -2276353694203554176L;
	
	private String comentario;
	private double nota;
	
	public Opiniao(String comentario, double nota) throws Exception{
		// Checando valores
		check(nota);
		
		// Inicializando atributos
		this.comentario = comentario;
		this.nota = nota;
	}
	
	public String getComentario(){
		return comentario;
	}

	public void setComentario(String novoComentario) {
		comentario = novoComentario;
	}
	
	public double getNota(){
		return nota;
	}
	
	public void setNota(double novaNota) throws NotaInvalidException {
		check(novaNota);
		nota = novaNota;
	}
	
	private void check(double nota) throws NotaInvalidException {
		if (nota < 0 || nota > 10) throw new NotaInvalidException();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Opiniao)) return false;
		Opiniao opiniaoTemp = (Opiniao) obj;
		
		if (opiniaoTemp.getComentario().equals(this.comentario) &&
			opiniaoTemp.getNota() == this.nota) {
			return true;
		}
		
		return false;
	}
}

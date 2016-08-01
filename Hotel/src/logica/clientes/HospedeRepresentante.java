package logica.clientes;

import java.io.Serializable;
import java.util.GregorianCalendar;

import logica.endereco.Endereco;
import programa.exceptions.entradainvalida.CpfInvalidException;
import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.EnderecoInvalidException;
import programa.formatos.FormatFactory;

public class HospedeRepresentante extends Hospede implements Serializable {
	private static final long serialVersionUID = -8076165237174994495L;
	
	private Endereco endereco;
    private String cpf;
	
    public HospedeRepresentante(String nome, GregorianCalendar dataDeNascimento, String cpf,  Endereco enderecoDeResidencia) throws DataInvalidException {
    	super(nome, dataDeNascimento);
		
		// Checando valores
		checkCpf(cpf);
		checkEndereco(enderecoDeResidencia);
		
		// Inicializando atributos
        this.cpf = cpf;
        this.endereco = enderecoDeResidencia;
   }

   public Endereco getEndereco() {
       return endereco;
   }
   
   public void setEnderecoDeResidencia(Endereco novoEndereco) throws EnderecoInvalidException {
	   checkEndereco(novoEndereco);
	   this.endereco = novoEndereco;
   }
	
   public String getCpf() {
	   return cpf;
   }
   
   public void setCpf(String novoCpf) throws CpfInvalidException {
	   checkCpf(novoCpf);
	   this.cpf = novoCpf;
   }

   private void checkCpf(String cpf) throws CpfInvalidException {		
	   if (!(FormatFactory.validateStringReverse(cpf)) || cpf.length() < FormatFactory.CPF_TAMANHO) throw new CpfInvalidException();
   }
	
   private void checkEndereco(Endereco endereco) throws EnderecoInvalidException{
	   if (endereco == null) throw new EnderecoInvalidException();
   }
	
   @Override
   public boolean equals(Object obj) {
	   if (! (obj instanceof HospedeRepresentante)) return false;
	   HospedeRepresentante hospTemp = (HospedeRepresentante) obj;
		
	   if (super.equals(hospTemp) && hospTemp.getCpf().equals(this.cpf)) return true;
	   return false;
	}
	
}

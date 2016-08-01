package testes;

import logica.endereco.EnderecoApartamento;
import logica.endereco.EnderecoCasa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.EnderecoInvalidException;

public class TestaEnderecoApartamento {
	private EnderecoCasa end1;
	private EnderecoApartamento end2, end3;
	
	@Before
	public void criaObjs() throws EnderecoInvalidException{
		end1 = new EnderecoCasa("Brasil", "Campina", "Catole", "ABC", 1);
		end2 = new EnderecoApartamento("Brasil", "Campina", "Catole", "ABC", 1,"2");
		end3 = new EnderecoApartamento("Brasil", "Campina", "Catole", "ABC", 1, "30");
	}
	
	@Test
	public void testaEquals() throws EnderecoInvalidException{
		Assert.assertFalse(end2.equals(end3));
		end3.setApt("2");
		Assert.assertTrue(end2.equals(end3));
		Assert.assertFalse(end2.equals(end1));
	}

}

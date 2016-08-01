package testes;

import logica.endereco.EnderecoApartamento;
import logica.endereco.EnderecoCasa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.EnderecoInvalidException;

public class TestaEnderecoCasa {
	
	private EnderecoCasa end1, end2;
	private EnderecoApartamento end3;
	
	@Before
	public void criaObjs() throws EnderecoInvalidException{
		end1 = new EnderecoCasa("Brasil", "Campina", "Catole", "ABC", 1);
		end2 = new EnderecoCasa("Brasil", "Campina", "Catole", "ABC", 2);
		end3 = new EnderecoApartamento("Brasil", "Campina", "Catole", "ABC", 1, "30");
	}
	
	@Test
	public void testaConstrutor(){
		try{
			new EnderecoCasa("    ", "Campina", "Catole", "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		try{
			new EnderecoCasa("", "Campina", "Catole", "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		try{
			new EnderecoCasa(null, "Campina", "Catole", "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		
		try{
			new EnderecoCasa("Brasil", "   ", "Catole", "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}

		try{
			new EnderecoCasa("Brasil", "", "Catole", "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}

		try{
			new EnderecoCasa("Brasil", null, "Catole", "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		

		try{
			new EnderecoCasa("Brasil", "Campina", "   ", "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}

		try{
			new EnderecoCasa("Brasil", "Campina", "", "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}

		try{
			new EnderecoCasa("Brasil", "Campina", null, "ABC", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		

		try{
			new EnderecoCasa("Brasil", "Campina", "Catole", "   ", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		try{
			new EnderecoCasa("Brasil", "Campina", "Catole", "", 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		try{
			new EnderecoCasa("Brasil", "Campina", "Catole", null, 12);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		
		try{
			new EnderecoCasa("Brasil", "Campina", "Catole", "ABC", -1);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		try{
			new EnderecoCasa("Brasil", "Campina", "Catole", "ABC", -10);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		try{
			new EnderecoCasa("Brasil", "Campina", "Catole", "ABC", -235);
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testaSet(){
		try{
			end1.setApt("12");
			Assert.fail();
		} catch(EnderecoInvalidException e){
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testaEquals() throws Exception{
		Assert.assertFalse(end1.equals(end2));
		end2.setNum(1);
		Assert.assertTrue(end1.equals(end2));
		Assert.assertFalse(end1.equals(end3));
		
	}
	

}

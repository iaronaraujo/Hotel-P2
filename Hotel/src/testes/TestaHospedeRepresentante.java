package testes;

import java.util.GregorianCalendar;

import logica.clientes.Hospede;
import logica.clientes.HospedeRepresentante;
import logica.endereco.EnderecoCasa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.EnderecoInvalidException;

public class TestaHospedeRepresentante {
	private GregorianCalendar dataNasc;
	private Hospede hosp1;
	private HospedeRepresentante hosp2, hosp3, hosp4, hosp5, hosp6;
	private EnderecoCasa end1;
	
	@Before
	public void criaObjs() throws DataInvalidException{
		end1 = new EnderecoCasa("Brasil", "Campina", "Catole", "ABC", 1);
		dataNasc = new GregorianCalendar(1996, 2, 2);
		hosp1 = new Hospede("Maria", dataNasc);
		hosp2 = new HospedeRepresentante("Maria", dataNasc,"123.456.789-01", end1);
		hosp3 = new HospedeRepresentante("Maria", dataNasc,"123.456.789-01", end1);
		hosp4 = new HospedeRepresentante("Joao", dataNasc,"123.456.789-01", end1);
		hosp5 = new HospedeRepresentante("Maria", dataNasc,"123.456.789-02", end1);
		hosp6 = new HospedeRepresentante("Joao", dataNasc,"123.456.789-02", end1);
	}
	
	@Test
	public void testaConstrutor(){
		try{
			new HospedeRepresentante("Maria", dataNasc, "123.456.789-01", null);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Endereço invalido.", e.getMessage());
		}
		
		try{
			new HospedeRepresentante("Maria", dataNasc, "", end1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Cpf Inválido.", e.getMessage());
		}
		try{
			new HospedeRepresentante("Maria", dataNasc, null, end1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Cpf Inválido.", e.getMessage());
		}
		try{
			new HospedeRepresentante("Maria", dataNasc, "12345678901", end1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Cpf Inválido.", e.getMessage());
		}
		try{
			new HospedeRepresentante("Maria", dataNasc, "012. 58.589-85", end1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Cpf Inválido.", e.getMessage());
		}
	}
	
	@Test
	public void testaEquals(){
		Assert.assertFalse(hosp2.equals(hosp1));
		Assert.assertFalse(hosp2.equals(hosp4));
		Assert.assertFalse(hosp2.equals(hosp5));
		Assert.assertFalse(hosp2.equals(hosp6));
		Assert.assertTrue(hosp2.equals(hosp3));
	}

}

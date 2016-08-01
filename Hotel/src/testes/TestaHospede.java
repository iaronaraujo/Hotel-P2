package testes;

import java.util.GregorianCalendar;

import logica.clientes.Hospede;
import logica.clientes.HospedeRepresentante;
import logica.endereco.EnderecoCasa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.NomeInvalidException;

public class TestaHospede {
	private GregorianCalendar dataNasc;
	private Hospede hosp1, hosp2, hosp3, hosp4;
	private EnderecoCasa end1;
	
	@Before
	public void criaObjs() throws DataInvalidException{
		end1 = new EnderecoCasa("Brasil", "Campina", "Catole", "ABC", 1);
		dataNasc = new GregorianCalendar(1996, 2, 2);
		hosp1 = new Hospede("Joao", dataNasc);
		hosp2 = new Hospede("Joao", dataNasc);
		hosp3 = new Hospede("Maria", dataNasc);
		hosp4 = new HospedeRepresentante("Maria", dataNasc,"123.456.789-01", end1);
	}
	
	@Test
	public void testaConstrutor(){
		
		try{
			new Hospede("", dataNasc);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try{
			new Hospede("        ", dataNasc);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try{
			new Hospede(null, dataNasc);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		
		try{
			new Hospede("Joao", null);
			Assert.fail();
		} catch(DataInvalidException e){
			Assert.assertEquals("Data inválida.", e.getMessage());
		}
	}
	
	@Test
	public void testaEquals(){
		Assert.assertTrue(hosp1.equals(hosp2));
		Assert.assertFalse(hosp1.equals(hosp3));
		Assert.assertFalse(hosp3.equals(hosp4));
	}
	

}

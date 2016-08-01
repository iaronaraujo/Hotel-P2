package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.*;
import logica.carros.*;

public class TestaCarro {
	
	
	@Test
	public void testaConstrutor(){
		try{
			new CarroExecutivo("    ");
			Assert.fail();
		} catch (DataInvalidException e){
			Assert.assertEquals("Identificação do carro vazia.", e.getMessage());
		}
		try{
			new CarroExecutivo("              ");
			Assert.fail();
		} catch (DataInvalidException e){
			Assert.assertEquals("Identificação do carro vazia.", e.getMessage());
		}
		try{
			new CarroExecutivo(null);
			Assert.fail();
		} catch (DataInvalidException e){
			Assert.assertEquals("Identificação do carro vazia.", e.getMessage());
		}
	}
	
	@Test
	public void testaGets()throws DataInvalidException{
		CarroExecutivo ce = new CarroExecutivo("ABC1234");
		CarroDeLuxo cl = new CarroDeLuxo("ABD1234");
		
		Assert.assertEquals(60.00, ce.getDiaria(),0.0001);
		Assert.assertEquals("ABC1234", ce.getPlaca());
		Assert.assertEquals("Carro Executivo", ce.getTipo());
		
		Assert.assertEquals(100.00, cl.getDiaria(),0.0001);
		Assert.assertEquals("ABD1234", cl.getPlaca());
		Assert.assertEquals("Carro de Luxo", cl.getTipo());
		
		
	}

}

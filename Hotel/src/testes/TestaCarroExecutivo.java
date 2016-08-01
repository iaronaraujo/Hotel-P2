package testes;

import logica.carros.CarroExecutivo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.DataInvalidException;

public class TestaCarroExecutivo {
	
	@Test
	public void testaPrecos() throws DataInvalidException{
		CarroExecutivo c1 = new CarroExecutivo("A");
		
		Assert.assertEquals(60.00, c1.getDiaria(),0.0001);
		Assert.assertEquals("A", c1.getPlaca());
		Assert.assertEquals("Carro Executivo", c1.getTipo());
		
		Assert.assertEquals(60.00, CarroExecutivo.getPreco(),0.0001);
		
		try{
			CarroExecutivo.setPreco(-120);
			Assert.fail();
		} catch(DataInvalidException e){
			Assert.assertEquals("O preco não pode ser negativo.", e.getMessage());
		}
		
		Assert.assertEquals(60.00, CarroExecutivo.getPreco(),0.0001);
		CarroExecutivo.setPreco(80);
		Assert.assertEquals(80.00, CarroExecutivo.getPreco(),0.0001);
		
		CarroExecutivo c2 = new CarroExecutivo("B");
		Assert.assertEquals(80.00, c2.getDiaria(),0.0001);
		Assert.assertEquals(60.00, c1.getDiaria(),0.0001);				
	}
}

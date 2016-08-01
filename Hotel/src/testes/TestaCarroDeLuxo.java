package testes;

import logica.carros.CarroDeLuxo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.DataInvalidException;

public class TestaCarroDeLuxo {
	
	@Test
	public void testaPrecos() throws DataInvalidException{
		CarroDeLuxo c1 = new CarroDeLuxo("A");
		
		Assert.assertEquals(100.00, c1.getDiaria(),0.0001);
		Assert.assertEquals("A", c1.getPlaca());
		Assert.assertEquals("Carro de Luxo", c1.getTipo());
		
		Assert.assertEquals(100.00, CarroDeLuxo.getPreco(),0.0001);
		
		try{
			CarroDeLuxo.setPreco(-120);
			Assert.fail();
		} catch(DataInvalidException e){
			Assert.assertEquals("O preco não pode ser negativo.", e.getMessage());
		}
		
		Assert.assertEquals(100.00, CarroDeLuxo.getPreco(),0.0001);
		CarroDeLuxo.setPreco(80);
		Assert.assertEquals(80.00, CarroDeLuxo.getPreco(),0.0001);
		
		CarroDeLuxo c2 = new CarroDeLuxo("B");
		Assert.assertEquals(80.00, c2.getDiaria(),0.0001);
		Assert.assertEquals(100.00, c1.getDiaria(),0.0001);				
	}

}

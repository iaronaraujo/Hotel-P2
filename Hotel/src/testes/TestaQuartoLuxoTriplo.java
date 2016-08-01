package testes;

import logica.quartos.tipos.QuartoLuxoTriplo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

public class TestaQuartoLuxoTriplo {
	
private QuartoLuxoTriplo Q1, Q2, Q3;
	
	
	@Before
	public void criaObjs() throws CamasLogicException, PrecoInvalidException{
		Q1 = new QuartoLuxoTriplo();
		QuartoLuxoTriplo.setPreco(700);
		Q2 = new QuartoLuxoTriplo();
		QuartoLuxoTriplo.setPreco(750);
		Q3 = new QuartoLuxoTriplo();
	}
	
	@Test
	public void testaGets(){
		Assert.assertEquals(3, Q1.getCapacidade());
		Assert.assertEquals(620.00, Q1.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto de Luxo Triplo", Q1.getNome());
		Assert.assertEquals(0, Q1.getQuantCamasExtras());
		
		Assert.assertEquals(3, Q2.getCapacidade());
		Assert.assertEquals(700.00, Q2.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto de Luxo Triplo", Q2.getNome());
		Assert.assertEquals(0, Q2.getQuantCamasExtras());
		
		Assert.assertEquals(3, Q3.getCapacidade());
		Assert.assertEquals(750.00, Q3.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto de Luxo Triplo", Q3.getNome());
		Assert.assertEquals(0, Q3.getQuantCamasExtras());
	}

}

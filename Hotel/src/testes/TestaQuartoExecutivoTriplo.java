package testes;

import logica.quartos.tipos.QuartoExecutivoTriplo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

public class TestaQuartoExecutivoTriplo {
	
private QuartoExecutivoTriplo Q1, Q2, Q3;
	
	
	@Before
	public void criaObjs() throws CamasLogicException, PrecoInvalidException{
		Q1 = new QuartoExecutivoTriplo();
		QuartoExecutivoTriplo.setPreco(500);
		Q2 = new QuartoExecutivoTriplo();
		QuartoExecutivoTriplo.setPreco(550);
		Q3 = new QuartoExecutivoTriplo();
	}
	
	@Test
	public void testaGets(){
		Assert.assertEquals(3, Q1.getCapacidade());
		Assert.assertEquals(440.00, Q1.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Triplo", Q1.getNome());
		Assert.assertEquals(0, Q1.getQuantCamasExtras());
		
		Assert.assertEquals(3, Q2.getCapacidade());
		Assert.assertEquals(500.00, Q2.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Triplo", Q2.getNome());
		Assert.assertEquals(0, Q2.getQuantCamasExtras());
		
		Assert.assertEquals(3, Q3.getCapacidade());
		Assert.assertEquals(550.00, Q3.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Triplo", Q3.getNome());
		Assert.assertEquals(0, Q3.getQuantCamasExtras());
	}

}

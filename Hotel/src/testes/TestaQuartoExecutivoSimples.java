package testes;

import logica.quartos.tipos.QuartoExecutivoSimples;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

public class TestaQuartoExecutivoSimples {
	private QuartoExecutivoSimples Q1, Q2, Q3;
	
	
	@Before
	public void criaObjs() throws CamasLogicException, PrecoInvalidException{
		Q1 = new QuartoExecutivoSimples(0);
		QuartoExecutivoSimples.setPreco(400);
		Q2 = new QuartoExecutivoSimples(1);
		QuartoExecutivoSimples.setPreco(450);
		Q3 = new QuartoExecutivoSimples(2);
	}
	
	@Test
	public void testaGets(){
		Assert.assertEquals(1, Q1.getCapacidade());
		Assert.assertEquals(360.00, Q1.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Simples", Q1.getNome());
		Assert.assertEquals(0, Q1.getQuantCamasExtras());
		
		Assert.assertEquals(1, Q2.getCapacidade());
		Assert.assertEquals(500.00, Q2.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Simples", Q2.getNome());
		Assert.assertEquals(1, Q2.getQuantCamasExtras());
		
		Assert.assertEquals(1, Q3.getCapacidade());
		Assert.assertEquals(650.00, Q3.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Simples", Q3.getNome());
		Assert.assertEquals(2, Q3.getQuantCamasExtras());
	}

}

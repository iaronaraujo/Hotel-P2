package testes;

import logica.quartos.tipos.QuartoPresidencial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

public class TestaQuartoPresidencial {
	
private QuartoPresidencial Q1, Q2, Q3;
	
	
	@Before
	public void criaObjs() throws CamasLogicException, PrecoInvalidException{
		Q1 = new QuartoPresidencial();
		QuartoPresidencial.setPreco(1600);
		Q2 = new QuartoPresidencial();
		QuartoPresidencial.setPreco(2000);
		Q3 = new QuartoPresidencial();
	}
	
	@Test
	public void testaGets(){
		Assert.assertEquals(4, Q1.getCapacidade());
		Assert.assertEquals(1200.00, Q1.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Presidencial", Q1.getNome());
		Assert.assertEquals(0, Q1.getQuantCamasExtras());
		
		Assert.assertEquals(4, Q2.getCapacidade());
		Assert.assertEquals(1600.00, Q2.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Presidencial", Q2.getNome());
		Assert.assertEquals(0, Q2.getQuantCamasExtras());
		
		Assert.assertEquals(4, Q3.getCapacidade());
		Assert.assertEquals(2000.00, Q3.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Presidencial", Q3.getNome());
		Assert.assertEquals(0, Q3.getQuantCamasExtras());
	}

}

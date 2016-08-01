package testes;

import logica.quartos.tipos.QuartoExecutivoDuplo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestaQuartoExecutivoDuplo {
private QuartoExecutivoDuplo Q1, Q2, Q3;
	
	
	@Before
	public void criaObjs() throws Exception{
		Q1 = new QuartoExecutivoDuplo(0);
		QuartoExecutivoDuplo.setPreco(400);
		Q2 = new QuartoExecutivoDuplo(1);
		QuartoExecutivoDuplo.setPreco(450);
		Q3 = new QuartoExecutivoDuplo(2);
	}
	
	@Test
	public void testaGets(){
		Assert.assertEquals(2, Q1.getCapacidade());
		Assert.assertEquals(385.00, Q1.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Duplo", Q1.getNome());
		Assert.assertEquals(0, Q1.getQuantCamasExtras());
		
		Assert.assertEquals(2, Q2.getCapacidade());
		Assert.assertEquals(500.00, Q2.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Duplo", Q2.getNome());
		Assert.assertEquals(1, Q2.getQuantCamasExtras());
		
		Assert.assertEquals(2, Q3.getCapacidade());
		Assert.assertEquals(650.00, Q3.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto Executivo Duplo", Q3.getNome());
		Assert.assertEquals(2, Q3.getQuantCamasExtras());
	}

}

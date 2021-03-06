package testes;

import logica.quartos.tipos.QuartoLuxoSimples;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;

public class TestaQuartoLuxoSimples {
private QuartoLuxoSimples Q1, Q2, Q3;
	
	
	@Before
	public void criaObjs() throws CamasLogicException, PrecoInvalidException{
		Q1 = new QuartoLuxoSimples(0);
		QuartoLuxoSimples.setPreco(600);
		Q2 = new QuartoLuxoSimples(1);
		QuartoLuxoSimples.setPreco(650);
		Q3 = new QuartoLuxoSimples(2);
	}
	
	@Test
	public void testaGets(){
		Assert.assertEquals(1, Q1.getCapacidade());
		Assert.assertEquals(520.00, Q1.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto de Luxo Simples", Q1.getNome());
		Assert.assertEquals(0, Q1.getQuantCamasExtras());
		
		Assert.assertEquals(1, Q2.getCapacidade());
		Assert.assertEquals(700.00, Q2.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto de Luxo Simples", Q2.getNome());
		Assert.assertEquals(1, Q2.getQuantCamasExtras());
		
		Assert.assertEquals(1, Q3.getCapacidade());
		Assert.assertEquals(850.00, Q3.getPrecoDiaria(), 0.001);
		Assert.assertEquals("Quarto de Luxo Simples", Q3.getNome());
		Assert.assertEquals(2, Q3.getQuantCamasExtras());
	}

}

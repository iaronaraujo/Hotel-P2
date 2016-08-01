package testes;

import logica.estrategias.*;

import org.junit.Assert;
import org.junit.Test;

public class TestaEstrategias {
	private EstrategiaDeTarifa strategy;
	
	@Test
	public void TestaBaixaEstacao() throws Exception{
		strategy = new BaixaEstacao();
		Assert.assertEquals(90, strategy.calculaTotalGasto(100), 0.01);
		Assert.assertEquals(180, strategy.calculaTotalGasto(200), 0.01);
		Assert.assertEquals(270, strategy.calculaTotalGasto(300), 0.01);
		Assert.assertEquals(360, strategy.calculaTotalGasto(400), 0.01);
		Assert.assertEquals(450, strategy.calculaTotalGasto(500), 0.01);
	}
	
	@Test
	public void TestaNatalEReveillon() throws Exception{
		strategy = new NatalEReveillon();
		Assert.assertEquals(150, strategy.calculaTotalGasto(100), 0.01);
		Assert.assertEquals(300, strategy.calculaTotalGasto(200), 0.01);
		Assert.assertEquals(450, strategy.calculaTotalGasto(300), 0.01);
		Assert.assertEquals(600, strategy.calculaTotalGasto(400), 0.01);
		Assert.assertEquals(750, strategy.calculaTotalGasto(500), 0.01);
	}
	
	@Test
	public void TestaSaoJoao() throws Exception{
		strategy = new SaoJoao();
		Assert.assertEquals(110, strategy.calculaTotalGasto(100), 0.01);
		Assert.assertEquals(220, strategy.calculaTotalGasto(200), 0.01);
		Assert.assertEquals(330, strategy.calculaTotalGasto(300), 0.01);
		Assert.assertEquals(440, strategy.calculaTotalGasto(400), 0.01);
		Assert.assertEquals(550, strategy.calculaTotalGasto(500), 0.01);
	}
	
	@Test
	public void TestaSimples() throws Exception{
		strategy = new Simples();
		Assert.assertEquals(100, strategy.calculaTotalGasto(100), 0.01);
		Assert.assertEquals(200, strategy.calculaTotalGasto(200), 0.01);
		Assert.assertEquals(300, strategy.calculaTotalGasto(300), 0.01);
		Assert.assertEquals(400, strategy.calculaTotalGasto(400), 0.01);
		Assert.assertEquals(500, strategy.calculaTotalGasto(500), 0.01);
	}

}

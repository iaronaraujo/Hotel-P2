package testes;

import logica.quartos.tipos.*;
import logica.servicos.DiariaQuarto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaDiariaQuarto {
	private QuartoExecutivoSimples quarto;
	
	@Before
	public void criaObjetos() throws Exception{
		quarto = new QuartoExecutivoSimples(1);
	}
	
	@Test
	public void testaConstrutor(){
		
		try{
			new DiariaQuarto(null, 2, "bom");
			Assert.fail("Excecao esperada!");
		}catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		
		try{
			new DiariaQuarto(quarto, 0, "bom");
			Assert.fail("Excecao esperada!");
		}catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new DiariaQuarto(quarto, -1, "bom");
			Assert.fail("Excecao esperada!");
		}catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new DiariaQuarto(quarto, -2, "bom");
			Assert.fail("Excecao esperada!");
		}catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new DiariaQuarto(quarto, -123, "bom");
			Assert.fail("Excecao esperada!");
		}catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new DiariaQuarto(quarto, 123, "      ");
			Assert.fail("Excecao esperada!");
		}catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new DiariaQuarto(quarto, 123, "");
			Assert.fail("Excecao esperada!");
		}catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new DiariaQuarto(quarto, 123, null);
			Assert.fail("Excecao esperada!");
		}catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		
	}
	
	@Test
	public void testaCalculaPreco() throws Exception{
		QuartoExecutivoSimples qes0,qes1,qes2;
		QuartoExecutivoDuplo qed0, qed1, qed2;
		QuartoExecutivoTriplo qet;
		QuartoLuxoSimples qls0,qls1,qls2;
		QuartoLuxoDuplo qld0, qld1, qld2;
		QuartoLuxoTriplo qlt;
		QuartoPresidencial qp;
		qes0 = new QuartoExecutivoSimples(0);
		qes1 = new QuartoExecutivoSimples(1);
		qes2 = new QuartoExecutivoSimples(2);
		qed0 = new QuartoExecutivoDuplo(0);
		qed1 = new QuartoExecutivoDuplo(1);
		qed2 = new QuartoExecutivoDuplo(2);
		qet = new QuartoExecutivoTriplo();
		qls0 = new QuartoLuxoSimples(0);
		qls1 = new QuartoLuxoSimples(1);
		qls2 = new QuartoLuxoSimples(2);
		qld0 = new QuartoLuxoDuplo(0);
		qld1 = new QuartoLuxoDuplo(1);
		qld2 = new QuartoLuxoDuplo(2);
		qlt = new QuartoLuxoTriplo();
		qp = new QuartoPresidencial();
		
		DiariaQuarto D = new DiariaQuarto(qes0, 1, "D");
		Assert.assertEquals(360.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qes0, 2, "D");
		Assert.assertEquals(360.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qes0, 3, "D");
		Assert.assertEquals(360.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qes1, 1, "D");
		Assert.assertEquals(460.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qes1, 2, "D");
		Assert.assertEquals(460.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qes1, 3, "D");
		Assert.assertEquals(460.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qes2, 1, "D");
		Assert.assertEquals(560.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qes2, 2, "D");
		Assert.assertEquals(560.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qes2, 3, "D");
		Assert.assertEquals(560.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qed0, 1, "D");
		Assert.assertEquals(385.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qed0, 2, "D");
		Assert.assertEquals(385.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qed0, 3, "D");
		Assert.assertEquals(385.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qed1, 1, "D");
		Assert.assertEquals(485.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qed1, 2, "D");
		Assert.assertEquals(485.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qed1, 3, "D");
		Assert.assertEquals(485.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qed2, 1, "D");
		Assert.assertEquals(585.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qed2, 2, "D");
		Assert.assertEquals(585.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qed2, 3, "D");
		Assert.assertEquals(585.00*3, D.calculaPreco(), 0.001);
		
		//===============================================
		
		D = new DiariaQuarto(qls0, 1, "D");
		Assert.assertEquals(520.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qls0, 2, "D");
		Assert.assertEquals(520.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qls0, 3, "D");
		Assert.assertEquals(520.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qls1, 1, "D");
		Assert.assertEquals(620.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qls1, 2, "D");
		Assert.assertEquals(620.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qls1, 3, "D");
		Assert.assertEquals(620.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qls2, 1, "D");
		Assert.assertEquals(720.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qls2, 2, "D");
		Assert.assertEquals(720.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qls2, 3, "D");
		Assert.assertEquals(720.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qld0, 1, "D");
		Assert.assertEquals(570.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qld0, 2, "D");
		Assert.assertEquals(570.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qld0, 3, "D");
		Assert.assertEquals(570.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qld1, 1, "D");
		Assert.assertEquals(670.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qld1, 2, "D");
		Assert.assertEquals(670.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qld1, 3, "D");
		Assert.assertEquals(670.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qld2, 1, "D");
		Assert.assertEquals(770.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qld2, 2, "D");
		Assert.assertEquals(770.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qld2, 3, "D");
		Assert.assertEquals(770.00*3, D.calculaPreco(), 0.001);
		
		//====================================================
		
		D = new DiariaQuarto(qet, 1, "D");
		Assert.assertEquals(440.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qet, 2, "D");
		Assert.assertEquals(440.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qet, 3, "D");
		Assert.assertEquals(440.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qlt, 1, "D");
		Assert.assertEquals(620.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qlt, 2, "D");
		Assert.assertEquals(620.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qlt, 3, "D");
		Assert.assertEquals(620.00*3, D.calculaPreco(), 0.001);
		
		D = new DiariaQuarto(qp, 1, "D");
		Assert.assertEquals(1200.00*1, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qp, 2, "D");
		Assert.assertEquals(1200.00*2, D.calculaPreco(), 0.001);
		D = new DiariaQuarto(qp, 3, "D");
		Assert.assertEquals(1200.00*3, D.calculaPreco(), 0.001);
		
	}

}

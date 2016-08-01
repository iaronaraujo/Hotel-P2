package testes;

import logica.carros.Carro;
import logica.carros.CarroDeLuxo;
import logica.carros.CarroExecutivo;
import logica.servicos.AluguelDeCarro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaAluguelDeCarro {
	
private Carro carro, carro1;
	
	@Before
	public void criaObjetos() throws Exception {
		carro = new CarroExecutivo("A");
		carro1 = new CarroDeLuxo("B");
	}
	
	@Test
	public void testaConstrutor(){
		try{
			new AluguelDeCarro(null, 3, false, false, "A");
			Assert.fail("Excecao esperada");
		} catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		
		try{
			new AluguelDeCarro(carro, 0, false, false, "A");
			Assert.fail("Excecao esperada");
		} catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new AluguelDeCarro(carro, -1, false, false, "A");
			Assert.fail("Excecao esperada");
		} catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new AluguelDeCarro(carro, -2, false, false, "A");
			Assert.fail("Excecao esperada");
		} catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new AluguelDeCarro(carro, -123, false, false, "A");
			Assert.fail("Excecao esperada");
		} catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		
		try{
			new AluguelDeCarro(carro, 2, false, false, null);
			Assert.fail("Excecao esperada");
		} catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new AluguelDeCarro(carro, 2, false, false, "");
			Assert.fail("Excecao esperada");
		} catch (Exception e){
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
	}
	
	@Test
	public void testaCalculaPreco() throws Exception{
		AluguelDeCarro a1 = new AluguelDeCarro(carro, 1, false, false, "A");
		AluguelDeCarro a2 = new AluguelDeCarro(carro, 2, false, false, "A");
		AluguelDeCarro a3 = new AluguelDeCarro(carro, 3, false, false, "A");
		AluguelDeCarro a4 = new AluguelDeCarro(carro, 1, true, false, "A");
		AluguelDeCarro a5 = new AluguelDeCarro(carro, 2, true, false, "A");
		AluguelDeCarro a6 = new AluguelDeCarro(carro, 3, true, false, "A");
		AluguelDeCarro a7 = new AluguelDeCarro(carro, 1, false, true, "A");
		AluguelDeCarro a8 = new AluguelDeCarro(carro, 2, false, true, "A");
		AluguelDeCarro a9 = new AluguelDeCarro(carro, 3, false, true, "A");
		AluguelDeCarro a10 = new AluguelDeCarro(carro, 1, true, true, "A");
		AluguelDeCarro a11 = new AluguelDeCarro(carro, 2, true, true, "A");
		AluguelDeCarro a12 = new AluguelDeCarro(carro, 3, true, true, "A");
		AluguelDeCarro b1 = new AluguelDeCarro(carro1, 1, false, false, "A");
		AluguelDeCarro b2 = new AluguelDeCarro(carro1, 2, false, false, "A");
		AluguelDeCarro b3 = new AluguelDeCarro(carro1, 3, false, false, "A");
		AluguelDeCarro b4 = new AluguelDeCarro(carro1, 1, true, false, "A");
		AluguelDeCarro b5 = new AluguelDeCarro(carro1, 2, true, false, "A");
		AluguelDeCarro b6 = new AluguelDeCarro(carro1, 3, true, false, "A");
		AluguelDeCarro b7 = new AluguelDeCarro(carro1, 1, false, true, "A");
		AluguelDeCarro b8 = new AluguelDeCarro(carro1, 2, false, true, "A");
		AluguelDeCarro b9 = new AluguelDeCarro(carro1, 3, false, true, "A");
		AluguelDeCarro b10 = new AluguelDeCarro(carro1, 1, true, true, "A");
		AluguelDeCarro b11 = new AluguelDeCarro(carro1, 2, true, true, "A");
		AluguelDeCarro b12 = new AluguelDeCarro(carro1, 3, true, true, "A");
		
		Assert.assertEquals(60, a1.calculaPreco(),0.01);
		Assert.assertEquals(120, a2.calculaPreco(),0.01);
		Assert.assertEquals(180, a3.calculaPreco(),0.01);
		
		Assert.assertEquals(210, a4.calculaPreco(),0.01);
		Assert.assertEquals(270, a5.calculaPreco(),0.01);
		Assert.assertEquals(330, a6.calculaPreco(),0.01);
		
		Assert.assertEquals(160, a7.calculaPreco(),0.01);
		Assert.assertEquals(220, a8.calculaPreco(),0.01);
		Assert.assertEquals(280, a9.calculaPreco(),0.01);
		
		Assert.assertEquals(310, a10.calculaPreco(),0.01);
		Assert.assertEquals(370, a11.calculaPreco(),0.01);
		Assert.assertEquals(430, a12.calculaPreco(),0.01);
		
		Assert.assertEquals(100, b1.calculaPreco(),0.01);
		Assert.assertEquals(200, b2.calculaPreco(),0.01);
		Assert.assertEquals(300, b3.calculaPreco(),0.01);
		
		Assert.assertEquals(250, b4.calculaPreco(),0.01);
		Assert.assertEquals(350, b5.calculaPreco(),0.01);
		Assert.assertEquals(450, b6.calculaPreco(),0.01);
		
		Assert.assertEquals(200, b7.calculaPreco(),0.01);
		Assert.assertEquals(300, b8.calculaPreco(),0.01);
		Assert.assertEquals(400, b9.calculaPreco(),0.01);
		
		Assert.assertEquals(350, b10.calculaPreco(),0.01);
		Assert.assertEquals(450, b11.calculaPreco(),0.01);
		Assert.assertEquals(550, b12.calculaPreco(),0.01);
	}
}

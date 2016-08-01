package testes;

import java.util.ArrayList;

import logica.servicos.Refeicao;
import logica.utilitarios.Prato;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaRefeicao {
	private ArrayList<Prato> l1, l2, l3, l4;
	private Prato file, arroz, salada, macarrao, vinho;
	private Refeicao r1, r2, r3;
	
	@Before
	public void criaObjs() throws Exception{
		l1 = new ArrayList<Prato>();
		l2 = new ArrayList<Prato>();
		l3 = new ArrayList<Prato>();
		l4 = new ArrayList<Prato>();
		file = new Prato("File", 50);
		arroz = new Prato("Arroz", 20);
		salada = new Prato("Salada", 15);
		macarrao = new Prato("Macarrao", 30);
		vinho = new Prato("Vinho", 120);
		l1.add(file);
		l1.add(arroz);
		l1.add(macarrao);
		l2.add(file);
		l2.add(file);
		l2.add(vinho);
		l3.add(salada);
		l3.add(salada);
		l3.add(arroz);
		
		r1 = new Refeicao(l1, "1");
		r2 = new Refeicao(l2, "2");
		r3 = new Refeicao(l3, "3");
		
	}
	
	@Test
	public void testaConstrutor(){
		try{
			new Refeicao(l4, "Refeicao");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Pratos inválidos.", e.getMessage());
		}
		try{
			new Refeicao(null, "Refeicao");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Pratos inválidos.", e.getMessage());
		}
		try{
			new Refeicao(l1, "");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new Refeicao(l1, "  ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
		try{
			new Refeicao(l4, null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Serviço inválido.", e.getMessage());
		}
	}
	
	@Test
	public void testaCalculaPreco(){
		Assert.assertEquals(100.00, r1.calculaPreco(), 0.001);
		Assert.assertEquals(220.00, r2.calculaPreco(), 0.001);
		Assert.assertEquals(50.00, r3.calculaPreco(), 0.001);
		// Se deve testar a quantidade de refeicoes tabem?
	}

}

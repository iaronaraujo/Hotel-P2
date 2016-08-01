package testes;

import java.util.GregorianCalendar;

import logica.servicos.Babysitting;
import logica.utilitarios.Baba;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.DateInvalidException;
import programa.exceptions.servicos.ServicoLogicException;

public class TestaBabysitting {
	
	Baba ana, maria;
	
	@Before
	public void criaObjs(){
		ana = new Baba("Ana");
		maria = new Baba("Maria");
	}
	
	@Test
	public void testaConstrutor() throws DataInvalidException, ServicoLogicException{
		Babysitting.addBaba(ana);
		GregorianCalendar hi1 = new GregorianCalendar(2015,1,1,15,0);
		
		try{
			new Babysitting(null, 2, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Data inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, -2, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, -24, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, -2, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, -24, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, -2, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, 0, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, 13, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, 24, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, -2, "Bom");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de horas inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, 10, "");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Descrição inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, 10, "      ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Descrição inválida.", e.getMessage());
		}
		try{
			new Babysitting(hi1, 10, null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Descrição inválida.", e.getMessage());
		}
		
		Babysitting baby1 = new Babysitting(hi1, 6, "Teste");
		try{
			new Babysitting(hi1, 3, "Teste");
			Assert.fail();
		} catch (Exception e){
			Assert.assertEquals("Serviço de babás indisponível no horário especificado.", e.getMessage());
		}
		
		Babysitting.addBaba(maria);
		Babysitting baby2 = new Babysitting(hi1, 6, "Teste");
		
		try{
			new Babysitting(hi1, 3, "Teste");
			Assert.fail();
		} catch (Exception e){
			Assert.assertEquals("Serviço de babás indisponível no horário especificado.", e.getMessage());
		}
		
		Babysitting.removeBaba(ana);
		Babysitting.removeBaba(maria);
		
	}
	
	@Test
	public void testaCalculaPreco() throws DataInvalidException, ServicoLogicException{
		
		Babysitting.addBaba(ana);
		Babysitting.addBaba(maria);
		GregorianCalendar h1 = new GregorianCalendar(2015,10,1,16,0);
		GregorianCalendar h2 = new GregorianCalendar(2015,10,1,23,0);
		Babysitting baby1 = new Babysitting(h1, 6, "Teste");
		Babysitting baby2 = new Babysitting(h2, 10, "Teste2");
		
		Assert.assertEquals(250.00, baby1.calculaPreco(),0.001);
		Assert.assertEquals(450.00, baby2.calculaPreco(), 0.001);
		
		Babysitting.removeBaba(ana);
		Babysitting.removeBaba(maria);
		
	}
	

}

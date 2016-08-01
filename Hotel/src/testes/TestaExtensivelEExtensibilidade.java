package testes;



import logica.quartos.extensibilidade.Extensibilidade;
import logica.quartos.extensibilidade.Extensivel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.PrecoInvalidException;
import programa.exceptions.servicos.CamasLogicException;



public class TestaExtensivelEExtensibilidade {
	private Extensivel Q1;
	
	@Before
	public void criaObjs() throws CamasLogicException, PrecoInvalidException{
		Q1 = new Extensivel(1);
	}
	
	
	@Test
	public void testaConstrutor(){
		try{
			new Extensivel(-1);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		try{
			new Extensivel(-2);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		try{
			new Extensivel(-123);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		try{
			new Extensivel(3);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		try{
			new Extensivel(15);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
	}
	
	@Test
	public void testaSets(){
		try{
			Extensibilidade.setPrecoCamaExtras(-150);
			Assert.fail();
		} catch(PrecoInvalidException e){
			Assert.assertEquals("O preco não pode ser negativo.", e.getMessage());
		}
		try{
			Extensibilidade.setPrecoCamaExtras(-200);
			Assert.fail();
		} catch(PrecoInvalidException e){
			Assert.assertEquals("O preco não pode ser negativo.", e.getMessage());
		}
		try{
			Extensibilidade.setPrecoCamaExtras(-300);
			Assert.fail();
		} catch(PrecoInvalidException e){
			Assert.assertEquals("O preco não pode ser negativo.", e.getMessage());
		}
		
		
		try{
			Q1.setQuantCamasExtras(-1);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		try{
			Q1.setQuantCamasExtras(-2);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		try{
			Q1.setQuantCamasExtras(-123);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		try{
			Q1.setQuantCamasExtras(3);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		try{
			Q1.setQuantCamasExtras(15);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
		
	}
	
	
	
	
}

package testes;

import logica.utilitarios.Opiniao;

import org.junit.Assert;
import org.junit.Test;

public class TestaOpiniao {
	
	@Test
	public void testaConstrutor(){
		
		try{
			new Opiniao("Minha nota", -1);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Nota inválida.", e.getMessage());
		}
		try{
			new Opiniao("Minha nota", -2);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Nota inválida.", e.getMessage());
		}
		try{
			new Opiniao("Minha nota", -123);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Nota inválida.", e.getMessage());
		}
		try{
			new Opiniao("Minha nota", 11);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Nota inválida.", e.getMessage());
		}
		try{
			new Opiniao("Minha nota", 20);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Nota inválida.", e.getMessage());
		}
		try{
			new Opiniao("Minha nota", 8001);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Nota inválida.", e.getMessage());
		}
	}
	
	@Test
	public void testaEquals() throws Exception{
		Opiniao op1 = new Opiniao("bom", 10);
		Opiniao op2 = new Opiniao("bom", 10);
		Opiniao op3 = new Opiniao("ruim", 10);
		Opiniao op4 = new Opiniao("bom", 0);
		Opiniao op5 = new Opiniao("ruim", 0);
		
		Assert.assertTrue(op1.equals(op2));
		Assert.assertFalse(op1.equals(op3));
		Assert.assertFalse(op1.equals(op4));
		Assert.assertFalse(op1.equals(op5));
	}

}

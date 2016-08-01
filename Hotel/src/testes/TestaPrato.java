package testes;

import logica.utilitarios.Prato;

import org.junit.Assert;
import org.junit.Test;

public class TestaPrato {
	
	@Test
	public void testaConstrutor(){
		try{
			new Prato("", 50);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try{
			new Prato("    ", 50);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		try{
			new Prato(null, 50);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome inválido.", e.getMessage());
		}
		
		try{
			new Prato("File", -1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("O preco não pode ser negativo.", e.getMessage());
		}
		try{
			new Prato("File", -10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("O preco não pode ser negativo.", e.getMessage());
		}
		try{
			new Prato("File", -50);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("O preco não pode ser negativo.", e.getMessage());
		}
	}

}

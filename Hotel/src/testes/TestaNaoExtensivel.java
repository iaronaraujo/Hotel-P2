package testes;

import logica.quartos.extensibilidade.NaoExtensivel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.servicos.CamasLogicException;

public class TestaNaoExtensivel {
	
	@Test
	public void teste() throws CamasLogicException{
		//Testa construtor
		NaoExtensivel Q = new NaoExtensivel();
		Assert.assertEquals(0, Q.getQuantCamasExtras());
		
		//Testa setQuantCamasExt
		
		try{
			Q.setQuantCamasExtras(2);
			Assert.fail();
		} catch(CamasLogicException e){
			Assert.assertEquals("Número de camas extras inválido.", e.getMessage());
		}
	}

}

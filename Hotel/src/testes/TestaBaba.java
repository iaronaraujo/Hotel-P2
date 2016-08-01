package testes;

import java.util.GregorianCalendar;

import logica.utilitarios.Baba;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaBaba {
	
	@Test
	public void testaConstrutor(){
		Baba ana = new Baba("Ana");
		Assert.assertTrue(ana.getHorariosInicio().isEmpty());
		Assert.assertTrue(ana.getHorariosFins().isEmpty());
	}
	
	@Test
	public void testaAddHorario(){
		GregorianCalendar hi1 = new GregorianCalendar(2015,1,1,15,0);
		GregorianCalendar hi2 = new GregorianCalendar(2015,1,1,13,0);
		GregorianCalendar hi3 = new GregorianCalendar(2015,1,1,16,0);
		
		GregorianCalendar hi4 = new GregorianCalendar(2015,1,1,20,0);
		GregorianCalendar hi5 = new GregorianCalendar(2015,1,1,14,0);
		
		GregorianCalendar hi6 = new GregorianCalendar(2015,1,1,23,0);
		GregorianCalendar hi7 = new GregorianCalendar(2015,1,2,02,0);
		
		
		
		Baba ana = new Baba("Ana");
		Assert.assertTrue(ana.addHorario(hi1, 4));
		Assert.assertFalse(ana.addHorario(hi2, 3));
		Assert.assertFalse(ana.addHorario(hi2, 7));
		Assert.assertFalse(ana.addHorario(hi1, 4));
		Assert.assertFalse(ana.addHorario(hi3, 4));
		Assert.assertFalse(ana.addHorario(hi3, 1));
		
		Assert.assertTrue(ana.addHorario(hi4, 2));
		Assert.assertFalse(ana.addHorario(hi5, 7));
		
		Assert.assertTrue(ana.addHorario(hi6, 5));
		Assert.assertFalse(ana.addHorario(hi7, 2));
		
		
	}

}

package testes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.HospedeInvalidException;
import programa.formatos.FormatFactory;
import logica.*;
import logica.carros.Carro;
import logica.carros.CarroExecutivo;
import logica.clientes.Hospede;
import logica.clientes.HospedeRepresentante;
import logica.endereco.Endereco;
import logica.endereco.EnderecoCasa;
import logica.essenciais.Contrato;
import logica.estrategias.EstrategiaDeTarifa;
import logica.estrategias.Simples;
import logica.quartos.tipos.Quarto;
import logica.quartos.tipos.QuartoExecutivoTriplo;
import logica.servicos.AluguelDeCarro;
import logica.servicos.DiariaQuarto;
import logica.servicos.Refeicao;
import logica.servicos.Servico;
import logica.utilitarios.Prato;

public class TestaContrato {
	
	private ArrayList<Servico> servicos;
	private ArrayList<Prato> pratos1, pratos2; 
	private int numCartao;
	private FormatFactory riv;
	private Contrato contrato1, contrato2, contrato3;
	private GregorianCalendar inicio1, inicio2, inicio3, fim1, fim2, fim3, nasc1, nasc2, nasc3;
	private EstrategiaDeTarifa strategy;
	private HospedeRepresentante joao, jose, maria;
	private Endereco end1, end2, end3;
	private AluguelDeCarro aluguelCarro;
	private Prato file, abobrinha;
	private DiariaQuarto diaria1, diaria2, diaria3;
	private Carro carro;
	private Quarto quarto1, quarto2, quarto3;
	private Refeicao refeicao1, refeicao2;
	
	@Before
	public void criaObjetos() throws Exception{
		try {
		numCartao = 123123;
		inicio1 = new GregorianCalendar(2015, 0, 24);
		inicio2 = new GregorianCalendar(2015, 0, 25);
		inicio3 = new GregorianCalendar(2015, 0, 26);
		fim1 = new GregorianCalendar(2015, 0, 27);
		fim2 = new GregorianCalendar(2015, 0, 28);
		fim3 = new GregorianCalendar(2015, 0, 29);
		nasc1 = new GregorianCalendar(1990, 2, 13);
		nasc2 = new GregorianCalendar(1992, 11, 15);
		nasc3 = new GregorianCalendar(1989, 3, 30);
		
		end1 = new EnderecoCasa("Brasil", "CG","A", "AZ1", 1);
		end2 = new EnderecoCasa("Brasil", "CG","A", "AZ1", 2);
		end3 = new EnderecoCasa("Brasil", "CG","A", "AZ1", 3);

		carro = new CarroExecutivo("ABC1");
		aluguelCarro = new AluguelDeCarro(carro, 2, false, false, "ABC");
		file = new Prato("file", 50);
		quarto1 = new QuartoExecutivoTriplo();
		quarto2 = new QuartoExecutivoTriplo();
		quarto3 = new QuartoExecutivoTriplo();
		diaria1 = new DiariaQuarto(quarto1, 2, "100");
		diaria2 = new DiariaQuarto(quarto2, 2, "101");
		diaria3 = new DiariaQuarto(quarto3, 2, "102");
		
		abobrinha = new Prato("Abobrinha", 200);
		
		
		
		servicos = new ArrayList<Servico>();
		pratos1 = new ArrayList<Prato>();
		pratos1.add(file);
		refeicao1 = new Refeicao(pratos1, "1");
		pratos2 = new ArrayList<Prato>();
		pratos2.add(abobrinha);
		refeicao2 = new Refeicao(pratos2, "2");
		
		servicos.add(aluguelCarro);
		servicos.add(refeicao1);
		servicos.add(diaria1);
		servicos.add(diaria2);
		servicos.add(diaria3);

		strategy = new Simples();

		joao = new HospedeRepresentante("Joao", nasc1, "123.123.123-00", end1);
		jose = new HospedeRepresentante("Jose", nasc2, "456.333.333-01", end2);
		maria = new HospedeRepresentante("Maria", nasc3, "789.222.222-02", end3);

		//contrato1 = new Contrato(joao, inicio1, fim1, strategy, "111", servicos, diaria1);
		//contrato2 = new Contrato(jose, inicio2, fim2, strategy, "222", servicos, diaria2);
		//contrato3 = new Contrato(maria, inicio3, fim3, strategy, "333", servicos, diaria3);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaConstrutor(){
		try{
			contrato1 = new Contrato(joao, inicio1, fim1, strategy, "111", servicos, diaria1);
			contrato2 = new Contrato(jose, inicio2, fim2, strategy, "222", servicos, diaria1);
			contrato3 = new Contrato(maria, inicio3, fim3, strategy, "333", servicos, diaria1);
		} catch (Exception e){
			Assert.fail();
		}
		try{
			new Contrato(null, inicio1, fim1, strategy, "111", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Hospede inválido.", e.getMessage());
		}
		try{
			new Contrato(joao, null, fim1, strategy, "111", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Data inválida.", e.getMessage());
		}
		try{
			new Contrato(joao, inicio1, null, strategy, "111", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Data inválida.", e.getMessage());
		}
		try{
			new Contrato(joao, fim1, inicio1, strategy, "111", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Data inválida.", e.getMessage());
		}
		try{
			new Contrato(joao, inicio1, fim1, null, "111", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Tarifa Nao Pode Ser Vazia", e.getMessage());
		}
		try{
			new Contrato(joao, inicio1, fim1, strategy, null, servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Número do cartão inválido.", e.getMessage());
		}
		try{
			new Contrato(joao, inicio1, fim1, strategy, "", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Número do cartão inválido.", e.getMessage());
		}
		try{
			new Contrato(joao, inicio1, fim1, strategy, "   ", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Número do cartão inválido.", e.getMessage());
		}
		try{
			new Contrato(joao, inicio1, fim1, strategy, "A", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Número do cartão inválido.", e.getMessage());
		}
		try{
			new Contrato(joao, inicio1, fim1, strategy, "123h437u1", servicos, diaria1);
			Assert.fail();
		} catch (DataInvalidException e) {
			Assert.assertEquals("Número do cartão inválido.", e.getMessage());
		}
		
	}
	
	@Test
	public void testaAdicionaServico() throws DataInvalidException{
		contrato1 = new Contrato(joao, inicio1, fim1, strategy, "111", servicos, diaria1);
		Assert.assertFalse(contrato1.adicionaServico(refeicao2));
		
		Assert.assertTrue(contrato1.adicionaServico(aluguelCarro));
		Assert.assertFalse(servicos.contains(aluguelCarro));
		
		Assert.assertTrue(contrato1.adicionaServico(refeicao1));
		Assert.assertFalse(servicos.contains(refeicao1));
		
		Assert.assertTrue(contrato1.adicionaServico(diaria1));
		Assert.assertTrue(servicos.contains(diaria1));
		Assert.assertTrue(contrato1.adicionaServico(diaria1));
		Assert.assertFalse(servicos.contains(diaria1));
		
		Assert.assertTrue(contrato1.removeServico(diaria1));
		Assert.assertTrue(servicos.contains(diaria1));
		
	}
	
	@Test
	public void testaAdicionaHospede() throws DataInvalidException{
		Hospede h1, h2, h3;
		h1 = new Hospede("1", nasc1);
		h2 = new Hospede("2", nasc1);
		h3 = new Hospede("3", nasc1);
		contrato1 = new Contrato(joao, inicio1, fim1, strategy, "111", servicos, diaria1);
		
		Assert.assertTrue(contrato1.adicionaHospede(h1));
		Assert.assertTrue(contrato1.adicionaHospede(h2));
		Assert.assertTrue(contrato1.adicionaHospede(h3));
		Assert.assertFalse(contrato1.adicionaHospede(h1));
		Assert.assertTrue(contrato1.removeHospede(h1));
		Assert.assertTrue(contrato1.adicionaHospede(h1));	
	}
	
	@Test
	public void testaCalculaTotal() throws DataInvalidException{
		contrato1 = new Contrato(joao, inicio1, fim1, strategy, "111", servicos, diaria1);
		Assert.assertEquals(880.00, contrato1.calculaTotalGasto(), 0.001);
		contrato1.adicionaServico(refeicao1);
		Assert.assertEquals(930.00, contrato1.calculaTotalGasto(), 0.001);
		contrato1.adicionaServico(aluguelCarro);
		Assert.assertEquals(1050.00, contrato1.calculaTotalGasto(), 0.001);
		contrato1.removeServico(refeicao1);
		Assert.assertEquals(1000.00, contrato1.calculaTotalGasto(), 0.001);
		contrato1.removeServico(diaria1);
		Assert.assertEquals(120.00, contrato1.calculaTotalGasto(), 0.001);
		contrato1.removeServico(aluguelCarro);
		Assert.assertEquals(0.00, contrato1.calculaTotalGasto(), 0.001);
		
	}
	

}

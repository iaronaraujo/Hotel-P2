package logica.relatorios;

import logica.utilitarios.CalculadoraFaturamento;


public class FaturamentoMensal implements Relatorio{
	
	private CalculadoraFaturamento calc;
	
	public FaturamentoMensal(CalculadoraFaturamento calc) {
		this.calc = calc;
	}

	public String geraRelatorio() {
		
		String outPut = "RELATORIO DE FATURAMENTO MENSAL(*):" + 
				"\n\n" + calc.geraRelatorio()
				+ "\n\n" + "(*)O relatorio e gerado tomando como referencia os contratos fechados no mes.";
		
		return outPut;
	}
}

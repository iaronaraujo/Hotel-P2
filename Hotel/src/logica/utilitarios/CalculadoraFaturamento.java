package logica.utilitarios;

import java.util.Calendar;
import java.util.List;

import logica.enumeracoes.MesDoAno;
import logica.essenciais.Contrato;

public class CalculadoraFaturamento {
	
	private MesDoAno mesFaturamento;
	private int anoFaturamento;
	private List<Contrato> contratos;
	private Double totalFaturado;
	
	public CalculadoraFaturamento(MesDoAno mesFaturamento,int anoFaturamento, List<Contrato> contratos) {
		this.contratos = contratos;
		this.mesFaturamento = mesFaturamento;
		this.anoFaturamento = anoFaturamento;
	}

	public String geraRelatorio() {
		calculaTotalFaturado();
		String outPut = "Total faturado no mes de " + mesFaturamento.toString().toLowerCase() + ": R$" + String.format("%.2f", totalFaturado);
		return outPut;
	}

	private void calculaTotalFaturado() {
		double total = 0.0;
		for (Contrato c : contratos) {
			int mesCheckout = c.getDataFinal().get(Calendar.MONTH);
			int anoCheckout = c.getDataFinal().get(Calendar.YEAR);
			if (mesCheckout == mesFaturamento.ordinal() + 1 && anoCheckout == anoFaturamento - 1){
					total += c.calculaTotalGasto();
				
				totalFaturado = total;
			}
		}
	}	
	
	private void relatorioPorContrato() {
		String outputContratos = "Contratos que realizaram checkout: ";
		for (Contrato c: contratos) {
			outputContratos += "\n\n" + c.toString();
		}
	}
}
package logica.relatorios;

import java.util.List;

import logica.enumeracoes.EstadoContrato;
import logica.essenciais.Contrato;

public class ContratosEmAberto implements Relatorio{
	
	private List<Contrato> contratos;
	
	public ContratosEmAberto(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	@Override
	public String geraRelatorio() {
		String outPut = "RELATORIO DE CONTRATOS EM ABERTO: ";
		
		for (Contrato c : contratos){
			if(c.getEstadoDoContrato() == EstadoContrato.ABERTO){
				outPut += "\n\n" + c.toString();
			}
		}
		return outPut;
	}
}
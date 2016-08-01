package logica.relatorios;

import java.util.List;

import logica.servicos.Servico;

public class ServicosDisponiveis implements Relatorio{
	
	private List<Servico> servicosOferecidos;
	public ServicosDisponiveis(List<Servico> servicosOferecidos){
		this.servicosOferecidos = servicosOferecidos;
	}

	@Override
	public String geraRelatorio() {
		String outPut = "RELATORIO DE SERVICOS DISPONIVEIS: ";
		for (Servico s : servicosOferecidos){
			outPut += "\n" + s.toString();
		}
		return outPut;
	}
}

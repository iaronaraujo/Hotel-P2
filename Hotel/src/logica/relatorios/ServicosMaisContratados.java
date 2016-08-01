package logica.relatorios;

import logica.utilitarios.ListaServicosContratados;

/**
 * 
 * Classe responsavel pela criacao do relatorio da quantidade de contratacoes de cada servico
 * @author luiz
 */
public class ServicosMaisContratados implements Relatorio{

	@Override
	public String geraRelatorio() {
		String outPut = "RELATORIO SERVICOS MAIS CONTRATADOS: ";
		outPut += "\n" + ListaServicosContratados.servicosMaisContratados();
		return outPut;
	}
}
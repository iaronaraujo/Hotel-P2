package logica.utilitarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import logica.servicos.Servico;

/**
 * Extensao de ArrayList<...> criada no intuito de facilitar a geracao de relatorios
 * @author luiz
 */
public class ListaServicosContratados extends ArrayList<Servico>{
	private static final long serialVersionUID = -3869908167562763947L;
	
	private static Map<String, Integer> mapaServicosContratados = new HashMap<String, Integer>(); 
	private static ComparadorDeValores comparador = new ComparadorDeValores(mapaServicosContratados);
	private static TreeMap<String, Integer> mapaOrdenadoServicosContratados;

	/**
	 * Versao modificada do ArrayList<...>.add(...) comum
	 */
	@Override
	public boolean add(Servico s){
		contadorServicosContratados(s);
		return super.add(s);
	}
	
	/**
	 * Adiciona no mapa a quantidade de servicos contratados de cada tipo
	 * 
	 * @param servico
	 * 				servico adicionado
	 */
	private void contadorServicosContratados(Servico servico){
		String nome = servico.getTipo();
		if(mapaServicosContratados.containsKey(nome)){
			int valorRelacionado = mapaServicosContratados.get(nome);
			mapaServicosContratados.put(nome, valorRelacionado + 1);
			return;
		}
		
		mapaServicosContratados.put(servico.getTipo(), 1);
	}

	/**
	 * Cria um TreeMap<...> com os elementos do mapa gerado na contagem dos servicos contratados em ordem
	 * decrescente de numero contratacoes
	 */
	public static void ordenacaoServicosContratados(){
		mapaOrdenadoServicosContratados = new TreeMap<>(comparador);
	}

	/**
	 * Gera uma String que mostra os servicos contratados e a quantidade de contratacoes de cada
	 * @return
	 */
	public static String servicosMaisContratados(){
		String outPut = "";
		ordenacaoServicosContratados();
		for(Map.Entry<String, Integer> relacaoElementos : mapaOrdenadoServicosContratados.entrySet()){

			if(!outPut.equals("")){
				outPut += "\n";
			}

			outPut += "\n" + "Servico: " + relacaoElementos.getKey() + "\n" + "Contratacoes: " + relacaoElementos.getValue();
		}
		return outPut;
	}
}
package logica.utilitarios;

import java.util.Comparator;
import java.util.Map;

/**
 * 
 * Comparador criado para ordenação do TreeMap<...> relacionado a ListaServicosContratados
 * @author luiz
 */
public class ComparadorDeValores implements Comparator<String> {
	
	Map<String, Integer> mapa;
	
	ComparadorDeValores(Map<String, Integer> mapa) {
		this.mapa = mapa;
	}
	
	public int compare(String a, String b){
		if (mapa.get(a) >= mapa.get(b)){
			return 1;
		}else {
			return -1;
		}
	}
}
package logica.utilitarios;

import java.io.Serializable;

/**
 * 
 * @author Iaron da Costa Araujo
 *
 * Esta classe eh a que irah conter todos os precos, ela
 * sera util para nosso projeto pois iremos fazer com que os
 * precos nao sejam estaticos, pois assim o gerenciador do hotel
 * possuira uma maior liberdade em relacao a gerencia do hotel
 * e os precos poderao acompanhar um certo padrao, como por exemplo
 * a inflacao de cada ano.
 */
public class GerenciadorDePrecos implements Serializable {
	private static final long serialVersionUID = -1965626404758833928L;
	
	private static double precoBabysitHoraNormal;
	
	public static double getPrecoBabysitHoraNormal() {
		return precoBabysitHoraNormal;
	}
	public static void setPrecoBabysitHoraNormal(double preco)  throws Exception{
		if(preco < 0) throw new Exception("O valor nao pode ser negativo!");
		GerenciadorDePrecos.precoBabysitHoraNormal = preco;
	}
	public static double getPrecoBabysitHoraDobrada() {
		return precoBabysitHoraNormal * 2;
	}
}

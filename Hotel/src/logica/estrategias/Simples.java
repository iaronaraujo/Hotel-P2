package logica.estrategias;

import java.io.Serializable;



/**
 *
 * @author luiz
 */
public class Simples implements EstrategiaDeTarifa, Serializable {
	private static final long serialVersionUID = 8714733237352306689L;
	
	double contaCheckout;
    double tarifaSimples = 0; // Pode ser alterada - DEFAULT = 0
    double valorTotalServicos;

 
    @Override
    public double calculaTotalGasto(double total) {
        return total + (tarifaSimples * total);
    }
}

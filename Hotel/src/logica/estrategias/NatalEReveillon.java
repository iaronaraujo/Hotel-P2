package logica.estrategias;

import java.io.Serializable;



/**
 *
 * @author luiz
 */
public class NatalEReveillon implements EstrategiaDeTarifa, Serializable {
	private static final long serialVersionUID = 6968193471076834965L;
	
	double contaCheckout;
    double tarifaNatalEReveillon = 0.50; // Acréscimo de 50% no Natal e Reveillon - DEFAULT

    public double calculaTotalGasto(double total) {
        return total + (tarifaNatalEReveillon * total);
    }
}

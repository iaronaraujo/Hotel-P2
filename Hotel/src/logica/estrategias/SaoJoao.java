package logica.estrategias;

import java.io.Serializable;

public class SaoJoao implements Serializable, EstrategiaDeTarifa {
	private static final long serialVersionUID = 1547922216099026354L;
	
	double contaCheckout;
    double tarifaSaoJoao = 0.10; // Acréscimo de 10% no São João - DEFAULT
    double valorTotalServicos;

    public double calculaTotalGasto(double total) {
        return total + (tarifaSaoJoao * total);
    }
}

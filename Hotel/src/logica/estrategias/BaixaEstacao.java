package logica.estrategias;

import java.io.Serializable;



/**
 *
 * @author luiz
 */
public class BaixaEstacao implements EstrategiaDeTarifa, Serializable {
	private static final long serialVersionUID = -5551918531669660419L;
	
	double contaCheckout;
    double tarifaBaixaEstacao = -0.10; // Desconto de 10% na baixa estação - DEFAULT
    double valorTotalServicos;

    public double calculaTotalGasto(double total) {
        return total + (tarifaBaixaEstacao * total);
    }
}

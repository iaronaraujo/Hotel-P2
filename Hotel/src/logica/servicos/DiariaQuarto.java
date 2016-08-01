package logica.servicos;

import java.io.Serializable;

import logica.quartos.tipos.Quarto;
import logica.quartos.tipos.QuartoExecutivoDuplo;
import logica.quartos.tipos.QuartoExecutivoSimples;
import logica.quartos.tipos.QuartoExecutivoTriplo;
import logica.quartos.tipos.QuartoLuxoSimples;
import logica.quartos.tipos.QuartoLuxoTriplo;
import logica.quartos.tipos.QuartoPresidencial;
import programa.exceptions.entradainvalida.ServicoInvalidException;
import programa.exceptions.servicos.CamasLogicException;
import programa.formatos.FormatFactory;

/**
 *
 * @author luiz
 */
public class DiariaQuarto implements Servico, Serializable {
	private static final long serialVersionUID = -3233771681283931253L;
	public static final String TIPO_SERVICO = "Quarto";
	private static int quantidade = 0;
	
    private String descricao;
    private int quantDeDias;
    private Quarto quarto;

    /**
     *
     * @param quartoDoHotel Objeto do tipo quarto que representa o quarto do
     * hotel a ser occupado
     * @param qDeDias Quantidade de dias da estadia(do alugel do quarto)
     * @param descricao Descrição do servico oferecido
     * @throws Exception Para quartoDoHotel fornecido nulo Para aDeDias
     * fornecida nula ou negativa Para descrição nula ou vazia Para quarto
     * ocupado
     */
    public DiariaQuarto(Quarto quartoDoHotel, int qDeDias, String descricao) throws Exception {
    	// Checando valores
    	checkQuarto(quartoDoHotel);
    	checkDescricao(descricao);
    	checkDias(qDeDias);

    	// Inicializando atributos
        this.quarto = quartoDoHotel;
        this.descricao = descricao;
        this.quantDeDias = qDeDias;
    }
    
    /**
     *
     * @return soma total do preço das diárias
     */
    @Override
    public double calculaPreco() {
        return quantDeDias * quarto.getPrecoDiaria();
    }

    /**
     *
     * @return quantidade de dias de estadia (diárias)
     */
    public int getQuantDeDias() {
        return quantDeDias;
    }

    /**
     * Atualiza a quantidade de diarias reservadas
     *
     * @param novaQDeDias novo numero de diarias
     * @throws Exception para quantidade de dias nula ou negativa
     */
    public void setQuantDeDias(int novaQuantDeDias) throws ServicoInvalidException {
    	checkDias(novaQuantDeDias);
        this.quantDeDias = novaQuantDeDias;
    }

    /**
     *
     * @return descriçao da reserva/serviço
     */
    @Override
	public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descriçao do servico prestado
     *
     * @param novaDescricao
     * 			Nova descricao
     * @throws Exception para descriçao - string - nula ou vazia
     */
    public void setDescricao(String novaDescricao) throws ServicoInvalidException {
    	checkDescricao(novaDescricao);
        this.descricao = novaDescricao;
    }
    
    public int getCamasExtras() {
    	return quarto.getQuantCamasExtras();
    }
    
    public String getTipo() {
    	return quarto.getNome();
    }

	public void setQuantCamasExtras(int novaQuantidade) throws CamasLogicException {
		quarto.setQuantCamasExtras(novaQuantidade);
	}
	
	@Deprecated
	public void setTipo(String novoTipo) {
		@SuppressWarnings("unused")
		String[] opcoesQuartos = new String[] {"Executivo Simples", "Luxo Simples", "Executivo Duplo",
					"Luxo Duplo", "Executivo Triplo", "Luxo Triplo",
					"Presidencial"};
		
		if (novoTipo.equalsIgnoreCase("Executivo Simples")) {
			try {
				quarto = new QuartoExecutivoSimples(this.getCamasExtras());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (novoTipo.equalsIgnoreCase("Luxo Simples")) {
			try {
				quarto = new QuartoLuxoSimples(this.getCamasExtras());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (novoTipo.equalsIgnoreCase("Executivo Duplo")) {
			try {
				quarto = new QuartoExecutivoDuplo(this.getCamasExtras());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (novoTipo.equalsIgnoreCase("Luxo Duplo")) {
			try {
				quarto = new QuartoLuxoSimples(this.getCamasExtras());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (novoTipo.equalsIgnoreCase("Executivo Triplo")) {
			try {
				quarto = new QuartoExecutivoTriplo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (novoTipo.equalsIgnoreCase("Luxo Triplo")) {
			try {
				quarto = new QuartoLuxoTriplo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (novoTipo.equalsIgnoreCase("Presidencial")) {
			try {
				quarto = new QuartoPresidencial();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
    private void checkQuarto(Quarto quarto) throws ServicoInvalidException {
    	if (quarto == null) throw new ServicoInvalidException();
    }
    
    private void checkDias(int dias) throws ServicoInvalidException {
    	if (dias <= 0) throw new ServicoInvalidException();
    }
    
    private void checkDescricao(String descricao) throws ServicoInvalidException {
    	if (!FormatFactory.validateString(descricao)) throw new ServicoInvalidException();
    }
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof DiariaQuarto)) return false;
		DiariaQuarto a = (DiariaQuarto)obj;
		
		if (a.getTipo().equals(this.getTipo())) return true;
		return false;
	}
	
	@Deprecated
	public void addQuantidade(){
		quantidade++;
	}
	
	@Deprecated
	public int getQuantidade(){
		return quantidade;
	}
	
	@Deprecated
	public void decrementaQuantidade(){
		quantidade--;
	}
}

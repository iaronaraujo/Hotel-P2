package logica.essenciais;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import logica.clientes.Hospede;
import logica.clientes.HospedeRepresentante;
import logica.enumeracoes.EstadoContrato;
import logica.estrategias.EstrategiaDeTarifa;
import logica.servicos.DiariaQuarto;
import logica.servicos.Servico;
import logica.utilitarios.Baba;
import logica.utilitarios.ListaServicosContratados;
import programa.exceptions.entradainvalida.CartaoInvalidException;
import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.DateInvalidException;
import programa.exceptions.entradainvalida.EstadoInvalidException;
import programa.exceptions.entradainvalida.HospedeInvalidException;
import programa.exceptions.entradainvalida.ServicoInvalidException;
import programa.exceptions.entradainvalida.TarifaInvalidException;
import programa.formatos.FormatFactory;

public class Contrato implements Serializable {
	private static final long serialVersionUID = -4594727453206992344L;
	
	private ArrayList<Servico> servicosContratados;
    private ArrayList<Hospede> hospedesAssociados;
    private ArrayList<Servico> servicosOferecidos;
    private EstrategiaDeTarifa tipoDeTarifa;
    private EstadoContrato estadoDoContrato;
    private GregorianCalendar dataInicial;
    private GregorianCalendar dataFinal;
    private ArrayList<Baba> babas;
    private String numCartao;

    public Contrato(HospedeRepresentante representante, GregorianCalendar dataInicial, GregorianCalendar dataFinal, EstrategiaDeTarifa tipoDeTarifa, String numCartao, ArrayList<Servico> servicosOferecidos, DiariaQuarto aluguel) throws DataInvalidException {
    	// Checando valores
    	checkDatas(dataInicial, dataFinal);
    	checkRepresentante(representante);
    	checkTarifa(tipoDeTarifa);
    	checkCartao(numCartao);
    	checkAluguel(aluguel);
    	
    	// Inicializando listas
        servicosContratados = new ListaServicosContratados();
        hospedesAssociados = new ArrayList<Hospede>();
        babas = new ArrayList<Baba>();
        
        // Inicializando atributos
        this.estadoDoContrato = EstadoContrato.ABERTO;
        this.servicosOferecidos = servicosOferecidos;
        this.hospedesAssociados.add(representante);
        this.tipoDeTarifa = tipoDeTarifa;
        this.dataInicial = dataInicial;
        this.adicionaServico(aluguel);
        this.dataFinal = dataFinal;
        this.numCartao = numCartao;
    }
    
    public double calculaTotalGasto() {
        double totalGasto = 0;
        double contaCheckout = 0;
        for (Servico s : servicosContratados) totalGasto += s.calculaPreco();
        contaCheckout = tipoDeTarifa.calculaTotalGasto(totalGasto);
        
        return contaCheckout;
    }

    public boolean adicionaHospede(Hospede hospede) {
        return (hospedesAssociados.contains(hospede)) ? (false) : (hospedesAssociados.add(hospede));
    }

    public boolean removeHospede(Hospede hospede) {
        return (!(hospede.equals(hospedesAssociados.get(0)))) ? (hospedesAssociados.remove(hospede)) : (false);
    }

    public boolean adicionaServico(Servico servico){
    	if (servicosOferecidos.remove(servico)) {
    		servico.addQuantidade();
    		return servicosContratados.add(servico);
    	}
    	
    	return false;
    }

    public boolean removeServico(Servico servico) {
        return (servicosContratados.remove(servico)) ? (servicosOferecidos.add(servico)) : (false);
    }

    public void setEstadoDoContrato(EstadoContrato novoEstado) throws EstadoInvalidException {
    	checkEstado(novoEstado);
        this.estadoDoContrato = novoEstado;
    }

    public EstadoContrato getEstadoDoContrato() {
        return estadoDoContrato;
    }

    @Deprecated
    public boolean atualizaHospede(Hospede hospedeMudar, Hospede novasInformacoes) {
    	// Quando usei o contains() por algum motivo deu erro.
        for (Hospede h : hospedesAssociados) {
        		if(h.equals(hospedeMudar)){
        			int i = hospedesAssociados.indexOf(h);
        			hospedesAssociados.set(i, novasInformacoes);
        			return true;
        	}
        }
        return false;
    }

    @Deprecated
    public List<Hospede> getListaDeHospedesAssociados(){
    	/*List<Hospede> listaDeHospedesCopia = new ArrayList<Hospede>();
    	for (Hospede hospede : listaDeHospedesAssociados) {
    		listaDeHospedesCopia.add(new Hospede(hospede));
    	}
    	System.out.println(listaDeHospedesCopia.size() + " DE CONTRATO");*/
        return hospedesAssociados;
    }


    @Deprecated
    public List<Servico> getListaDeServicosContratados() {
        return servicosContratados; 
    }


    public GregorianCalendar getDataInicial() {
        return new GregorianCalendar(dataInicial.get(Calendar.YEAR), dataInicial.get(Calendar.MONTH), dataInicial.get(Calendar.DAY_OF_MONTH));
    }

    public void setDataInicial(GregorianCalendar novaData) throws DateInvalidException, DateInvalidException {
    	checkDatas(novaData, this.dataFinal);
        this.dataInicial = novaData;
    }

    public GregorianCalendar getDataFinal() {
        return new GregorianCalendar(dataFinal.get(Calendar.YEAR), dataFinal.get(Calendar.MONTH), dataFinal.get(Calendar.DAY_OF_MONTH));
    }

    public void setDataFinal(GregorianCalendar novaData) throws DateInvalidException, DateInvalidException {
    	checkDatas(novaData, this.dataFinal);
        this.dataFinal = novaData;
    }

    public EstrategiaDeTarifa getTipoDeTarifa() {
        return tipoDeTarifa;
    }

    public void setTipoDeTarifa(EstrategiaDeTarifa novoTipo) throws TarifaInvalidException {
    	checkTarifa(novoTipo);
        this.tipoDeTarifa = novoTipo;
    }

    @Deprecated
    public List<Servico> getServicosOferecidos() {
        return servicosOferecidos;
    }

  

    public String getNumCartaoDeCredito() {
        return numCartao;
    }

    public void setNumCartaoDeCredito(String novoNumero) throws CartaoInvalidException {
    	checkCartao(novoNumero);
        numCartao = novoNumero;
    }
    
   public Hospede pesquisaHospede(Hospede hospede) throws HospedeInvalidException { // REVER
       if (hospede == null) throw new HospedeInvalidException();

       for (Hospede h : hospedesAssociados) {
           if (h.equals(hospede)) {
               return h;
           }
       }
       return null;
   }
   
   public HospedeRepresentante getRepresentante() {
	   return (HospedeRepresentante) hospedesAssociados.get(0);
   }
   
   private void checkRepresentante(HospedeRepresentante representante) throws HospedeInvalidException {
	   if(representante == null) throw new HospedeInvalidException();
   }
   
   private void checkDatas(GregorianCalendar dataInicial, GregorianCalendar dataFinal) throws DateInvalidException {
	   if (dataFinal == null) throw new DateInvalidException();
	   if (dataInicial == null) throw new DateInvalidException();
	   if (dataInicial.compareTo(dataFinal) >= 0) throw new DateInvalidException();
   }
   
   private void checkTarifa(EstrategiaDeTarifa tipoDeTarifa) throws TarifaInvalidException {
	   if (tipoDeTarifa == null) throw new TarifaInvalidException();
   }
   
   private void checkCartao(String numCartao) throws CartaoInvalidException {
	   if (!FormatFactory.validateDigitOnlyString(numCartao)) throw new CartaoInvalidException();
   }
   
   private void checkAluguel(DiariaQuarto diaria) throws ServicoInvalidException {
	   if (diaria == null) throw new ServicoInvalidException();
   }
   
   private void checkEstado(EstadoContrato estado) throws EstadoInvalidException {
	   if (estado == null) throw new EstadoInvalidException();
   }

   @Override
   public boolean equals(Object obj) {
	   if (!(obj instanceof Contrato)) return false;
	   Contrato contratoTemp = (Contrato) obj;
  
	   if (contratoTemp.getDataFinal().equals(dataFinal) && contratoTemp.getDataInicial().equals(dataInicial) && contratoTemp.getRepresentante().equals(this.getRepresentante())) {            
		   return true;
	   }

	   return false;
    }
}
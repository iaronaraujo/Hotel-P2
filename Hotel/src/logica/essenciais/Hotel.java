package logica.essenciais;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import logica.enumeracoes.EstadoContrato;
import logica.relatorios.Relatorio;
import logica.servicos.Servico;
import logica.utilitarios.Opiniao;
import programa.exceptions.entradainvalida.CampoInvalidException;
import programa.exceptions.entradainvalida.ContratoInvalidException;
import programa.exceptions.entradainvalida.DataInvalidException;
import programa.exceptions.entradainvalida.EstadoInvalidException;
import programa.exceptions.entradainvalida.OpiniaoInvalidException;
import programa.exceptions.entradainvalida.ServicoInvalidException;
import programa.formatos.FormatFactory;

public class Hotel implements Serializable {
	private static final long serialVersionUID = 4315027199377374913L;
	public static final String LOCALIZACAO = "Brasil";
	
	private List<Servico> servicosOferecidos;
    private List<Contrato> contratos;
    private List<Opiniao> opinioes;
    private String localidade;
    private String nomeHotel;

    public Hotel(String nomeHotel, String localidade) throws DataInvalidException {
    	// Checando valores
    	checkCampo(localidade);
    	checkCampo(nomeHotel);
    	
    	// Inicializando listas
        this.servicosOferecidos = new ArrayList<Servico>();
        this.contratos = new ArrayList<Contrato>();
    	this.opinioes = new ArrayList<Opiniao>();
    	
        // Inicializando Atributos
        this.localidade = localidade;
        this.nomeHotel = nomeHotel;
    }
    
    public boolean checkIn(Contrato contrato) throws ContratoInvalidException {
        if (contrato == null) throw new ContratoInvalidException();
        return contratos.add(contrato);
    }

    public boolean checkOut(Contrato contrato) throws ContratoInvalidException, EstadoInvalidException {
    	if (contrato == null)  throw new ContratoInvalidException();

        for (Contrato c : contratos) {
            if (c.equals(contrato)) {
                c.setEstadoDoContrato(EstadoContrato.FECHADO);
                return true;
            }
        }
        
        return false;
    }

    public Contrato pesquisaContrato(Contrato contrato) throws ContratoInvalidException {
        if (contrato == null) throw new ContratoInvalidException();

        for (Contrato c : contratos) {
            if (c.equals(contrato)) {
                return c;
            }
        }
        
        return null;
    }

    public boolean adicionaServico(Servico servico) throws ServicoInvalidException {
        if (servico == null) throw new ServicoInvalidException();
        return servicosOferecidos.add(servico);
    }
    
    public boolean removeServico(Servico servico) throws ServicoInvalidException{
    	if (servico == null) throw new ServicoInvalidException();
    	return servicosOferecidos.remove(servico);
	}
    
    public String geraRelatorio(Relatorio relatorio) throws Exception{
    	return relatorio.geraRelatorio();
    }

    public Servico pesquisaServico(Servico servico) throws ServicoInvalidException {
        if (servico == null) throw new ServicoInvalidException();

        for (Servico s : servicosOferecidos) {
            if (s.equals(servico)) {
                return s;
            }
        }
        
        return null;
    }
    
    public boolean adicionaOpiniao(Opiniao opiniao) throws OpiniaoInvalidException {
        if (opiniao == null) throw new OpiniaoInvalidException();
        return opinioes.add(opiniao);
    }

    public double mediaDeAceitacao() {
        double total = 0;
        if (opinioes.isEmpty()) return 0.0;
        for(Opiniao o : opinioes){
            total += o.getNota();
        }
        double media = total / opinioes.size();
        
        return media;
    }
    
    public String getLocalidade() {
        return localidade;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setLocalidade(String novaLocalidade) throws CampoInvalidException {
        checkCampo(novaLocalidade);
        this.localidade = novaLocalidade;
    }
    
    public void setNomeHotel(String novoNome) throws CampoInvalidException {
    	checkCampo(novoNome);
        this.nomeHotel = novoNome;
    }
    
    @Deprecated
    public List<Servico> getServicosOferecidos() {
		return servicosOferecidos;
	}
    
    @Deprecated
    public List<Contrato> getContratos(){
		return contratos;
	}
    
    @Deprecated
    public List<Opiniao> getOpinioes() {
		return opinioes;
	}
      
    private void checkCampo(String campo) throws CampoInvalidException {
    	if (!FormatFactory.validateString(campo)) throw new CampoInvalidException();
   }
}

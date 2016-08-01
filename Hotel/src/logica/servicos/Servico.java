package logica.servicos;

/**
 * 
 * @author Wesley
 * Interface que ira representar servico
 */
public interface Servico {
    double calculaPreco();
    @Deprecated
    void addQuantidade();
    String getDescricao();
    public String getTipo();
}

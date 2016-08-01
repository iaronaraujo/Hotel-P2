package programa.arquivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Classe para criaçao de um arquivo
 * 
 * @author arthur
 * @param <t>
 *
 */

public class CreateFile<T> {
	private ObjectOutputStream saveFile;
	private ObjectInputStream saveFileInput;
	private final String nomeArquivo;
	private T x;
	
	/**
	 * Cria um arquivo recebendo seu nome
	 * 
	 * @param nomeArquivo
	 * 		O nome do arquivo 
	 */
	
	public CreateFile(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	/**
	 * Abre uma stream na forma de object
	 * 
	 */
	
	public void open() {
		try {
			saveFile = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
			saveFileInput = new ObjectInputStream(new FileInputStream(nomeArquivo));
		} catch (Exception e) {
			System.out.println("DEU MERDA");
		} finally {
			
		}
	}
	
	/**
	 * Escreve o objeto no arquivo
	 * 
	 * @param f
	 * 		Um funcionario
	 */
	
	public void write(T f) {
		T obj = f;
		try{
			saveFile.writeObject(obj);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Funcionario> readFuncionarios() {
		try {
			return (ArrayList<Funcionario>) saveFileInput.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return new ArrayList<Funcionario>();
		}
	}
	
	/**
	 * Le as informacoes do objeto gravado no arquivo
	 * 
	 * @return O objeto gravado no arquivo
	 */
	
	public T read(){
		try {
			x = (T) saveFileInput.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	/**
	 * Fecha a stream da forma de object
	 * 
	 * @throws Exception
	 */
	
	public void close() throws Exception{
		saveFile.close();
		saveFileInput.close();
	}
}

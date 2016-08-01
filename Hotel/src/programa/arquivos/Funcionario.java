package programa.arquivos;

import java.io.Serializable;

/**
 * Classe para a criacao de um Funcionario
 * 
 * @author arthur
 *
 */

public class Funcionario implements Serializable{
	private static final long serialVersionUID = 2304304832L;
	private final String usuario;
	private String senha;
	private final String tipo;
	private String email;
	
	/**
	 * Cria um funcionario a partir do usuario, senha, tipo e email
	 * 
	 * @param usuario
	 * 		O nome do usuario
	 * @param senha
	 * 		A senha do usuario
	 * @param tipo
	 * 		O tipo do usuario
	 * 		O email do usuario
	 * @param email
	 */
	
	public Funcionario(String usuario, String senha, String tipo, String email) {
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
		this.email = email;
	}
	
	/**
	 * Recupera a senha
	 * 
	 * @return senha
	 */

	public String getSenha() {
		return senha;
	}
	
	/**
	 * Atualiza a senha
	 * 
	 * @param senha
	 * 		a nova senha do usuario
	 */
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Recupera o email
	 * 
	 * @return O email
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * Atualiza o email
	 * 
	 * @param email
	 * 		O novo email do usuario
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Recupera o nome do usuario
	 * 
	 * @return O nome do usuario
	 */
	
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s, %s, %s, %s", usuario, senha, tipo, email);
	}
}

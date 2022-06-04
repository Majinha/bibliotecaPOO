package Amigo;

/**Classe para objetos do tipo Amigo, onde serão contidos, valores e métodos para o mesmo.
* @author Mariana Trentiny Barbosa
* @version 1.8.0_202-b08
* @since Release 01 da aplicação
*/

public class Amigo {
	
	private int idAmigo;
	private String nome;
	private String celular;
	
	

	public Amigo(int idAmigo, String nome, String celular) {
		super();
		this.idAmigo = idAmigo;
		this.nome = nome;
		this.celular = celular;
	}

	 /** Método para retorno do idAmigo do Amigo
	 * @return String - Nr do amigo*/
	public int getIdAmigo() {
		return idAmigo;
	}

	 /** Método para retorno do nome do Amigo
	 * @return String - Nome do amigo*/
	public String getNome() {
		return nome;
	}

	 /** Método para retorno do celular do Amigo
	 * @return String - Celular do amigo*/
	public String getCelular() {
		return celular;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	@Override
	public String toString() {
		return "\n   " + idAmigo + "-" + "nome: " + nome + "\n   celular: " + celular;
	}
}

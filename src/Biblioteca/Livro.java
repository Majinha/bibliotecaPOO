package Biblioteca;

/**Classe para objetos do tipo Livro, onde serão contidos, valores e métodos para o mesmo.
* @author Mariana Trentiny Barbosa
* @version 1.8.0_202-b08
* @since Release 01 da aplicação
*/


public class Livro implements Comparable<Livro> {
	private int idLivro;
	private String titulo;
	private String autor;
	private float preco;
	private Disponibilidade disponibilidade;

	public Livro(int idLivro, String titulo, String autor, float preco, Disponibilidade disponibilidade) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.disponibilidade = disponibilidade;
	} //todos sao requisitados para a operacao acontecer naturalmente
	
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
		
	}

	public Disponibilidade setDisponibilidade(Disponibilidade disponibilidade) {
		return this.disponibilidade = disponibilidade;
	}

	@Override
	public String toString() {
		return "\n   " + idLivro + " - " + "titulo: " + titulo + "\n   autor: " + autor + "\n   preco: " + preco + "\n   Disponibilidade: " + disponibilidade;
	}
	
	@Override
	public int compareTo(Livro livro) {
		//nome.compareToIgnoreCase(contato.nome)
		// na main pode fazer o comparator para voltar, usando o id
		return this.getTitulo().compareTo(livro.getTitulo());
	}
   
}

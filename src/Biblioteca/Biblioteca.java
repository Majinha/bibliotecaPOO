package Biblioteca;

/**ArrayList do tipo Biblioteca para objetos do tipo Livro, onde serão guardados e ordenados, valores para o mesmo.
* @author Mariana Trentiny Barbosa
* @version 1.8.0_202-b08
* @since Release 01 da aplicação
*/


import java.util.ArrayList;

public class Biblioteca {

	private String nome;
	private static ArrayList<Livro> alLivros;
	private float investimento;
	
	//construtor que cria o alLivros, pois o array esta encapsulado
	public Biblioteca(String nome) {
		super();
		this.nome = nome;
		this.alLivros = new ArrayList<Livro>();
		investimento = 0;
	}
	
	public static Livro addLivro(String titulo, String autor, float preco, Disponibilidade dispLivro) {
		int idLivro = alLivros.size() + 1;
		Livro livro = new Livro(idLivro, titulo, autor, preco, dispLivro);
		alLivros.add(livro);
		return livro;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static ArrayList<Livro> getAlLivros() {
		return alLivros;
	}

	public float getInvestimento() {
		return investimento;
	}

	public void setInvestimento(float investimento) {
		this.investimento = investimento;
	}
	
	public Livro getLivro(int idLivro) {
		return alLivros.get(idLivro - 1);
	}
}

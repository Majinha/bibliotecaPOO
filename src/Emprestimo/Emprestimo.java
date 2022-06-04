package Emprestimo;

/**Classe para objetos do tipo Emprestimo, onde serão contidos, valores e métodos para o mesmo.
* @author Mariana Trentiny Barbosa
* @version 1.8.0_202-b08
* @since Release 01 da aplicação
*/


import java.time.LocalDate;

import Amigo.Amigo;
import Biblioteca.Livro;

public class Emprestimo {

	private int idAmigo;
	private int idLivro;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	
	public Emprestimo(int idAmigo, int idLivro, int dia, int mes, int ano) {
		this.idAmigo = idAmigo;
		this.idLivro = idLivro;
		this.dataEmprestimo = LocalDate.of(ano, mes, dia);
		this.dataDevolucao = LocalDate.of(1900, 01, 01);
	}
	
	

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao() {
		this.dataDevolucao = LocalDate.now();
	}

	public int getIdAmigo() {
		return idAmigo;
	}

	public int getIdLivro() {
		return idLivro;
	}
	
	
	@Override
	public String toString() {
		return "\n   idAmigo:" + idAmigo  + "\n   idLivro:" + idLivro + "\n   data do emprestimo:" + dataEmprestimo;
	}
}

package Emprestimo;

/**ArrayList do tipo ListaEmprestimo para objetos do tipo Emprestimo, onde serão guardados e ordenados, valores para o mesmo.
* @author Mariana Trentiny Barbosa
* @version 1.8.0_202-b08
* @since Release 01 da aplicação
*/


import java.time.LocalDate;
import java.util.ArrayList;

public class ListaEmprestimo {

	private ArrayList<Emprestimo> alEmprestimos;


	// construtor cria alEmprestimos, ArrayList que fica encapsulado na classe ListaEmprestimos
	public ListaEmprestimo() {
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}	
	
	public Emprestimo addEmprestimo (int idAmigo, int idLivro, int dia, int mes, int ano) {
		Emprestimo emprestimos = new Emprestimo(idAmigo, idLivro, dia, mes, ano);
		alEmprestimos.add(emprestimos);
		return emprestimos;
	}

	public ArrayList<Emprestimo> getAlEmprestimos() {
		return alEmprestimos;
	}

	public void setAlEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
	}
	
}

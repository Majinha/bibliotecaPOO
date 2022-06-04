package Main;

/**Classe Main, onde serão contidos, funções e métodos para o programa.
* @author Mariana Trentiny Barbosa
* @version 1.8.0_202-b08
* @since Release 01 da aplicação
*/

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import Amigo.*;
import Biblioteca.*;
import Emprestimo.*;

public class Main {
	static Scanner teclado = new Scanner(System.in);
	private static Biblioteca livros = new Biblioteca(null);
	private static ListaEmprestimo emprestimos = new ListaEmprestimo();
	private static ListaAmigo amigos = new ListaAmigo();
	
	public static void main(String[] args) {
		Amigo idAmigo;
		Livro idLivro;
		
		idAmigo = amigos.addAmigo("Pedro", "(41) 99876-5432");
		idAmigo = amigos.addAmigo("Maria", "(47) 98123-2121");
		idAmigo = amigos.addAmigo("Joao", "(47) 98123-2121");
		idAmigo = amigos.addAmigo("Paulo", "(47) 98123-2121");
		idAmigo = amigos.addAmigo("Alberto", "(47) 98123-2121");
		idLivro = Biblioteca.addLivro("A maquina do tempo", "HG Wells",23.5f, Disponibilidade.CONSULTALOCAL);
		idLivro = Biblioteca.addLivro("Um de nos esta mentindo", "Karen McMannus", 36.3f, Disponibilidade.DISPONIVEL);
		idLivro = Biblioteca.addLivro("O fim", "Lemony Snicket", 13.50f, Disponibilidade.DISPONIVEL);
		idLivro = Biblioteca.addLivro("Shada", "Douglas Adams", 90.9f, Disponibilidade.DANIFICADO);
		idLivro = Biblioteca.addLivro("O caçador de zumbis", "John Kopler", 28.90f, Disponibilidade.DISPONIVEL);
		
		int opcao;
		do {
			// menu
			System.out.print("\n\n\n\n   ----------------------\n");
			System.out.println("   Menu de opções:");
			System.out.println("   0  -  sair");
			System.out.println("   1  -  incluir amigo");
			System.out.println("   2  -  incluir livro");
			System.out.println("   3  -  remover amigo");
			System.out.println("   4  -  remover livro");
			System.out.println("   5  -  procurar amigo");
			System.out.println("   6  -  emprestar um livro");
			System.out.println("   7  -  devolver um livro");
			System.out.println("   8  -  listar todos os amigos");
			System.out.println("   9  -  listar todos os emprestimos atuais");
			System.out.println("   10 -  listar o historico de emprestimo de um livro");
			System.out.println("   11 -  biblioteca (todos os livros)");
			System.out.print("\n   Qual a sua escolha: ");
			opcao = teclado.nextInt();
			System.out.print("   -----------------------------------------------------------\n");
			teclado.nextLine();
			switch (opcao) {
			// por ser static nao era necessario o direcionamento das funcoes
			// com listaAmigo
			case 1:
				addAmigs();
				break;
			case 2:
				addlivrs();
				break;
			case 3:
				deleteAmigo();
				break;
			case 4:
				deleteLivro();
				break;
			case 5:
				searchAmigo();
				break;
			case 6:
				emprestaLivro();
				break;
			case 7:
				devolveLivro();
				break;
			case 8:
				allAmigos();
				break;
			case 9:
				listaUmLivro();
				break;
			case 10:
				historico();
				break;
			case 11:
				allLivros();
				break;
			}
		} while (opcao != 0);
		teclado.close();
	}
	
	/* 1 - ADICIONAR AMIGO */
	 /**Método para adicionar um novo amigo ao ArrayList ListaAmigo
	 * @author Mariana Trentiny Barbosa
	 * @param idAmigo int do tipo Amigo - Número único do Amigo. 
	 * @param nome String - Nome do Amigo.
	 * @param celular String - Numero guardado como String para informações do Amigo.
	 * @return idAmigo - A ação addAmigo ao final do método.
	 */
	private static Amigo addAmigs() {
		Amigo idAmigo;
		String nome;
		String celular;
		System.out.print("   Qual o nome do amigo que quer incluir? ");
		nome = teclado.nextLine();
		System.out.print("   Qual o celular do/a " + nome + "? ");
		celular = teclado.nextLine();
		idAmigo = amigos.addAmigo(nome, celular);
		System.out.println("   Amigo add com sucesso!");
		return idAmigo;
	}
	
	/* 2 - ADICIONAR LIVRO */
	 /**Método para adicionar um novo livro ao ArrayList Biblioteca
	 * @author Mariana Trentiny Barbosa
	 * @param idLivro int do tipo Livro - Número único do Livro. 
	 * @param titulo String - Titulo do Livro.
	 * @param autor String - Autor do Livro.
	 * @param preco Float - Float para guardar o Valor do Livro.
	 * @param i int - Usado para a escolha ao Menu de Escolhas de Disponibilidade.
	 * @return null - Void.
	 */
	private static Livro addlivrs() {
		Livro idLivro;
		String titulo;
		String autor;
		Float preco;
		Integer i;
		
		System.out.print("   Qual o nome do livro que quer incluir? ");
		titulo = teclado.nextLine();
		System.out.print("   Qual o autor do livro " + titulo + "? ");
		autor = teclado.nextLine();
		System.out.print("   Qual o preco do livro " + titulo + "? ");
		preco = teclado.nextFloat();
		System.out.print("\n\n   1 - DISPONIVEL\n   2 - CONSULTALOCAL\n   3 - EMPRESTADO\n   4 - DANIFICADO\n   5 - EXTRAVIADO\n");
		System.out.print("   Qual a disponibilidade do livro " + titulo + "?");
		i = teclado.nextInt();
		switch (i) {
		case 1:
			idLivro = Biblioteca.addLivro(titulo, autor, preco, Disponibilidade.DISPONIVEL);
			return idLivro;
		case 2:
			idLivro = Biblioteca.addLivro(titulo, autor, preco, Disponibilidade.CONSULTALOCAL);
			return idLivro;
		case 3:
			idLivro = Biblioteca.addLivro(titulo, autor, preco, Disponibilidade.EMPRESTADO);
			return idLivro;
		case 4:
			idLivro = Biblioteca.addLivro(titulo, autor, preco, Disponibilidade.DANIFICADO);
			return idLivro;
		case 5:
			idLivro = Biblioteca.addLivro(titulo, autor, preco, Disponibilidade.EXTRAVIADO);
			return idLivro;
		}
		return null;
	}
	
	/* 3 - DELETAR AMIGO */
	 /**Método para Deletar um amigo ao ArrayList ListaAmigo
	 * @author Mariana Trentiny Barbosa
	 * @param Amigo String do tipo Amigo - Classe Amigo. 
	 * @param nome String - Nome do Amigo.
	 * @param conferir String - Resposta do úsuario para Deletar o Amigo.
	 */
	private static void deleteAmigo() {
		Amigo amigo;
		String nome;
		String conferir;
		
		System.out.print("   Qual o nome do amigo que deseja deletar? ");
		nome = teclado.nextLine();
		
		boolean achou = false;
		Iterator<Amigo> it = amigos.getAlAmigos().iterator();
		while(it.hasNext() && !achou) {
			amigo = it.next();
			if(amigo.getNome().toUpperCase().contains(nome.toUpperCase())) {
				System.out.println("   "+amigo.getNome()+" encontrado");
				System.out.println("   Quer mesmo deletar o "+amigo.getNome()+"?");
				conferir = teclado.nextLine();
				if(conferir.toUpperCase().charAt(0) == 'S') {
					achou = true;
					System.out.println("   Quer mesmo deletar? ");
					conferir = teclado.nextLine();
					if(conferir.toUpperCase().charAt(0) == 'S') {
						System.out.println("   Amigo deletado com sucesso!");
						it.remove();
					}
				}
			}
		} if(!achou) {
			System.out.println("   Amigo não encontrado :( tente novamente");
		}
	}
	
	/* 4 - DELETAR LIVRO */
	 /**Método para Deletar um livro ao ArrayList Biblioteca
	 * @author Mariana Trentiny Barbosa
	 * @param livro String do tipo Livro - Classe Livro. 
	 * @param titulo String - Titulo do livro.
	 * @param conferir String - Resposta do úsuario para Deletar o Livro.
	 */
	private static void deleteLivro() {
		Livro livro;
		String titulo;
		String conferir;
		boolean achou = false;
		
		System.out.print("   Qual o titulo do livro que deseja deletar? ");
		titulo = teclado.nextLine();
		
		Iterator<Livro> it = Biblioteca.getAlLivros().iterator();
		while(it.hasNext() && !achou) {
			livro = it.next();
			if(livro.getTitulo().toUpperCase().contains(titulo.toUpperCase())) {
				System.out.println("   "+livro.getTitulo()+" encontrado!");
				System.out.println("   Quer mesmo deletar o "+livro.getTitulo()+"?");
				conferir = teclado.nextLine();
				if(conferir.toUpperCase().charAt(0) == 'S') {
					System.out.println("   Quer mesmo deletar o livro?");
					conferir = teclado.nextLine();
					if(conferir.toUpperCase().charAt(0) == 'S') {
						achou = true;
						System.out.println("   Livro deletado com sucesso!");
						it.remove();
					}
				}
			}
		} if(!achou) {
			System.out.println("   Titulo não encontrado :( tente novamente");
		}
		
	}
	
	/* 5 - ACHAR O AMIGO */
	 /**Método para Achar um amigo ao ArrayList ListaAmigo
	 * @author Mariana Trentiny Barbosa
	 * @param amigo String - Utilizado para o Scanner, resposta do usuário. 
	 * @param conferir String - Resposta do úsuario para Achar o Amigo.
	 * @param achou Boolean - Para a busca por Nomes no programa.
	 */
	private static void searchAmigo() {
		String amigo;
		String conferir;
		boolean achou = false;
		
		System.out.println("   Qual amigo voce gostaria de ver os dados? ");
		amigo = teclado.nextLine();
		for (Amigo itarable : amigos.getAlAmigos()) {
			if(itarable.getNome().toUpperCase().contains(amigo.toUpperCase())) {
				System.out.println("   Amigo encontrado!! ");
				System.out.println("   Nome: " + itarable.getNome()+ "\n   Esse que voce estava procurando? ");
				conferir = teclado.nextLine();
				if(conferir.toUpperCase().charAt(0) == 'S') {
					achou = true;
					System.out.println("   Nome: " + itarable.getNome());
					System.out.println("   Celular: " + itarable.getCelular());
				}
			}
		}
	}
	
	/* 6 - EMPRESTAR UM LIVRO */
	 /**Método para Achar um amigo ao ArrayList ListaAmigo
	 * @author Mariana Trentiny Barbosa
	 * @param conferir String - Resposta do úsuario para Achar o Amigo e o Livro correto.
	 * @param amigo String - Guardar a resposta digitada pelo usuário.
	 * @param titulo - Guardar a resposta digitada pelo usuário.
	 * @param idA int iniciado em 0 - Instanciado para guardar o idAmigo.
	 * @param idL int iniciado em 0 - Instanciado para guardar o idLivro.
	 * @param dia int - Dia digitado pelo usuário.
	 * @param mes int - Mes digitado pelo usuário.
	 * @param ano int - Ano digitado pelo usuário.
	 * @param achou Boolean - Para a busca por Nomes e Livros no programa.
	 */
	private static void emprestaLivro() {
		String conferir;
		String amigo;
		String titulo;
		Integer idA = 0;
		Integer idL = 0;
		Integer dia;
		Integer mes;
		Integer ano;
		boolean achou = false;
		System.out.println("   Qual o nome do amigo que vai emprestar o livro? ");
		amigo = teclado.nextLine();
		for (Amigo itarable : amigos.getAlAmigos()) {
			if(itarable.getNome().toUpperCase().contains(amigo.toUpperCase())) {
				System.out.println("   Amigo encontrado!! ");
				System.out.println("   Nome: " + itarable.getNome()+ "\n   Esse que voce estava procurando? ");
				conferir = teclado.nextLine();
				if(conferir.toUpperCase().charAt(0) == 'S') {
					achou = true;
					System.out.println("   idAmigo: "+ itarable.getIdAmigo());
					System.out.println("   Nome: " + itarable.getNome());
					idA = itarable.getIdAmigo();
				}
			}
		}
		System.out.println("   Qual o nome do livro que ele vai emprestar");
		titulo = teclado.nextLine();
		for (Livro livro : livros.getAlLivros()) {
			if(livro.getTitulo().toUpperCase().contains(titulo.toUpperCase())) {
				Disponibilidade estado = livro.getDisponibilidade();
				if(estado != Disponibilidade.DANIFICADO) {
					System.out.println("   Titulo encontrado!! ");
					System.out.println("   Titulo: " + livro.getTitulo()+ "\n   Esse que voce estava procurando? ");
					conferir = teclado.nextLine();
					achou = false;
					if(conferir.toUpperCase().charAt(0) == 'S') {
						achou = true;
						System.out.println("   idLivro: "+ livro.getIdLivro());
						System.out.println("   Nome: " + livro.getTitulo());
						idL = livro.getIdLivro();
						livro.setDisponibilidade(Disponibilidade.EMPRESTADO);
						System.out.print("   Qual o dia que ele vai emprestar? ");
						dia = teclado.nextInt();
						System.out.print("   Qual o mes? ");
						mes = teclado.nextInt();
						System.out.print("   Qual o ano? ");
						ano = teclado.nextInt();
						emprestimos.addEmprestimo(idA, idL, dia, mes, ano);
						break;
					}
				}else {
					System.out.println("   O titulo no momento está como danificado :( tente novamente mais tarde");
					break;
				}
			}
		}
	}

	/* 7 - DEVOLUCAO DE UM LIVRO EMPRESTADO */
	private static void devolveLivro() {
		Livro livro;
		Emprestimo emprestimo;
		String devolucao;
		String conferir;
		
		System.out.println("   Que livro gostaria de devolver? ");
		devolucao = teclado.nextLine();
		
		boolean achou = false;
		Iterator<Emprestimo> it = emprestimos.getAlEmprestimos().iterator();
		while(it.hasNext() && !achou) {
			emprestimo = it.next();
			livro = livros.getLivro(emprestimo.getIdLivro());
			if(livro.getTitulo().toUpperCase().contains(devolucao.toUpperCase())) {
				if(emprestimo.getDataDevolucao().getYear()==1900) {
					System.out.println("   "+livro.getTitulo()+" encontrado");
					System.out.println("   Quer mesmo devolver o "+livro.getTitulo()+"?");
					conferir = teclado.nextLine();
					if(conferir.toUpperCase().charAt(0) == 'S') {
						achou = true;
						System.out.println("   Livro devolvido com sucesso!");
						livro.setDisponibilidade(Disponibilidade.DISPONIVEL);
						emprestimo.setDataDevolucao();
					}
				}
			}
		} if(!achou) {
			System.out.println("   Emprestimo não encontrado :( tente novamente");
		}
	}
	
	/* 8 - LISTA DE TODOS OS AMIGOS */
	private static void allAmigos() {
		Iterator<Amigo> it = amigos.getAlAmigos().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/* 9 - LISTAR TODOS OS EMPRESTIMOS */
	private static void listaUmLivro() {
		Livro livro;
		Iterator<Livro> it = livros.getAlLivros().iterator();
		while(it.hasNext()) {
			livro = it.next();
			Disponibilidade d = livro.getDisponibilidade();
			if(d == Disponibilidade.EMPRESTADO)
			System.out.println(livro);
		}
	}
	
	/* 10 - HISTORICO DE EMPRESTIMOS */
	private static void historico() {
		Emprestimo emprestimo;
		Livro livro;
		Amigo amigo;
		String emprestado;
		
		System.out.print("   Qual livro gostaria de ver os emprestimos? ");
		emprestado = teclado.nextLine();
		Iterator<Emprestimo> it = emprestimos.getAlEmprestimos().iterator();
		while(it.hasNext()) {
			emprestimo = it.next();
			livro = livros.getLivro(emprestimo.getIdLivro());	
			if(livro.getTitulo().toUpperCase().contains(emprestado.toUpperCase())) {
				amigo = amigos.getAmigo(emprestimo.getIdAmigo());
				System.out.println("   \nTitulo: "+livro.getTitulo());
				System.out.println("   Nome: "+amigo.getNome());
				System.out.println("   Emprestimo: " + emprestimo.getDataEmprestimo());
				if(emprestimo.getDataDevolucao().getYear()==1900) {
					System.out.println("   Devolucao: Livro ainda emprestado!");
				} else { 
					System.out.println("   Devolucao: " + emprestimo.getDataDevolucao()); 
				}
			}
		}
	}
	
	/*11 - LISTA DE TODOS OS LIVROS */
	private static void allLivros() {
		// com o comparator da pra fazer return livro1.getIdLivro - livro2.getIdLivro, 
		//ele voltaria para a ordem certa
		//ArrayList<Livro> clone = (ArrayList(<Livro>) livros.clone();
		List<Livro> lista = new ArrayList<Livro>(livros.getAlLivros());
		Collections.sort(lista);
		Iterator<Livro> it = lista.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

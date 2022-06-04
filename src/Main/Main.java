package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import Dados.Contato;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Contato> listaContatos = new ArrayList<Contato>();


    public static void main(String[] args) {
        int opcao;  
        //tem como deixar a listaContatos = new ArrayList<Contato>(); aqui!!
        
        Contato c1 = new Contato("Maria");
        listaContatos.add(c1);
        listaContatos.add(new Contato("Pedro"));
        listaContatos.add(new Contato("Joao"));
        listaContatos.add(new Contato("Thiago"));
        listaContatos.add(new Contato("Matheus", 10, 8, 2000));
        listaContatos.add(new Contato("Marcos"));
        do {
            // menu
            System.out.println("Menu de opções:\n");
            System.out.println("   0 - sair");
            System.out.println("   1 - incluir contato");
            System.out.println("   2 - procurar contato");
            System.out.println("   3 - alterar contato");
            System.out.println("   4 - remover contato");
            System.out.println("   5 - listar todos os contatos");
            System.out.print("\n   Qual escolha: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); 
            switch (opcao) {
                case 1:
                	//System.out.println("\n# Incluir contato\n");
                    listaContatos.add(Main.lerContato()); //pode por o nome da classe, ira aparecer todos os metodos
                    break;
                case 2:
                	acharContato();
                	break;
                case 3:
                	break;
                case 4:
                	deletarContato();
                	break;
                case 5:
                	//System.out.println("\n# Listagem de todos contatos\n");
                    imprimirLista();
                    break;
            }
        }while (opcao != 0);
        teclado.close();
    }

    private static void acharContato() {
		String nome;
		String confere;
		boolean achou = false;
		
		System.out.print("   Qual contato voce desejaria encontrar: ");
    	nome = teclado.nextLine();
    	
        for (int i = 0; i < listaContatos.size() && !achou; i++) {
        	if (listaContatos.get(i).getNome().toUpperCase().contains(nome.toUpperCase())) {
	        	System.out.println("   Nome encontrado: "+listaContatos.get(i).getNome());
    			System.out.print("   Confere? ");
    			confere = teclado.nextLine();
    			if(confere.toUpperCase().charAt(0) == 'S') {
    				achou = true;
    				Contato contato = listaContatos.get(i);
    				System.out.println("   Os dados do contato: "); //pedir ajuda pro prof de como da pra fazer isso
    				System.out.println("Nome: " +  contato.getNome());
    				System.out.println("Data Nascimento: " + contato.getDataNascFormatoBR());
    				System.out.println("Idade: " + contato.getIdade());
    			}
    			
        	}
        } 
	}

	public static Contato lerContato(){
        Contato contato;
        String nome;

        System.out.print("Qual o nome do contato: ");
        nome = teclado.nextLine();
        contato = new Contato(nome);
        return contato;
    }

    public static void imprimirLista (){
    	// op 1 naevgar pelo arraylist usadno FOR normal com SIZE
        for (int i = 0; i < listaContatos.size(); i++) {
            System.out.println(i + " - " + listaContatos.get(i).getNome());
        }
        
        // OPCAO 2 - navegar usando FOREACH
        for (Contato contato: listaContatos) {
            System.out.println("   [FE] " + contato.getNome());
            // listaContatos.remove(contato); // remove o contato em questão da lista
        }

        // OPCAO 3 - navegar usando a interface ITERATOR
        Iterator<Contato> iterator = listaContatos.iterator();
        while (iterator.hasNext()) {
        	// tem próximo? tem mais alguém na lista?
            Contato contato = iterator.next();
            // iterator.remove(); // remove este objeto da sua coleção
            System.out.println("   [It] " + contato.getNome());
        }
    }

    
    public static void deletarContato () {
    	Contato contato;
    	String nome;	
    	String confere;	
    	boolean achou = false;
    	
    	System.out.print("   Qual o nome do contato que deseja deletar: ");
    	nome = teclado.nextLine();
    	
    	//navegar para procurar usando a interface Iterator
    	Iterator<Contato> iterator = listaContatos.iterator();
    	while(iterator.hasNext() && !achou) {
    		contato = iterator.next();
    		if (contato.getNome().toUpperCase().contains(nome.toUpperCase())) {
    			System.out.println("   Nome encontrado: "+contato.getNome());
    			System.out.print("   Confere? ");
    			confere = teclado.nextLine();
    			if(confere.toUpperCase().charAt(0) == 'S') {
    				achou = true;
    				System.out.print("   Quer mesmo apagar o/a "+contato.getNome());
    				confere = teclado.nextLine();
    				if(confere.toUpperCase().charAt(0) == 'S') {
    					System.out.println("   -"+contato.getNome()+"> foi removido da lista!!");
    					iterator.remove();
    				}
    				//vale a pena ainda perguntar para confirmar novamente
    			}
    		}
    	}
    	if (!achou) {
			System.out.println("   Contato "+nome+" n foi encontrado");
    	}
    }
}
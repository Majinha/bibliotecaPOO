package Amigo;

/**ArrayList do tipo ListaAmigo para o objeto do tipo Amigo, onde serão guardados e ordenados, valores para o mesmo.
* @author Mariana Trentiny Barbosa
* @version 1.8.0_202-b08
* @since Release 01 da aplicação
*/


import java.util.ArrayList;

public class ListaAmigo {

	private ArrayList<Amigo> alAmigos;

	
	public ListaAmigo() {
		super();
		this.alAmigos =  new ArrayList<Amigo>();
	}
	
	public Amigo addAmigo (String nome, String celular) {
		int idAmigo = alAmigos.size() + 1; 
		Amigo amigo = new Amigo(idAmigo, nome,celular);
		alAmigos.add(amigo);
		return amigo;
	}

	public int getListaAmigosSize(){
		return alAmigos.size();
	}

	public Amigo getAmigo(int i){
		return alAmigos.get(i - 1);
	}

	public ArrayList<Amigo> getAlAmigos() {
		return alAmigos;
	}

}

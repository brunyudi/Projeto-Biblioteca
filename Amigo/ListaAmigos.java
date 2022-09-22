package Amigo;
import java.util.ArrayList;
public class ListaAmigos {

	private ArrayList<Amigo> alAmigos;
	
	// construtor cria alAmigos, ArrayList que fica encapsulado na classe ListaAmigos

	/**
	 * Construtor da lista de amigos
	 */

	public ListaAmigos() {
		super();
		this.alAmigos = new ArrayList<Amigo>();
	}


	/**
	 * método para a inclusao de novos amigos na lista e a criação automática de um idAmigo para o amigo
	 * @param nome
	 * @param celular
	 * @return
	 */


	public int addAmigo (String nome, String celular) {
		int idAmigo = alAmigos.size() + 1;
		Amigo amigo = new Amigo(idAmigo, nome,celular);
		alAmigos.add(amigo);
		return idAmigo;
	}


	/**
	 * setters e getters da classe da lista de amigos
	 * @return
	 */


	public int getListaAmigosSize(){
		return alAmigos.size();
	}

	public Amigo getAmigo(int i){
		return alAmigos.get(i);
	}

	// demais métodos getters, setters etc necessários
	// toString

}

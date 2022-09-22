package Biblioteca;
import java.util.ArrayList;

public class Biblioteca {

	private String nome;
	private ArrayList<Livro> alLivros;
	private float investimento;

	// construtor cria alLivros, ArrayList que fica encapsulado na classe Biblioteca


	/**
	 * Construtor da biblioteca
	 * @param nome
	 */

	public Biblioteca(String nome) {
		this.nome = nome;
		this.alLivros = new ArrayList<Livro>();
		investimento = 0;
	}


	/**
	 * método para a inclusão de novos livros na biblioteca e criação automatica de idLivro
	 * @param titulo
	 * @param autor
	 * @param preco
	 * @param dispLivro
	 * @return
	 */


	public int addLivro (String titulo, String autor, float preco, Disponibilidade dispLivro){
		int idLivro = alLivros.size() + 1;
		Livro livro = new Livro(idLivro, titulo, autor, preco, dispLivro);
		alLivros.add(livro);
		return idLivro;
	}


	/**
	 * getters e setters da biblioteca
	 * @return
	 */


	public int getBibliotecaSize(){
		return alLivros.size();
	}

	public Livro getLivro(int i) {
		return alLivros.get(i);
	}

	public float getInvestimento(){
		float investimento = 0;
		for (Livro livro : alLivros){
			investimento += livro.getPreco();
		}
		return investimento;
	}

	// demais métodos getters, setters, toString, compareTo (para ordenação) etc 
	// conforme a modelagem e encapsulamento especificados 
	// mais o que estudante decidir implementar
}

package Emprestimo;
import Amigo.Amigo;
import Biblioteca.Disponibilidade;
import Biblioteca.Livro;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;

	// construtor cria alEmprestimos, ArrayList que fica encapsulado na classe ListaEmprestimos

	/**
	 * Construtor da lista de emprestimos
	 */

	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}


	/**
	 * Método para a inclusão de emprestimos na lista
	 * @param idAmigo
	 * @param idLivro
	 * @param dataEmprestimo
	 * @param dataDevolucao
	 * @param livro
	 * @param amigo
	 * @param dispLivro
	 * @return
	 */

	public int addEmprestimo (int idAmigo, int idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao, Livro livro, Amigo amigo, Disponibilidade dispLivro){
		int idEmprestimo = alEmprestimos.size() +1;
		Emprestimo emprestimo = new Emprestimo(idAmigo, idLivro, dataEmprestimo, dataDevolucao, livro, amigo, idEmprestimo, dispLivro);
		alEmprestimos.add(emprestimo);
		return idEmprestimo;
	}


	/**
	 * Getters e setters da lista de emprestimo
	 * @return
	 */

	public int getListaEmprestimoSize(){ return alEmprestimos.size();}

	public Emprestimo getEmprestimo(int i){
		return alEmprestimos.get(i);
	}



	// construtor
	// addEmprestimo
	// getters e setters
	// toString
	// etc
}

package Emprestimo;
import java.time.LocalDate;

import Amigo.Amigo;
import Biblioteca.Disponibilidade;
import Biblioteca.Livro;

public class Emprestimo implements Comparable<Emprestimo> {

	private int idAmigo;
	private int idLivro;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	// para a equipe PENSAR nesta repetição de informação, pois pode-se obter os objetos pelo IDs
	// caso mantenha a base do ArrayList organizada fisicamente, pode usar o Id como chave de acesso
	// caso contrário, ou como opção extra para acesso, pode manter a referência ao objeto
	private Livro livro;
	private Amigo amigo;
	private int idEmprestimo;
	private Disponibilidade dispLivro;


	/**
	 * Construtor da classe emprestimo
	 * @param idAmigo
	 * @param idLivro
	 * @param dataEmprestimo
	 * @param dataDevolucao
	 * @param livro
	 * @param amigo
	 * @param idEmprestimo
	 * @param dispLivro
	 */

	public Emprestimo (int idAmigo, int idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao, Livro livro, Amigo amigo, int idEmprestimo, Disponibilidade dispLivro){
		super();
		this.idAmigo = idAmigo;
		this.idLivro = idLivro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.livro = livro;
		this.amigo = amigo;
		this.idEmprestimo = idEmprestimo;
		this.dispLivro = dispLivro;
	}


	/**
	 * getters e setters de emprestimo
	 * @return
	 */


	public int getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
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

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Amigo getAmigo() {
		return amigo;
	}

	public void setAmigo(Amigo amigo) {
		this.amigo = amigo;
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Disponibilidade getDispLivro() {
		return dispLivro;
	}

	public void setDispLivro(Disponibilidade dispLivro) {
		this.dispLivro = dispLivro;
	}

	/**
	 * Códigos para a comparação da disponibilidade de um livro e da impressão dos dados de emprestimo
	 * @param emprestimo the object to be compared.
	 * @return
	 */


	public int compareTo(Emprestimo emprestimo){return dispLivro.compareTo(emprestimo.dispLivro);}

	@Override
	public String toString(){
		return "Emprestimo [ Livro: " + livro + ", Amigo: " + amigo + ", Data do emprestimo: " + dataEmprestimo + ", Data de devolucao: " + dataDevolucao + ", Disponibilidade atual: " + dispLivro + " ]";
	}

	// construtor
	// getters e setters
	// demais métodos
	// toString

}

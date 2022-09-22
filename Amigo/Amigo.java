package Amigo;

import Biblioteca.Livro;

public class Amigo implements Comparable<Amigo> {

	private int idAmigo;
	private String nome;
	private String celular;

	/**
	 * Construtor da classe amigo
	 * @param idAmigo
	 * @param nome
	 * @param celular
	 */

	public Amigo(int idAmigo, String nome, String celular) {
		super();
		this.idAmigo = idAmigo;
		this.nome = nome;
		this.celular = celular;
	}


	/**
	 * Setters e getters da classe Amigo
	 * @return
	 */


	public String getNome() {
		return nome;
	}

	public void setNome(String nomeAmigo) {
		this.nome = nomeAmigo;
	}

	public int getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}


	/**
	 * Código para a comparação dos amigos com base nos nomes
	 * @param amigo the object to be compared.
	 * @return
	 */


	@Override
	public int compareTo(Amigo amigo) {
		return nome.compareToIgnoreCase(amigo.nome);
	}


	/**
	 * Código para realizar o retorno dos dados da classe
	 * @return
	 */


	@Override
	public String toString() {
		return "Amigo [idAmigo =" + idAmigo + ", nome =" + nome + ", celular =" +celular + "]";
	}

	// demais métodos necessários.......
	// getters e setters
	// etc

}

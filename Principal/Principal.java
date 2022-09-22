package Principal;

import java.time.LocalDate;
import java.util.*;

import Amigo.*;
import Emprestimo.*;
import Biblioteca.*;

public class Principal {

	static Scanner teclado =new Scanner(System.in);

	private static Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
	private static ListaEmprestimos emprestimos = new ListaEmprestimos();
	private static ListaAmigos amigos = new ListaAmigos();
	
	public static void main(String[] args) {


		/**
		 * Aqui tem duas manipulações de amigos hardcoded para facilitar a demonstração do programa
		 */


		int idAmigo;
		idAmigo = amigos.addAmigo("Fulano", "(41) 99876-5432");
		System.out.println("Adicionado com codigo " + idAmigo);

		idAmigo = amigos.addAmigo("Ciclano", "(47) 98123-2121");
		System.out.println("Adicionado com codigo " + idAmigo);

		for (int i =0; i < amigos.getListaAmigosSize(); i++) {
			Amigo amigo = amigos.getAmigo(i);
			System.out.println("Nome: " + amigo.getNome());
			System.out.println("Celular: " + amigo.getCelular());
		}


		/**
		 *  Aqui são quatro manipulações hardcoded de livros para facilitar a demonstração do programa
		 */


		int idLivro;
		idLivro = bib.addLivro("Eragon","Christopher Paolini",30,Disponibilidade.DISPONIVEL);
		System.out.println("Adicionado com codigo " + idLivro);

		idLivro = bib.addLivro("Eldest","Christopher Paolini",30,Disponibilidade.DISPONIVEL);
		System.out.println("Adicionado com codigo " + idLivro);

		idLivro = bib.addLivro("Brisingr","Christopher Paolini",30,Disponibilidade.CONSULTALOCAL);
		System.out.println("Adicionado com codigo " + idLivro);

		idLivro = bib.addLivro("Heranca","Christopher Paolini",30,Disponibilidade.DANIFICADO);
		System.out.println("Adicionado com codigo " + idLivro);

		String titulolivro;
		String autorlivro;
		float precolivro;
		Disponibilidade disponilivro;
		String nomeamigo;
		String celularamigo;

		int opcao;


		/**
		 * A partir daqui há o menu principal da biblioteca e os códigos para a realização dos comandos
		 * O case 1 pega as informações necessárias para a implementação de um novo amigo no código e automaticamente cria um idAmigo
		 * O Case 2 pega as informações necessárias para a implementação de um novo livro no código e automaticamente cria um idLivro
		 * O menu fica rodando com as opções até escolher a opção de saida 0 (zero)
		 */


		do{
			System.out.println("\n# Menu Principal da Biblioteca\n");
			System.out.println("   0 - sair");
			System.out.println("   1 - cadastrar livro");
			System.out.println("   2 - cadastrar amigo");
			System.out.println("   3 - emprestar");
			System.out.println("   4 - devolver");
			System.out.println("   5 - listar emprestimos atuais");
			System.out.println("   6 - listar historico de emprestimos de um livro");
			System.out.println("   7 - listar toda a biblioteca");
			System.out.println("   8 - alterar estado");
			System.out.println("   9 - listar amigos");    //apenas para teste
			System.out.println("\n   Qual escolha?: ");
			opcao = teclado.nextInt();
			teclado.nextLine();              //consumir enter extra
			switch (opcao){
				case 1:
					System.out.println("\n# Cadastrar livro\n");
					System.out.print("   Qual o titulo do livro?: ");
					titulolivro = teclado.nextLine();
					System.out.print("   Qual o autor do livro?: ");
					autorlivro = teclado.nextLine();
					System.out.print("   Qual o preco do livro?: ");
					precolivro = teclado.nextFloat();
					System.out.print("   Qual a disponibilidade do livro? ");
					disponilivro = Disponibilidade.valueOf(teclado.next());
					idLivro = bib.addLivro(titulolivro, autorlivro, precolivro, disponilivro);
					break;
				case 2:
					System.out.println("\n# Cadastrar Amigo\n");
					System.out.print("   Qual o nome do amigo?: ");
					nomeamigo = teclado.nextLine();
					System.out.print("   Qual o celular do amigo?: ");
					celularamigo = teclado.nextLine();
					idAmigo = amigos.addAmigo(nomeamigo, celularamigo);
					break;
				case 3:
					System.out.println("\n# Emprestimo de livros\n");
					emprestarLivro();
					break;
				case 4:
					System.out.println("\n# Devolucao de livros\n");
					devolverLivro();
					break;
				case 5:
					System.out.println("\n# Emprestimos atuais:\n");
					listarEmprestimos();
					break;
				case 6:
					System.out.println("\n# Historico de emprestimos do livro:\n");
					listarHistoricoEmprestimos();
					break;
				case 7:
					System.out.println("\n# Listar a biblioteca\n");
					listarBiblioteca();
					break;
				case 8:
					System.out.println("\n# Alterar estado:\n");
					alterarEstadoLivro();
					break;
				case 9:
					System.out.println("\n# Lista de amigos:\n");
					imprimirAmigos();
					break;
				}
			}
			while (opcao != 0);
			teclado.close();
	}


	/**
	 * O Método imprimirAmigos realiza a impressão dos dados dos amigos dentro da lista criada
	 */


	public static void imprimirAmigos(){
		for (int i =0; i < amigos.getListaAmigosSize(); i++) {
			Amigo amigo = amigos.getAmigo(i);
			System.out.println("idAmigo: " + amigo.getIdAmigo());
			System.out.println("Nome: " + amigo.getNome());
			System.out.println("Celular: " + amigo.getCelular());
		}
	}


	/**
	 * O método listar biblioteca faz a impressão dos dados dos livros dentro da lista
	 * Era para realizar uma ordenação nos componentes porém não encontrei formas de funcionar
	 * O calculo do investimento na biblioteca (soma dos custos dos livros) também não consegui fazer funcionar
	 */


	public static void listarBiblioteca(){
		for (int i =0; i < bib.getBibliotecaSize(); i++){
			Livro livro = bib.getLivro(i);
			//Collections.sort(Biblioteca);
			System.out.println("idLivro: " + livro.getIdLivro());
			System.out.println("Titulo: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Preco: R$ " + livro.getPreco());
			System.out.println("Disponibilidade: " + livro.getDispLivro());
			//System.out.println("Investimento: R$ " + biblioteca.getInvestimento());
			//VER OUTRA FORMA DE ORDENAR E SOMAR
		}
	}


	/**
	 * O método listarHistoricoEmprestimos realiza a impressão dos dados dos emprestimos realizados atraves da leitura do ID de um livro
	 * Contem informacoes sobre o livro emprestado, quem realizou o emprestimo e datas de emprestimo e devolucao
	 */


	public static void listarHistoricoEmprestimos(){
		String titlivrohist;
		int idlivrohist;

		System.out.println("   Verificar historico de qual livro? (ID do livro) ");
		//titlivrohist = teclado.nextLine();
		idlivrohist = teclado.nextInt();
		for (int x =0; x < bib.getBibliotecaSize(); x++) {
			Livro livro = bib.getLivro(x);
			//if (livro.getTitulo().toUpperCase().contains(titlivrohist.toUpperCase())) {
				//for (int i = 0; i < emprestimos.getListaEmprestimoSize(); i++) {
					//Emprestimo emprestimo = emprestimos.getEmprestimo(i);
					//if (bib.getLivro(x) == emprestimo.getLivro()) {
					//	System.out.println("");
					//}
				//}
			//}
			if (livro.getIdLivro() == idlivrohist){
				for (int i=0; i < emprestimos.getListaEmprestimoSize(); i++){
					Emprestimo emprestimo = emprestimos.getEmprestimo(i);
					if (livro.getIdLivro() == emprestimo.getIdLivro());
					//System.out.println("   Livro emprestado: " + emprestimo.getLivro());
					//System.out.println("   Amigo que emprestou: " + emprestimo.getAmigo());
					System.out.println(emprestimos.getEmprestimo(i));
				}
			}
		}
	}


	/**
	 * O método listarEmprestimos realiza a impressão do titulo do livro emprestado, quem realizou o emprestimo e a data que foi realizada
	 * através da comparação do dispLivro com o valor EMPRESTADO
	 */


	public static void listarEmprestimos(){
		for (int i =0; i < emprestimos.getListaEmprestimoSize(); i++){
			Emprestimo emprestimo = emprestimos.getEmprestimo(i);
			if (emprestimo.getDispLivro().equals(Disponibilidade.EMPRESTADO)){
				System.out.println("   Titulo: " + emprestimo.getLivro());
				System.out.println("   Emprestado para: "+ emprestimo.getAmigo());
				System.out.println("   Data de emprestimo: " + emprestimo.getDataEmprestimo());
			}
		}
	}


	/**
	 * O método emprestarLivro realiza o emprestimo do livro escolhido, amigo escolhido e muda o estado do livro para EMPRESTADO
	 * Era para realizar o emprestimo atraves dos IDS do livro e amigo, porém por algum motivo deu erro
	 * Então realiza o procedimento com os nomes do livro e do amigo
	 */


	public static void emprestarLivro(){
		String titlivro;
		String nomeamigo;
		String confere;
		String confereamigo;
		int idEmprestimo;
		int idlivroemp;
		int idamigoemp;

		//System.out.println("   Qual livro emprestar? (ID) ");
		//idlivroemp = teclado.nextInt();
		//for (int x =0; x < bib.getBibliotecaSize(); x++){
		//	Livro livro = bib.getLivro(x);
		//	if (livro.getIdLivro() == idlivroemp){
		//		if (livro.getDispLivro().equals(Disponibilidade.DISPONIVEL)){
		//			System.out.println("   Livro encontrado: " + livro.getTitulo());
		//			System.out.println("   Confere? S/N ");
		//			confere = teclado.nextLine();
		//			if (confere.toUpperCase().charAt(0) == 'S'){
		//				System.out.println("   Qual o ID do amigo que vai emprestar? ");
		//				idamigoemp = teclado.nextInt();
		//				for (int y =0; y < amigos.getListaAmigosSize(); y++){
		//					Amigo amigo = amigos.getAmigo(y);
		//					if (amigo.getIdAmigo() == idamigoemp){
		//						System.out.println("   Amigo encontrado: " + amigo.getNome());
		//						System.out.println("   Confere? S/N");
		//						confereamigo = teclado.nextLine();
		//						if (confereamigo.toUpperCase().charAt(0) == 'S'){
		//							idEmprestimo = emprestimos.addEmprestimo(amigo.getIdAmigo(), livro.getIdLivro(), LocalDate.now(), null, bib.getLivro(x), amigos.getAmigo(y), Disponibilidade.EMPRESTADO);
		//							livro.setDispLivro(Disponibilidade.EMPRESTADO);
		//							System.out.println("   Livro emprestado com sucesso! ");
		//						}
		//					}
		//				}
		//			}
		//			else{System.out.println("   Livro nao emprestado");}
		//		}
		//		else {System.out.println("   Livro nao disponivel para emprestimo ou nao encontrado. ");}
		//	}
		//}

		System.out.println("   Qual livro emprestar? ");
		titlivro = teclado.nextLine();
		for (int i =0; i < bib.getBibliotecaSize(); i++){
			Livro livro = bib.getLivro(i);
			if (livro.getTitulo().toUpperCase().contains(titlivro.toUpperCase())) {
				if (livro.getDispLivro().equals(Disponibilidade.DISPONIVEL)) {
					System.out.println("   Livro encontrado: " + livro.getTitulo());
					System.out.println("   Confere? S/N ");
					confere = teclado.nextLine();
					if (confere.toUpperCase().charAt(0) == 'S') {
						System.out.println("   Qual o nome do amigo que vai emprestar? ");
						nomeamigo = teclado.nextLine();
						for (int x =0; x < amigos.getListaAmigosSize(); x++){
							Amigo amigo = amigos.getAmigo(x);
							if (amigo.getNome().toUpperCase().contains((nomeamigo.toUpperCase()))){
								System.out.println("   Amigo encontrado: " + amigo.getNome());
								System.out.println("   Confere? S/N");
								confereamigo = teclado.nextLine();
								if (confereamigo.toUpperCase().charAt(0) == 'S'){
									idEmprestimo = emprestimos.addEmprestimo(amigo.getIdAmigo(), livro.getIdLivro(), LocalDate.now(), null, bib.getLivro(i), amigos.getAmigo(x), Disponibilidade.EMPRESTADO);
									livro.setDispLivro(Disponibilidade.EMPRESTADO);
									System.out.println("   Livro emprestado com sucesso! ");
								}
							}
							//else {System.out.println("   Amigo nao encontrado! ");}
						}
					}
					else{System.out.println("   Livro nao emprestado");}
				}
				else {System.out.println("   Livro nao disponivel para emprestimo ou nao encontrado! ");}
			}
		//	//else {System.out.println("   Livro nao encontrado! ");}
		}



	}


	/**
	 * o método devolver livro realiza a devolução do livro, recebendo o nome do livro e mudando o estado para DISPONIVEL novamente
	 * assim como o método anterior, por algum motivo dava erro recebendo os IDs
	 */


	public static void devolverLivro(){
		String tlivro;
		String conferedevlivro;
		int idlivrodev;

		//System.out.println("   Qual livro devolver? (ID) ");
		//idlivrodev = teclado.nextInt();
		//for (int z = 0; z < bib.getBibliotecaSize(); z++){
		//	Livro livro = bib.getLivro(z);
		//	if (livro.getIdLivro() == idlivrodev){
		//		System.out.println("   Livro encontrado:  " + livro.getTitulo());
		//		System.out.println("   Confere? S/N");
		//		conferedevlivro = teclado.nextLine();
		//		if (conferedevlivro.toUpperCase().charAt(0) == 'S');
		//		livro.setDispLivro(Disponibilidade.DISPONIVEL);
		//		for (int w = 0; w < emprestimos.getListaEmprestimoSize(); w++){
		//			Emprestimo emprestimo = emprestimos.getEmprestimo(w);
		//			if (emprestimo.getLivro() == bib.getLivro(z)){
		//				emprestimo.setDataDevolucao(LocalDate.now());
		//				emprestimo.setDispLivro(Disponibilidade.DISPONIVEL);
		//				System.out.println("   Livro devolvido com sucesso! ");
		//			}
		//		}
		//	}
		//}

		System.out.println("   Qual livro devolver? ");
		tlivro = teclado.nextLine();
		for (int z = 0; z < bib.getBibliotecaSize(); z++){
			Livro livro = bib.getLivro(z);
			if (livro.getTitulo().toUpperCase().contains(tlivro.toUpperCase())){
				System.out.println("   Livro encontrado: " + livro.getTitulo());
				System.out.println("   Confere? S/N");
				conferedevlivro = teclado.nextLine();
				if (conferedevlivro.toUpperCase().charAt(0) == 'S');
				livro.setDispLivro(Disponibilidade.DISPONIVEL);
				for (int w = 0; w < emprestimos.getListaEmprestimoSize(); w++){
					Emprestimo emprestimo = emprestimos.getEmprestimo(w);
					if (emprestimo.getLivro() == bib.getLivro(z)){
						emprestimo.setDataDevolucao(LocalDate.now());
						emprestimo.setDispLivro(Disponibilidade.DISPONIVEL);
						System.out.println("   Livro devolvido com sucesso! ");
					}
				}
			}
		}
	}


	/**
	 * O método alterarEstadoLivro realiza a alteração manual do estado de um livro
	 * através da escolha de um livro pelo nome e do novo estado
	 * Assim como os ultimos dois metodos, dava erro com os IDs
	 */


	public static void alterarEstadoLivro(){
		String titullivro;
		int idlivroalterarest;
		String conferelivro;
		Disponibilidade disponilivro;

		//System.out.println("   Alterar estado de qual livro? (ID) ");
		//idlivroalterarest = teclado.nextInt();
		//for (int y = 0; y < bib.getBibliotecaSize(); y++){
		//	Livro livro = bib.getLivro(y);
		//	if (livro.getIdLivro() == idlivroalterarest){
		//		System.out.println("   Livro encontrado: " + livro.getTitulo());
		//		System.out.println("   Confere? S/N ");
		//		conferelivro = teclado.nextLine();
		//		if (conferelivro.toUpperCase().charAt(0) == 'S'){
		//			System.out.println("   Para qual estado modificar? ");
		//			disponilivro = Disponibilidade.valueOf(teclado.next());
		//			livro.setDispLivro(disponilivro);
		//			System.out.println("   Estado modificado! ");
		//		}
		//	}
		//}

		System.out.println("   Alterar estado de qual livro? ");
		titullivro = teclado.nextLine();
		for (int y =0; y < bib.getBibliotecaSize(); y++){
			Livro livro = bib.getLivro(y);
			if (livro.getTitulo().toUpperCase().contains(titullivro.toUpperCase())){
				System.out.println("   Livro encontrado: " + livro.getTitulo());
				System.out.println("   Confere? S/N ");
				conferelivro = teclado.nextLine();
				if (conferelivro.toUpperCase().charAt(0) == 'S'){
					System.out.println("   Para qual estado modificar? ");
					disponilivro = Disponibilidade.valueOf(teclado.next());
					livro.setDispLivro(disponilivro);
					System.out.println("   Estado modificado! ");
				}
			}
		}
	}

}

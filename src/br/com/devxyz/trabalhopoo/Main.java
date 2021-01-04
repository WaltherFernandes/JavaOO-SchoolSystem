package br.com.devxyz.trabalhopoo;

import java.util.Scanner;

/**
 * 
 * @author Walther Fernandes, Mateus Rezende
 *
 */

public class Main {
	
	static Scanner scn = new Scanner(System.in);
	static Sistema sistema = Sistema.getInstance();
	
	public static void main(String[] args) {
		sistema.init();
		
		int opcao;
		while(true) {
			clear(15);
			println("Digite uma opção");
			println("0 - Sair da aplicação");
			println("1 - Cadastrar disciplina");
			println("2 - Excluir disciplina");
			println("3 - Listar disciplinas");
			println("4 - Cadastrar aluno");
			println("5 - Listar alunos");
			println("6 - Editar aluno");
			println("7 - Cadastrar aluno em disciplina");
			println("8 - Detalhar aluno");
			
			opcao = getOpcao(); while(opcao == -1) { opcao = getOpcao(); }
			
			switch(opcao) {
				case 0:
					println("Nunca será um adeus ;-(");
					System.exit(0);
					break;
				case 1:
					cadastrarDisciplina();
					break;
				case 2:
					excluirDisciplina();
					break;
				case 3:
					listarDisciplinas();
					break;
				case 4:
					cadastrarAluno();
					break;
				case 5: 
					listarAlunos();
					break;
				case 6:
					editarAlunos();
					break;
				default:
					println("Opção inválida!");
					wait(1);
					break;
			}
			
		}
	}





	// Register subject
	static void cadastrarDisciplina() {
		println("Digite o nome da disciplina: ");
		String nome = scnString();
		println("Digite o ano da disciplina: ");
		int ano = scnInt();
		println("Digite o número de vagas da disciplina: ");
		int numVagas = scnInt();
		println("Digite o nome do professor da disciplina: ");
		String nomeDoProfessor = scnString();
		
		
		
		println(sistema.cadastrarDisciplina(nome, ano, numVagas, nomeDoProfessor));
		wait(3);
	}
	// Exclude subject
	static void excluirDisciplina() {
		println("Digite o nome da disciplina que você deseja excluir: ");
		String nome = scnString();
		println(sistema.excluirDisciplina(nome));
		wait(2);
	}
	// List subjects
	static void listarDisciplinas() {
		int tamanhoMaiorNome = 0;
		for(Disciplina d : sistema.getDisciplinas()) {
			if(d.getNome().length() > tamanhoMaiorNome) {
				tamanhoMaiorNome = d.getNome().length();
			}
		}
		
		clear(15);
		print( "Cód.  Disciplina" );printSpace( tamanhoMaiorNome + 2 - ( "Disciplina".length() ) );
		println("Ano   Vagas Professor");
		for(Disciplina d : sistema.getDisciplinas()) {
			print(String.valueOf(d.getCodigo())); printSpace((int) (6 - String.valueOf(d.getCodigo()).length()));
			print(d.getNome()); Main.printSpace((int)((tamanhoMaiorNome + 2) - d.getNome().length()));
			print(String.valueOf(d.getAno())); Main.printSpace(6 - String.valueOf(d.getAno()).length());
			print(String.valueOf(d.getNumVagas())); Main.printSpace(6 - String.valueOf(d.getNumVagas()).length());
			println(d.getNomeProfessor());
		}
		wait(6);
	}
	// Register student
	static void cadastrarAluno() {
		println("Digite o nome do aluno: ");
		String nome = scnString();
		println("Digite o nome do Pai aluno: ");
		String nomeDoPai = scnString();
		println("Digite o nome da Mãe aluno: ");
		String nomeDaMae = scnString();
		println("Digite o endereço do aluno: ");
		String endereco = scnString();
		
		sistema.cadastrarAluno(nome, nomeDoPai, nomeDaMae, endereco);
	}
	// List students
	static void listarAlunos() {	
		int maiorNome = 0;
		int maiorNomeMae = 0;
		int maiorNomePai = 0;
		for(Aluno a : sistema.getAlunos()) {
			if(a.getNome().length() > maiorNome) {
				maiorNome = a.getNome().length();
			}
			if(a.getNomeDaMae().length() > maiorNomeMae) {
				maiorNomeMae = a.getNomeDaMae().length();
			}
			if(a.getNomeDoPai().length() > maiorNomePai) {
				maiorNomePai = a.getNomeDoPai().length();
			}
		}
			
		print("Mat.  Nome"); printSpace(maiorNome+2 - ("Nome".length()));
		print("Mãe"); printSpace(maiorNomeMae+2 - ("Mãe".length()));
		print("Pai"); printSpace(maiorNomePai+2 - ("Pai".length()));
		println("Endereço");
		
		for(Aluno a : sistema.getAlunos()) {
			print(String.valueOf(a.getNumMatricula())); printSpace((int) (6 - String.valueOf(a.getNumMatricula()).length()));
			print(a.getNome()); Main.printSpace((int)((maiorNome + 2) - a.getNome().length()));
			print(a.getNomeDaMae()); Main.printSpace(maiorNomeMae + 2 - a.getNomeDaMae().length());
			print(a.getNomeDoPai()); Main.printSpace(maiorNomePai + 2 - a.getNomeDoPai().length());
			println(a.getEndereco());
		}
		wait(6);
	}
	// Edit students
	static void editarAlunos() {
		clear(15);
		println("Digite o nome do aluno a ser editado!");
		String nomeAluno = scnString();
		Aluno alunoEditing = sistema.buscarAlunoPorNome(nomeAluno);
		String messagePass = alunoEditing != null ? "Aluno encontrado!" : "Aluno não encontrado";
		println(messagePass);
		wait(2);
		
		while(true) {
			clear(15);
			println("0 - Voltar ao menu principal");
			println("1 - Editar nome");
			println("2 - Editar nome da mãe");
			println("3 - Editar nome do pai");
			println("4 - Editar endereço");
			int opcao = getOpcao(); while(opcao == -1) { opcao = getOpcao(); }
			
			switch(opcao) {
				case 0:
					return;
				case 1:
					println("Digite o novo nome ao aluno " + nomeAluno + ": ");
					String novoNome = scnString();
					sistema.editNomeAluno(alunoEditing, novoNome);
					break;
				case 2:
					println("Digite o novo nome da mãe d o aluno " + nomeAluno + ": ");
					String novoNomeMae = scnString();
					sistema.editNomeMae(alunoEditing, novoNomeMae);
					break;
				case 3:
					println("Digite o novo nome do pai do aluno " + nomeAluno + ": ");
					String novoNomePai = scnString();
					sistema.editNomePai(alunoEditing, novoNomePai);
					break;
				case 4:
					println("Digite o novo endereço da casa do aluno " + nomeAluno + ": ");
					String novoEndereco = scnString();
					sistema.editEndereco(alunoEditing, novoEndereco);
					break;
			}
		}
	}
	
	
	
	
	// Secondary optional functions
	static int getOpcao() {
		int opcao = -1;
	    try {
	        opcao = scn.nextInt();
	        return opcao;
	    } catch (Exception nfe) {
	    	println("Digite uma opção válida: ");
	    }
	    return opcao;
	}
	static void clear(int times) {

		for (int i = 0; i < times; i++) {
			System.out.println();
		}
	}
	static void wait(int segundos) {
		try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
        	return;
        }
	}
	// Text extra functions
	static void println(String text) {
		System.out.println(text);
	}
	static void print(String text) {
		System.out.print(text);
	}
	static void printSpace(int vzs) {
		for (int i = 0; i < vzs; i++) {
			System.out.print(" ");
		}
	}
	// Keyboard input read functions
	static String scnString() {
		scn.nextLine();
		String text = scn.nextLine();
		return text;
	}
	static int scnInt() {
		int number = scn.nextInt();
		return number;
	}
	static double scnDouble() {
		double number = scn.nextDouble();
		return number;
	}
	
}

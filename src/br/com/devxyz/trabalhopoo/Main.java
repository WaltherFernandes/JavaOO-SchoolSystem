package br.com.devxyz.trabalhopoo;

import java.util.Scanner;

/**
 * 
 * @author Walther Fernandes, Mateus Rezende
 * 
 * @dictionary Disciplina: subject; Aluno: student; 
 *
 */

public class Main {
	
	static boolean canShowRegisterOptions = true; // List students / subjects before you give the name
	
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
			println("9 - Listar matrículas");
			
			opcao = getOpcao(); while(opcao == -1) { opcao = getsOpcao(); }
			
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
					listarDisciplinas(6);
					break;
				case 4:
					cadastrarAluno();
					break;
				case 5: 
					listarAlunos(6);
					break;
				case 6:
					editarAlunos();
					break;
				case 7:
					registerAlunoInClass();
					break;
				case 8:
					detalharAluno();
					break;
				case 9:
					listarMatriculas();
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
		if(canShowRegisterOptions) { listarDisciplinas(3); }
		println("Digite o nome da disciplina que você deseja excluir: ");
		String nome = scnString();
		println(sistema.excluirDisciplina(nome));
		wait(2);
	}
	// List subjects
	static void listarDisciplinas(int time) {
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
		wait(time);
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
	static void listarAlunos(int time) {	
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
		wait(time);
	}
	// Edit students
	static void editarAlunos() {
		if(canShowRegisterOptions) { listarAlunos(3); }
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
	// Register student in new subject
	static void registerAlunoInClass() {
		if(canShowRegisterOptions) { listarAlunos(3); }
		clear(15);
		
		println("Digite o nome do aluno: ");
		String nomeAluno = scnString();
		Aluno a = sistema.buscarAlunoPorNome(nomeAluno);
		if(a == null) { println("Aluno não encontrado!"); wait(2); return; }
		println("Aluno encontrado!");

		if(canShowRegisterOptions) { listarDisciplinas(3); }
		println("Digite o nome da disciplina: ");
		String nomeDisciplina = scnStrings();
		Disciplina d = sistema.buscarDisciplinaPorNome(nomeDisciplina);
		if(d == null) { println("Aluno não encontrado!"); wait(2); return; }
		println("Disciplina encontrada!");
		
		println("Digite a nota do aluno: ");
		double nota = scnDouble();
		if(nota < 0.0) { println("A nota não pode ser menor que 0 "); wait(2); return; }
		
		
		NotaDisciplina newND = NotaDisciplina.getInstance(nota, d);
		println(sistema.cadastrarAlunoInClass(newND, a));
		wait(3);
	}
	// Detail specific student above his subjects
	static void detalharAluno() {
		if(canShowRegisterOptions) { listarAlunos(3); }
		println("Digite o nome do aluno: ");
		String nomeAluno = scnString();
		Aluno a = sistema.buscarAlunoPorNome(nomeAluno);
		if(a == null) { println("Aluno não encontrado!"); return; }
		println("Aluno encontrado!");
		
		if(!sistema.hasDiscs(a)) { println("Esse aluno não está cadastrado em nenhuma disciplina."); wait(2); return; }
		
		int maiorNomeDisciplina = 0;
		for ( NotaDisciplina nd : a.getDiscs() ) {
			if(nd.getDisc().getNome().length() > maiorNomeDisciplina) {
				maiorNomeDisciplina = nd.getDisc().getNome().length();
			}
		}
		
		print("Aluno"); printSpace( a.getNome().length() + 2 - "Aluno".length() );
		print("Disciplina"); printSpace(maiorNomeDisciplina + 2 - "Disciplina".length());
		println("Nota");
		
		for( NotaDisciplina nd : a.getDiscs() ) {
			print(a.getNome()); printSpace(2);
			print(nd.getDisc().getNome()); printSpace(maiorNomeDisciplina + 2 - nd.getDisc().getNome().length());
			println(String.valueOf(nd.getNota()));
		}
		wait(6);
	}
	// List all the registrations
	static void listarMatriculas() {
		clear(15);
		int maiorNome = 0;
		for(Aluno a : sistema.getAlunos()) {
			if(a.getNome().length() + 2 > maiorNome) {
				maiorNome = a.getNome().length() + 2;
			}
		}
		
		print("Aluno"); printSpace(maiorNome - "Aluno".length());
		println("Disciplina");
		for( Aluno a :  sistema.getAlunos() ) {
			for( NotaDisciplina nd : a.getDiscs() ) {
				print(a.getNome()); printSpace(maiorNome - a.getNome().length());
				println(nd.getDisc().getNome());
			}
		}
		wait(4);
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
	static int getsOpcao() {
		int opcao = -1;
	    try {
	    	scn.next();
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
	static String scnStrings() {
		String text = scn.nextLine();
		return text;
	}
	static int scnInt() {
		int number = scn.nextInt();
		return number;
	}
	static double scnDouble() {
		String numberAux = scn.nextLine();
		numberAux = numberAux.replace(",", ".");
		double number = Double.valueOf(numberAux);
		return number;
	}
	
}

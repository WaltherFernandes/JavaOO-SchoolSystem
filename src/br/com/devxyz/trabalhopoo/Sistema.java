package br.com.devxyz.trabalhopoo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private  List<Disciplina> disciplinas;
	private  int numDisciplinas;
	private  List<Aluno> alunos;
	private  int numAlunos;
    
    private static Sistema instance;
    
    public void init() {
    	// Creating/Registering subjects
    	cadastrarDisciplina("Programa��o para WEB", 2, 15, "Odilon");
    	cadastrarDisciplina("Programa��o Orientada a Objetos", 1, 15, "Luciano");
    	cadastrarDisciplina("Banco de Dados", 2, 15, "Odilon");
    	cadastrarDisciplina("Geografia", 2, 32, "Romerito");
    	cadastrarDisciplina("Reda��o T1", 2, 15, "Thiago");
    	
    	//Creating/Registering students
    	cadastrarAluno("Walther", "Paulo", "Roseli", "Bar�o de Cocais");
    	cadastrarAluno("Ingridi", "Unknown", "Maria", "Bar�o de Cocais");
    	cadastrarAluno("Mateus", "Jos�", "Carla", "Rio Piracicaba");
    }
    
    
    
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public int getNumDisciplinas() {
		return numDisciplinas;
	}
	public void setNumDisciplinas(int numDisciplinas) {
		this.numDisciplinas = numDisciplinas;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public int getNumAlunos() {
		return numAlunos;
	}
	public void setNumAlunos(int numAlunos) {
		this.numAlunos = numAlunos;
	}
	private Sistema() {
		disciplinas = new ArrayList<Disciplina>();
		alunos = new ArrayList<Aluno>();
	}
	
	
    
    public static Sistema getInstance() {
    	if(instance == null) {
    		instance = new Sistema();
    	}
    	return instance;
    }
    
    // Method responsible to create new subjects
    public String cadastrarDisciplina(String nome, int ano, int numVagas, String nomeDoProfessor) {
    	String messagePass;
    	for(Disciplina d : disciplinas) {
			if(d.getNome().equals(nome)) {
				messagePass = "Nome de disciplina j� cadastrado! N�o cadastramos a disciplina.";
				return messagePass;
			}
		}

		Disciplina newDisciplina = Disciplina.getInstance(nome, ano, numVagas, nomeDoProfessor);
		messagePass = newDisciplina == null ? "Falha ao cadastrar!" : "Cadastrado com sucesso!";
		if(newDisciplina != null) 
			disciplinas.add(newDisciplina);
			numDisciplinas++;

		return messagePass;
    }    
    // Method responsible to exclude subjects by name
    public String excluirDisciplina(String nome) {
    	String messagePass = "N�o foi poss�vel excluir!";
    	for(Disciplina d : disciplinas) {
    		if(d.getNome().equals(nome)) {
    			disciplinas.remove(d);
        		messagePass = "Disciplina exclu�da com sucesso";
    		}
    	}
    	return messagePass;
    }

    //Method responsible to create new students
    public String cadastrarAluno(String nome, String nomeDoPai, String nomeDaMae, String endereco) {
    	String messagePass;
    	for(Aluno a : alunos) {
    		if(a.getNome().equals(nome)) {
    			if(a.getNomeDaMae().equals(nomeDaMae)){
    				messagePass = "Aluno com mesmo nome e m�e j� cadastrado. Falha ao realizar novo cadastro";
    				return messagePass;
    			}
    		}
    	}
    	
    	Aluno newAluno = Aluno.getInstance(nome, nomeDoPai, nomeDaMae, endereco);
    	messagePass = newAluno == null ? "Falha ao cadastrar!" : "Cadastrado com sucesso!"; alunos.add(newAluno); numAlunos++;
    	
    	return messagePass;
    }


}
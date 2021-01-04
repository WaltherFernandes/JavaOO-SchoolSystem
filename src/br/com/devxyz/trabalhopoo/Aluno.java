package br.com.devxyz.trabalhopoo;

import java.util.ArrayList;

public class Aluno {
	
	private long numMatricula;
	private String nome;
	private String nomeDoPai;
	private String nomeDaMae;
	private String endereco;
	private ArrayList<NotaDisciplina> discs;
	
	private static int auxiliarMatricula = 1;
	
	
	public long getNumMatricula() {
		return numMatricula;
	}
	public void setNumMatricula(long numMatricula) {
		this.numMatricula = numMatricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeDoPai() {
		return nomeDoPai;
	}
	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}
	public String getNomeDaMae() {
		return nomeDaMae;
	}
	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<NotaDisciplina> getDiscs() {
		return discs;
	}
	public void setDiscs(ArrayList<NotaDisciplina> discs) {
		this.discs = discs;
	}
	
	// Method responsible to create a new Student object
	public Aluno(String nome, String nomeDoPai, String nomeDaMae, String endereco) {
		this.numMatricula = auxiliarMatricula;
		auxiliarMatricula++;
		
		this.nome = nome;
		this.nomeDaMae = nomeDaMae;
		this.nomeDoPai = nomeDoPai;
		this.endereco = endereco;
		
		this.discs = new ArrayList<NotaDisciplina>();
	}
	// Method responsible to instantiate student objects
	public static Aluno getInstance(String nome, String nomeDoPai, String nomeDaMae, String endereco) {
		if(nome != null && nomeDoPai != null && nomeDaMae != null && endereco != null) {
			return new Aluno(nome, nomeDoPai, nomeDaMae, endereco);
		}else {
			return null;
		}
	}
}
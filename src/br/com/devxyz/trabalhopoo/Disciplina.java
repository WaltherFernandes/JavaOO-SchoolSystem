package br.com.devxyz.trabalhopoo;

public class Disciplina {
	
	private long codigo;
    private String nome;
    private int ano;
    private int numVagas;
    private int numVagasInalteradas;
    private String nomeProfessor;
    
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getNumVagas() {
		return numVagas;
	}
	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}
	public int getNumVagasInalteradas() {
		return numVagasInalteradas;
	}
	public void setNumVagasInalteradas(int numVagasInalteradas) {
		this.numVagasInalteradas = numVagasInalteradas;
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
}

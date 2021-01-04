package br.com.devxyz.trabalhopoo;

public class Disciplina {
	
	private long codigo;
    private String nome;
    private int ano;
    private int numVagas;
    private String nomeDoProfessor;
    
    private int numAlunos;
    private int vagasTotais;
    private static int contadorCodigo = 1;
    
    
    
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
		return vagasTotais;
	}
	public void setNumVagasInalteradas(int vagasTotais) {
		this.vagasTotais= vagasTotais;
	}
	public String getNomeProfessor() {
		return nomeDoProfessor;
	}
	public void setNomeProfessor(String nomeDoProfessor) {
		this.nomeDoProfessor = nomeDoProfessor;
	}
	public int getNumAlunos() {
		return numAlunos;
	}
	public void setNumAlunos(int numAlunos) {
		this.numAlunos = numAlunos;
	}
	
	
	//Method responsible to create a new subject object
	private Disciplina(String nome, int ano, int numVagas, String nomeDoProfessor) {
		this.codigo = contadorCodigo;
		contadorCodigo++;
		
		this.nome = nome;
		this.ano = ano;
		this.numVagas = numVagas;
		this.nomeDoProfessor = nomeDoProfessor;
		this.numAlunos = 0;
	}
	// Method responsible to instantiate subject objects
	public static Disciplina getInstance(String nome, int ano, int numVagas, String nomeDoProfessor) {
		if(nome!=null && ano>0 && numVagas>0 && nomeDoProfessor!=null) {
			return new Disciplina(nome, ano, numVagas, nomeDoProfessor);
		}else {
			return null;
		}
	}
	
}

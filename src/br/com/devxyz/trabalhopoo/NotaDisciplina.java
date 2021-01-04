package br.com.devxyz.trabalhopoo;

public class NotaDisciplina {
	
	private double nota;
	private Disciplina disc;
	
	public static NotaDisciplina getInstance(double nota, Disciplina d) {
		if(d != null && nota >= 0) {
			return new NotaDisciplina(nota, d);
		}else {
			return null;
		}
	}
	
	public NotaDisciplina(double nota, Disciplina d) {
		this.disc = d;
		this.nota = nota;
	}
	
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Disciplina getDisc() {
		return disc;
	}
	public void setDisc(Disciplina disc) {
		this.disc = disc;
	}
}

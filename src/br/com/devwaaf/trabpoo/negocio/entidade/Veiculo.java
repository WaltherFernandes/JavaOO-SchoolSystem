package br.com.devwaaf.trabpoo.negocio.entidade;

public class Veiculo {
	private String placa;
	private String modelo;
	private String tipo;
	private int ano;
	private Cliente dono;
	private int id;
	
	private static int idReminder = 1;
	private static int maiorTipo = 0, maiorModelo = 0;
	
	private Veiculo(String placa, String modelo, String tipo, int ano, Cliente dono) {
		this.placa = placa;
		this.modelo = modelo;
		this.tipo = tipo;
		this.ano = ano;
		this.dono = dono;
		this.setId(idReminder); 
		
		Veiculo.idReminder++;
		if(maiorTipo < tipo.length()) maiorTipo = tipo.length();
		if(maiorModelo < modelo.length()) maiorModelo = modelo.length();
	}
	
	public static Veiculo getInstance(String placa, String modelo, String tipo, int ano, Cliente dono) {
		if(placa!=null && modelo!=null && tipo!=null && dono!=null) {
			return new Veiculo(placa, modelo, tipo, ano, dono);
		}
		return null;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Cliente getDono() {
		return dono;
	}
	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public static int getMaiorTipo() {
		return maiorTipo;
	}

	public static void setMaiorTipo(int maiorTipo) {
		Veiculo.maiorTipo = maiorTipo;
	}

	public static int getMaiorModelo() {
		return maiorModelo;
	}

	public static void setMaiorModelo(int maiorModelo) {
		Veiculo.maiorModelo = maiorModelo;
	}

	@Override
	public String toString() {
		String details = "";
		details += this.id + "  ";
		details += this.dono.getNome();
		details += " ".repeat(Cliente.getMaiorNome() - this.dono.getNome().length() + 2);
		details += this.modelo;
		details += " ".repeat(Veiculo.maiorModelo - this.modelo.length() + 2);
		details += this.ano;
		details += " ".repeat(2);
		details += this.tipo;
		details += " ".repeat(Veiculo.maiorTipo - this.tipo.length() + 2);
		details += this.placa;
		
		return details;
	}
}

package br.com.devwaaf.trabpoo.negocio.entidade;

public class Cliente {
	private String nome;
	private String CPF;
	private String endereco;
	private String email;
	private String password;
	private int id;
	
	private static int idReminder = 1;
	private static int maiorNome=0, maiorEmail=0, maiorSenha=0;
	
	private Cliente(String nome, String CPF, String endereco, String email, String password) {
		this.nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
		this.email = email;
		this.password = password;
		this.id = idReminder;
		
		idReminder++;
	}
	
	public static Cliente getInstance(String nome, String CPF, String endereco, String email, String password) {
		configureVariables(nome, email, password);
		return new Cliente(nome, CPF, endereco, email, password);
	}

	private static void configureVariables(String nome2, String email2, String password2) {
		if(maiorNome < nome2.length()) maiorNome = nome2.length();
		if(maiorEmail < email2.length()) maiorEmail = email2.length();
		if(maiorSenha < password2.length()) maiorSenha = password2.length();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public static int getMaiorNome() {
		return maiorNome;
	}

	public static void setMaiorNome(int maiorNome) {
		Cliente.maiorNome = maiorNome;
	}

	public static int getMaiorEmail() {
		return maiorEmail;
	}

	public static void setMaiorEmail(int maiorEmail) {
		Cliente.maiorEmail = maiorEmail;
	}

	public static int getMaiorSenha() {
		return maiorSenha;
	}

	public static void setMaiorSenha(int maiorSenha) {
		Cliente.maiorSenha = maiorSenha;
	}
	
	
	
	@Override
	public String toString() {
		String retorno = "";
		retorno += this.id + "  ";
		retorno += this.nome;
		retorno += " ".repeat(maiorNome - this.nome.length() + 2);
		retorno += this.CPF;
		retorno += " ".repeat(2);
		retorno += this.email;
		retorno += " ".repeat(maiorEmail - this.email.length() + 2);
		retorno += tratarSenha();
		retorno += " ".repeat(maiorSenha - this.password.length() + 2);
		retorno += this.endereco;
		return retorno;
	}

	private String tratarSenha() {
		String senha = "";
		int parte = (int) ((int) this.password.length() * 0.6);
		for (int i = 0; i < this.password.length(); i++) {
			if(i<=parte) senha += "*";
			if(i>parte) senha += this.password.charAt(i);
		}
		
		return senha;
	}
}

package br.com.devwaaf.trabpoo.ui;

import java.util.Scanner;

public class UILogin {
	Scanner scn = new Scanner(System.in);
	public void printErrorUser(){
		System.out.println("Usuário e/ou senha inválidos!");
	}

	public void printPassUser() {
		System.out.println("Logado com sucesso!");
	}

	public String getEmail() {
		System.out.print("Digite o email do usuário de login: ");
		String email = scn.nextLine();
		return email;
	}
	
	public String getPassword() {
		System.out.print("Digite a senha do usuário de login: ");
		String email = scn.nextLine();
		return email;
	}
}

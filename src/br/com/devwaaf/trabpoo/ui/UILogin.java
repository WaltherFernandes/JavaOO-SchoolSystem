package br.com.devwaaf.trabpoo.ui;

import java.util.Scanner;

public class UILogin {
	Scanner scn = new Scanner(System.in);
	public void printErrorUser(){
		System.out.println("Usu�rio e/ou senha inv�lidos!");
	}

	public void printPassUser() {
		System.out.println("Logado com sucesso!");
	}

	public String getEmail() {
		System.out.print("Digite o email do usu�rio de login: ");
		String email = scn.nextLine();
		return email;
	}
	
	public String getPassword() {
		System.out.print("Digite a senha do usu�rio de login: ");
		String email = scn.nextLine();
		return email;
	}
}

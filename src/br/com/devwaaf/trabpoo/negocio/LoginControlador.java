package br.com.devwaaf.trabpoo.negocio;

import java.util.Scanner;

import br.com.devwaaf.trabpoo.ui.UILogin;

public class LoginControlador {
	private Sistema system;
	private UILogin UILogin;
	
	public LoginControlador() {
		system = Sistema.getInstance();
		UILogin = new UILogin();
	}
	
	Scanner scn = new Scanner(System.in);
	
	public boolean isAdminUser() {
		String email = this.logar();
		
		while(email.equals("incorrect")) {
			UILogin.printErrorUser();
			email = this.logar();
		}
		
		if (email.equals("admin")) return true;
		
		return false;
	}
	
	public String logar() {
		
		String email = UILogin.getEmail();
		String userPassword = system.getClientController().getPasswordByName(email);
		if(userPassword != null) {
			System.out.print("Digite a senha do usuário: ");
			String pass = scn.nextLine();
			if(userPassword.equals(pass)) return "client";
		}
		if(email.equals("admin@oficinaalek.com")) {
			System.out.print("Digite a senha do usuário: ");
			String pass = scn.nextLine();
			if(pass.equals("admin")) return "admin";
		}
		return "incorrect";
	}
}

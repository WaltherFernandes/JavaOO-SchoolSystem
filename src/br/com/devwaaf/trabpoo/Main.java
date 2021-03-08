package br.com.devwaaf.trabpoo;

import br.com.devwaaf.trabpoo.negocio.Sistema;
import br.com.devwaaf.trabpoo.ui.UIPrincipalAdmin;

// Trabalho feito por Mateus Rezende e Walther Fernandes 

// Como � um sistema desktop, s� precisa do login na entrada do sistema

// Login: admin@oficinaalek.com	
// Password: admin

public class Main {
	

	private static boolean logarUsuarios = false;
	
	
	public static void main(String[] args) {
		Sistema sistema = Sistema.getInstance();
		sistema.init();
		if(logarUsuarios) {
			sistema.conectarADM();
			if(sistema.isAdminUser()) {
				UIPrincipalAdmin UIAdmin = new UIPrincipalAdmin();
				UIAdmin.iniciar();
			}else {
				// Implementarei no pr�ximo se for necess�rio
			}
		}else {
			UIPrincipalAdmin UIAdmin = new UIPrincipalAdmin();
			UIAdmin.iniciar();
		}
	}
}
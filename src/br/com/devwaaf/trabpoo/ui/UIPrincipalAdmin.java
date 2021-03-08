package br.com.devwaaf.trabpoo.ui;

import java.util.Scanner;

public class UIPrincipalAdmin {
	private UICliente UICliente;
	private UIVeiculo UIVeiculo;
	
	public UIPrincipalAdmin() {
		UICliente = new UICliente();
		UIVeiculo = new UIVeiculo();
	}
	
	public void iniciar() {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			clear(15);
			System.out.println("Digite uma opção");
			System.out.println("0 - Sair da aplicação");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Excluir cliente");
			System.out.println("3 - Listar clientes");
			System.out.println("4 - Editar cliente");
			System.out.println("5 - Cadastrar carros");
			System.out.println("6 - Excluir carros");
			System.out.println("7 - Listar carros");
			System.out.println("8 - Editar carro");
			System.out.println("9 - Listar carros do cliente");
			System.out.print("R = ");
			
			int opcao = scn.nextInt();
			
			rodarFuncao(opcao);
		}
	}
	
	private void rodarFuncao(int opcao) {
		switch (opcao) {
			case 0:
				System.out.println("Nunca será um adeus! 🚀");
				System.exit(200);
				break;
			case 1:
				UICliente.cadastrar();
				break;
			case 2: 
				UICliente.remover();
				break;
			case 3: 
				UICliente.listar();
				break;
			case 4: 
				UICliente.editar();
				break;
			case 5:
				UIVeiculo.cadastrar();
				break;
			case 6:
				UIVeiculo.remover();
				break;
			case 7:
				UIVeiculo.listar(); 
				break;
			case 8:
				UIVeiculo.editar();
				break;
			case 9: 
				UIVeiculo.listarVeiculosPorDono();
				break;
			default:
				break;
		}
		
	}

	private void clear(int times) {
		for (int i = 0; i < times; i++) {
			System.out.println();
		}
	}
}

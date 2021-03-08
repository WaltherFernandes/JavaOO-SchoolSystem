package br.com.devwaaf.trabpoo.ui;

import java.util.Scanner;

import br.com.devwaaf.trabpoo.negocio.Sistema;
import br.com.devwaaf.trabpoo.negocio.entidade.Cliente;

public class UICliente {
	private Scanner scn;
	private Sistema system;
	
	public UICliente() {
		scn = new Scanner(System.in);
		system = Sistema.getInstance();
	}
	
	
	public void cadastrar() {
		
		System.out.print("Digite o nome do cliente: ");
		String nome = scn.nextLine();
		
		System.out.print("Digite o CPF do cliente: ");
		String CPF = scn.nextLine();
		
		System.out.print("Digite o endereço do cliente: ");
		String endereco = scn.nextLine();
		
		System.out.print("Digite o email do cliente: ");
		String email = scn.nextLine();
		
		System.out.print("Digite a senha do cliente: ");
		String password = scn.nextLine();
		
		Cliente customer = Cliente.getInstance(nome, CPF, endereco, email, password);
		
		
		if(!system.inserir(customer)) {
			System.out.println("Já possui um cliente com esse CPF ou email cadastrado. Não foi possível cadastrar!");
			system.wait(3);
		}
	}


	public void listar() {
		System.out.println(system.listarClientes());
		system.wait(6);
	}


	public void remover() {
		this.listar();
		System.out.print("Digite o id do cliente que deseja excluir: ");
		int id = scn.nextInt();
		int position = getPositionByID(id);
		if(position == -1) { 
			System.out.println("Código inváldo"); 
			system.wait(2); 
			return;
		}
		system.apagarVeiculoPeloCliente(id);
		system.removerCliente(position);
	}
	
	private int getPositionByID(int id) {
		return system.getPositionByIDCliente(id);
	}


	public void editar() {
		this.listar();
		System.out.print("Digite o id do cliente que deseja editar: ");
		int id = scn.nextInt();
		int position = getPositionByID(id);
		if(position == -1) { 
			System.out.println("Código inváldo"); 
			system.wait(2); 
			return;
		}
		editarCliente(position);
	}
	
	public void editarCliente(int id) {
		while(true) {
			clear(15);
			System.out.println("Digite uma opção");
			System.out.println("0 - Voltar para o menu principal");
			System.out.println("1 - Editar nome");
			System.out.println("2 - Editar endereço");
			System.out.println("3 - Editar email");
			System.out.println("4 - Editar senha");
			
			int opcao = scn.nextInt();
			
			switch(opcao) {
				case 0: 
					return;
				case 1: 
					System.out.println("Digite o novo nome: ");
					scn.nextLine();
					String nome = scn.nextLine();
					system.editarCliente(1, id, nome);
					break;
				case 2:
					System.out.println("Digite o novo endereco: ");
					scn.nextLine();
					String endereco = scn.nextLine();
					system.editarCliente(2, id, endereco);
					break;
				case 3:
					System.out.println("Digite o novo email: ");
					scn.nextLine();
					String email = scn.nextLine();
					system.editarCliente(3, id, email);
					break;
				case 4:
					System.out.println("Digite a nova senha: ");
					scn.nextLine();
					String senha = scn.nextLine();
					system.editarCliente(4, id, senha);
					break;
			}
		}
	}
	
	private void clear(int times) {
		for (int i = 0; i < times; i++) {
			System.out.println();
		}
	}


	
}

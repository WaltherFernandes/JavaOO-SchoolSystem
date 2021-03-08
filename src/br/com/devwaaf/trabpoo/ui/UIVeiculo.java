package br.com.devwaaf.trabpoo.ui;

import java.util.List;
import java.util.Scanner;

import br.com.devwaaf.trabpoo.negocio.Sistema;
import br.com.devwaaf.trabpoo.negocio.entidade.Cliente;
import br.com.devwaaf.trabpoo.negocio.entidade.Veiculo;

public class UIVeiculo {
	private Sistema system;
	Scanner scn = new Scanner(System.in);
	
	public UIVeiculo() {
		system = Sistema.getInstance();
	}

	public void cadastrar() {
		
		System.out.print("Digite a placa do veiculo: ");
		String placa = scn.nextLine();
		if(placa.equals("")) placa = scn.nextLine();
		
		System.out.print("Digite o modelo do veiculo: ");
		String modelo = scn.nextLine();
		
		System.out.print("Digite o tipo do veiculo: ");
		String tipo = scn.nextLine();
		
		System.out.print("Digite o ano do veiculo: ");
		int ano = scn.nextInt();
		
		clear(15);
		System.out.print(system.listarClientes());
		System.out.print("Digite o ID do dono do veiculo: ");
		int positionCustomer = scn.nextInt();

		int idCustomer = system.getClientController().getPositionByID(positionCustomer);
		Cliente customer = system.getClientController().getCustomer(idCustomer);
		
		Veiculo vehicle = Veiculo.getInstance(placa, modelo, tipo, ano, customer);
		
		
		if(!system.inserir(vehicle)) {
			System.out.println("Já possui um cliente com esse CPF ou email cadastrado. Não foi possível cadastrar!");
			system.wait(3);
		}
	}
	
	public void listar() {
		clear(15);
		System.out.println(system.listarVeiculos());
		wait(5);
	}

	public void remover() {
		this.listar();
		System.out.print("Digite o ID do veículo que você deseja excluir: ");
		int idCustomer = scn.nextInt();
		system.removerVeiculo(system.getPositionByIDVeiculo(idCustomer));
	}
	
	public void editar() {
		this.listar();
		System.out.print("Digite o id do veiculo que deseja editar: ");
		int id = scn.nextInt();
		int position = system.getPositionByIDVeiculo(id);
		if(position == -1) { 
			System.out.println("Código inváldo"); 
			system.wait(2); 
			return;
		}
		editarVeiculo(position);
	}
	
	public void editarVeiculo(int id) {
		while(true) {
			clear(15);
			System.out.println("Digite uma opção");
			System.out.println("Para nossa segurança, caso tenha associado um veiculo a um cliente diferente, exclua o veiculo e refina-o.");
			System.out.println("0 - Voltar para o menu principal");
			System.out.println("1 - Editar placa");
			System.out.println("2 - Editar modelo");
			System.out.println("3 - Editar tipo");
			System.out.println("4 - Editar ano");
			System.out.print("R = ");
			
			int opcao = scn.nextInt();
			
			switch(opcao) {
				case 0: 
					return;
				case 1: 
					System.out.println("Digite a nova placa: ");
					scn.nextLine();
					String placa = scn.nextLine();
					system.editarVeiculo(1, id, placa);
					break;
				case 2:
					System.out.println("Digite o novo modelo: ");
					scn.nextLine();
					String modelo = scn.nextLine();
					system.editarVeiculo(2, id, modelo);
					break;
				case 3:
					System.out.println("Digite o novo tipo: ");
					scn.nextLine();
					String tipo = scn.nextLine();
					system.editarVeiculo(3, id, tipo);
					break;
				case 4:
					System.out.println("Digite o novo ano: ");
					scn.nextLine();
					int ano = scn.nextInt();
					system.editarVeiculo(4, id, Integer.toString(ano));
					break;
			}
		}
	}
	
	private void clear(int times) {
		for (int i = 0; i < times; i++) {
			System.out.println();
		}
	}
	public void wait(int seconds) {
		try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        	return;
        }
	}
	
	public void listarVeiculosPorDono() {
		System.out.println(system.listarClientes());
		system.wait(4);
		System.out.print("Digite o id do cliente que deseja editar: ");
		int id = scn.nextInt();
		int position = system.getPositionByIDCliente(id);
		if(position == -1) { 
			System.out.println("Código inváldo"); 
			system.wait(2); 
			return;
		}
		List<Veiculo> veiculos =  system.getVehicleController().getCarsByCustomer(system.getClientController().getCustomer(position));
		String veiculosDosDonos = "";
		for(Veiculo vehicle : veiculos) {
			veiculosDosDonos += vehicle.toString() + "\n";
		}
		System.out.println(veiculosDosDonos);
		system.wait(4);
	}

}

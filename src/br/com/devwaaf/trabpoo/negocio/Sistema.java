package br.com.devwaaf.trabpoo.negocio;

import br.com.devwaaf.trabpoo.negocio.entidade.Cliente;
import br.com.devwaaf.trabpoo.negocio.entidade.Veiculo;

public class Sistema {

	private static Sistema instance;
	private static LoginControlador LoginSystem;
	private ClienteControlador CustomerController;
	private VeiculoControlador VehicleController;
	
	private static boolean isAdminUser;
	
	private Sistema() {
		CustomerController = new ClienteControlador();
		VehicleController = new VeiculoControlador();
		setAdminUser(false);
	}

	// Singleton
	public static Sistema getInstance() {
		if (instance == null) {
			instance = new Sistema();
		}
		return instance;
	}
	
	public void init() {
		// Cadastro de clientes
		CustomerController.add(Cliente.getInstance("Walther Fernandes", "123.456.789-10", "Rua X, 001, Barão de Cocais", "waltheraaf@gmail.com", "1234"));
		CustomerController.add(Cliente.getInstance("Mateus Rezende", "987.654.321-00", "Coronel Fabriciano", "mateusrezendexd@gmail.com", "1234"));
		CustomerController.add(Cliente.getInstance("Ingridi Nogueira", "135.792.468-00", "Barão de Cocais", "ingridiin@gmail.com", "1234"));
		CustomerController.add(Cliente.getInstance("Roseli Batista", "246.813.579-00", "Brazil", "roselibn@roseli.com", "1234"));
		CustomerController.add(Cliente.getInstance("Luciano", "123.789.456-00", "Vale do aço", "lucainonm@gmail.com", "1234"));
		// Métodos de clientes
		CustomerController.remover(2);
		CustomerController.editEmail(2, "roselibn@hotmail.com");
		CustomerController.editSenha(2, "123456789");
		
		// Cadastro de veículos
		VehicleController.add(Veiculo.getInstance("AWZ-1234", "Fiat Palio", "Hatch", 2008, CustomerController.getCustomer(1)));
		VehicleController.add(Veiculo.getInstance("AWZ-1235", "Volkswagen Voyage", "Sedan", 2011, CustomerController.getCustomer(0)));
		VehicleController.add(Veiculo.getInstance("AWZ-1236", "Jeep Compass", "SUV", 2010, CustomerController.getCustomer(0)));
		VehicleController.add(Veiculo.getInstance("AWZ-1237", "Toyota Hilux", "PickUp", 2016, CustomerController.getCustomer(3)));
		VehicleController.add(Veiculo.getInstance("AWZ-1238", "Lamborghini Huracán", "Superesportivo", 2010, CustomerController.getCustomer(3)));
		// Métodos de veículos
		VehicleController.remover(4);
		VehicleController.editAno(2, 2017);
		VehicleController.editTipo(2, "Pick-UP");
	}
	
	
	
	
	public void conectarADM() {
		LoginSystem = new LoginControlador();
		isAdminUser = LoginSystem.isAdminUser();
		return;
	}

	public boolean isAdminUser() {
		return isAdminUser;
	}

	public static void setAdminUser(boolean isAdminUser) {
		Sistema.isAdminUser = isAdminUser;
	}
	
	public ClienteControlador getClientController() {
		return this.CustomerController;
	}
	public VeiculoControlador getVehicleController() {
		return this.VehicleController;
	}

	
	
	
	// Funções a favor dos clientes
	public boolean inserir(Cliente customer) {
		return CustomerController.add(customer);
	}
	
	public void wait(int seconds) {
		try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        	return;
        }
	}

	public String listarClientes() {
		return CustomerController.list();
	}

	public void removerCliente(int id) {
		CustomerController.remover(id);
	}

	public int getPositionByIDCliente(int id) {
		return CustomerController.getPositionByID(id);
	}
	public int getPositionByIDVeiculo(int id) {
		return VehicleController.getPositionByIDCliente(id);
	}

	public void editarCliente(int opcao, int id, String valor) {
		if(opcao == 1) CustomerController.editName(id, valor);
		if(opcao == 2) CustomerController.editEndereco(id, valor);
		if(opcao == 3) CustomerController.editEmail(id, valor);
		if(opcao == 4) CustomerController.editSenha(id, valor);
	}

	public boolean inserir(Veiculo vehicle) {
		return VehicleController.add(vehicle);
	}

	public String listarVeiculos() {
		return VehicleController.list();
	}

	public void removerVeiculo(int positionByIDVeiculo) {
		VehicleController.remover(positionByIDVeiculo);
	}

	public void apagarVeiculoPeloCliente(int id) {
		VehicleController.removeByCustomer(id);
	}

	public void editarVeiculo(int opcao, int id, String valor) {
		if(opcao == 1) VehicleController.editPlaca(id, valor);
		if(opcao == 2) VehicleController.editModelo(id, valor);
		if(opcao == 3) VehicleController.editTipo(id, valor);
		if(opcao == 4) VehicleController.editAno(id, Integer.parseInt(valor));
	}


}

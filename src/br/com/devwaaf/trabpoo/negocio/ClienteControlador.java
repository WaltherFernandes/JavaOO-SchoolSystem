package br.com.devwaaf.trabpoo.negocio;

import java.util.List;

import br.com.devwaaf.trabpoo.dados.ClienteRepositorio;
import br.com.devwaaf.trabpoo.negocio.entidade.Cliente;

public class ClienteControlador {
	private ClienteRepositorio repositorio;
	
	public ClienteControlador() {
		repositorio = new ClienteRepositorio();
	}
	
	public boolean add(Cliente customer) {
		if(!validarCliente(customer)) return false;
		repositorio.add(customer);
		return true;
	}
	
	public String list() {
		String customers = "";
		for(Cliente client : repositorio.all()) {
			customers += client.toString() + "\n";
		}
		
		return customers;
	}
	public Cliente getCustomer(int id) {
		return repositorio.buscarCliente(id);
	}
	
	public void remover(Cliente customer) {
		repositorio.remove(customer);
	}
	public void remover(int id) {
		repositorio.remove(id);
	}
	
	public String getPasswordByName(String email) {
		List<Cliente> clientes = repositorio.all();
		for(Cliente client : clientes) {
			if(client.getEmail().equals(email)) {
				return client.getPassword();
			}
		}
		return null;
	}
	
	public boolean validarCliente(Cliente customer) {
		List<Cliente> customers = repositorio.all();
		
		for(Cliente itemCustomer : customers ) {
			if(customer.getCPF().equals(itemCustomer.getCPF())) return false;
			if(customer.getEmail().equals(itemCustomer.getEmail())) return false;
		}
		
		return true;
	}

	public int getPositionByID(int id) {
		int index = 0;
		for(Cliente customer : repositorio.all() ) {
			if(customer.getId() == id) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public void editName(int id, String valor) {
		Cliente customer = repositorio.buscarCliente(id);
		customer.setNome(valor);
		if(Cliente.getMaiorNome() < valor.length()) Cliente.setMaiorNome(valor.length());
		repositorio.set(id, customer);
	}

	public void editEndereco(int id, String valor) {
		Cliente customer = repositorio.buscarCliente(id);
		customer.setEndereco(valor);
		repositorio.set(id, customer);
	}

	public void editEmail(int id, String valor) {
		Cliente customer = repositorio.buscarCliente(id);
		customer.setEmail(valor);
		if(Cliente.getMaiorEmail() < valor.length()) Cliente.setMaiorEmail(valor.length());
		repositorio.set(id, customer);
	}

	public void editSenha(int id, String valor) {
		Cliente customer = repositorio.buscarCliente(id);
		customer.setPassword(valor);
		if(Cliente.getMaiorSenha() < valor.length()) Cliente.setMaiorSenha(valor.length());
		repositorio.set(id, customer);
	}
}

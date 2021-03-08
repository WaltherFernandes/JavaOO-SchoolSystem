package br.com.devwaaf.trabpoo.dados;

import java.util.ArrayList;
import java.util.List;

import br.com.devwaaf.trabpoo.negocio.entidade.Cliente;

public class ClienteRepositorio {
	private List<Cliente> clientes;
	
	public ClienteRepositorio() {
		clientes = new ArrayList<Cliente>();
	}
	
	public List<Cliente> all() {
		return clientes;
	}
	
	public Cliente buscarCliente(int index) {
		if(index < clientes.size()) {
			return clientes.get(index);
		}
		return null;
	}
	public Cliente buscarCliente(Cliente client) {
		int index = clientes.indexOf(client);
		return clientes.get(index);
	}
	
	public void add(Cliente client) {
		clientes.add(client);
	}
	
	public void set(int id, Cliente customer) {
		clientes.set(id, customer);
	}
	
	public void remove(int id) {
		clientes.remove(id);
	}
	public void remove(Cliente client) {
		clientes.remove(client);
	}
}

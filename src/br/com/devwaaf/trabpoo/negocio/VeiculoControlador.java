package br.com.devwaaf.trabpoo.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.devwaaf.trabpoo.dados.VeiculoRepositorio;
import br.com.devwaaf.trabpoo.negocio.entidade.Cliente;
import br.com.devwaaf.trabpoo.negocio.entidade.Veiculo;

public class VeiculoControlador {
	private VeiculoRepositorio repositorio;
	
	public VeiculoControlador() {
		repositorio = new VeiculoRepositorio();
	}

	public boolean add(Veiculo vehicle) {
		if(repositorio.existePlaca(vehicle)) return false;
		if(vehicle == null) return false;
		repositorio.add(vehicle);
		
		return true;
	}

	public String list() {
		String vehiclesString = "";
		for(Veiculo vehicle : repositorio.all()) {
			if(vehicle != null) {
				vehiclesString += vehicle.toString() + "\n";
			}
		}
		
		return vehiclesString;
	}

	public int getPositionByIDCliente(int id) {
		int index = 0;
		for(Veiculo vehicle : repositorio.all()) {
			if(vehicle.getId() == id) {
				return index;
			}
			index++;
		}
		
		return -1;
	}

	public void remover(int id) {
		repositorio.remove(id);
	}

	public void removeByCustomer(int id) {
		int index = 0;
		for(Veiculo vehicle : repositorio.all()) {
			if(vehicle.getDono().getId() == id) {
				repositorio.remove(id);
			}
			index++;
		}
		index = index+=0; // Desconsidere essa linha, somente pra retirar o warning
	}

	public void editPlaca(int id, String valor) {
		Veiculo vehicle = repositorio.getVehicle(id);
		vehicle.setPlaca(valor);
		repositorio.set(id, vehicle);
	}
	
	public void editModelo(int id, String valor) {
		Veiculo vehicle = repositorio.getVehicle(id);
		vehicle.setModelo(valor);
		if(Veiculo.getMaiorModelo() < valor.length()) Veiculo.setMaiorModelo(valor.length());
		repositorio.set(id, vehicle);
	}

	public void editTipo(int id, String valor) {
		Veiculo vehicle = repositorio.getVehicle(id);
		vehicle.setTipo(valor);
		if(Veiculo.getMaiorTipo() < valor.length()) Veiculo.setMaiorTipo(valor.length());
		repositorio.set(id, vehicle);
	}

	public void editAno(int id, int valor) {
		Veiculo vehicle = repositorio.getVehicle(id);
		vehicle.setAno(valor);
		repositorio.set(id, vehicle);
	}

	public List<Veiculo> getCarsByCustomer(Cliente customer) {
		List<Veiculo> vehicles = new ArrayList<Veiculo>();
		for(Veiculo vehicle: repositorio.all()) {
			if(vehicle.getDono().equals(customer)) {
				vehicles.add(vehicle);
			}
		}
		
		return vehicles;
	}
}


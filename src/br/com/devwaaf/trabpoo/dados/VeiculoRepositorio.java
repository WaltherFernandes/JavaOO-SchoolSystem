package br.com.devwaaf.trabpoo.dados;

import java.util.ArrayList;
import java.util.List;

import br.com.devwaaf.trabpoo.negocio.entidade.Veiculo;

public class VeiculoRepositorio {
	List<Veiculo> vehicles;
	
	public VeiculoRepositorio() {
		vehicles = new ArrayList<Veiculo>();
	}
	
	public void add(Veiculo vehicle) {
		vehicles.add(vehicle);
	}

	public boolean existePlaca(Veiculo vehicle) {
		for(Veiculo currentVehicle : vehicles) {
			if(currentVehicle != null && vehicle != null) {
				if(currentVehicle.getPlaca().equals(vehicle.getPlaca())) return true;
			}
		}
		return false;
	}

	public List<Veiculo> all() {
		return this.vehicles;
	}

	public void remove(int id) {
		vehicles.remove(id);
	}
	
	public Veiculo getVehicle(int id) {
		System.out.println(id);
		return vehicles.get(id);
	}
	
	public Veiculo getVehicle(Veiculo vehicle) {
		int index = vehicles.indexOf(vehicle);
		return vehicles.get(index);
	}

	public void set(int id, Veiculo vehicle) {
		vehicles.set(id, vehicle);
	}
	
}

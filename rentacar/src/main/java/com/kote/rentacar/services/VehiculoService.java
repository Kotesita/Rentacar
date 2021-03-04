package com.kote.rentacar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kote.rentacar.models.*;
import com.kote.rentacar.repositories.VehiculoRepository;

@Service
public class VehiculoService {
private final VehiculoRepository vehiRepo;
	
	public VehiculoService(VehiculoRepository vehiRepo) {
		this.vehiRepo = vehiRepo;
	}
	
	public List<Vehiculo> allVehiculos(){
		return vehiRepo.findAll();
	}
	
	public Vehiculo createVehiculo(Vehiculo vehi) {		
		return vehiRepo.save(vehi);
	}
	
	public Vehiculo unVehiculo(Integer id) {
		return vehiRepo.findById(id);
	}
	
	public void deleteVehiculo(Vehiculo vehi) {
		vehiRepo.delete(vehi);
	}
	
}

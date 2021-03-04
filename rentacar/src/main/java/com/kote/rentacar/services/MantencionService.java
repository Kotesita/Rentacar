package com.kote.rentacar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.kote.rentacar.repositories.MantencionRepository;
import com.kote.rentacar.repositories.VehiculoRepository;
import com.kote.rentacar.models.*;

@Service
public class MantencionService {
	private final MantencionRepository mantRepo;
	
	public MantencionService(MantencionRepository mantRepo) {
		this.mantRepo = mantRepo;
	}
	
	public List<Mantencion> allMantenciones(){
		return mantRepo.findAll();
	}
	
	public Mantencion createMantencion(Mantencion mant) {		
		return mantRepo.save(mant);
	}
	
	public Mantencion unaMantencion(Integer id) {
		return mantRepo.findById(id);
	}
	
	public void deleteMantencion(Mantencion mant) {
		mantRepo.delete(mant);
	}
	
}

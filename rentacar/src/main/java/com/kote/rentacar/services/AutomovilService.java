package com.kote.rentacar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kote.rentacar.models.*;
import com.kote.rentacar.repositories.AutomovilRepository;

@Service
public class AutomovilService {
private final AutomovilRepository autoRepo;
	
	public AutomovilService(AutomovilRepository autoRepo) {
		this.autoRepo = autoRepo;
	}
	
	public List<Automovil> allAutomoviles(){
		return autoRepo.findAll();
	}

	public Automovil createAuto(Automovil auto) {		
		return autoRepo.save(auto);
	}
	
	public Automovil unAutomovil(Integer id) {
		return autoRepo.findById(id);
	}
	
	public void deleteAuto(Automovil auto) {
		autoRepo.delete(auto);
	}
	
}

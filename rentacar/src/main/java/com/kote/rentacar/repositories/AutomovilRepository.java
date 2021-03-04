package com.kote.rentacar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.rentacar.models.Automovil;

public interface AutomovilRepository extends JpaRepository<Automovil, Long>{

    List<Automovil> findAll();

	Automovil findById(Integer id);
}

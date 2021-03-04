package com.kote.rentacar.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kote.rentacar.models.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{

    List<Vehiculo> findAll();

	Vehiculo findById(Integer id);

}
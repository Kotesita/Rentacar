package com.kote.rentacar.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.rentacar.models.Mantencion;

public interface MantencionRepository extends JpaRepository<Mantencion, Long>{

    List<Mantencion> findAll();

	Mantencion findById(Integer id);

}

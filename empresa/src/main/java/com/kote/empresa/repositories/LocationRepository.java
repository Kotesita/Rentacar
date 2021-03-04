package com.kote.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.empresa.models.Location;

public interface LocationRepository extends JpaRepository<Location, Float>{

    List<Location> findAll();

    Location findById(Integer id);
}

package com.kote.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.empresa.models.Region;

public interface RegionRepository extends JpaRepository<Region, Float>{

    List<Region> findAll();

    Region findById(Integer id);
}

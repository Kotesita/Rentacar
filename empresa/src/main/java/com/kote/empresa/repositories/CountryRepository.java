package com.kote.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.empresa.models.Country;

public interface CountryRepository extends JpaRepository<Country, Float>{

	    List<Country> findAll();

		Country findById(Integer id);
}

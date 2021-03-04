package com.kote.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.empresa.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Float>{

    List<Department> findAll();

	Department findById(Integer id);
}

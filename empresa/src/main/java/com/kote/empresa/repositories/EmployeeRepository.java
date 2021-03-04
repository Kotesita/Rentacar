package com.kote.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.empresa.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Float>{

    List<Employee> findAll();

    Employee findById(Integer id);
}

package com.kote.empresa.services;

import java.util.List;

import com.kote.empresa.models.Employee;
import com.kote.empresa.repositories.EmployeeRepository;


public class EmployeeService {
	private final EmployeeRepository empRepo;
		
		public EmployeeService(EmployeeRepository empRepo) {
			this.empRepo = empRepo;
		}
		
		public List<Employee> allEmployee(){
			return empRepo.findAll();
		}
	
		public Employee createEmp(Employee emp) {		
			return empRepo.save(emp);
		}
		
		public Employee anEmp(Integer id) {
			return empRepo.findById(id);
		}
		
		public void deleteEmployee(Employee emp) {
			empRepo.delete(emp);
		}
		
}

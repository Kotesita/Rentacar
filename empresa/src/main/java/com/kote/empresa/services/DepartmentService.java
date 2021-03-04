package com.kote.empresa.services;

import java.util.List;

import com.kote.empresa.models.Department;
import com.kote.empresa.repositories.DepartmentRepository;


public class DepartmentService {
	private final DepartmentRepository depRepo;
		
		public DepartmentService(DepartmentRepository depRepo) {
			this.depRepo = depRepo;
		}
		
		public List<Department> allDepartments(){
			return depRepo.findAll();
		}
	
		public Department createDep(Department dep) {		
			return depRepo.save(dep);
		}
		
		public Department aDep(Integer id) {
			return depRepo.findById(id);
		}
		
		public void deleteDepartment(Department dep) {
			depRepo.delete(dep);
		}
		
}

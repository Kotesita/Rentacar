package com.kote.empresa.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kote.empresa.models.*;
import com.kote.empresa.services.*;

public class ApplicationController {

private final CountryService countryService;
private final DepartmentService depService;
private final EmployeeService empService;
private final JobService jobService;
private final JobHistoryService jhService;
private final LocationService locService;
private final RegionService regionService;

	public ApplicationController(CountryService countryService, DepartmentService depService, EmployeeService empService, JobService jobService, JobHistoryService jhService, LocationService locService, RegionService regionService) {
		this.countryService = countryService;
		this.depService = depService;
		this.empService = empService;
		this.jobService = jobService;
		this.jhService = jhService;
		this.locService = locService;
		this.regionService = regionService;
	}
	
	@GetMapping(path="/empleadosGrupo")
	public ArrayList<Integer> getEmpleadosGrupo(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Integer SegmentoA = 0;
		Integer SegmentoB = 0;
		Integer SegmentoC = 0;
		for(Employee emp : empService.allEmployee()) {
			if(emp.getSalary()<3500) {
				SegmentoA+=1;
			} else if (emp.getSalary()>=3500 && emp.getSalary()<8000) {
				SegmentoB+=1;
			} else {
				SegmentoC+=1;
			}	
		}	
		lista.add(SegmentoA);
		lista.add(SegmentoB);
		lista.add(SegmentoC);
		return lista;
	}
	
	@GetMapping(path="/departamentosGrupo")
	public ArrayList<Integer> getDepartamentosGrupo(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Integer SegmentoA = 0;
		Integer SegmentoB = 0;
		Integer SegmentoC = 0;
		for(Department dep: depService.allDepartments()) {
			for(Employee emp : dep.getEmployees()) {
				if(emp.getSalary()<3500) {
					SegmentoA+=1;
				} else if (emp.getSalary()>=3500 && emp.getSalary()<8000) {
					SegmentoB+=1;
				} else {
					SegmentoC+=1;
				}	
			}	
		}	
		lista.add(SegmentoA);
		lista.add(SegmentoB);
		lista.add(SegmentoC);
		return lista;
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(path="/empleadosAntiguos")
	public ArrayList<Employee> getEmpleadosAntiguos(){
		ArrayList<Employee> lista = new ArrayList<Employee>();
		LocalDateTime now = LocalDateTime.now();  
		for (Employee emp : empService.allEmployee()) {
			if((now.getYear()-emp.getHire_date().getYear())>=15) {
				lista.add(emp);
			}
		}
		return lista;
	
	}
}

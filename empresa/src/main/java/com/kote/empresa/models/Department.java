package com.kote.empresa.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Float department_id;
	
	private String department_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id")
	@NotNull(message = "El campo no debe estar vacío")
    private Location location;
	
	@OneToMany(mappedBy="departments", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    private List<Employee> managers;

	public Float getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Float department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Employee> getManagers() {
		return managers;
	}

	public void setManagers(List<Employee> managers) {
		this.managers = managers;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}

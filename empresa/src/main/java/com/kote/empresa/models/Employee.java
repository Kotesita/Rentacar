package com.kote.empresa.models;

import java.util.Date;
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
@Table(name="Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Float employee_id;
	
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private String phone_number;
	
	private Date hire_date;
	
	private Float salary;
	
	private Float comission_pct;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
	@NotNull(message = "El campo no debe estar vacío")
    private Department department;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="job_id")
	@NotNull(message = "El campo no debe estar vacío")
    private Job job;

	public Float getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Float employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Float getComission_pct() {
		return comission_pct;
	}

	public void setComission_pct(Float comission_pct) {
		this.comission_pct = comission_pct;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}

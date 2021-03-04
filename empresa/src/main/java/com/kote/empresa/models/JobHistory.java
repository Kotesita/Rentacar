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
import javax.persistence.Table;

@Entity
@Table(name="Job_history")
public class JobHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Float id;
	
	private Date start_date;
	
	private Date end_date;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="job_id")
    private Job job;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;
    
    @OneToMany(mappedBy="employees", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employee;

	public Float getId() {
		return id;
	}

	public void setId(Float id) {
		this.id = id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
    
}

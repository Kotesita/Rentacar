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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Locations")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Float location_id;
	
	private String street_address;
	
	private String postal_code;
	
	private String city;
	
	private String state_province;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
	@NotNull(message = "El campo no debe estar vacío")
    private Country country;
	
	@OneToMany(mappedBy="departments", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments;

	public Float getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Float location_id) {
		this.location_id = location_id;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState_province() {
		return state_province;
	}

	public void setState_province(String state_province) {
		this.state_province = state_province;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
}

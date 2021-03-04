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
@Table(name="Countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String country_id;
	
	private String country_name;
	
	private Float region_id;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
	@NotNull(message = "El campo no debe estar vacío")
    private Region region;
	
	@OneToMany(mappedBy="countries", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations;
	
	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Float getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Float region_id) {
		this.region_id = region_id;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
		
}

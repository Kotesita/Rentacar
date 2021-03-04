package com.kote.empresa.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Regions")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Float region_id;
	
	private String region_name;
	
	@OneToMany(mappedBy="regions", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Country> countries;

	public Float getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Float region_id) {
		this.region_id = region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
}

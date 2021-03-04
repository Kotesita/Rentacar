package com.kote.empresa.services;

import java.util.List;

import com.kote.empresa.models.Country;
import com.kote.empresa.repositories.CountryRepository;


public class CountryService {
	private final CountryRepository countryRepo;
		
		public CountryService(CountryRepository countryRepo) {
			this.countryRepo = countryRepo;
		}
		
		public List<Country> allCountries(){
			return countryRepo.findAll();
		}
	
		public Country createCOuntry(Country country) {		
			return countryRepo.save(country);
		}
		
		public Country aCountry(Integer id) {
			return countryRepo.findById(id);
		}
		
		public void deleteCountry(Country country) {
			countryRepo.delete(country);
		}
		
}

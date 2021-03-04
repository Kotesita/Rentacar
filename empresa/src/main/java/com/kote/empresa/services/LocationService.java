package com.kote.empresa.services;

import java.util.List;

import com.kote.empresa.models.Location;
import com.kote.empresa.repositories.LocationRepository;


public class LocationService {
	private final LocationRepository locRepo;
		
		public LocationService(LocationRepository locRepo) {
			this.locRepo = locRepo;
		}
		
		public List<Location> allLocation(){
			return locRepo.findAll();
		}
	
		public Location createLocation(Location loc) {		
			return locRepo.save(loc);
		}
		
		public Location aLocation(Integer id) {
			return locRepo.findById(id);
		}
		
		public void deleteLocation(Location loc) {
			locRepo.delete(loc);
		}
		
}

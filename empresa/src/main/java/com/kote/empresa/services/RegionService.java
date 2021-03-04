package com.kote.empresa.services;

import java.util.List;

import com.kote.empresa.models.Region;
import com.kote.empresa.repositories.RegionRepository;


public class RegionService {
	private final RegionRepository regRepo;
		
		public RegionService(RegionRepository regRepo) {
			this.regRepo = regRepo;
		}
		
		public List<Region> allRegion(){
			return regRepo.findAll();
		}
	
		public Region createRegion(Region reg) {		
			return regRepo.save(reg);
		}
		
		public Region aRegion(Integer id) {
			return regRepo.findById(id);
		}
		
		public void deleteRegion(Region reg) {
			regRepo.delete(reg);
		}
		
}

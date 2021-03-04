package com.kote.empresa.services;

import java.util.List;

import com.kote.empresa.models.JobHistory;
import com.kote.empresa.repositories.JobHistoryRepository;


public class JobHistoryService {
	private final JobHistoryRepository jhRepo;
		
		public JobHistoryService(JobHistoryRepository jhRepo) {
			this.jhRepo = jhRepo;
		}
		
		public List<JobHistory> allJobHistory(){
			return jhRepo.findAll();
		}
	
		public JobHistory createJobHistory(JobHistory jh) {		
			return jhRepo.save(jh);
		}
		
		public JobHistory aJobHistory(Integer id) {
			return jhRepo.findById(id);
		}
		
		public void deleteJobHistory(JobHistory jh) {
			jhRepo.delete(jh);
		}
		
}

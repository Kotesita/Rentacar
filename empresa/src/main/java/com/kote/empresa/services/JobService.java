package com.kote.empresa.services;

import java.util.List;

import com.kote.empresa.models.Job;
import com.kote.empresa.repositories.JobRepository;


public class JobService {
	private final JobRepository jobRepo;
		
		public JobService(JobRepository jobRepo) {
			this.jobRepo = jobRepo;
		}
		
		public List<Job> allJob(){
			return jobRepo.findAll();
		}
	
		public Job createJob(Job job) {		
			return jobRepo.save(job);
		}
		
		public Job aJob(Integer id) {
			return jobRepo.findById(id);
		}
		
		public void deleteJob(Job job) {
			jobRepo.delete(job);
		}
		
}

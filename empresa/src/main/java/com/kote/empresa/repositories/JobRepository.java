package com.kote.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.empresa.models.Job;

public interface JobRepository extends JpaRepository<Job, Float>{

    List<Job> findAll();

    Job findById(Integer id);
}

package com.kote.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kote.empresa.models.JobHistory;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Float>{

    List<JobHistory> findAll();

    JobHistory findById(Integer id);
}

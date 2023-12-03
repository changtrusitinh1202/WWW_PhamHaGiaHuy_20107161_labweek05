package com.example.lab_week05.backend.repositories;

import com.example.lab_week05.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
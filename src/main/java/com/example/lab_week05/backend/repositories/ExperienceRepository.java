package com.example.lab_week05.backend.repositories;

import com.example.lab_week05.backend.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
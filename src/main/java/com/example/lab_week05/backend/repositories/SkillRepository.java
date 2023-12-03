package com.example.lab_week05.backend.repositories;

import com.example.lab_week05.backend.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
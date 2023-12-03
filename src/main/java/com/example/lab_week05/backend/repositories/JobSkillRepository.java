package com.example.lab_week05.backend.repositories;

import com.example.lab_week05.backend.ids.JobSkillID;
import com.example.lab_week05.backend.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillID> {
}
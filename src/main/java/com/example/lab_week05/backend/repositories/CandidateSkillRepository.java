package com.example.lab_week05.backend.repositories;

import com.example.lab_week05.backend.ids.CandidateSkillID;
import com.example.lab_week05.backend.models.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillID> {
}
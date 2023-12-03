package com.example.lab_week05.backend.ids;

import com.example.lab_week05.backend.models.Candidate;
import com.example.lab_week05.backend.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSkillID implements Serializable {
    private Candidate candidate;
    private Skill skill;
}

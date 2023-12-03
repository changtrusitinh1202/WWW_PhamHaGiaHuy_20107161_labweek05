package com.example.lab_week05.backend.ids;

import com.example.lab_week05.backend.models.Job;
import com.example.lab_week05.backend.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSkillID implements Serializable {
    private Job job;
    private Skill skill;
}

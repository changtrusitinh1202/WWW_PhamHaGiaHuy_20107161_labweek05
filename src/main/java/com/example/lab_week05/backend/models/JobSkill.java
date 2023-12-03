package com.example.lab_week05.backend.models;

import com.example.lab_week05.backend.converters.SkillLevelConverter;
import com.example.lab_week05.backend.enums.SkillLevel;
import com.example.lab_week05.backend.ids.JobSkillID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(JobSkillID.class)
public class JobSkill {
    @Convert(converter = SkillLevelConverter.class)
    @Column(name = "skill_level", columnDefinition = "tinyint(4)")
    private SkillLevel skillLevel;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Job job;
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfo;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id")
    private Skill skill;
}

package com.example.lab_week05.backend.models;

import com.example.lab_week05.backend.converters.SkillTypeConverter;
import com.example.lab_week05.backend.enums.SkillLevel;
import com.example.lab_week05.backend.ids.CandidateSkillID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidate_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(CandidateSkillID.class)
public class CandidateSkill {
    @Convert(converter = SkillTypeConverter.class)
    @Column(name = "skill_level", columnDefinition = "tinyint(4)")
    private SkillLevel skillLevel;
    @Id
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfo;
}

package com.example.lab_week05.backend.models;

import com.example.lab_week05.backend.converters.SkillTypeConverter;
import com.example.lab_week05.backend.enums.SkillType;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "skill_name", columnDefinition = "varchar(150)")
    private String skillName;
    @Column(name = "skill_desc", columnDefinition = "varchar(300)")
    private String skillDescription;
    @Convert(converter = SkillTypeConverter.class)
    @Column(name = "skill_type", columnDefinition = "tinyint(4)")
    private SkillType skillType;
}

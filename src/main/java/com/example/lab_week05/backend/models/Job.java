package com.example.lab_week05.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "job_name", columnDefinition = "varchar(255)")
    private String name;
    @ManyToOne
    @JoinColumn(name = "company", referencedColumnName = "com_id")
    private Company company;
    @Column(name = "job_desc", columnDefinition = "varchar(255)")
    private String description;
    @OneToMany(mappedBy = "job",fetch = FetchType.EAGER)
    private List<JobSkill> jobSkills;
}

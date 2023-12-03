package com.example.lab_week05.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "to_date", columnDefinition = "date")
    private LocalDate toDate;
    @Column(name = "from_date",columnDefinition = "date")
    private LocalDate fromDate;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "company", columnDefinition = "varchar(200)")
    private String companyName;
    @Column( columnDefinition = "varchar(100)")
    private String role;
    @Column(name = "work_desc", columnDefinition = "varchar(400)")
    private String workDescription;
}

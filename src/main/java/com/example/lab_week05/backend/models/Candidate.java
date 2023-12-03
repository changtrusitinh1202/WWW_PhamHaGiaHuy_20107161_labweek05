package com.example.lab_week05.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(columnDefinition = "varchar(15)")
    private String phone;
    @Column(columnDefinition = "date")
    private LocalDate dob;
    @Column(columnDefinition = "varchar(255)")
    private String email;
    @Column(columnDefinition = "varchar(255)")
    private String fullName;
    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "add_id")
    private Address address;
    @OneToMany(mappedBy = "candidate" ,fetch = FetchType.EAGER)
    private List<CandidateSkill> candidateSkills;
    @OneToMany(mappedBy = "candidate" ,fetch = FetchType.EAGER)
    private List<Experience> experiences;

    public Candidate(String phone, LocalDate dob, String email, String fullName, Address address) {
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
    }
}

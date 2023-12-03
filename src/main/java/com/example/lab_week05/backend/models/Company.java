package com.example.lab_week05.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(columnDefinition = "varchar(2000)")
    private String about;
    @Column(columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "comp_name",columnDefinition = "varchar(2000)")
    private String name;
    @Column(columnDefinition = "varchar(255)")
    private String phone;
    @Column(columnDefinition = "varchar(255)")
    private String webUrl;
    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "add_id")
    private Address address;
    @OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
    private List<Job> job;
}

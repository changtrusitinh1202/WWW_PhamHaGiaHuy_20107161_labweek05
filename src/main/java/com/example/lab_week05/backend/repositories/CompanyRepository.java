package com.example.lab_week05.backend.repositories;

import com.example.lab_week05.backend.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
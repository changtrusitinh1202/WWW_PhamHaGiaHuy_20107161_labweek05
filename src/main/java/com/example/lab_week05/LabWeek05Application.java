package com.example.lab_week05;

import com.example.lab_week05.backend.models.Address;
import com.example.lab_week05.backend.models.Candidate;
import com.example.lab_week05.backend.repositories.AddressRepository;
import com.example.lab_week05.backend.repositories.CandidateRepository;
import com.example.lab_week05.backend.repositories.CandidateSkillRepository;
import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication

public class LabWeek05Application {

    public static void main(String[] args) {
        SpringApplication.run(LabWeek05Application.class, args);
    }
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Bean
    CommandLineRunner initData(){
        return args -> {
            Random rnd =new Random();
            for (int i = 1; i < 1000; i++) {
                Address add = new Address(rnd.nextInt(1, 1000) + "", CountryCode.VN, "HCM",
                        "Quang Trung",  rnd.nextInt(70000, 80000) + "");

                addressRepository.save(add);
                Candidate can = new Candidate(rnd.nextLong(1111111111L, 9999999999L) + "",
                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
                        "email_" + i + "@gmail.com",
                        "Name #" + i,
                        add);

                candidateRepository.save(can);
                System.out.println("Added: " + can);
            }
        };
    }
}

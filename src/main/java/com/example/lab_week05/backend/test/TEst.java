package com.example.lab_week05.backend.test;

import com.example.lab_week05.backend.models.Candidate;
import com.example.lab_week05.backend.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TEst {
    @Autowired
    private static CandidateRepository candidateRepository;
    public static void main(String[] args) {
        List<Candidate> list = candidateRepository.findAll();
        System.out.println(list.size());

    }
}

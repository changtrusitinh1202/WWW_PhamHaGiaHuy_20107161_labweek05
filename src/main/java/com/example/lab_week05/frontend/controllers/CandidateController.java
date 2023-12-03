package com.example.lab_week05.frontend.controllers;

import com.example.lab_week05.backend.models.Address;
import com.example.lab_week05.backend.models.Candidate;
import com.example.lab_week05.backend.repositories.AddressRepository;
import com.example.lab_week05.backend.repositories.CandidateRepository;
import com.example.lab_week05.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }


    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage= candidateService.findPagined(
                PageRequest.of(currentPage - 1, pageSize)
        );
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }


    @GetMapping("/insertCandidate") // đường dẫn trên web
    public String showFormAddCandiate(ModelMap model){
        Candidate candidate = new Candidate();
        Address address = new Address();
        model.addAttribute("candidate", candidate);
        model.addAttribute("address", address);
        return "candidates/add-candidate"; // đường dẫn của trang html trong project
    }
    @PostMapping("/insertCandidate")
    public String addCandidate(ModelMap modelMap, @ModelAttribute("candidate") Candidate candidate, @ModelAttribute("address") Address address){
        Address addressSave = addressRepository.save(address);
        candidate.setAddress(addressSave);
        candidateRepository.save(candidate);

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable long id){
        Optional<Candidate> candidate = candidateRepository.findById(id);
        candidateRepository.delete(candidate.get());
        return "redirect:/list";
    }
    @GetMapping("/update/{id}")
    public String showFormUpdateCandiate(ModelMap model, @PathVariable("id") long id){
        Optional<Candidate> candidate = candidateRepository.findById(id);
        Optional<Address> address = addressRepository.findById(candidate.get().getAddress().getId());
        model.addAttribute("candidate", candidate.get());
        model.addAttribute("address", address.get());
        return "candidates/update-candidates"; // đường dẫn của trang html trong project
    }

    @PostMapping("/update/{id}")
    public String updateCandidate(@ModelAttribute("candidate") Candidate candidate, @ModelAttribute("address") Address address){
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
        return "redirect:/list";
    }
}

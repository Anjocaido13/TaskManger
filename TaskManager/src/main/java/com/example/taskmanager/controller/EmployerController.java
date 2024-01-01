package com.example.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.taskmanager.model.Employer;
import com.example.taskmanager.repository.EmployerRepository;

@Controller
public class EmployerController {
    @Autowired
    private final EmployerRepository employerRepository;

    public EmployerController(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @GetMapping("/Employer")
    public String employer() {
        return "Employer.html";
    }

    @PostMapping("/register")
    public String registerEmployer(Employer employer, Model model) {
        if (employer.getRole() != null && employer.getName() != null && employer.getTask() != null) {
            employerRepository.save(employer);
            model.addAttribute("message", "Registered Successfully");
        }
        return "Employer.html";
    }

}

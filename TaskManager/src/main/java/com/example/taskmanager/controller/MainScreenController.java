package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.taskmanager.model.Employer;
import com.example.taskmanager.repository.EmployerRepository;
import org.springframework.ui.Model;

@Controller
public class MainScreenController {

    @Autowired
    EmployerRepository employerRepository;

    @GetMapping("Home")
    public String MainScreen(Model model) {
        List<Employer> dataList = employerRepository.findAll();
        boolean hasData = !dataList.isEmpty();
        if (hasData) {
            model.addAttribute("dataList", dataList);
        } else {
            model.addAttribute("warming", "Hmm it looks like you don't have tasks registered please register some");
        }

        return "MainScreen";

    }

}

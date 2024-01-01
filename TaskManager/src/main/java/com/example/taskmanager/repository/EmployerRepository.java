package com.example.taskmanager.repository;

import com.example.taskmanager.model.Employer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

}

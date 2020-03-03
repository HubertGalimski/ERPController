package com.example.project.components.Workers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    List<Worker> findAllByLastNameContainingIgnoreCase(String lastName);
    Optional<Worker>findByTelephoneNumber(String telephoneNumber);
    Optional<Worker>findByEmail(String email);
}

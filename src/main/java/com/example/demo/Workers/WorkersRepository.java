package com.example.demo.Workers;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

interface WorkersRepository extends JpaRepository<Worker, Long> {
    List<Worker> findAllByLastNameContainingIgnoreCase(String lastName);
    Optional<Worker>findByTelephoneNumber(String telephoneNumber);
}

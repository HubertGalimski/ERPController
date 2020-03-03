package com.example.project.components.Workers;

import com.example.project.components.Evaluations.Evaluation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, message = "Pole imię nie może być puste")
    private String firstName;
    @Size(min = 1,message = "Pole nazwisko nie może być puste")
    private String lastName;
    @Column(unique = true)
    @NotNull(message = "Pole email nie może być puste")
    @Email(message = "Podaj poprawny email")
    private String email;
    @Column(unique = true)
    @Pattern(regexp = "(\\+48)[0-9]{9}", message = "Podaj poprawny numer pamiętając o +48")
    private String telephoneNumber;
    @OneToMany(mappedBy ="worker")
    List<Evaluation> evaluations = new ArrayList<>();

}




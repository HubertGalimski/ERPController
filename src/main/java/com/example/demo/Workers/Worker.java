package com.example.demo.Workers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity(name = "workers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Size(min = 1, message = "Pole imię nie może być puste")
    protected String firstName;
    @Size(min = 1,message = "Pole nazwisko nie może być puste")
    protected String lastName;
    @Column(unique = true)
    @NotNull(message = "Pole email nie może być puste")
    @Email(message = "Podaj poprawny email")
    protected String email;
    @Column(unique = true)
    @Pattern(regexp = "(\\+48)[0-9]{9}", message = "Podaj poprawny numer pamiętając o +48")
    @NotNull(message = "Pole numer telefonu nie może być puste")
    protected String telephoneNumber;
}




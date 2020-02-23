package com.example.demo.Workers;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@Entity(name = "workers")
@AllArgsConstructor
@NoArgsConstructor
class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Column(unique = true)
    @NotNull
    @Email
    private String email;
    @Size(min = 9, max = 9)
    @Column(unique = true)
    @NotNull
    private String telephoneNumber;
}




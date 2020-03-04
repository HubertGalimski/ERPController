package com.example.project.components.Evaluations;

import com.example.project.components.Workers.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "evaluations")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    @Max(6)
    private Integer qualityOfWork;
    @Min(1)
    @Max(6)
    private Integer quantityOfWork;
    @Min(1)
    @Max(6)
    private Integer punctually;
    private Date createdAt;
    @ManyToOne
    private Worker worker;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }
}

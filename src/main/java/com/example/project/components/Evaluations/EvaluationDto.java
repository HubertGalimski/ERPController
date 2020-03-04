package com.example.project.components.Evaluations;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class EvaluationDto {

    private Long id;
    private Integer qualityOfWork;
    private Integer quantityOfWork;
    private Integer punctually;
    private Date createdAt;
    private Long workerId;
}

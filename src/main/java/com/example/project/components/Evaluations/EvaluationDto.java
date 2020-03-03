package com.example.project.components.Evaluations;

import com.example.project.components.Workers.Worker;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class EvaluationDto {

    private Long id;
    private Integer qualityOfWork;
    private Integer quantityOfWork;
    private Integer punctually;
    private Worker worker;
}

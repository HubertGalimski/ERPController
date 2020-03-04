package com.example.project.components.Evaluations;

public class EvaluationMapper {

      public static EvaluationDto toDto(Evaluation evaluation){
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setId(evaluation.getId());
        evaluationDto.setQualityOfWork(evaluation.getQualityOfWork());
        evaluationDto.setQuantityOfWork(evaluation.getQuantityOfWork());
        evaluationDto.setPunctually(evaluation.getPunctually());
        evaluationDto.setCreatedAt(evaluation.getCreatedAt());
        evaluationDto.setWorkerId(evaluation.getId());
        return evaluationDto;
    }

       static Evaluation toEntity(EvaluationDto evaluationDto){
        Evaluation evaluationEntity = new Evaluation();
        evaluationEntity.setQualityOfWork(evaluationDto.getQualityOfWork());
        evaluationEntity.setQuantityOfWork(evaluationDto.getQuantityOfWork());
        evaluationEntity.setPunctually(evaluationDto.getPunctually());
        evaluationEntity.setCreatedAt(evaluationDto.getCreatedAt());
        return evaluationEntity;
    }

}

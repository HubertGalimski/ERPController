package com.example.project.components.Evaluations;

class EvaluationMapper {

    static Evaluation toEntity(EvaluationDto evaluationDto){
        Evaluation evaluation = new Evaluation();
        evaluation.setId(evaluationDto.getId());
        evaluation.setQualityOfWork(evaluationDto.getQualityOfWork());
        evaluation.setQuantityOfWork(evaluationDto.getQuantityOfWork());
        evaluation.setPunctually(evaluationDto.getPunctually());
        return evaluation;
    }

    static EvaluationDto toDto(Evaluation evaluation){
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setId(evaluation.getId());
        evaluationDto.setQualityOfWork(evaluation.getQualityOfWork());
        evaluationDto.setQuantityOfWork(evaluation.getQuantityOfWork());
        evaluationDto.setPunctually(evaluation.getPunctually());
        return evaluationDto;
    }
}

package com.example.project.components.Evaluations;

import com.example.project.components.ExceptionsAndAdvices.WorkerNotFoundException;
import com.example.project.components.Workers.Worker;
import com.example.project.components.Workers.WorkerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvaluationService {

    private EvaluationRepository evaluationRepository;
    private WorkerRepository workerRepository;

    protected EvaluationService(EvaluationRepository evaluationRepository, WorkerRepository workerRepository) {
        this.evaluationRepository = evaluationRepository;
        this.workerRepository = workerRepository;
    }

    List<EvaluationDto> showAll() {
        return evaluationRepository.findAll().stream().map(EvaluationMapper::toDto).collect(Collectors.toList());
    }

    protected EvaluationDto save(EvaluationDto evaluationDto) {
        Evaluation evaluation = EvaluationMapper.toEntity(evaluationDto);
        Optional<Worker> worker = workerRepository.findById(evaluationDto.getWorkerId());
        evaluation.setWorker(worker.orElseThrow(WorkerNotFoundException::new));
        Evaluation savedEvaluation = evaluationRepository.save(evaluation);
        return EvaluationMapper.toDto(savedEvaluation);
    }

}

package com.example.project.components.Evaluations;

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

    List<EvaluationDto>showEvaluations(Long id){
        Optional<Worker> worker = workerRepository.findById(id);
    return worker.get().getEvaluations().stream().map(EvaluationMapper::toDto).collect(Collectors.toList());
    }

    
}

package com.example.project.components.Evaluations;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {

    List<Evaluation> findEvaluationByWorkerId(Long workerId);
}

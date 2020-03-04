package com.example.project.components.Evaluations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationRestController {

    private EvaluationService evaluationService;

    protected EvaluationRestController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("")
    private List<EvaluationDto> findAll() {
        return evaluationService.showAll();
    }

    @PostMapping("")
    private ResponseEntity<EvaluationDto> save(@RequestBody EvaluationDto evaluationDto) throws ResponseStatusException {
        if (evaluationDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zapisany obiekt nie może mieć ustwionego id");
        EvaluationDto savedEvaluation = evaluationService.save(evaluationDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEvaluation.getId()).toUri();
        return ResponseEntity.created(location).body(savedEvaluation);
    }
}

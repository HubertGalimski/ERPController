package com.example.project.components.Workers;

import com.example.project.components.Evaluations.EvaluationDto;
import com.example.project.components.Evaluations.EvaluationMapper;
import com.example.project.components.Evaluations.EvaluationRepository;
import com.example.project.components.ExceptionsAndAdvices.DuplicateEmailException;
import com.example.project.components.ExceptionsAndAdvices.DuplicateTelephoneNumberException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    private WorkerRepository workerRepository;
    private EvaluationRepository evaluationRepository;

    protected WorkerService(WorkerRepository workerRepository, EvaluationRepository evaluationRepository) {
        this.workerRepository = workerRepository;
        this.evaluationRepository = evaluationRepository;
    }

    protected Optional<WorkerDto> findById(Long id) {
        return workerRepository.findById(id).map(WorkerMapper::toDto);
    }

    protected List<WorkerDto> findAll() {
        return workerRepository.findAll()
                .stream()
                .map(WorkerMapper::toDto)
                .collect(Collectors.toList());
    }

    protected List<WorkerDto> findByLastName(String lastName) {
        return workerRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(WorkerMapper::toDto)
                .collect(Collectors.toList());
    }

    protected WorkerDto save(WorkerDto workerDto) {
        Optional<Worker> workerByTelephoneNumber = workerRepository.findByTelephoneNumber(workerDto.getTelephoneNumber());
        workerByTelephoneNumber.ifPresent(u -> {
            throw new DuplicateTelephoneNumberException();
        });
        Optional<Worker> workerByEmail = workerRepository.findByEmail(workerDto.getEmail());
        workerByEmail.ifPresent(u -> {
            throw new DuplicateEmailException();
        });
        return mapAndSaveUser(workerDto);
    }

    protected WorkerDto update(WorkerDto workerDto) {
        Optional<Worker> workerByTelephoneNumber = workerRepository.findByTelephoneNumber(workerDto.getTelephoneNumber());
        workerByTelephoneNumber.ifPresent(s -> {
            if (!s.getId().equals(workerDto.getId()))
                throw new DuplicateTelephoneNumberException();
        });

        Optional<Worker> workerByEmail = workerRepository.findByEmail(workerDto.getEmail());
        workerByEmail.ifPresent(s -> {
            if (!s.getId().equals(workerDto.getId()))
                throw new DuplicateEmailException();
        });
        return mapAndSaveUser(workerDto);
    }

    protected void delete(Long id) {
        workerRepository.deleteById(id);
    }
    List<EvaluationDto> showEvaluationsByWorker(Long id) {
        return evaluationRepository.findEvaluationByWorkerId(id).stream().map(EvaluationMapper::toDto).collect(Collectors.toList());
    }


    private WorkerDto mapAndSaveUser(WorkerDto worker) {
        Worker workerEntity = WorkerMapper.toEntity(worker);
        Worker savedWorker = workerRepository.save(workerEntity);
        return WorkerMapper.toDto(savedWorker);
    }

}

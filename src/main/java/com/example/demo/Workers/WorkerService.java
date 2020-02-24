package com.example.demo.Workers;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class WorkerService {

    private WorkerRepository workerRepository;

    protected WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
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

    private WorkerDto mapAndSaveUser(WorkerDto worker) {
        Worker workerEntity = WorkerMapper.toEntity(worker);
        Worker savedWorker = workerRepository.save(workerEntity);
        return WorkerMapper.toDto(savedWorker);
    }

}

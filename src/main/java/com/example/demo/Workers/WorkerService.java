package com.example.demo.Workers;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class WorkerService {

    private WorkersRepository workersRepository;

    protected WorkerService(WorkersRepository workersRepository) {
        this.workersRepository = workersRepository;
    }

    protected Optional<WorkerDto> findById(Long id) {
        return workersRepository.findById(id).map(WorkerMapper::toDto);
    }

    protected List<WorkerDto> findAll() {
        return workersRepository.findAll()
                .stream()
                .map(WorkerMapper::toDto)
                .collect(Collectors.toList());
    }

    protected List<WorkerDto> findByLastName(String lastName) {
        return workersRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(WorkerMapper::toDto)
                .collect(Collectors.toList());
    }

    protected WorkerDto save(WorkerDto workerDto) {
        Optional<Worker> workerByTelephoneNumber = workersRepository.findByTelephoneNumber(workerDto.getTelephoneNumber());
        workerByTelephoneNumber.ifPresent(u -> {
            throw new DuplicateTelephoneNumberException();
        });
        return mapAndSaveUser(workerDto);
    }

    protected WorkerDto update(WorkerDto workerDto) {
        Optional<Worker> workerByTelephoneNumber = workersRepository.findByTelephoneNumber(workerDto.getTelephoneNumber());
        workerByTelephoneNumber.ifPresent(s -> {
            if (!s.getId().equals(workerDto.getId()))
                throw new DuplicateTelephoneNumberException();
        });
        return mapAndSaveUser(workerDto);
    }

    protected void delete(Long id) {
        workersRepository.deleteById(id);
    }

    private WorkerDto mapAndSaveUser(WorkerDto worker) {
        Worker workerEntity = WorkerMapper.toEntity(worker);
        Worker savedWorker = workersRepository.save(workerEntity);
        return WorkerMapper.toDto(savedWorker);
    }


}

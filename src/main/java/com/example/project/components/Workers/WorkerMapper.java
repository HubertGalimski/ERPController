package com.example.project.components.Workers;

class WorkerMapper {

    static WorkerDto toDto(Worker worker) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.setId(worker.getId());
        workerDto.setFirstName(worker.getFirstName());
        workerDto.setLastName(worker.getLastName());
        workerDto.setEmail(worker.getEmail());
        workerDto.setTelephoneNumber(worker.getTelephoneNumber());
        return workerDto;
    }

    static Worker toEntity(WorkerDto workerDto) {
        Worker worker = new Worker();
        worker.setId(workerDto.getId());
        worker.setFirstName(workerDto.getFirstName());
        worker.setLastName(workerDto.getLastName());
        worker.setEmail(workerDto.getEmail());
        worker.setTelephoneNumber(workerDto.getTelephoneNumber());
        return worker;
    }
}

package com.example.demo.Workers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/workers")
class WorkerResource {

    private WorkerService workerService;


    private WorkerResource(WorkerService workerService ) {
        this.workerService = workerService;

    }

    @GetMapping(value = "",produces = {"application/hal+json"})
    private List<WorkerDto> findAll(@RequestParam(required = false) String lastName) {
        if (lastName != null)
            return workerService.findByLastName(lastName);
        return workerService.findAll();
    }



    @GetMapping("/{id}")
    private ResponseEntity<WorkerDto> findById(@PathVariable Long id) {
        return workerService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    private ResponseEntity<WorkerDto> save(@RequestBody WorkerDto workerDto) {
        if (workerDto.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zapisany obiekt nie może mieć ustwionego id");
        }
        WorkerDto savedWorker = workerService.save(workerDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedWorker.getId()).toUri();
        return ResponseEntity.created(location).body(savedWorker);
    }

    @PutMapping("/{id}")
    private ResponseEntity<WorkerDto> update(@PathVariable Long id, @RequestBody WorkerDto workerDto) {
        if (!id.equals(workerDto.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktualizowany obiekt musi mieć id zgodne z id w ścieżce zasobu");
        }
        WorkerDto updatedUser = workerService.update(workerDto);
        return ResponseEntity.ok(updatedUser);
    }

}

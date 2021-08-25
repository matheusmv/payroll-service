package com.github.matheusmv.hrworker.resources;

import com.github.matheusmv.hrworker.entities.Worker;
import com.github.matheusmv.hrworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
@AllArgsConstructor
public class WorkerResource {

    private final WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        var listOfWorkers = repository.findAll();

        return ResponseEntity.ok().body(listOfWorkers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

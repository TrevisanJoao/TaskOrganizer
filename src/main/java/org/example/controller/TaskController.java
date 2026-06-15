package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.TaskDTO;
import org.example.model.Task;
import org.example.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> criar(@RequestBody @Valid TaskDTO dto) {
        Task task = taskService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> listarTodas() {
        return ResponseEntity.ok(taskService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.searchByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizar(@PathVariable Long id, @RequestBody @Valid TaskDTO dto) {
        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> atualizarStatus(@PathVariable Long id, @RequestBody Task.Status status) {
        return ResponseEntity.ok(taskService.updateStatus(id, status));
    }
}

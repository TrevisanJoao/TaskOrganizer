package org.example.service;

import org.example.dto.TaskDTO;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setExpireDate(dto.getExpireDate());
        return taskRepository.save(task);
    }

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task searchByID(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Tarefa nao encontrada"));
    }

    public Task update(Long id, TaskDTO dto) {
        Task task = searchByID((id));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setExpireDate(dto.getExpireDate());
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        searchByID(id);
        taskRepository.deleteById(id);
    }

    public Task updateStatus(Long id, Task.Status status) {
        Task task = searchByID(id);
        task.setStatus(status);
        return taskRepository.save(task);
    }
}

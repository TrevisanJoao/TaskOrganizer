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

    public Task criar(TaskDTO dto) {
        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setStatus(dto.getStatus());
        task.setPrioridade(dto.getPrioridade());
        task.setDataVencimento(dto.getDataVencimento());
        return taskRepository.save(task);
    }

    public List<Task> listarTodas() {
        return taskRepository.findAll();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Tarefa nao encontrada"));
    }

    public Task atualizar(Long id, TaskDTO dto) {
        Task task = buscarPorId((id));
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setStatus(dto.getStatus());
        task.setPrioridade(dto.getPrioridade());
        task.setDataVencimento(dto.getDataVencimento());
        return taskRepository.save(task);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        taskRepository.deleteById(id);
    }

    public Task atualizarStatus(Long id, Task.Status status) {
        Task task = buscarPorId(id);
        task.setStatus(status);
        return taskRepository.save(task);
    }
}

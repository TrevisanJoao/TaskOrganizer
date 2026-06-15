package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;
import org.example.model.Task;

@Data
public class TaskDTO {
    private Long id;

    @NotBlank(message = "Task must have a title")
    private String title;

    private String description;

    private Task.Status status;

    private Task.Prioridade priority;

    private LocalDate expireDate;
}

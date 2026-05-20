package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;
import org.example.model.Task;

@Data
public class TaskDTO {
    private Long id;

    @NotBlank(message = "Titulo obrigatorio")
    private String titulo;

    private String descricao;

    private Task.Status status;

    private Task.Prioridade prioridade;

    private LocalDate dataVencimento;
}

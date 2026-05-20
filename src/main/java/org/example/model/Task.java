package org.example.model;

 import jakarta.persistence.*;
 import jakarta.validation.constraints.NotBlank;
 import lombok.Data;
 import java.time.LocalDate;
 import java.time.LocalDateTime;

 @Data
 @Entity
 @Table(name = "tasks")
public class Task {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @NotBlank
     private String titulo;

     private String descricao;

     @Enumerated(EnumType.STRING)
     private Status status;

     @Enumerated(EnumType.STRING)
     private Prioridade prioridade;

     private LocalDate dataVencimento;

     @Column(updatable = false)
     private LocalDateTime criadoEm;

     @PrePersist
     public void prePersist() {
         this.criadoEm = LocalDateTime.now();
     }

     public enum Status {
         PENDENTE, EM_ANDAMENTO, CONCLUIDA
     }

     public enum Prioridade {
         BAIXA, MEDIA, ALTA
     }
}

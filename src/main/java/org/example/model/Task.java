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
     private String title;

     private String description;

     @Enumerated(EnumType.STRING)
     private Status status;

     @Enumerated(EnumType.STRING)
     private Prioridade priority;

     private LocalDate expireDate;

     @Column(updatable = false)
     private LocalDateTime creationDate;

     @PrePersist
     public void prePersist() {
         this.creationDate = LocalDateTime.now();
     }

     public enum Status {
         PENDING, IN_PROGRESS, CONCLUDED
     }

     public enum Prioridade {
         LOW, MEDIUM, HIGH
     }
}

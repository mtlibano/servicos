package com.github.mtlibano.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty
    private String name;

    @Column(nullable = false, length = 11)
    @NotNull
    @CPF
    private String cpf;

    @Column(name = "date_register", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegister;

    @PrePersist
    public void prePersist() {
        setDateRegister(LocalDate.now());
    }

}
package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Curso extends Base {

    @Column(name = "nombreCurso")
    @NotNull
    private String nombreCurso;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Materia> materias;
}

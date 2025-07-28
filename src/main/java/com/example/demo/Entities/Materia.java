package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Materia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Materia extends Base {

    @Column(name = "nombreMateria")
    @NotNull
    private String nombreMateria;

    @Column(name = "añoMateria")
    @NotNull
    private int añoMateria;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "materia-alumno",
            joinColumns = @JoinColumn(name = "materia_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    private List<Alumno> alumnos;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}

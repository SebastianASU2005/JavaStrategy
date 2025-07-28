package com.example.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Entity
@Table(name = "Alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Alumno extends Base {

    @Column(name = "nombre")
    @NotNull
    public String nombre;

    @Column(name = "edad")
    @NotNull
    public int edad;

    @ManyToMany(mappedBy = "alumnos")
    private List<Materia> materias;
}
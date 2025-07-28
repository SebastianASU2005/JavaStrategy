package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Profesor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Profesor extends Base {

    @Column(name = "nombre")
    @NotNull
    public String nombre;

    @Column(name = "añosExperiencia")
    @NotNull
    public int añosExperiencia;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.MERGE)
    private List<Materia> materias;

}
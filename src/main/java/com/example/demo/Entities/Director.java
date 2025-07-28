package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "Director")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Director extends Base {

    @Column(name = "nombre")
    @NotNull
    public String nombre;

    @Column(name = "edad")
    @NotNull
    public int edad;
}

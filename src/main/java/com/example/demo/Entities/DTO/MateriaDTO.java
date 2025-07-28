package com.example.demo.Entities.DTO;

import com.example.demo.Entities.Curso;
import com.example.demo.Entities.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class MateriaDTO {
    private Long id;
    private String nombreMateria;
    private int añoMateria;
    private ProfesorDTO profesorDTO;
    private List<AlumnoDTO> alumnoDTOs;
    private CursoDTO cursoDTO;

    public static MateriaDTO fromEntity(Materia materia) {
        return new MateriaDTO(
                materia.getId(),
                materia.getNombreMateria(),
                materia.getAñoMateria(),
                materia.getProfesor() != null ? ProfesorDTO.fromEntity(materia.getProfesor()) : null,
                materia.getAlumnos() != null ? AlumnoDTO.fromEntities(materia.getAlumnos()) : new ArrayList<>(),
                materia.getCurso() != null ? CursoDTO.fromEntity(materia.getCurso()) : null);
    }

    public static List<MateriaDTO> fromEntities(List<Materia> materias) {
        List<MateriaDTO> materiaDTOS = new ArrayList<>();
        for(Materia materia: materias){
            materiaDTOS.add(fromEntity(materia));
        }
        return materiaDTOS;
    }
}

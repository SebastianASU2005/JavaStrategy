package com.example.demo.Entities.DTO;

import com.example.demo.Entities.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CursoDTO {
    private Long id;
    private String nombreCurso;

    public static CursoDTO fromEntity(Curso curso) {
        return new CursoDTO(curso.getId(), curso.getNombreCurso());
    }

    public static List<CursoDTO> fromEntities(List<Curso> cursos) {
        List<CursoDTO> cursoDTOS = new ArrayList<>();
        for(Curso curso: cursos){
            cursoDTOS.add(fromEntity(curso));
        }
        return cursoDTOS;
    }
}

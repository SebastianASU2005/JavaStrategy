package com.example.demo.Entities.DTO;

import com.example.demo.Entities.Curso;
import com.example.demo.Entities.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CursoNombreDTO {
    private Long id;
    private String nombreCurso;
    private List<MateriaNombreDTO> materiasNombreDTO;

    public static CursoNombreDTO fromEntity(Curso curso) {
        List<Materia> materias = curso.getMaterias();
        List<MateriaNombreDTO> materiasNombreDTO = materias != null ? MateriaNombreDTO.fromEntities(materias) : null;
        return new CursoNombreDTO(curso.getId(), curso.getNombreCurso(), materiasNombreDTO);
    }

    public static List<CursoNombreDTO> fromEntities(List<Curso> cursos) {
        List<CursoNombreDTO> cursoNombreDTOS = new ArrayList<>();
        for(Curso curso: cursos){
            cursoNombreDTOS.add(fromEntity(curso));
        }
        return cursoNombreDTOS;
    }
}

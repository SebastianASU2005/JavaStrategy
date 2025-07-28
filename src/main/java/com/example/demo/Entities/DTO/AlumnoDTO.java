package com.example.demo.Entities.DTO;

import com.example.demo.Entities.Alumno;
import com.example.demo.Entities.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AlumnoDTO {
    private Long id;
    private String nombre;
    private int edad;

    public static AlumnoDTO fromEntity(Alumno alumno) {
        return new AlumnoDTO(alumno.getId(), alumno.getNombre(), alumno.getEdad());
    }

    public static List<AlumnoDTO> fromEntities(List<Alumno> alumnos) {
        List<AlumnoDTO> alumnoDTOS = new ArrayList<>();
        for(Alumno alumno: alumnos){
            alumnoDTOS.add(fromEntity(alumno));
        }
        return alumnoDTOS;
    }
}

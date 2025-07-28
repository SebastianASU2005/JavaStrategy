package com.example.demo.Entities.DTO;

import com.example.demo.Entities.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AlumnoNombreDTO {
    private Long id;
    private String nombre;
    private int edad;
    private List<MateriaNombreDTO> materiasNombreDTO;

    public static AlumnoNombreDTO fromEntity(Alumno alumno) {
        return new AlumnoNombreDTO(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getEdad(),
                MateriaNombreDTO.fromEntities(alumno.getMaterias()));
    }

    public static List<AlumnoNombreDTO> fromEntities(List<Alumno> alumnos) {
        List<AlumnoNombreDTO> alumnoNombreDTOS = new ArrayList<>();
        for(Alumno alumno: alumnos){
            alumnoNombreDTOS.add(fromEntity(alumno));
        }
        return alumnoNombreDTOS;
    }
}

package com.example.demo.Entities.DTO;

import com.example.demo.Entities.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProfesorNombreDTO {
    private Long id;
    private String nombre;
    private int añosExperiencia;
    private List<MateriaNombreDTO> materiasNombreDTO;

    public static ProfesorNombreDTO fromEntity(Profesor profesor) {
        return new ProfesorNombreDTO(profesor.getId(), profesor.getNombre(), profesor.getAñosExperiencia(), MateriaNombreDTO.fromEntities(profesor.getMaterias()));
    }

    public static List<ProfesorNombreDTO> fromEntities(List<Profesor> profesors) {
        List<ProfesorNombreDTO> profesorNombreDTOS = new ArrayList<>();
        for(Profesor profesor: profesors){
            profesorNombreDTOS.add(fromEntity(profesor));
        }
        return profesorNombreDTOS;
    }
}

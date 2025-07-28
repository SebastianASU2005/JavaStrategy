package com.example.demo.Entities.DTO;

import com.example.demo.Entities.Curso;
import com.example.demo.Entities.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProfesorDTO {
    private Long id;
    private String nombre;
    private int añosExperiencia;

    public static ProfesorDTO fromEntity(Profesor profesor) {
        return new ProfesorDTO(profesor.getId(), profesor.getNombre(), profesor.getAñosExperiencia());
    }

    public static List<ProfesorDTO> fromEntities(List<Profesor> profesors) {
        List<ProfesorDTO> profesorDTOS = new ArrayList<>();
        for(Profesor profesor: profesors){
            profesorDTOS.add(fromEntity(profesor));
        }
        return profesorDTOS;
    }
}

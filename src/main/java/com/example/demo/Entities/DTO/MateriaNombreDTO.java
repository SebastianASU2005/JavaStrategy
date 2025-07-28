package com.example.demo.Entities.DTO;

import com.example.demo.Entities.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class MateriaNombreDTO {
    private Long id;
    private String nombreMateria;
    private int añoMateria;

    public static MateriaNombreDTO fromEntity(Materia materia) {
        return new MateriaNombreDTO(
                materia.getId(),
                materia.getNombreMateria(),
                materia.getAñoMateria());
    }

    public static List<MateriaNombreDTO> fromEntities(List<Materia> materias) {
        List<MateriaNombreDTO> materiaNombreDTOS = new ArrayList<>();
        for(Materia materia: materias){
            materiaNombreDTOS.add(fromEntity(materia));
        }
        return materiaNombreDTOS;
    }
}

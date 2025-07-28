package com.example.demo.Service;

import com.example.demo.Entities.Materia;
import com.example.demo.Entities.Profesor;
import com.example.demo.Repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService extends BaseService<Profesor, Long, ProfesorRepository> {

    @Autowired
    private  ProfesorRepository profesorRepository;

    @Override
    public Profesor update(Long id, Profesor updatedProfesor) throws Exception {
        Profesor profesorExistente = profesorRepository.findById(id)
                .orElseThrow(() -> new Exception("Profesor no encontrado"));

        profesorExistente.setNombre(updatedProfesor.getNombre());
        profesorExistente.setAñosExperiencia(updatedProfesor.getAñosExperiencia());
        List<Materia> materias = updatedProfesor.getMaterias();

        if (materias != null) {
            for (Materia materia : materias) {
                materia.setProfesor(profesorExistente);
            }
        }

        profesorExistente.setMaterias(materias);
        return profesorRepository.save(profesorExistente);
    }
}

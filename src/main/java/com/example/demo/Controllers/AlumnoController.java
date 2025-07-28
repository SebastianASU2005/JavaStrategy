package com.example.demo.Controllers;

import com.example.demo.Entities.Alumno;
import com.example.demo.Entities.DTO.AlumnoNombreDTO;
import com.example.demo.Entities.DTO.ProfesorNombreDTO;
import com.example.demo.Entities.Profesor;
import com.example.demo.Repositories.AlumnoRepository;
import com.example.demo.Service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/strategy/alumno")
public class AlumnoController extends BaseController<Alumno, Long, AlumnoRepository, AlumnoService> {
    public AlumnoController(AlumnoService alumnoService) {
        super(alumnoService);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AlumnoNombreDTO>> findAll() {
        try{
            List<Alumno> alumnos = service.findAll();
            return ResponseEntity.ok(AlumnoNombreDTO.fromEntities(alumnos));
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoNombreDTO> findById(@PathVariable Long id) {
        try{
            Alumno alumno = service.findById(id);
            if(alumno == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(AlumnoNombreDTO.fromEntity(alumno));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

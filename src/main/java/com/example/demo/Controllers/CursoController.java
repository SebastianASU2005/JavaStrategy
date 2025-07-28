package com.example.demo.Controllers;

import com.example.demo.Entities.Curso;
import com.example.demo.Entities.DTO.CursoNombreDTO;
import com.example.demo.Entities.DTO.ProfesorNombreDTO;
import com.example.demo.Entities.Profesor;
import com.example.demo.Repositories.CursoRepository;
import com.example.demo.Service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/strategy/curso")
public class CursoController extends BaseController<Curso, Long, CursoRepository, CursoService> {
    public CursoController(CursoService cursoService){
        super(cursoService);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CursoNombreDTO>> findAll() {
        try{
            List<Curso> cursos = service.findAll();
            return ResponseEntity.ok(CursoNombreDTO.fromEntities(cursos));
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CursoNombreDTO> findById(@PathVariable Long id) {
        try{
            Curso curso = service.findById(id);
            if(curso == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(CursoNombreDTO.fromEntity(curso));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

package com.example.demo.Controllers;

import com.example.demo.Entities.DTO.MateriaDTO;
import com.example.demo.Entities.DTO.ProfesorNombreDTO;
import com.example.demo.Entities.Materia;
import com.example.demo.Entities.Profesor;
import com.example.demo.Repositories.ProfesorRepository;
import com.example.demo.Service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/strategy/profesor")
public class ProfesorController extends BaseController<Profesor, Long, ProfesorRepository, ProfesorService> {
    public  ProfesorController (ProfesorService profesorService){
        super(profesorService);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProfesorNombreDTO>> findAll() {
        try{
            List<Profesor> profesors = service.findAll();
            return ResponseEntity.ok(ProfesorNombreDTO.fromEntities(profesors));
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorNombreDTO> findById(@PathVariable Long id) {
        try{
            Profesor profesor = service.findById(id);
            if(profesor == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(ProfesorNombreDTO.fromEntity(profesor));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

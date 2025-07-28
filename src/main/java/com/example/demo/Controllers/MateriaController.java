package com.example.demo.Controllers;

import com.example.demo.Entities.DTO.MateriaDTO;
import com.example.demo.Entities.Materia;
import com.example.demo.Repositories.MateriaRepository;
import com.example.demo.Service.MateriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/strategy/materia")
public class MateriaController extends BaseController<Materia, Long, MateriaRepository, MateriaService> {
    public MateriaController(MateriaService materiaService) {
        super(materiaService);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MateriaDTO>> findAll() {
        try{
            List<Materia> materias = service.findAll();
            return ResponseEntity.ok(MateriaDTO.fromEntities(materias));
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> findById(@PathVariable Long id) {
        try{
            Materia materia = service.findById(id);
            if(materia == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(MateriaDTO.fromEntity(materia));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

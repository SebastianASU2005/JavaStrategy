package com.example.demo.Service;

import com.example.demo.Entities.Materia;
import com.example.demo.Repositories.MateriaRepository;
import org.springframework.stereotype.Service;

@Service
public class MateriaService extends BaseService<Materia, Long, MateriaRepository> {
}

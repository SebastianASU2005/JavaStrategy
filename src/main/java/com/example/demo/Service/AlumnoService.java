package com.example.demo.Service;

import com.example.demo.Entities.Alumno;
import com.example.demo.Repositories.AlumnoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService extends BaseService<Alumno, Long, AlumnoRepository> {
}

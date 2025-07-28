package com.example.demo.Repositories;

import com.example.demo.Entities.Alumno;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends BaseRepository<Alumno, Long> {
}

package com.example.demo.Repositories;

import com.example.demo.Entities.Curso;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends BaseRepository<Curso, Long> {
}

package com.example.demo.Config;

import com.example.demo.Entities.*;
import com.example.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public void run(String... args) throws Exception {
        Profesor profesor1 = Profesor.builder()
                .nombre("Carlos")
                .añosExperiencia(10)
                .build();

        Profesor profesor2 = Profesor.builder()
                .nombre("María")
                .añosExperiencia(15)
                .build();

        Profesor profesor3 = Profesor.builder()
                .nombre("Julián")
                .añosExperiencia(8)
                .build();

        profesorRepository.saveAll(List.of(profesor1, profesor2, profesor3));

        Alumno alumno1 = Alumno.builder()
                .nombre("Pablo")
                .edad(24)
                .build();

        Alumno alumno2 = Alumno.builder()
                .nombre("Lucía")
                .edad(21)
                .build();

        Alumno alumno3 = Alumno.builder()
                .nombre("Tomás")
                .edad(22)
                .build();

        Alumno alumno4 = Alumno.builder()
                .nombre("Sofía")
                .edad(23)
                .build();

        Alumno alumno5 = Alumno.builder()
                .nombre("Mateo")
                .edad(25)
                .build();

        alumnoRepository.saveAll(List.of(alumno1, alumno2, alumno3, alumno4, alumno5));

        Materia materia1 = Materia.builder()
                .nombreMateria("Física 1")
                .añoMateria(2)
                .build();

        Materia materia2 = Materia.builder()
                .nombreMateria("Matemática Discreta")
                .añoMateria(1)
                .build();

        Materia materia3 = Materia.builder()
                .nombreMateria("Algoritmos y Estructuras de Datos")
                .añoMateria(2)
                .build();

        Materia materia4 = Materia.builder()
                .nombreMateria("Bases de Datos")
                .añoMateria(3)
                .build();

        Materia materia5 = Materia.builder()
                .nombreMateria("Sistemas Operativos")
                .añoMateria(3)
                .build();

        Materia materia6 = Materia.builder()
                .nombreMateria("Ingeniería de Software")
                .añoMateria(4)
                .build();

        Materia materia7 = Materia.builder()
                .nombreMateria("Redes de Computadoras")
                .añoMateria(4)
                .build();

        materiaRepository.saveAll(List.of(
                materia1, materia2, materia3, materia4,
                materia5, materia6, materia7
        ));

        Curso curso1 = Curso.builder()
                .nombreCurso("Aula 1")
                .build();

        Curso curso2 = Curso.builder()
                .nombreCurso("Aula 2")
                .build();

        Curso curso3 = Curso.builder()
                .nombreCurso("Laboratorio A")
                .build();

        Curso curso4 = Curso.builder()
                .nombreCurso("Aula Magna")
                .build();

        Curso curso5 = Curso.builder()
                .nombreCurso("Sala Informatica")
                .build();

        cursoRepository.saveAll(List.of(curso1, curso2, curso3, curso4, curso5));

        Director director1 = Director.builder()
                                        .nombre("Sergio")
                                        .edad(58)
                                        .build();

        directorRepository.save(director1);

        materia1.setAlumnos(List.of(alumno1, alumno2, alumno3));
        materia1.setProfesor(profesor1);
        materia1.setCurso(curso1);

        materia2.setAlumnos(List.of(alumno2, alumno4));
        materia2.setProfesor(profesor2);
        materia2.setCurso(curso2);

        materia3.setAlumnos(List.of(alumno1, alumno5));
        materia3.setProfesor(profesor3);
        materia3.setCurso(curso3);

        materia4.setAlumnos(List.of(alumno3, alumno4, alumno5));
        materia4.setProfesor(profesor1);
        materia4.setCurso(curso4);

        materia5.setAlumnos(List.of(alumno2, alumno3));
        materia5.setProfesor(profesor2);
        materia5.setCurso(curso5);

        materia6.setAlumnos(List.of(alumno1, alumno2, alumno5));
        materia6.setProfesor(profesor3);
        materia6.setCurso(curso1);

        materia7.setAlumnos(List.of(alumno1, alumno3));
        materia7.setProfesor(profesor1);
        materia7.setCurso(curso2);

        materiaRepository.saveAll(List.of(materia1, materia2, materia3, materia4, materia5, materia6, materia7));
    }
}
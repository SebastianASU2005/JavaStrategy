package com.example.demo.Strategies;

import com.example.demo.Entities.Alumno;
import com.example.demo.Entities.Curso;
import com.example.demo.Entities.Director;
import com.example.demo.Entities.Enum.TipoPersona;
import com.example.demo.Entities.Materia;
import com.example.demo.Repositories.AlumnoRepository;
import com.example.demo.Repositories.CursoRepository;
import com.example.demo.Repositories.DirectorRepository;
import com.itextpdf.text.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorStrategy implements IReport {
    private final DirectorRepository directorRepository;
    private final CursoRepository cursoRepository;
    private final AlumnoRepository alumnoRepository;

    public DirectorStrategy(DirectorRepository directorRepository, CursoRepository cursoRepository, AlumnoRepository alumnoRepository) {
        this.directorRepository = directorRepository;
        this.cursoRepository = cursoRepository;
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public TipoPersona getReportType() {
        return TipoPersona.Director;
    }

    @Override
    public void documento(Document document, Long id) throws DocumentException {
        final Director director = directorRepository.findById(id).orElseThrow();
        final List<Curso> cursoList = cursoRepository.findAll();
        final List<Alumno> alumnosList = alumnoRepository.findAll();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
        Font sectionTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.DARK_GRAY);
        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        Font italicFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 12, BaseColor.GRAY);

        Paragraph titleParagraph = new Paragraph("Reporte General", titleFont);
        titleParagraph.setSpacingAfter(20);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(titleParagraph);

        Paragraph directorInfo = new Paragraph("Información del Director", sectionTitleFont);
        directorInfo.setSpacingAfter(10);
        document.add(directorInfo);

        document.add(new Paragraph("Nombre: " + director.getNombre(), normalFont));
        document.add(new Paragraph("Edad: " + director.getEdad(), normalFont));
        document.add(new Paragraph("------------------------------------------------------", italicFont));

        for (Curso curso : cursoList) {
            Paragraph cursoHeader = new Paragraph("Curso: " + curso.getNombreCurso(), subtitleFont);
            cursoHeader.setSpacingBefore(15);
            cursoHeader.setSpacingAfter(5);
            document.add(cursoHeader);

            if (curso.getMaterias() != null && !curso.getMaterias().isEmpty()) {
                document.add(new Paragraph("Materias:", normalFont));
                for (Materia materia : curso.getMaterias()) {
                    document.add(new Paragraph("• Nombre: " + materia.getNombreMateria(), normalFont));
                    document.add(new Paragraph("  Año: " + materia.getAñoMateria(), normalFont));
                    if (materia.getProfesor() != null) {
                        document.add(new Paragraph("  Profesor: " + materia.getProfesor().getNombre(), normalFont));
                    } else {
                        document.add(new Paragraph("  Profesor: No asignado", italicFont));
                    }
                    document.add(new Paragraph("  Cantidad de alumnos: " +
                            (materia.getAlumnos() != null ? materia.getAlumnos().size() : 0), normalFont));
                    document.add(new Paragraph(""));
                }
            } else {
                document.add(new Paragraph("No hay materias asignadas a este curso.", italicFont));
            }
            document.add(new Paragraph("------------------------------------------------------", italicFont));
        }

        Paragraph alumnosTitle = new Paragraph("Listado General de Alumnos", sectionTitleFont);
        alumnosTitle.setSpacingBefore(20);
        alumnosTitle.setSpacingAfter(10);
        document.add(alumnosTitle);

        if (!alumnosList.isEmpty()) {
            for (Alumno alumno : alumnosList) {
                document.add(new Paragraph("• " + alumno.getNombre(), normalFont));
            }
        } else {
            document.add(new Paragraph("No hay alumnos registrados.", italicFont));
        }
    }
}

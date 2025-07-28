package com.example.demo.Strategies;

import com.example.demo.Entities.Alumno;
import com.example.demo.Entities.Enum.TipoPersona;
import com.example.demo.Entities.Materia;
import com.example.demo.Repositories.AlumnoRepository;
import com.itextpdf.text.*;
import org.springframework.stereotype.Service;

@Service
public class AlumnoStrategy implements IReport {
    private final AlumnoRepository alumnoRepository;

    public AlumnoStrategy(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public TipoPersona getReportType() {
        return TipoPersona.Alumno;
    }

    @Override
    public void documento(Document document, Long id) throws DocumentException {
        final Alumno alumno = alumnoRepository.findById(id).orElseThrow();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
        Font materiaFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.DARK_GRAY);
        Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

        Paragraph titleParagraph = new Paragraph("Reporte de materias", titleFont);
        titleParagraph.setSpacingAfter(20);
        document.add(titleParagraph);

        Paragraph alumnoInfo = new Paragraph(
                "Nombre: " + alumno.getNombre() + "\n" +
                        "Edad: " + alumno.getEdad(),
                subtitleFont);
        document.add(alumnoInfo);

        for (Materia materia : alumno.getMaterias()) {
            Paragraph materiaName = new Paragraph(materia.getNombreMateria(), materiaFont);
            materiaName.setSpacingBefore(10);
            document.add(materiaName);

            Paragraph añoMateria = new Paragraph("Año: " + materia.getAñoMateria(), normalFont);
            document.add(añoMateria);

            if (materia.getCurso() != null) {
                Paragraph curso = new Paragraph("Curso: " + materia.getCurso().getNombreCurso(), normalFont);
                document.add(curso);
            } else {
                Paragraph curso = new Paragraph("Curso: No asignado", normalFont);
                document.add(curso);
            }

            if (materia.getProfesor() != null) {
                Paragraph profesor = new Paragraph("Profesor: " + materia.getProfesor().getNombre(), normalFont);
                document.add(profesor);
            } else {
                Paragraph profesor = new Paragraph("Profesor: No asignado", normalFont);
                document.add(profesor);
            }
        }
    }
}

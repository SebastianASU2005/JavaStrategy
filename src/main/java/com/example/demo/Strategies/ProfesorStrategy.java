package com.example.demo.Strategies;

import com.example.demo.Entities.Alumno;
import com.example.demo.Entities.Enum.TipoPersona;
import com.example.demo.Entities.Materia;
import com.example.demo.Entities.Profesor;
import com.example.demo.Repositories.ProfesorRepository;
import com.itextpdf.text.*;
import org.springframework.stereotype.Service;

import com.itextpdf.text.*;
import java.io.IOException;

@Service
public class ProfesorStrategy implements IReport {
    private final ProfesorRepository profesorRepository;

    public ProfesorStrategy(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public TipoPersona getReportType() {
        return TipoPersona.Profesor;
    }

    @Override
    public void documento(Document document, Long id) throws DocumentException {
        final Profesor profesor = profesorRepository.findById(id).orElseThrow();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
        Font materiaFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.DARK_GRAY);
        Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

        Paragraph titleParagraph = new Paragraph("Reporte de materias", titleFont);
        titleParagraph.setSpacingAfter(20);
        document.add(titleParagraph);

        Paragraph profesorInfo = new Paragraph(
                  "Nombre: " + profesor.getNombre() + "\n" +
                        "Años de experiencia: " + profesor.getAñosExperiencia(),
                subtitleFont);
        document.add(profesorInfo);
        for (Materia materia: profesor.getMaterias()) {
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

            document.add(new Paragraph("Alumnos: ", subtitleFont));
            int number = 1;
            for(Alumno alumnos: materia.getAlumnos()) {
                if(alumnos != null){
                    Paragraph alumno = new Paragraph("   " + number + ". " + alumnos.getNombre(), normalFont);
                    document.add(alumno);
                } else {
                    Paragraph alumno = new Paragraph("Alumno: No asignado", normalFont);
                    document.add(alumno);
                }
                number++;
            }
        }
    }
}

package com.example.demo.Controllers;

import com.example.demo.Config.ReportFactory;
import com.example.demo.Entities.Enum.TipoPersona;
import com.itextpdf.text.DocumentException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class StrategyController {
    private final ReportFactory reportFactory;

    public StrategyController(ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }

    @GetMapping("/generatePdf/{id}")
    public ResponseEntity<byte[]> generarPdf (@RequestParam TipoPersona tipoPersona, @PathVariable Long id) throws DocumentException, IOException {
        byte[] pdfBytes = reportFactory.generateReport(tipoPersona, id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                        .filename("reporte_" + tipoPersona.name().toLowerCase() + "_" + id + ".pdf")
                        .build()
        );

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}

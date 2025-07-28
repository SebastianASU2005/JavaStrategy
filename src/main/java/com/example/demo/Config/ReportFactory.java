package com.example.demo.Config;

import com.example.demo.Entities.Enum.TipoPersona;
import com.example.demo.Strategies.IReport;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ReportFactory {
    private Map<TipoPersona, IReport> reportMap;

    @Autowired
    public ReportFactory(Set<IReport> types) {
        this.reportMap = new HashMap<>();
        types.forEach(type -> this.reportMap.put(type.getReportType(), type));
    }

    public byte[] generateReport(TipoPersona tipoPersona, Long id) throws DocumentException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();

        var report = this.reportMap.get(tipoPersona);
        report.documento(document, id);
        document.newPage();
        document.close();

        return outputStream.toByteArray();
    }
}

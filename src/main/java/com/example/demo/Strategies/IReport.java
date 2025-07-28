package com.example.demo.Strategies;

import com.example.demo.Entities.Enum.TipoPersona;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

public interface IReport {
    TipoPersona getReportType();

    void documento(Document document, Long id) throws DocumentException;
}

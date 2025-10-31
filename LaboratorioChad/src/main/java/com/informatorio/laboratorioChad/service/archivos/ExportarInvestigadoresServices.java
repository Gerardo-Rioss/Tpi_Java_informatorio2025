package com.informatorio.laboratorioChad.service.archivos;

import com.informatorio.laboratorioChad.dominio.Investigador;

import java.util.List;

public interface ExportarInvestigadoresServices {
    void exportarInvestigadoresCSV(List<Investigador> investigadores);
}

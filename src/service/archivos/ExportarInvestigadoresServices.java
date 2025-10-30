package service.archivos;

import dominio.Investigador;

import java.util.List;

public interface ExportarInvestigadoresServices {
    void exportarInvestigadoresCSV(List<Investigador> investigadores);
}

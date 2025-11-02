package com.informatorio.laboratorioChad.service.investigador;
import com.informatorio.laboratorioChad.dominio.Investigador;

import java.util.List;

public interface InvestigadorService {
    Investigador resgistrarInvestigador(String nombre, int edad);
    List<Investigador> obtenerTodos();
    void exportarInvestigadoresCSV();
}

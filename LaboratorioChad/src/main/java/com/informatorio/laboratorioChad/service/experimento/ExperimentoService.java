package com.informatorio.laboratorioChad.service.experimento;

import com.informatorio.laboratorioChad.dominio.Experimento;
import com.informatorio.laboratorioChad.dominio.ExperimentoFisico;
import com.informatorio.laboratorioChad.dominio.ExperimentoQuimico;
import com.informatorio.laboratorioChad.dominio.Investigador;

import java.util.List;

public interface ExperimentoService {
    void registrarExperimentoQuimico(ExperimentoQuimico experimento);
    void registrarExperimentoFisico(ExperimentoFisico experimento);
    List<Experimento>obtenerTodos();
    int getTotalExitosos();
    int getTotalFallidos();
    Experimento getExperimentoMayorDuracion();
    double getPromedioDuracion();
    double getPorcentajeExito();
    Investigador getInvestigadorConMasExperimentos();
    List<Investigador> getListaDeInvestigadores();
}

package com.informatorio.laboratorioChad.service.experimento;

import com.informatorio.laboratorioChad.dominio.Experimento;
import com.informatorio.laboratorioChad.dominio.ExperimentoFisico;
import com.informatorio.laboratorioChad.dominio.ExperimentoQuimico;
import com.informatorio.laboratorioChad.dominio.Investigador;

import java.util.List;

public interface ExperimentoService {
    ExperimentoQuimico registrarExperimentoQuimico(String nombre,int duracion,boolean resultado,String reactivo,Investigador investigador);
    ExperimentoFisico registrarExperimentoFisico(String nombre,int duracion,boolean resultado,String instrumento, List<Investigador> seleccionados);
    List<Experimento> obtenerTodos();
    int getTotalExitosos();
    int getTotalFallidos();
    Experimento getExperimentoMayorDuracion();
    double getPromedioDuracion();
    double getPorcentajeExito();
    Investigador getInvestigadorConMasExperimentos();
    List<Investigador> getListaDeInvestigadores();
}

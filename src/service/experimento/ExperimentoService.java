package service.experimento;

import dominio.Experimento;
import dominio.ExperimentoFisico;
import dominio.ExperimentoQuimico;
import dominio.Investigador;

import java.util.List;
import java.util.Map;

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

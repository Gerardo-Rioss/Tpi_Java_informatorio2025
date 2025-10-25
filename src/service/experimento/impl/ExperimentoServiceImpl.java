package service.experimento.impl;

import dominio.Experimento;
import dominio.ExperimentoFisico;
import dominio.ExperimentoQuimico;
import dominio.Investigador;
import service.experimento.ExperimentoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExperimentoServiceImpl implements ExperimentoService {
    private List<Experimento> experimentos = new ArrayList<>();

    @Override
    public void registrarExperimentoQuimico(ExperimentoQuimico experimento) {
        experimentos.add(experimento);
    }

    @Override
    public void registrarExperimentoFisico(ExperimentoFisico experimento) {
        experimentos.add(experimento);
    }

    @Override
    public List<Experimento> obtenerTodos() {
        return experimentos;
    }

    @Override
    public int getTotalExitosos() {
        int contador = 0;
        for(Experimento exp: experimentos){
            if(exp.getResultado()){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int getTotalFallidos() {
        int contador=0;
        for(Experimento exp: experimentos){
            if(exp.getResultado()==false){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public Experimento getExperimentoMayorDuracion() {
        if(experimentos.isEmpty()){
            return null;
        }
        Experimento mayor = experimentos.getFirst();
        for(Experimento exp: experimentos){
            if(exp.getDuracion()>mayor.getDuracion()){
                mayor= exp;
            }
        }
        return mayor;
    }

    @Override
    public double getPromedioDuracion() {
        if(experimentos.isEmpty()){
            return 0;
        }
        int total=0;
        for(Experimento exp: experimentos){
            total+=exp.getDuracion();
        }
        return (double) total/experimentos.size();
    }

    @Override
    public double getPorcentajeExito() {
        if(experimentos.isEmpty()){
            return 0;
        }
        return (getPorcentajeExito()*100.0)/experimentos.size();
    }

    @Override
    public Investigador getInvestigadorConMasExperimentos() {
        return null;
    }

    @Override
    public Map<Investigador, Integer> getContadorExperimentosPorInvestigador() {
        return Map.of();
    }
}

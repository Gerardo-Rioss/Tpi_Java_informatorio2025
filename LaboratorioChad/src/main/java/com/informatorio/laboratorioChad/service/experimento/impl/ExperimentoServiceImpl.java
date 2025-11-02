package com.informatorio.laboratorioChad.service.experimento.impl;

import com.informatorio.laboratorioChad.dominio.Experimento;
import com.informatorio.laboratorioChad.dominio.ExperimentoFisico;
import com.informatorio.laboratorioChad.dominio.ExperimentoQuimico;
import com.informatorio.laboratorioChad.dominio.Investigador;
import com.informatorio.laboratorioChad.repository.experimento.ExperimentoRepository;
import com.informatorio.laboratorioChad.repository.investigador.InvestigadorRepository;
import com.informatorio.laboratorioChad.service.experimento.ExperimentoService;
import com.informatorio.laboratorioChad.service.utils.Imput;
import com.informatorio.laboratorioChad.service.utils.Validar;

import java.util.ArrayList;
import java.util.List;

public class ExperimentoServiceImpl implements ExperimentoService {
    private ExperimentoRepository experimentoRepository;

    public ExperimentoServiceImpl(ExperimentoRepository experimentoRepository ) {
        this.experimentoRepository = experimentoRepository;
    }

        @Override
    public ExperimentoQuimico registrarExperimentoQuimico(String nombre,int duracion,boolean resultado,String reactivo,Investigador investigador) {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del experimento no puede estar vacío.");
            }
            if (duracion <= 0) {
                throw new IllegalArgumentException("La duración debe ser mayor a 0 minutos.");
            }
            if (reactivo == null || reactivo.trim().isEmpty()) {
                throw new IllegalArgumentException("El reactivo no puede estar vacío.");
            }
            if (reactivo.trim().length() < 2) {
                throw new IllegalArgumentException("El reactivo debe tener al menos 2 caracteres.");
            }
        ExperimentoQuimico eq = new ExperimentoQuimico(nombre,duracion,resultado,reactivo,investigador);
        experimentoRepository.guardar(eq);
        return eq;
    }

    @Override
    public ExperimentoFisico registrarExperimentoFisico(String nombre, int duracion, boolean resultado, String instrumento, List<Investigador> seleccionados) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (duracion <= 0)
            throw new IllegalArgumentException("La duración debe ser mayor a 0.");
        if (instrumento == null || instrumento.trim().isEmpty())
            throw new IllegalArgumentException("El instrumento no puede estar vacío.");
        if (seleccionados == null)
            throw new IllegalArgumentException("La lista de investigadores no puede ser nula.");
        if (seleccionados.isEmpty())
            throw new IllegalArgumentException("Debe haber al menos un investigador.");
        ExperimentoFisico ef = new ExperimentoFisico(nombre,duracion,resultado,instrumento,seleccionados);
        experimentoRepository.guardar(ef);
        return ef;
    }

    @Override
    public List<Experimento> obtenerTodos() {
        return experimentoRepository.obtenerTodos();
    }

    @Override
    public int getTotalExitosos() {
        int contador = 0;
        for(Experimento exp: experimentoRepository.obtenerTodos()){
            if(exp.getResultado()){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int getTotalFallidos() {
        int contador=0;
        for(Experimento exp: experimentoRepository.obtenerTodos()){
            if(exp.getResultado()==false){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public Experimento getExperimentoMayorDuracion() {
        if(experimentoRepository.obtenerTodos().isEmpty()){
            return null;
        }
        Experimento mayor = experimentoRepository.obtenerTodos().get(0);
        for(Experimento exp: experimentoRepository.obtenerTodos()){
            if(exp.getDuracion()>mayor.getDuracion()){
                mayor= exp;
            }
        }
        return mayor;
    }

    @Override
    public double getPromedioDuracion() {
        if(experimentoRepository.obtenerTodos().isEmpty()){
            return 0.00;
        }
        int total=0;
        for(Experimento exp: experimentoRepository.obtenerTodos()){
            total+=exp.getDuracion();
        }
        double promedio= (double) total/experimentoRepository.obtenerTodos().size();
        return Math.round(promedio*100.0)/100.0;
    }

    @Override
    public double getPorcentajeExito() {
        if(experimentoRepository.obtenerTodos().isEmpty()){
            return 0.00;
        }
        double porcentaje =(getTotalExitosos()*100.0)/experimentoRepository.obtenerTodos().size();
        return Math.round(porcentaje*100.0)/100.0;
    }

    @Override
    public Investigador getInvestigadorConMasExperimentos() {
        List<Investigador> todos = getListaDeInvestigadores();
        if(todos.isEmpty()){
            return null;
        }
        Investigador masFrecuente = null;
        int maxContador = 0;
        // Recorremos la lista para ver cuál investigador aparece más veces
        for (int i =0; i<todos.size();i++){
            Investigador actual = todos.get(i);
            int contador=0;
            //Contamos cuantas veces aparece el investigador
            for(int j=0;j<todos.size();j++){
                if(todos.get(j).equals(actual)){
                    contador++;
                }
            }
            // Si este tiene más apariciones que el máximo actual, lo actualizamos
            if (contador>maxContador){
                maxContador= contador;
                masFrecuente=actual;
            }
        }
        return masFrecuente;
    }

    private List<Investigador> getListaDeInvestigadores(){
        List<Investigador> lista = new ArrayList<>();
        for(Experimento exp:experimentoRepository.obtenerTodos()){
            if(exp instanceof ExperimentoQuimico ){
                ExperimentoQuimico eq = (ExperimentoQuimico) exp;
                lista.add(eq.getInvestigador());
            } else if (exp instanceof ExperimentoFisico) {
                ExperimentoFisico ef = (ExperimentoFisico) exp;
                lista.addAll(ef.getInvestigadores());
            }
        }
        return lista;
    }


}

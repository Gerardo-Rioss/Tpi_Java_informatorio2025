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
    //private List<Experimento> experimentos = new ArrayList<>();
    private ExperimentoRepository experimentoRepository;
    private InvestigadorRepository investigadorRepository;

    public ExperimentoServiceImpl(ExperimentoRepository experimentoRepository, InvestigadorRepository investigadorRepository) {
        this.experimentoRepository = experimentoRepository;
        this.investigadorRepository = investigadorRepository;
    }

    //    @Override
//    public void registrarExperimentoQuimico(ExperimentoQuimico experimento) {
//        experimentos.add(experimento);
//    }

//    @Override
//    public void registrarExperimentoFisico(ExperimentoFisico experimento) {
//        experimentos.add(experimento);
//    }

    @Override
    public void registrarExperimento() {
        System.out.println("Seleccione tipo de experimento: ");
        System.out.println("1. Químico");
        System.out.println("2. Físico");

        int tipo = Imput.leerEnteroConRango("Opcion: ",1,2);
        String nombre;
        do {
            nombre = Imput.leerCadena("Nombre del experimento: ");
            try{
                Validar.validadNoVacio(nombre,"nombre del experimento");
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while (true);

        int duracion;
        do {
            duracion = Imput.leerEntero("Duración (minutos): ");
            try{
                Validar.validarPositivo(duracion,"duración");
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while (true);

        boolean resultado = Imput.leerBooleano("Resultado (éxito)");
        if (tipo==1){
            registrarExperimentoQuimico(nombre,duracion,resultado);
        }else {
            registrarExperimentoFisico(nombre, duracion, resultado);
        }
    }

    private void registrarExperimentoQuimico(String nombre, int duracion, boolean resultado){
        String reactivo;
        do {
            reactivo = Imput.leerCadena("Tipo de reactivo: ");
            try{
                Validar.validadNoVacio(reactivo,"reactivo");
                break;
            } catch(IllegalArgumentException e){
                System.out.println("Error: "+ e.getMessage());
            }
        }while (true);

        List<Investigador> investigadores = investigadorRepository.obtenerTodos();
        if(investigadores.isEmpty()){
            System.out.println("No hay investigadores registrados. Debe registrar al menos uno.");
            return;
        }
        Investigador investigador= Imput.seleccionarDeLista("Seleccione Investigador: ",investigadores);

        ExperimentoQuimico eq = new ExperimentoQuimico(nombre, duracion,resultado,reactivo,investigador);
        experimentoRepository.guardar(eq);
        System.out.println("Experimento químico registrado con éxito.");
    }

    private void registrarExperimentoFisico(String nombre, int duracion, boolean resultado){
        String instrumento;
        do {
            instrumento = Imput.leerCadena("Instrumento utilizado: ");
            try{
                Validar.validadNoVacio(instrumento,"instrumento");
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+ e.getMessage());
            }
        }while (true);

        List<Investigador>investigadores = investigadorRepository.obtenerTodos();
        if (investigadores.isEmpty()){
            System.out.println("No hay investigadores registrados. Debe registrar al menos uno.");
            return;
        }

        List<Investigador> seleccionados= new ArrayList<>();
        while (true){
            try{
                Investigador inv = Imput.seleccionarDeLista("Seleccione un investigador (0 para terminar): ",investigadores);
                seleccionados.add(inv);
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+ e.getMessage());
                break;
            }
            System.out.println("¿Desea agregar otro investigador? (1: Si , 2: No): ");
            if (!Imput.leerBooleano("")){
                break;
            }
        }

        if(seleccionados.isEmpty()){
            System.out.println("No se seleccionaron investigadores. Operación cancelada.");
            return;
        }

        ExperimentoFisico ef = new ExperimentoFisico(nombre, duracion,resultado,instrumento, seleccionados);
        experimentoRepository.guardar(ef);
        System.out.println("Experimento físico registrado con éxito.");
    }

//    @Override
//    public int getTotalExitosos() {
//        int contador = 0;
//        for(Experimento exp: experimentos){
//            if(exp.getResultado()){
//                contador++;
//            }
//        }
//        return contador;
//    }
//
//    @Override
//    public int getTotalFallidos() {
//        int contador=0;
//        for(Experimento exp: experimentos){
//            if(exp.getResultado()==false){
//                contador++;
//            }
//        }
//        return contador;
//    }
//
//    @Override
//    public Experimento getExperimentoMayorDuracion() {
//        if(experimentos.isEmpty()){
//            return null;
//        }
//        Experimento mayor = experimentos.get(0);
//        for(Experimento exp: experimentos){
//            if(exp.getDuracion()>mayor.getDuracion()){
//                mayor= exp;
//            }
//        }
//        return mayor;
//    }
//
//    @Override
//    public double getPromedioDuracion() {
//        if(experimentos.isEmpty()){
//            return 0;
//        }
//        int total=0;
//        for(Experimento exp: experimentos){
//            total+=exp.getDuracion();
//        }
//        return (double) total/experimentos.size();
//    }
//
//    @Override
//    public double getPorcentajeExito() {
//        if(experimentos.isEmpty()){
//            return 0;
//        }
//        return (getTotalExitosos()*100.0)/experimentos.size();
//    }
//
//    @Override
//    public Investigador getInvestigadorConMasExperimentos() {
//        List<Investigador> todos = getListaDeInvestigadores();
//        if(todos.isEmpty()){
//            return null;
//        }
//        Investigador masFrecuente = null;
//        int maxContador = 0;
//        // Recorremos la lista para ver cuál investigador aparece más veces
//        for (int i =0; i<todos.size();i++){
//            Investigador actual = todos.get(i);
//            int contador=0;
//            //Contamos cuantas veces aparece el investigador
//            for(int j=0;j<todos.size();j++){
//                if(todos.get(j).equals(actual)){
//                    contador++;
//                }
//            }
//            // Si este tiene más apariciones que el máximo actual, lo actualizamos
//            if (contador>maxContador){
//                maxContador= contador;
//                masFrecuente=actual;
//            }
//        }
//        return masFrecuente;
//    }
//
//    @Override
//    public List<Investigador> getListaDeInvestigadores(){
//        List<Investigador> lista = new ArrayList<>();
//        for(Experimento exp:experimentos){
//            if(exp instanceof ExperimentoQuimico ){
//                ExperimentoQuimico eq = (ExperimentoQuimico) exp;
//                lista.add(eq.getInvestigador());
//            } else if (exp instanceof ExperimentoFisico) {
//                ExperimentoFisico ef = (ExperimentoFisico) exp;
//                lista.addAll(ef.getInvestigadores());
//            }
//        }
//        return lista;
//    }


}

package com.informatorio.laboratorioChad.service.ui.impl;

import com.informatorio.laboratorioChad.dominio.Experimento;
import com.informatorio.laboratorioChad.dominio.ExperimentoFisico;
import com.informatorio.laboratorioChad.dominio.ExperimentoQuimico;
import com.informatorio.laboratorioChad.dominio.Investigador;
import com.informatorio.laboratorioChad.service.experimento.ExperimentoService;
import com.informatorio.laboratorioChad.service.investigador.InvestigadorService;
import com.informatorio.laboratorioChad.service.ui.UiServices;
import com.informatorio.laboratorioChad.service.utils.Imput;

import java.util.ArrayList;
import java.util.List;

public class UiServicesImpl implements UiServices {
    private InvestigadorService investigadorService;
    private ExperimentoService experimentoService;

    public UiServicesImpl(InvestigadorService investigadorService, ExperimentoService experimentoService) {
        this.investigadorService = investigadorService;
        this.experimentoService= experimentoService;
    }

    @Override
    public void registrarInvestigador() {
        System.out.println("\n--- REGISTRAR INVESTIGADOR ---");
        String nombre = Imput.leerCadena("Ingrese nombre del investigador: ","nombre");;
        //int edad =  Imput.leerEntero("Ingrese edad del investigador: ");
        int edad = Imput.leerEnteroConRango("Ingrese la edad del investigador: ",18,70);
        Investigador investigador= investigadorService.resgistrarInvestigador(nombre,edad);
        System.out.println(investigador.toString());
        System.out.println("Registrado con éxito.");
    }

    @Override
    public void registrarExperimento() {
        System.out.println("Seleccione tipo de experimento: ");
        System.out.println("1. Químico");
        System.out.println("2. Físico");
        int tipo = Imput.leerEnteroConRango("Opcion: ",1,2);
        String nombre= Imput.leerCadena("Nombre del experimento: ","nombre del experimento");;
        int duracion = Imput.leerEntero("Duración (minutos): ");;
        boolean resultado = Imput.leerBooleano("Resultado (éxito)");
        if (tipo==1){
            registrarExperimentoQuimico(nombre,duracion,resultado);
        }else {
            registrarExperimentoFisico(nombre,duracion,resultado);
        }
    }

    @Override
    public void mostrarListadoExperimentos() {
        System.out.println("\n--- LISTADO DE EXPERIMENTOS ---");
        List<Experimento> experimentos = experimentoService.obtenerTodos();
        if (experimentos.isEmpty()){
            System.out.println("No hay experimentos registrados.");
            return;
        }
        for(Experimento exp : experimentos){
            System.out.println(exp);
        }
    }

    @Override
    public void mostrarTotales() {
        System.out.println("\n--- TOTALES DE EXPERIMENTOS ---");
        int exitosos = experimentoService.getTotalExitosos();
        int fallidos = experimentoService.getTotalFallidos();

        System.out.println("Experimentos exitosos: " + exitosos);
        System.out.println("Experimentos fallidos: " + fallidos);
        System.out.println("Total de experimentos: " + (exitosos + fallidos));
    }

    @Override
    public void mostrarExperimentoMayorDuracion() {
        System.out.println("\n--- EXPERIMENTO DE MAYOR DURACIÓN ---");
        Experimento experimento = experimentoService.getExperimentoMayorDuracion();

        if (experimento == null){
            System.out.println("No hay experimentos registrados.");
        }else {
            System.out.println("Experimento de mayor duración: "+experimento.getNombre()+" con "+experimento.getDuracion()+" minutos.");
        }
    }

    @Override
    public void generarReporte() {
        System.out.println("\n--- REPORTE DE ESTADÍSTICAS ---");
        double promedio = experimentoService.getPromedioDuracion();
        double porcentajeExitoso = experimentoService.getPorcentajeExito();

        System.out.println("Promedio de duración: "+promedio+" minutos.");
    }

    private void registrarExperimentoQuimico(String nombre, int duracion, boolean resultado){
        String reactivo = Imput.leerCadena("Tipo de reactivo: ","reactivo") ;
        List<Investigador> investigadores = investigadorService.obtenerTodos();
        if(investigadores.isEmpty()){
            System.out.println("No hay investigadores registrados. Debe registrar al menos uno.");
            return;
        }
        Investigador investigador= Imput.seleccionarDeLista("Seleccione Investigador: ",investigadores);

        ExperimentoQuimico eq=experimentoService.registrarExperimentoQuimico(nombre,duracion,resultado,reactivo,investigador);
        System.out.println(eq.toString());
        System.out.println("Experimento químico registrado con éxito.");
    }

    private void registrarExperimentoFisico(String nombre, int duracion, boolean resultado){

        //---leer instrumento
        String instrumento = Imput.leerCadena("Instrumento utilizado: ","instrumento");

        //---verificar si hay investigadores registrados
        List<Investigador>investigadores = investigadorService.obtenerTodos();
        if (investigadores.isEmpty()){
            System.out.println("No hay investigadores registrados. Debe registrar al menos uno.");
            return;
        }

        //---Seleccionar investigadores
        List<Investigador> seleccionados= new ArrayList<>();
        while (true){
            try{
                Investigador inv = Imput.seleccionarDeLista("Seleccione un investigador (0 para terminar): ",investigadores);
                if (inv==null){
                    break;
                }
                seleccionados.add(inv);
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+ e.getMessage());
            }
            System.out.println("¿Desea agregar otro investigador? (1: Si , 2: No): ");
            if (!Imput.leerBooleano("")){
                break;
            }
        }

        //---validad seleccion
        if(seleccionados.isEmpty()){
            System.out.println("No se seleccionaron investigadores. Operación cancelada.");
            return;
        }

        //---registrar experimento
        ExperimentoFisico ef = experimentoService.registrarExperimentoFisico(nombre,duracion,resultado,instrumento,seleccionados);
        System.out.println(ef.toString());
        System.out.println("Experimento físico registrado con éxito.");
    }

    @Override
    public void mostrarInvestigadorConMasExperimentos() {

    }
}

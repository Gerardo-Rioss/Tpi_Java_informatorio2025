package com.informatorio.laboratorioChad.service.menu.impl;

import com.informatorio.laboratorioChad.dominio.Experimento;
import com.informatorio.laboratorioChad.dominio.ExperimentoFisico;
import com.informatorio.laboratorioChad.dominio.ExperimentoQuimico;
import com.informatorio.laboratorioChad.dominio.Investigador;
import com.informatorio.laboratorioChad.service.experimento.ExperimentoService;
import com.informatorio.laboratorioChad.service.investigador.InvestigadorService;
import com.informatorio.laboratorioChad.service.menu.MenuService;
import com.informatorio.laboratorioChad.service.utils.Imput;
import com.informatorio.laboratorioChad.service.utils.Validar;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    private  InvestigadorService investigadorService;
    private  ExperimentoService experimentoService;

    public MenuServiceImpl(InvestigadorService investigadorService, ExperimentoService experimentoService) {
        this.investigadorService = investigadorService;
        this.experimentoService = experimentoService;

    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA GESTOR DE EXPERIMENTOS - LABORATORIO CHAD ===");
        System.out.println("1. Registrar investigador");
        System.out.println("2. Registrar experimento");
        System.out.println("3. Mostrar listado de experimentos");
        System.out.println("4. Mostrar totales de experimentos (exitosos y fallidos)");
        System.out.println("5. Mostrar experimento de mayor duración");
        System.out.println("6. Generar reporte (promedio duración y porcentaje éxito)");
        System.out.println("7. Mostrar investigador con más experimentos");
        System.out.println("8. Exportar investigadores a CSV");
        System.out.println("9. Salir");
    }

    @Override
    public void procesarOpcion(int opcion) {
        switch (opcion){
            case 1:
                uiRegistrarInvestigador();
                break;
            case 2:
                uiRegistrarExperimento();
                break;
            case 3:
                uiMostrarListadoExperimentos();
                break;
            case 4:
                uiMostrarTotales();
                break;
            case 5:
                //mostrarExperimentoMayorDuracion();
                break;
            case 6:
                //generarReporte();
                break;
            case 7:
                //mostrarInvestigadorConMasExperimentos();
                break;
            case 9:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    private void uiRegistrarInvestigador(){
        System.out.println("\n--- REGISTRAR INVESTIGADOR ---");
        String nombre = Imput.leerCadena("Ingrese nombre del investigador: ","nombre");;
        //int edad =  Imput.leerEntero("Ingrese edad del investigador: ");
        int edad = Imput.leerEnteroConRango("Ingrese la edad del investigador: ",18,70);
        Investigador investigador= investigadorService.resgistrarInvestigador(nombre,edad);
        System.out.println(investigador.toString());
        System.out.println("Registrado con éxito.");
    }

    private void uiRegistrarExperimento(){
        System.out.println("Seleccione tipo de experimento: ");
        System.out.println("1. Químico");
        System.out.println("2. Físico");
        int tipo = Imput.leerEnteroConRango("Opcion: ",1,2);
        String nombre= Imput.leerCadena("Nombre del experimento: ","nombre del experimento");;
        int duracion = Imput.leerEntero("Duración (minutos): ");;
        boolean resultado = Imput.leerBooleano("Resultado (éxito)");
        if (tipo==1){
            uiRegistrarExperimentoQuimico(nombre,duracion,resultado);
        }else {
            uiRegistrarExperimentoFisico(nombre,duracion,resultado);
        }
    }

    private void uiRegistrarExperimentoQuimico(String nombre, int duracion, boolean resultado){
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

    private void uiRegistrarExperimentoFisico(String nombre, int duracion, boolean resultado){

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

    private void uiMostrarListadoExperimentos(){
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

    private void uiMostrarTotales(){
        System.out.println("\n--- TOTALES DE EXPERIMENTOS ---");
        int exitosos = experimentoService.getTotalExitosos();
        int fallidos = experimentoService.getTotalFallidos();

        System.out.println("Experimentos exitosos: " + exitosos);
        System.out.println("Experimentos fallidos: " + fallidos);
        System.out.println("Total de experimentos: " + (exitosos + fallidos));
    }

//    private void mostrarExperimentoMayorDuracion(){
//        System.out.println("\n--- EXPERIMENTO DE MAYOR DURACIÓN ---");
//        Experimento experimento = experimentoService.getExperimentoMayorDuracion();
//
//        if (experimento == null){
//            System.out.println("No hay experimentos registrados.");
//        }else {
//            System.out.println("Experimento de mayor duración: "+experimento.getNombre()+" con "+experimento.getDuracion()+" minutos.");
//        }
//    }
//
//    private void generarReporte(){
//        System.out.println("\n--- REPORTE DE ESTADÍSTICAS ---");
//        double promedio = experimentoService.getPromedioDuracion();
//        double porcentajeExitoso = experimentoService.getPorcentajeExito();
//
//        System.out.println("Promedio de duración: "+promedio+" minutos.");
//        System.out.println("Porcentaje de éxito: "+porcentajeExitoso+"%");
//    }
//
//    private void mostrarInvestigadorConMasExperimentos(){
//        System.out.println("\n--- INVESTIGADOR CON MÁS EXPERIMENTOS ---");
//        Investigador investigador = experimentoService.getInvestigadorConMasExperimentos();
//        if (investigador==null){
//            System.out.println("No hay investigadores con experimentos registrados.");
//        }else{
//            System.out.println("Investigador con más experimentos: "+ investigador.getNombre()+ " (Edad: "+investigador.getEdad()+")");
//        }
//    }


}

package service.menu.impl;

import dominio.Experimento;
import dominio.ExperimentoFisico;
import dominio.ExperimentoQuimico;
import dominio.Investigador;
import service.experimento.ExperimentoService;
import service.investigador.InvestigadorService;
import service.menu.MenuService;
import service.utils.Imput;
import service.utils.Validar;

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
                registrarInvestigador();
                break;
            case 2:
                registrarExperimento();
                break;
            case 3:
                mostrarListadoExperimentos();
                break;
            case 9:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    private void registrarInvestigador(){
        System.out.println("\n--- REGISTRAR INVESTIGADOR ---");
        String nombre;
        do{
            nombre = Imput.leerCadena("Ingrese nombre del investigador: ");
            try{
                Validar.validadNoVacio(nombre,"nombre");
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while (true);

        int edad;
        do {
            edad= Imput.leerEntero("Ingrese edad del investigador: ");
            try{
                Validar.validarPositivo(edad,"edad");
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Error "+ e.getMessage());
            }
        }while (true);
        Investigador investigador = new Investigador(nombre,edad);
        investigadorService.resgistrarInvestigador(investigador);
        System.out.println("Investigador registrado con éxito.");
    }

    private void registrarExperimento(){
        System.out.println("Seleccione tipo de experimento: ");
        System.out.println("1. Químico");
        System.out.println("1. Físico");
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
            registrarExperimentoFisico(nombre,duracion,resultado);
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

        List<Investigador> investigadores = investigadorService.obtenerTodos();
        if(investigadores.isEmpty()){
            System.out.println("No hay investigadores registrados. Debe registrar al menos uno.");
            return;
        }
        Investigador investigador= Imput.seleccionarDeLista("Seleccione Investigador: ",investigadores);

        ExperimentoQuimico eq = new ExperimentoQuimico(nombre, duracion,resultado,reactivo,investigador);
        experimentoService.registrarExperimentoQuimico(eq);
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

        List<Investigador>investigadores = investigadorService.obtenerTodos();
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
        experimentoService.registrarExperimentoFisico(ef);
        System.out.println("Experimento físico registrado con éxito.");
    }

    private void mostrarListadoExperimentos(){
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


}

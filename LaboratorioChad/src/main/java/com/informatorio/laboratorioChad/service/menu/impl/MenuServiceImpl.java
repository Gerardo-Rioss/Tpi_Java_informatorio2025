package com.informatorio.laboratorioChad.service.menu.impl;
import com.informatorio.laboratorioChad.service.experimento.ExperimentoService;
import com.informatorio.laboratorioChad.service.investigador.InvestigadorService;
import com.informatorio.laboratorioChad.service.menu.MenuService;
import com.informatorio.laboratorioChad.service.ui.UiServices;

public class MenuServiceImpl implements MenuService {
    private  InvestigadorService investigadorService;
    private  ExperimentoService experimentoService;
    private UiServices uiServices;

    public MenuServiceImpl(InvestigadorService investigadorService, ExperimentoService experimentoService,UiServices uiServices) {
        this.investigadorService = investigadorService;
        this.experimentoService = experimentoService;
        this.uiServices = uiServices;
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
                uiServices.registrarInvestigador();
                break;
            case 2:
                uiServices.registrarExperimento();
                break;
            case 3:
                uiServices.mostrarListadoExperimentos();
                break;
            case 4:
                uiServices.mostrarTotales();
                break;
            case 5:
                uiServices.mostrarExperimentoMayorDuracion();
                break;
            case 6:
                uiServices.generarReporte();
                break;
            case 7:
                uiServices.mostrarInvestigadorConMasExperimentos();
                break;
            case 8:
                uiServices.exportarInvestigadoresCSV();
                break;
            case 9:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
}

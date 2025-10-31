package com.informatorio.laboratorioChad;

import com.informatorio.laboratorioChad.service.experimento.ExperimentoService;
import com.informatorio.laboratorioChad.service.experimento.impl.ExperimentoServiceImpl;
import com.informatorio.laboratorioChad.service.investigador.InvestigadorService;
import com.informatorio.laboratorioChad.service.investigador.impl.InvestigadorServiceImpl;
import com.informatorio.laboratorioChad.service.menu.MenuService;
import com.informatorio.laboratorioChad.service.menu.impl.MenuServiceImpl;
import com.informatorio.laboratorioChad.service.utils.Imput;

public class App
{
    public static void main( String[] args )
    {
        InvestigadorService investigadorService = new InvestigadorServiceImpl() ;
        ExperimentoService experimentoService = new ExperimentoServiceImpl();
        MenuService menuService= new MenuServiceImpl(investigadorService, experimentoService);

        int opcion;
        do{
            menuService.mostrarMenu();
            opcion= Imput.leerEnteroConRango("Seleccione una opción: ",1,9);
            menuService.procesarOpcion(opcion);
        }while (opcion!=9);


    }
}

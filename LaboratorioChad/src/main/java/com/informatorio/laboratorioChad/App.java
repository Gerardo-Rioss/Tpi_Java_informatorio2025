package com.informatorio.laboratorioChad;

import com.informatorio.laboratorioChad.repository.experimento.ExperimentoRepository;
import com.informatorio.laboratorioChad.repository.experimento.impl.ExperimentoRepositoryImpl;
import com.informatorio.laboratorioChad.repository.investigador.InvestigadorRepository;
import com.informatorio.laboratorioChad.repository.investigador.impl.InvestigadorRepositoryImpl;
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
        InvestigadorRepository investigadorRepository = new InvestigadorRepositoryImpl();
        ExperimentoRepository experimentoRepository = new ExperimentoRepositoryImpl();
        InvestigadorService investigadorService = new InvestigadorServiceImpl(investigadorRepository) ;
        ExperimentoService experimentoService = new ExperimentoServiceImpl(experimentoRepository);
        MenuService menuService= new MenuServiceImpl(investigadorService, experimentoService);

        int opcion;
        do{
            menuService.mostrarMenu();
            opcion= Imput.leerEnteroConRango("Seleccione una opción: ",1,9);
            menuService.procesarOpcion(opcion);
        }while (opcion!=9);


    }
}

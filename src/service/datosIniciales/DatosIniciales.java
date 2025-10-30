package service.datosIniciales;

import dominio.ExperimentoFisico;
import dominio.ExperimentoQuimico;
import dominio.Investigador;
import service.experimento.ExperimentoService;
import service.investigador.InvestigadorService;

import java.util.ArrayList;
import java.util.List;

public class DatosIniciales {
    private InvestigadorService investigadorService;
    private ExperimentoService experimentoService;

    public DatosIniciales(InvestigadorService investigadorService, ExperimentoService experimentoService) {
        this.investigadorService = investigadorService;
        this.experimentoService = experimentoService;
    }

    public void cargaDatosIniciales (){

        // Crear investigadores
        Investigador i1 = new Investigador("Gera", 38);
        Investigador i2 = new Investigador("Luis", 40);
        Investigador i3 = new Investigador("Ana", 35);
        Investigador i4 = new Investigador("Sofía", 29);

        // Registrar investigadores
        investigadorService.resgistrarInvestigador(i1);
        investigadorService.resgistrarInvestigador(i2);
        investigadorService.resgistrarInvestigador(i3);
        investigadorService.resgistrarInvestigador(i4);

        // Crear experimentos químicos
        ExperimentoQuimico eq1 = new ExperimentoQuimico("Síntesis de compuesto A", 30, true, "Uso de catalizador X", i1);
        ExperimentoQuimico eq2 = new ExperimentoQuimico("Reacción exotérmica", 45, false, "Control de temperatura", i2);
        ExperimentoQuimico eq3 = new ExperimentoQuimico("Purificación de muestra", 25, true, "Filtro especial", i3);

        // Crear lista de investigadores para experimentos físicos
        List<Investigador> equipo1 = new ArrayList<>();
        equipo1.add(i2);
        equipo1.add(i3);

        List<Investigador> equipo2 = new ArrayList<>();
        equipo2.add(i1);
        equipo2.add(i4);

        // Crear experimentos físicos
        ExperimentoFisico ef1 = new ExperimentoFisico("Medición de campo magnético", 40, false, "Imán de neodimio", equipo1);
        ExperimentoFisico ef2 = new ExperimentoFisico("Ensayo de resistencia", 60, true, "Material compuesto", equipo2);

        // Registrar experimentos
        experimentoService.registrarExperimentoQuimico(eq1);
        experimentoService.registrarExperimentoQuimico(eq2);
        experimentoService.registrarExperimentoQuimico(eq3);

        experimentoService.registrarExperimentoFisico(ef1);
        experimentoService.registrarExperimentoFisico(ef2);

        System.out.println("Datos iniciales cargados correctamente.");

    }
}

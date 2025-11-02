package com.informatorio.laboratorioChad.service.utils;

import com.informatorio.laboratorioChad.service.experimento.ExperimentoService;
import com.informatorio.laboratorioChad.service.investigador.InvestigadorService;
import com.informatorio.laboratorioChad.dominio.Investigador;

import java.util.ArrayList;
import java.util.List;

public class DatosIniciales {
    public static void cargarDatos(InvestigadorService investigadorService, ExperimentoService experimentoService){
        // === INVESTIGADORES ===
        investigadorService.resgistrarInvestigador("Gera", 38);
        investigadorService.resgistrarInvestigador("Luis", 40);
        investigadorService.resgistrarInvestigador("Silvia", 50);
        investigadorService.resgistrarInvestigador("Ana", 35);
        investigadorService.resgistrarInvestigador("Carlos", 45);
        investigadorService.resgistrarInvestigador("María", 29);
        investigadorService.resgistrarInvestigador("Pablo", 33);
        investigadorService.resgistrarInvestigador("Sofía", 31);
        investigadorService.resgistrarInvestigador("Julián", 42);
        investigadorService.resgistrarInvestigador("Martina", 37);

        List<Investigador> investigadores = investigadorService.obtenerTodos();

        // Alias rápidos
        Investigador i1 = investigadores.get(0); // Gera
        Investigador i2 = investigadores.get(1); // Luis
        Investigador i3 = investigadores.get(2); // Silvia
        Investigador i4 = investigadores.get(3); // Ana
        Investigador i5 = investigadores.get(4); // Carlos
        Investigador i6 = investigadores.get(5); // María
        Investigador i7 = investigadores.get(6); // Pablo
        Investigador i8 = investigadores.get(7); // Sofía
        Investigador i9 = investigadores.get(8); // Julián
        Investigador i10 = investigadores.get(9); // Martina

        // === EXPERIMENTOS QUÍMICOS ===
        experimentoService.registrarExperimentoQuimico("Reacción Ácida", 30, true, "Ácido Clorhídrico", i1);
        experimentoService.registrarExperimentoQuimico("Neutralización", 45, true, "Hidróxido de Sodio", i2);
        experimentoService.registrarExperimentoQuimico("Síntesis Orgánica", 60, false, "Etanol", i3);
        experimentoService.registrarExperimentoQuimico("Oxidación de Metales", 35, true, "Peróxido de Hidrógeno", i4);
        experimentoService.registrarExperimentoQuimico("Reacción de Combustión", 25, false, "Propano", i5);
        experimentoService.registrarExperimentoQuimico("Destilación Fraccionada", 70, true, "Petróleo Crudo", i6);
        experimentoService.registrarExperimentoQuimico("Electrólisis del Agua", 40, true, "Agua y electrodos", i7);
        experimentoService.registrarExperimentoQuimico("Fermentación Alcohólica", 55, false, "Glucosa", i8);
        experimentoService.registrarExperimentoQuimico("Titulación Ácido-Base", 20, true, "Fenolftaleína", i9);
        experimentoService.registrarExperimentoQuimico("Precipitación de Sales", 30, false, "Nitrato de Plata", i10);

        // === EXPERIMENTOS FÍSICOS ===

        // 1
        List<Investigador> grupo1 = new ArrayList<>();
        grupo1.add(i1);
        grupo1.add(i2);
        experimentoService.registrarExperimentoFisico("Caída Libre", 40, true, "Cronómetro", grupo1);

        // 2
        List<Investigador> grupo2 = new ArrayList<>();
        grupo2.add(i2);
        grupo2.add(i3);
        experimentoService.registrarExperimentoFisico("Movimiento Ondulatorio", 50, false, "Generador de ondas", grupo2);

        // 3
        List<Investigador> grupo3 = new ArrayList<>();
        grupo3.add(i4);
        grupo3.add(i5);
        experimentoService.registrarExperimentoFisico("Leyes de Newton", 35, true, "Plano inclinado", grupo3);

        // 4
        List<Investigador> grupo4 = new ArrayList<>();
        grupo4.add(i6);
        grupo4.add(i7);
        experimentoService.registrarExperimentoFisico("Energía Cinética", 25, false, "Pelota y regla", grupo4);

        // 5
        List<Investigador> grupo5 = new ArrayList<>();
        grupo5.add(i8);
        grupo5.add(i9);
        experimentoService.registrarExperimentoFisico("Electromagnetismo", 60, true, "Bobina e imán", grupo5);

        // 6
        List<Investigador> grupo6 = new ArrayList<>();
        grupo6.add(i10);
        grupo6.add(i1);
        experimentoService.registrarExperimentoFisico("Presión Atmosférica", 45, false, "Tubo de ensayo", grupo6);

        // 7
        List<Investigador> grupo7 = new ArrayList<>();
        grupo7.add(i3);
        grupo7.add(i5);
        experimentoService.registrarExperimentoFisico("Circuito Eléctrico Simple", 20, true, "Multímetro", grupo7);

        // 8
        List<Investigador> grupo8 = new ArrayList<>();
        grupo8.add(i2);
        grupo8.add(i8);
        experimentoService.registrarExperimentoFisico("Reflexión de la Luz", 30, true, "Espejo y linterna", grupo8);

        // 9
        List<Investigador> grupo9 = new ArrayList<>();
        grupo9.add(i4);
        grupo9.add(i6);
        experimentoService.registrarExperimentoFisico("Dilación Térmica", 55, false, "Varilla metálica", grupo9);

        // 10
        List<Investigador> grupo10 = new ArrayList<>();
        grupo10.add(i7);
        grupo10.add(i10);
        experimentoService.registrarExperimentoFisico("Resonancia del Sonido", 40, true, "Tubo de resonancia", grupo10);

        System.out.println("✅ Datos iniciales cargados correctamente (" +
                investigadores.size() + " investigadores y 20 experimentos)");
    }
}

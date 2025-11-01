package com.informatorio.laboratorioChad.service.investigador.impl;
import com.informatorio.laboratorioChad.dominio.Investigador;
import com.informatorio.laboratorioChad.repository.experimento.ExperimentoRepository;
import com.informatorio.laboratorioChad.repository.investigador.InvestigadorRepository;
import com.informatorio.laboratorioChad.service.investigador.InvestigadorService;

import java.util.List;

public class InvestigadorServiceImpl implements InvestigadorService {
    private InvestigadorRepository investigadorRepository;

    public InvestigadorServiceImpl(InvestigadorRepository investigadorRepository) {
        this.investigadorRepository = investigadorRepository;
    }

    @Override
    public Investigador resgistrarInvestigador(String nombre, int edad) {
        Investigador investigador = new Investigador(nombre,edad);
        investigadorRepository.guardar(investigador);
        return investigador;
    }

    @Override
    public List<Investigador> obtenerTodos() {
        return investigadorRepository.obtenerTodos();
    }


}

package com.informatorio.laboratorioChad.service.investigador.impl;
import com.informatorio.laboratorioChad.dominio.Investigador;
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
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (edad < 18 || edad > 65) {
            throw new IllegalArgumentException("La edad debe estar entre 18 y 65 años");
        }
        if (investigadorRepository.buscarPorNombre(nombre) != null) {
            throw new IllegalArgumentException("Ya existe un investigador con ese nombre");
        }

        Investigador investigador = new Investigador(nombre,edad);
        investigadorRepository.guardar(investigador);
        return investigador;
    }

    @Override
    public List<Investigador> obtenerTodos() {
        return investigadorRepository.obtenerTodos();
    }


}

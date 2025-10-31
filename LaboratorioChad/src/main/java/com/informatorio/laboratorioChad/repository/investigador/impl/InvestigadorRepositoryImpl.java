package com.informatorio.laboratorioChad.repository.investigador.impl;

import com.informatorio.laboratorioChad.dominio.Investigador;
import com.informatorio.laboratorioChad.repository.investigador.InvestigadorRepository;

import java.util.ArrayList;
import java.util.List;

public class InvestigadorRepositoryImpl implements InvestigadorRepository {
    private List<Investigador> investigadores = new ArrayList<>();


    @Override
    public void guardar(Investigador investigador) {
        investigadores.add(investigador);
    }

    @Override
    public List<Investigador> obtenerTodos() {
        return investigadores;
    }

}

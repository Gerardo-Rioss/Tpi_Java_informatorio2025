package com.informatorio.laboratorioChad.repository.experimento.impl;

import com.informatorio.laboratorioChad.dominio.Experimento;
import com.informatorio.laboratorioChad.repository.experimento.ExperimentoRepository;

import java.util.ArrayList;
import java.util.List;

public class ExperimentoRepositoryImpl implements ExperimentoRepository {
    private List<Experimento> experimentos= new ArrayList<>();

    @Override
    public void guardar(Experimento experimento) {
        experimentos.add(experimento);
    }

    @Override
    public List<Experimento> obtenerTodos() {
        return experimentos;
    }
}

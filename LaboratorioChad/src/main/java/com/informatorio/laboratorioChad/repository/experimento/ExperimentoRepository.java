package com.informatorio.laboratorioChad.repository.experimento;

import com.informatorio.laboratorioChad.dominio.Experimento;

import java.util.List;

public interface ExperimentoRepository {
    void guardar (Experimento experimento);
    List<Experimento> obtenerTodos();
}

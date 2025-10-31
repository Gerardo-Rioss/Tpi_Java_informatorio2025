package com.informatorio.laboratorioChad.repository.investigador;


import com.informatorio.laboratorioChad.dominio.Investigador;

import java.util.List;

public interface InvestigadorRepository {

    void guardar (Investigador investigador);

    List<Investigador> obtenerTodos();
}

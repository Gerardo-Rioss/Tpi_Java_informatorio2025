package service.investigador;

import dominio.Investigador;

import java.util.List;

public interface InvestigadorService {
    void resgistrarInvestigador(Investigador investigador);
    List<Investigador> obtenerTodos();
    Investigador buscarPorNombre(String nombre);
}

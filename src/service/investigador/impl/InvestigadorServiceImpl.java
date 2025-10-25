package service.investigador.impl;

import dominio.Investigador;
import service.investigador.InvestigadorService;

import java.util.ArrayList;
import java.util.List;

public class InvestigadorServiceImpl implements InvestigadorService {
    private List<Investigador> investigadores = new ArrayList<>();

    @Override
    public void resgistrarInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    @Override
    public List<Investigador> obtenerTodos() {
        return investigadores;
    }

//    equalsIgnoreCase compara el nombre del investigador con el parámetro nombre proporcionado,
//    ignorando las diferencias entre mayúsculas y minúsculas.

    @Override
    public Investigador buscarPorNombre(String nombre) {
        for(Investigador inv : investigadores){
            if (inv.getNombre().equalsIgnoreCase(nombre)){
                return inv;
            }
        }
        return null;
    }
}

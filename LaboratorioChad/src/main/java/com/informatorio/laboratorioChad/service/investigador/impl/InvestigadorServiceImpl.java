package com.informatorio.laboratorioChad.service.investigador.impl;

import com.informatorio.laboratorioChad.dominio.Investigador;
import com.informatorio.laboratorioChad.repository.investigador.InvestigadorRepository;
import com.informatorio.laboratorioChad.service.investigador.InvestigadorService;
import com.informatorio.laboratorioChad.service.utils.Imput;
import com.informatorio.laboratorioChad.service.utils.Validar;

public class InvestigadorServiceImpl implements InvestigadorService {
    private InvestigadorRepository investigadorRepository;

    public InvestigadorServiceImpl(InvestigadorRepository investigadorRepository) {
        this.investigadorRepository = investigadorRepository;
    }

    @Override
    public void resgistrarInvestigador() {
        System.out.println("\n--- REGISTRAR INVESTIGADOR ---");

        String nombre;
        do{
            nombre = Imput.leerCadena("Ingrese nombre del investigador: ");
            try{
                Validar.validadNoVacio(nombre,"nombre");
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while (true);

        int edad;
        do {
            edad= Imput.leerEntero("Ingrese edad del investigador: ");
            try{
                Validar.validarPositivo(edad,"edad");
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Error "+ e.getMessage());
            }
        }while (true);

        Investigador investigador = new Investigador(nombre,edad);
        investigadorRepository.guardar(investigador);
        System.out.println(investigador.toString());
        System.out.println("Registrado con éxito.");
    }



}

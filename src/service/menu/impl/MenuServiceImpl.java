package service.menu.impl;

import dominio.Investigador;
import service.investigador.InvestigadorService;
import service.investigador.impl.InvestigadorServiceImpl;
import service.menu.MenuService;
import service.utils.Imput;
import service.utils.Validar;

public class MenuServiceImpl implements MenuService {
    InvestigadorService investigadorService = new InvestigadorServiceImpl();

    @Override
    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA GESTOR DE EXPERIMENTOS - LABORATORIO CHAD ===");
        System.out.println("1. Registrar investigador");
        System.out.println("2. Registrar experimento");
        System.out.println("3. Mostrar listado de experimentos");
        System.out.println("4. Mostrar totales de experimentos (exitosos y fallidos)");
        System.out.println("5. Mostrar experimento de mayor duración");
        System.out.println("6. Generar reporte (promedio duración y porcentaje éxito)");
        System.out.println("7. Mostrar investigador con más experimentos");
        System.out.println("8. Exportar investigadores a CSV");
        System.out.println("9. Salir");
    }

    @Override
    public void procesarOpcion(int opcion) {
    }

    private void registrarInvestigador(){
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
        investigadorService.resgistrarInvestigador(investigador);
        System.out.println("Investigador registrado con éxito.");
    }
}

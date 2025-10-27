package service.menu.impl;

import service.menu.MenuService;

public class MenuServiceImpl implements MenuService {
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
}

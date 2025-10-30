import service.datosIniciales.DatosIniciales;
import service.experimento.ExperimentoService;
import service.experimento.impl.ExperimentoServiceImpl;
import service.investigador.InvestigadorService;
import service.investigador.impl.InvestigadorServiceImpl;
import service.menu.MenuService;
import service.menu.impl.MenuServiceImpl;
import service.utils.Imput;


public class app {
    public static void main(String[] args) {

        InvestigadorService investigadorService = new InvestigadorServiceImpl() ;
        ExperimentoService experimentoService = new ExperimentoServiceImpl();
        MenuService menuService= new MenuServiceImpl(investigadorService, experimentoService);
        DatosIniciales datos = new DatosIniciales(investigadorService,experimentoService);

        //Carga los datos
        datos.cargaDatosIniciales();

        int opcion;
        do{
            menuService.mostrarMenu();
            opcion= Imput.leerEnteroConRango("Seleccione una opción: ",1,9);
            menuService.procesarOpcion(opcion);
        }while (opcion!=9);

    }
}

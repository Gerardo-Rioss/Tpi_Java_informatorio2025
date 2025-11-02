package com.informatorio.laboratorioChad.service.archivos.impl;

import com.informatorio.laboratorioChad.dominio.Investigador;
import com.informatorio.laboratorioChad.service.archivos.ExportarInvestigadoresServices;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportarInvestigadoresServicesImpl implements ExportarInvestigadoresServices {

    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\com\\informatorio\\laboratorioChad\\resource\\";
    CSVWriter csvWriter;
    @Override
    public void exportarInvestigadoresCSV(List<Investigador> investigadores) {
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("lista-investigadores.csv");
        try{
            this.csvWriter = new CSVWriter(new FileWriter(ruta));

            String[] encabezado = {"NOMBRE", "EDAD"};
            this.csvWriter.writeNext( encabezado );

            for (Investigador inv : investigadores) {
                String[] datos = {  inv.getNombre()  , Integer.toString( inv.getEdad() )   };
                this.csvWriter.writeNext( datos );
            }

            System.out.println("Exportacion exitosa!!!!");
            this.cerrarWriter();

        }catch (IOException ioException){
            System.out.println(
                    "Algo salio mal motivo : " + ioException.getMessage().concat( "Ubicacion archivo : " + ruta )
            );
        }
    }
    private void cerrarWriter(){
        if ( this.csvWriter != null ){
            try {
                this.csvWriter.close();
            }catch (IOException e) {
                System.out.println("Algo salio mal motivo : " + e.getMessage());
            }
        }
    }
}

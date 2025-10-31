package com.informatorio.laboratorioChad.service.archivos.impl;

import com.informatorio.laboratorioChad.dominio.Investigador;
import com.informatorio.laboratorioChad.service.archivos.ExportarInvestigadoresServices;

import java.util.List;

public class ExportarInvestigadoresServicesImpl implements ExportarInvestigadoresServices {

    private final String UBICACION_ARCHIVO = "\\src\\resource\\";
    @Override
    public void exportarInvestigadoresCSV(List<Investigador> investigadores) {

    }

//    @Override
//    public void exportarMisionesCSV(List<Mision> misiones){
//        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("misiones-realizadas.csv");
//        try{
//            this.csvWriter = new CSVWriter(new FileWriter(ruta));
//
//            String[] encabezado = {"NUMERO", "PUNTAJE"};
//            this.csvWriter.writeNext( encabezado );
//
//            for (Mision mision : misiones) {
//
//                String[] datos = { Integer.toString( mision.getNumero() ) , Integer.toString( mision.getPuntaje() )   };
//                this.csvWriter.writeNext( datos );
//
//            }
//
//            System.out.println("Exportacion exitosa!!!!");
//            this.cerrarWriter();
//
//        }catch (IOException ioException){
//            System.out.println(
//                    "Algo salio mal motivo : " + ioException.getMessage().concat( "Ubicacion archivo : " + ruta )
//            );
//        }
//    }
//
//    private void cerrarWriter(){
//        if ( this.csvWriter != null ){
//            try {
//                this.csvWriter.close();
//            }catch (IOException e) {
//                System.out.println("Algo salio mal motivo : " + e.getMessage());
//            }
//        }
//    }

}

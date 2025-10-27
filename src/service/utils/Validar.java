package service.utils;

public class Validar {
    public static void validadNoVacio(String valor, String campo){
        if(valor==null || valor.trim().isEmpty()){
            throw new IllegalArgumentException("El cammpo "+campo+" no puede estar vaccío.");
        }
    }
}

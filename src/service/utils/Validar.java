package service.utils;

public class Validar {
    public static void validadNoVacio(String valor, String campo){
        if(valor == null || valor.trim().isEmpty()){
            throw  new IllegalArgumentException("El campo "+ campo+" no puede estar vacio.");
        }
    }
    public static void validarPositivo(int valor, String campo){
        if (valor<=0){
            throw new IllegalArgumentException("El campo "+ campo+ " debe ser un número positivo.");
        }
    }

    public static void  validarRango(int valor, int min, int max, String campo){
        if (valor<min || valor> max){
            throw new IllegalArgumentException("El campo "+campo+" debe estar entre "+min+" y "+max+".");
        }
    }

}

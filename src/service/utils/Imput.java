package service.utils;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Imput {
    private  static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje){
        while (true){
            try{
                System.out.print(mensaje);
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }catch (InputMismatchException e)  {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.nextLine();
            }
        }
    }

    public static int leerEnteroConRango(String mensaje, int min, int max){
        while (true){
            int valor = leerEntero(mensaje);
            if (valor>= min && valor<=max){
                return valor;
            }else{
                System.out.println("Error: El número debe estar entre "+min+" y "+max+"." );
            }
        }
    }

    public static boolean leerBooleano(String mensaje){
        while (true){
            int valor = Imput.leerEntero(mensaje+ " (1: Si , 0: No ): ");
            if (valor==0 || valor==1){
                return valor ==1;
            }else {
                System.out.println("Error: Debe ingresar 0 (no) o 1 (sí).");
            }
        }
    }

    public static String leerCadena(String mensaje){
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static <T> T seleccionarDeLista(String mensaje, List<T> lista){
        if (lista.isEmpty()){
            throw new IllegalStateException("La lista está vacía.");
        }
        for(int i = 0; i< lista.size(); i++){
            System.out.println((i+1)+". "+ lista.get(i).toString());
        }
        int indice = Imput.leerEnteroConRango(mensaje,1,lista.size());
        return lista.get(indice-1);

    }

}

package service.utils;

import javax.swing.*;
import java.util.InputMismatchException;
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

    public static String leerCadena(String mensaje){
        System.out.print(mensaje);
        return scanner.nextLine();
    }

}

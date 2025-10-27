package service.utils;

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
}

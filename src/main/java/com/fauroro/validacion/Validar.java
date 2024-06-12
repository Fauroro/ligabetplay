package com.fauroro.validacion;

import java.util.Scanner;

public class Validar {
    static Scanner sc = new Scanner(System.in);

    public static int validarInt(String mensaje){
        int resultado;
        while (true){
            try {
                System.out.println(mensaje);
                resultado = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un dato valido");
            }
        }
        return resultado;
    }


}

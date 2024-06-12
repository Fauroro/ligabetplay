package com.fauroro;

import java.util.ArrayList;
import java.util.Scanner;

import com.fauroro.models.Tabla;
import com.fauroro.validacion.Validar;
import com.fauroro.vistas.Menus;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Tabla> resultados = new ArrayList<Tabla>();

        boolean flag = true;
        while (flag) {

            int seleccion = Validar.validarInt("Seleccione la opcion que requiera\n1. " +
                    "Registrar Equipo\n2. Registrar Fecha\n3. Reportes\n4. Ver tabla de posiciones\n5. Salir\n->");


            switch (seleccion) {
                case 1:
                    Menus.regEquipo();
                    break;
                case 2:
                    Menus.regFecha();
                    break;
                case 3:
                    Menus.reportes();
                    break;
                case 4:
                    Menus.ordenarPuntos();
                    break;
                case 5:
                    flag = false;
                    System.out.println("Gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Seleccione una opcion existente\n");
                    sc.nextLine();
            }

        }

    }


}
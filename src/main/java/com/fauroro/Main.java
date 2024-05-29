package com.fauroro;

import java.util.ArrayList;
import java.util.Scanner;

import com.fauroro.models.Tabla;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Tabla> resultados = new ArrayList<Tabla>();

        boolean flag = true;
        while (flag) {
            System.out.println("\n******** LIGA BETPLAY ********\n");
            System.out.println(
                    "Seleccione la opcion que requiera\n1. Registrar Equipo\n2. Registrar Fecha\n3. Reportes\n4. Ver tabla de posiciones\n5. Salir\n->");
            int seleccion = sc.nextInt();

            switch (seleccion) {
                case 1:
                    regEquipo(resultados);
                    break;
                case 2:
                    regFecha(resultados);
                    break;
                case 3:
                    reportes(resultados);
                    break;
                case 4:
                    ordenarPuntos(resultados);
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

    public static void regEquipo(ArrayList<Tabla> resultados) {
        boolean isTrue = true;
        while (isTrue) {
            Scanner sc = new Scanner(System.in);
            Tabla myResuTabla = new Tabla(null, 0, 0, 0, 0, 0, 0, 0);
            System.out.println("Ingrese el nombre del equipo : ");
            myResuTabla.setNombreEquipo(sc.nextLine());
            resultados.add(myResuTabla);
            System.out.println("Desea registrar otro equipo. 1 si - 2 no");
            int valid = sc.nextInt();
            if (valid != 1) {
                isTrue = false;
            }
        }
    }

    public static void regFecha(ArrayList<Tabla> resultados) {
        boolean isTrue = true;
        while (isTrue) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el equipo visitante");
            String visitante = sc.nextLine();
            System.out.println("Ingrese el marcador del equipo " + visitante);
            int golVisit = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el equipo local");
            String local = sc.nextLine();
            System.out.println("Ingrese el marcador del equipo " + local);
            int golLocal = sc.nextInt();

            if (golLocal > golVisit) {
                for (Tabla equipo : resultados) {
                    if (equipo.getNombreEquipo().equals(local)) {
                        equipo.setJugados(equipo.getJugados() + 1);
                        equipo.setGanados(equipo.getGanados() + 1);
                        equipo.setGolesFavor(equipo.getGolesFavor() + golLocal);
                        equipo.setGolesContra(equipo.getGolesContra() + golVisit);
                        equipo.setTotalPuntos(equipo.getTotalPuntos() + 3);

                    } else if (equipo.getNombreEquipo().equals(visitante)) {
                        equipo.setJugados(equipo.getJugados() + 1);
                        equipo.setPerdidos(equipo.getPerdidos() + 1);
                        equipo.setGolesFavor(equipo.getGolesFavor() + golVisit);
                        equipo.setGolesContra(equipo.getGolesContra() + golLocal);
                    }
                }
            } else if (golLocal < golVisit) {
                for (Tabla equipo : resultados) {
                    if (equipo.getNombreEquipo().equals(visitante)) {
                        equipo.setJugados(equipo.getJugados() + 1);
                        equipo.setGanados(equipo.getGanados() + 1);
                        equipo.setGolesFavor(equipo.getGolesFavor() + golVisit);
                        equipo.setGolesContra(equipo.getGolesContra() + golLocal);
                        equipo.setTotalPuntos(equipo.getTotalPuntos() + 3);

                    } else if (equipo.getNombreEquipo().equals(local)) {
                        equipo.setJugados(equipo.getJugados() + 1);
                        equipo.setPerdidos(equipo.getPerdidos() + 1);
                        equipo.setGolesFavor(equipo.getGolesFavor() + golLocal);
                        equipo.setGolesContra(equipo.getGolesContra() + golVisit);
                    }
                }
            } else {
                for (Tabla equipo : resultados) {
                    if (equipo.getNombreEquipo().equals(visitante) || equipo.getNombreEquipo().equals(local)) {
                        equipo.setJugados(equipo.getJugados() + 1);
                        equipo.setEmpates(equipo.getEmpates() + 1);
                        equipo.setGolesFavor(equipo.getGolesFavor() + golLocal);
                        equipo.setGolesContra(equipo.getGolesContra() + golVisit);
                        equipo.setTotalPuntos(equipo.getTotalPuntos() + 1);
                    }
                }
            }

            System.out.println("Desea registrar otra fecha. 1 si - 2 no");
            int valid = sc.nextInt();
            if (valid != 1) {
                isTrue = false;
            }
        }
    }

    public static void reportes(ArrayList<Tabla> resultados) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;

        while (flag) {

            System.out.println("*** MODULO DE REPORTES ***\n");
            System.out.println(
                    "Seleccione la opcion que requiera\n1. Nombre del equipo que mas goles anoto\n2. Nombre del equipo que mas puntos tiene\n3. Nombre del equipo que mas partidos gano\n4. Total de goles anotados por todos los equipos\n5. Promedio de goles anotados en el torneola federacion colombiana de futbol\n6. Salir\n->");
            int seleccion = sc.nextInt();

            switch (seleccion) {
                case 1:
                    masGoles(resultados);
                    break;
                case 2:
                    masPuntos(resultados);
                    break;
                case 3:
                    masVictorias(resultados);
                    break;
                case 4:
                    totalGoles(resultados);
                    break;
                case 5:
                    promedioGoles(resultados);
                    break;
                case 6:
                    flag = false;
                    System.out.println("Gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Seleccione una opcion existente\n");
                    sc.nextLine();
            }
        }
    }

    public static void masGoles(ArrayList<Tabla> resultados) {
        Tabla equipoMasGoles = resultados.get(0);
        for (Tabla equipo : resultados) {
            if (equipo.getGolesFavor() > equipoMasGoles.getGolesFavor()) {
                equipoMasGoles = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas goles es: %s", equipoMasGoles.getNombreEquipo()));
    }

    public static void masPuntos(ArrayList<Tabla> resultados) {
        Tabla equipoMasPuntos = resultados.get(0);
        for (Tabla equipo : resultados) {
            if (equipo.getTotalPuntos() > equipoMasPuntos.getTotalPuntos()) {
                equipoMasPuntos = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas puntos es: %s", equipoMasPuntos.getNombreEquipo()));
    }

    public static void masVictorias(ArrayList<Tabla> resultados) {
        Tabla equipoMasVictorias = resultados.get(0);
        for (Tabla equipo : resultados) {
            if (equipo.getGanados() > equipoMasVictorias.getGanados()) {
                equipoMasVictorias = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas victorias es: %s", equipoMasVictorias.getNombreEquipo()));
    }

    public static void totalGoles(ArrayList<Tabla> resultados) {
        int golesTotales = 0;
        for (Tabla equipo : resultados) {
            golesTotales += equipo.getGolesFavor();
        }
        System.out.println(String.format("El total de goles marcados es: %s", golesTotales));
    }

    public static void promedioGoles(ArrayList<Tabla> resultados) {
        int golesTotales = 0;
        float promedioGoles = 0;
        for (Tabla equipo : resultados) {
            golesTotales += equipo.getGolesFavor();
        }
        promedioGoles = golesTotales / resultados.size();
        System.out.println(String.format("El promedio de goles marcados es: %s", promedioGoles));
    }

    public static void ordenarPuntos(ArrayList<Tabla> equipos) {
        int n = equipos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (equipos.get(j).getTotalPuntos() < equipos.get(j + 1).getTotalPuntos()) {
                    Tabla temp = equipos.get(j);
                    equipos.set(j, equipos.get(j + 1));
                    equipos.set(j + 1, temp);
                }
            }
        }
        imprimirTabla(equipos);
    }

    public static void imprimirTabla(ArrayList<Tabla> equipos) {
        // Imprimir encabezado
        System.out.printf("%-20s %5s %5s %5s %5s %5s %5s %5s\n",
                "Equipo", "J", "G", "P", "E", "GF", "GC", "Puntos");
        System.out.println("---------------------------------------------------------------");

        // Imprimir cada equipo en la tabla
        for (Tabla equipo : equipos) {
            System.out.printf("%-20s %5s %5s %5s %5s %5s %5s %5s\n", equipo.getNombreEquipo(), equipo.getJugados(),
                    equipo.getGanados(), equipo.getPerdidos(), equipo.getEmpates(), equipo.getGolesFavor(),
                    equipo.getGolesContra(), equipo.getTotalPuntos());
        }
    }

}
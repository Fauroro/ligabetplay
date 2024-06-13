package com.fauroro.vistas;

import com.fauroro.Plantel;
import com.fauroro.controlador.ControladorTabla;
import com.fauroro.controlador.JugadorController;
import com.fauroro.models.Jugador;
import com.fauroro.models.Tabla;
import com.fauroro.validacion.Validar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menus {
    static ArrayList<Tabla> resultados = new ArrayList<Tabla>();
    static Scanner sc = new Scanner(System.in);
    static JugadorController myJugadorControlador = new JugadorController();

    public static void regEquipo() {
        boolean isTrue = true;
        while (isTrue) {
            int idEquipo = resultados.size()+1;
            Tabla myResuTabla = new Tabla(idEquipo,null, 0, 0, 0, 0, 0, 0, 0);
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

    public static void regFecha() {
        boolean isTrue = true;
        while (isTrue) {
            ArrayList<String> list = new ArrayList<>();
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

            System.out.println("Desea registrar otro equipo. 1 si - 2 no");
            int valid = sc.nextInt();
            if (valid != 1) {
                isTrue = false;
            }
        }
    }

    public static void regPlantel(){
        boolean flag = true;

        etiqueta: while (flag) {
        System.out.println("Equipos Registrados");
        ControladorTabla.showEquipos(resultados);
        int idEquipo = Validar.validarInt("Seleccione el id del equipo");
        Tabla equipoSeleccionado = ControladorTabla.searchId(resultados,idEquipo);

        int seleccion = Validar.validarInt("Seleccione la opcion que requiera\n1. Registrar Jugador\n2. Registrar Cuerpo tecnico\n3. Registrar Cuerpo medico\n4. Salir");

            switch (seleccion) {
                case 1:
                    regJugador(equipoSeleccionado.getIdEquipo());
                    break;
                case 2:
                    masPuntos();
                    break;
                case 3:
                    masVictorias();
                    break;
                case 4:
                    flag = false;
                    System.out.println("Gracias por usar nuestros servicios");
                    break etiqueta;
                default:
                    System.out.println("Seleccione una opcion existente\n");
                    sc.nextLine();
            }

            int valid = Validar.validarInt("Desea realizar otro registro. 1 si - 2 no");
            if (valid != 1) {
                flag = false;
            }
        }    }


    public static void reportes() {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;

        etiqueta: while (flag) {
            System.out.println(
                    "Seleccione la opcion que requiera\n1. Nombre del equipo que mas goles anoto\n2. Nombre del equipo que mas puntos " +
                            "tiene\n3. Nombre del equipo que mas partidos gano\n4. Total de goles anotados por todos los resultado\n5. " +
                            "Promedio de goles anotados en el torneola federacion colombiana de futbol\n6. Salir\n->");
            int seleccion = sc.nextInt();

            switch (seleccion) {
                case 1:
                    masGoles();
                    break;
                case 2:
                    masPuntos();
                    break;
                case 3:
                    masVictorias();
                    break;
                case 4:
                    totalGoles();
                    break;
                case 5:
                    promedioGoles();
                    break;
                case 6:
                    flag = false;
                    System.out.println("Gracias por usar nuestros servicios");
                    break etiqueta;
                default:
                    System.out.println("Seleccione una opcion existente\n");
                    sc.nextLine();
            }

            int valid = Validar.validarInt("Desea ver otro registro. 1 si - 2 no");
            if (valid != 1) {
                flag = false;
            }
        }
    }

    public static void masGoles() {
        Tabla equipoMasGoles = null;
        for (Tabla equipos : resultados) {
            if (equipoMasGoles == null || equipos.getGolesFavor() > equipoMasGoles.getGolesFavor()) {
                equipoMasGoles = equipos;
            }
        }
//        Tabla equipoMasGoles = resultados.get(0);
//        for (Tabla equipo : resultados) {
//            if (equipo.getGolesFavor() > equipoMasGoles.getGolesFavor()) {
//                equipoMasGoles = equipo;
//            }
//        }
        System.out.println(String.format("El equipo con mas goles es: %s", equipoMasGoles.getNombreEquipo()));
    }

    public static void masPuntos() {
        Tabla equipoMasPuntos = resultados.get(0);
        for (Tabla equipo : resultados) {
            if (equipo.getTotalPuntos() > equipoMasPuntos.getTotalPuntos()) {
                equipoMasPuntos = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas puntos es: %s", equipoMasPuntos.getNombreEquipo()));
    }

    public static void masVictorias() {
        Tabla equipoMasVictorias = resultados.get(0);
        for (Tabla equipo : resultados) {
            if (equipo.getGanados() > equipoMasVictorias.getGanados()) {
                equipoMasVictorias = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas victorias es: %s", equipoMasVictorias.getNombreEquipo()));
    }

    public static void totalGoles() {
        int golesTotales = 0;
        for (Tabla equipo : resultados) {
            golesTotales += equipo.getGolesFavor();
        }
        System.out.println(String.format("El total de goles marcados es: %s", golesTotales));
    }

    public static void promedioGoles() {
        int golesTotales = 0;
        float promedioGoles = 0;
        for (Tabla equipo : resultados) {
            golesTotales += equipo.getGolesFavor();
        }
        promedioGoles = golesTotales / resultados.size();
        System.out.println(String.format("El promedio de goles marcados es: %s", promedioGoles));
    }

    public static void ordenarPuntos() {
        int n = resultados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (resultados.get(j).getTotalPuntos() < resultados.get(j + 1).getTotalPuntos()) {
                    Tabla temp = resultados.get(j);
                    resultados.set(j, resultados.get(j + 1));
                    resultados.set(j + 1, temp);
                }
            }
        }
        imprimirTabla(resultados);
    }

    public static void imprimirTabla(ArrayList<Tabla> resultado) {
        // Imprimir encabezado
        System.out.printf("%-20s %5s %5s %5s %5s %5s %5s %5s\n",
                "Equipo", "J", "G", "P", "E", "GF", "GC", "Puntos");
        System.out.println("---------------------------------------------------------------");

        // Imprimir cada equipo en la tabla
        for (Tabla equipo : resultado) {
            System.out.printf("%-20s %5s %5s %5s %5s %5s %5s %5s\n", equipo.getNombreEquipo(), equipo.getJugados(),
                    equipo.getGanados(), equipo.getPerdidos(), equipo.getEmpates(), equipo.getGolesFavor(),
                    equipo.getGolesContra(), equipo.getTotalPuntos());
        }
    }

    public static void regJugador(int idEquipo) {

        int idJugador = myJugadorControlador.lastId();

        int edadJugador = Validar.validarInt("Ingrese la edad del jugador");
        int dorsalJugador = Validar.validarInt("Ingrese el dorsal del jugador");
        sc.nextLine();
        System.out.println("Ingrese el Nombre del jugador");
        String nombreJugador = sc.nextLine();
        System.out.println("Ingrese el Apellido del jugador");
        String apellidoJugador = sc.nextLine();
        System.out.println("Ingrese la nacionalidad del jugador");
        String nacionalidadJugador = sc.nextLine();
        System.out.println("Ingrese la posicion de juego del jugador");
        String posicionJugador = sc.nextLine();
        System.out.println("Ingrese la fecha de ingreso del jugador (dd/MM/yyyy):");
        String fechaString = sc.nextLine();

        // Definir el formato de fecha esperado
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fechaIngresoJugador = null;
        try {
            // Convertir la cadena en un objeto Date
            Date fecha = formato.parse(fechaString);

            // Imprimir la fecha formateada
            fechaIngresoJugador = formato.format(fecha);
        } catch (ParseException e) {
            // Manejar cualquier error de análisis de fecha
            System.out.println("Error: Formato de fecha incorrecto. Asegúrate de ingresar la fecha en el formato dd/MM/yyyy.");
        }

        myJugadorControlador.save(new Jugador(idJugador, nombreJugador, apellidoJugador, edadJugador, idEquipo, nacionalidadJugador, dorsalJugador, posicionJugador, fechaIngresoJugador, 0, 0, 0));

    }

}

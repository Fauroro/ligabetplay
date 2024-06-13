package com.fauroro.controlador;

import com.fauroro.models.Jugador;
import com.fauroro.models.Tabla;

import java.util.ArrayList;
import java.util.List;

public class ControladorTabla {
    public static void showEquipos(List<Tabla> equipos){
        for (Tabla equipo : equipos){
            System.out.println(equipo.getIdEquipo()+" "+equipo.getNombreEquipo());
        }
    }

    public static Tabla searchId(List<Tabla> equipos, int id) {
        Tabla resultado = null;
        for (Tabla c : equipos) {
            if (c.getIdEquipo() == id) {
                resultado = c;
            }
        }
        return resultado;
    }

}

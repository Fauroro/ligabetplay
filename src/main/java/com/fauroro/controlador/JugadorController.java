package com.fauroro.controlador;

import com.fauroro.abstraccion.Repositorio;
import com.fauroro.models.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorController extends Repositorio<Jugador> {

    List<Jugador> ArrayJugador;

    public JugadorController() {
        this.ArrayJugador = new ArrayList<>();
    }

    @Override
    public void save(Jugador objeto) {
        this.ArrayJugador.add(objeto);

    }

    @Override
    public List<Jugador> show() {
        return ArrayJugador;
    }

    @Override
    public Jugador searchId(int id) {
        Jugador resultado = null;
        for (Jugador c : ArrayJugador) {
            if (c.getId() == id) {
                resultado = c;
            }
        }
        return resultado;
    }

    @Override
    public int lastId() {
        return this.ArrayJugador.size() + 1;
    }
}

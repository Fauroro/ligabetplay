package com.fauroro.controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.fauroro.abstraccion.Repositorio;
import com.fauroro.models.Jugador;

public class JugadorController extends Repositorio<Jugador> {
    private static final String FILE_PATH = "jugador.json";
    private Gson gson;
    List<Jugador> arrayJugador;

    public JugadorController() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.arrayJugador = load();
    }

    @Override
    public void save(Jugador objeto) {
        this.arrayJugador.add(objeto);
        savePersona();

    }

    @Override
    public List<Jugador> show() {
        return new ArrayList<>(arrayJugador);
    }

    @Override
    public Jugador searchId(int id) {
        Jugador resultado = null;
        for (Jugador c : arrayJugador) {
            if (c.getId() == id) {
                resultado = c;
            }
        }
        return resultado;
    }

    @Override
    public int lastId() {
        return this.arrayJugador.size() + 1;
    }

    @Override
    public List<Jugador> load() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Jugador>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Si el archivo no existe, devolver una lista vacía
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void savePersona() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(arrayJugador, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Jugador objeto) {
        for (int i = 0; i < arrayJugador.size(); i++) {
            if (arrayJugador.get(i).getId() == objeto.getId()) {
                arrayJugador.set(i, objeto);
                savePersona();
                return;
            }
        }
    }


}

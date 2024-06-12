package com.fauroro.models;

import com.fauroro.Plantel;

import java.time.LocalDate;

public class Jugador extends Plantel {

    int dorsal;
    String posJuego;
    LocalDate fechaIngreso;
    int golesAnotados;
    int tarjetaRoja;
    int tarjetaAmarilla;

    public Jugador(int id, String nombre, String apellido, int edad, int idEquipo, String nacionalidad, int dorsal, String posJuego, LocalDate fechaIngreso, int golesAnotados, int tarjetaRoja, int tarjetaAmarilla) {
        super(id, nombre, apellido, edad, idEquipo, nacionalidad);
        this.dorsal = dorsal;
        this.posJuego = posJuego;
        this.fechaIngreso = fechaIngreso;
        this.golesAnotados = golesAnotados;
        this.tarjetaRoja = tarjetaRoja;
        this.tarjetaAmarilla = tarjetaAmarilla;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosJuego() {
        return posJuego;
    }

    public void setPosJuego(String posJuego) {
        this.posJuego = posJuego;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getTarjetaRoja() {
        return tarjetaRoja;
    }

    public void setTarjetaRoja(int tarjetaRoja) {
        this.tarjetaRoja = tarjetaRoja;
    }

    public int getTarjetaAmarilla() {
        return tarjetaAmarilla;
    }

    public void setTarjetaAmarilla(int tarjetaAmarilla) {
        this.tarjetaAmarilla = tarjetaAmarilla;
    }


}

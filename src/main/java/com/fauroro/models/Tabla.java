package com.fauroro.models;

public class Tabla {
    String nombreEquipo;
    int jugados;
    int ganados;
    int perdidos;
    int empates;
    int golesFavor;
    int golesContra;
    int totalPuntos;
    

    public Tabla() {
    }

    public Tabla(String nombreEquipo, int jugados, int ganados, int perdidos, int empates, int golesFavor,
            int golesContra, int totalPuntos) {
        this.nombreEquipo = nombreEquipo;
        this.jugados = jugados;
        this.ganados = ganados;
        this.perdidos = perdidos;
        this.empates = empates;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.totalPuntos = totalPuntos;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getJugados() {
        return jugados;
    }

    public void setJugados(int jugados) {
        this.jugados = jugados;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(int totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    


}

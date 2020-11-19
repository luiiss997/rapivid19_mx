package com.servicio.rapivid_19mx.modelo;

import java.io.Serializable;

public class Estado implements Serializable {
    private String nombre;
    private String activos;
    private String mortales;
    private String recuperados;
    private String totales;
    private int semaforo;

    public Estado() {
    }

    public Estado(String nombre, String activos, String mortales, String recuperados, String totales, int semaforo) {
        this.nombre = nombre;
        this.activos = activos;
        this.mortales = mortales;
        this.recuperados = recuperados;
        this.totales = totales;
        this.semaforo = semaforo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActivos() {
        return activos;
    }

    public void setActivos(String activos) {
        this.activos = activos;
    }

    public String getMortales() {
        return mortales;
    }

    public void setMortales(String mortales) {
        this.mortales = mortales;
    }

    public String getRecuperados() {
        return recuperados;
    }

    public void setRecuperados(String recuperados) {
        this.recuperados = recuperados;
    }

    public String getTotales() {
        return totales;
    }

    public void setTotales(String totales) {
        this.totales = totales;
    }

    public int getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(int semaforo) {
        this.semaforo = semaforo;
    }

}
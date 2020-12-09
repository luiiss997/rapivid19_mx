package com.servicio.rapivid_19mx.modelo;

public class Mexico {
    private String activos;
    private String mortales;
    private String recuperados;
    private String totales;
    private String ult_alt;

    public Mexico(String activos, String mortales, String recuperados, String totales, String ult_alt) {
        this.activos = activos;
        this.mortales = mortales;
        this.recuperados = recuperados;
        this.totales = totales;
        this.ult_alt = ult_alt;
    }

    public Mexico() {
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

    public String getUlt_alt() {
        return ult_alt;
    }

    public void setUlt_alt(String ult_alt) {
        this.ult_alt = ult_alt;
    }
}

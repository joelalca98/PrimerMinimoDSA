package edu.upc.dsa.models;

import java.util.Date;

public class Personas {
    String idUsuario;
    String idVacuna;
    Date fecha;
    String descripcion;

    public Personas() {
    }

    public Personas(String idUsuario, String idVacuna, Date fecha, String descripcion) {
        this.idUsuario = idUsuario;
        this.idVacuna = idVacuna;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(String idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

package edu.upc.dsa.models;

import java.util.Date;

public class Seguimiento {
    String idUser;
    Date fecha;
    String descripcion;

    public Seguimiento() {
    }

    public Seguimiento(String idUser, Date fecha, String descripcion) {
        this.idUser = idUser;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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
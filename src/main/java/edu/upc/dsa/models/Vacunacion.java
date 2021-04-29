package edu.upc.dsa.models;

import java.util.Date;

public class Vacunacion {
    String idPersona;
    String idVacuna;
    Date fecha;
    String name;

    public Vacunacion() {
    }

    public Vacunacion(String idPersona, String idVacuna, Date fecha, String name) {
        this.idPersona = idPersona;
        this.idVacuna = idVacuna;
        this.fecha = fecha;
        this.name = name;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vacunacion(String idPersona, String idVacuna, Date fecha) {
        this.idPersona = idPersona;
        this.idVacuna = idVacuna;
        this.fecha = fecha;
    }
}
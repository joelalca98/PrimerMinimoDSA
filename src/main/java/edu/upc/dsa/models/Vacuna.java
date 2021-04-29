package edu.upc.dsa.models;

public class Vacuna {
    String nombre;
    String id;
    Integer veces;

    public Vacuna() {
    }

    public Vacuna(String nombre, String id, Integer veces) {
        this.nombre = nombre;
        this.id = id;
        this.veces = veces;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVeces() {
        return veces;
    }

    public void setVeces(Integer veces) {
        this.veces = veces;
    }
}

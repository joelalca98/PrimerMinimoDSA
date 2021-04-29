package edu.upc.dsa.models;

import java.util.Date;
import edu.upc.dsa.util.RandomUtils;
public class Muestra {
    String idMuestra;
    String idClinico;
    String idPersona;
    Date fecha;
    String idLab;
    String resultado;
    String comentario;

    public Muestra() {
    }

    public Muestra(String idMuestra, String idClinico, String idPersona, Date fecha, String idLab) {
        this.idMuestra = idMuestra;
        this.idClinico = idClinico;
        this.idPersona = idPersona;
        this.fecha = fecha;
        this.idLab = idLab;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Muestra(String idMuestra, String idClinico, String idPersona, Date fecha, String idLab, String resultado, String comentario) {
        this.idMuestra = idMuestra;
        this.idClinico = idClinico;
        this.idPersona = idPersona;
        this.fecha = fecha;
        this.idLab = idLab;
        this.resultado = resultado;
        this.comentario = comentario;
    }
}

package edu.upc.dsa;

import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;

import java.util.Date;
import java.util.List;

public interface CovidInterfaz {

    public Persona crearPersona (String id, String nombre, String apellido, Integer edad, String nivel);
    public Muestra crearMuestra (String idMuestra, String idClinico, String idPersona, Date fecha, String idLab);
    public void procesarMuestra (String resultado, String comentario);
    public List<Muestra> ListaDeMuestrasdeUnUsuario (String id);
    public int sizePersonas();
    public int sizeMuestras();
    public int sizeMuestrasProc();

}

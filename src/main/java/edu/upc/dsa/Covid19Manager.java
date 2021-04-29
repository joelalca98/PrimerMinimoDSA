package edu.upc.dsa;

import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Vacuna;
import edu.upc.dsa.models.Vacunacion;

import java.util.Date;
import java.util.List;

public interface Covid19Manager {
    public void Vacunacion (String idUser, String idVacuna, Date fecha);
    public List<Vacunacion> ListaOrdenadaVacunaciones (List<Vacunacion> lista);
    public List<Vacuna> ordenDesc (List<Vacuna> listaVacuna);
    public Seguimiento addSeguimiento (String idPersona, Date fecha, String descripcion);
    public List<Seguimiento> listaUser (String idUser);
    public int sizepersonas();
    public int sizeVacunas();
    public int sizeVacunaciones();
    public int sizeSeguimientos();
    public List<Vacunacion> getListaVacunacion();
    public List<Vacuna> getListaDeVacunas();
}

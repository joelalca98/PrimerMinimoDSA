package edu.upc.dsa;

import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.*;


public class Covid19ManagerImpl implements Covid19Manager{
    private static Covid19ManagerImpl manager;
    static final Logger logger = Logger.getLogger(CovidImpl.class.getName());

    public static Covid19ManagerImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/
    {
        if (manager==null) manager = new Covid19ManagerImpl();
        return manager;

    }
    public static void delete(){
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");
    }

    HashMap<String, Personas> personas;
    List<Seguimiento> seguimientos;
    List<Vacuna> vacunas;
    List<Vacunacion> vacunaciones;

    private Covid19ManagerImpl (){ //Inicializar contenedores
        this.seguimientos = new LinkedList<Seguimiento>();
        this.personas = new HashMap<String, Personas>();
        this.vacunas = new LinkedList<Vacuna>();
        this.vacunaciones = new LinkedList<Vacunacion>();
    }




    @Override
    public void Vacunacion(String idUser, String idVacuna, Date fecha) {


     Vacunacion vacunacion = new Vacunacion(idUser, idVacuna, fecha);
     this.vacunaciones.add(vacunacion);
     for (Vacuna v : this.vacunas)
     {
         if(v.getId().equals(idVacuna))
         {
             int veces;
            veces = v.getVeces();
            v.setVeces(veces + 1);
         }
     }

    }

    @Override
    public List<Vacunacion> ListaOrdenadaVacunaciones(List<Vacunacion> lista) {

        Collections.sort(lista, new Comparator<Vacunacion>() {
            @Override
            public int compare(Vacunacion o1, Vacunacion o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Collections.sort(lista, new Comparator<Vacunacion>() {
            @Override
            public int compare(Vacunacion o1, Vacunacion o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
        });
                return lista;
    }

    @Override
    public List<Vacuna> ordenDesc(List<Vacuna> listaVacuna) {
        Collections.sort(listaVacuna, new Comparator<Vacuna>() {
            @Override
            public int compare(Vacuna o1, Vacuna o2) {
                return o2.getVeces()-o1.getVeces();
            }
        });
        return listaVacuna;
    }

    @Override
    public Seguimiento addSeguimiento(String idPersona, Date fecha, String descripcion) {

        Seguimiento seguimiento = new Seguimiento(idPersona,fecha,descripcion);
        this.seguimientos.add(seguimiento);
        return seguimiento;


    }

    @Override
    public List<Seguimiento> listaUser(String idUser) {
        List<Seguimiento> milista = new LinkedList<Seguimiento>();
        for(Seguimiento s: this.seguimientos)
        {
            if(s.getIdUser().equals(idUser))
            {
                milista.add(s);
            }
        }
        return milista;
    }

    @Override
    public int sizepersonas() {

        int ret = this.personas.size();
        logger.info("size personas: "+ ret);
        return ret;
    }

    @Override
    public int sizeVacunas() {

        int ret = this.vacunas.size();
        logger.info("size vacunas "+ ret);
        return ret;
    }

    @Override
    public int sizeVacunaciones() {

        int ret = this.vacunaciones.size();
        logger.info("size vacunaciones "+ ret);
        return ret;
    }

    @Override
    public int sizeSeguimientos() {
        int ret = this.seguimientos.size();
        logger.info("size seguimientos "+ ret);
        return ret;
    }

    @Override
    public List<Vacunacion> getListaVacunacion() {
        return this.vacunaciones;
    }

    @Override
    public List<Vacuna> getListaDeVacunas() {
        return this.vacunas;
    }
}

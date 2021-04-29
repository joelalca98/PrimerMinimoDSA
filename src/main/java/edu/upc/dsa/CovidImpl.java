package edu.upc.dsa;

import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;


import org.apache.log4j.Logger;

import java.util.*;

public class CovidImpl implements CovidInterfaz {
    private static CovidImpl manager;


    static final Logger logger = Logger.getLogger(CovidImpl.class.getName());
    HashMap<String, Persona> personas;

    public static CovidImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/
    {
        if (manager==null) manager = new CovidImpl();
        return manager;

    }
    public static void delete(){
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");
    }


    Queue<Muestra> muestras; //Lista con id y eso pero son resultado y comentario VACIO
    List<Muestra> muestrasProc; //Lista toda rellena

    private CovidImpl (){ //Inicializar contenedores
        this.muestras = new LinkedList<Muestra>();
        this.personas = new HashMap<String, Persona>();
        this.muestrasProc = new LinkedList<Muestra>();
    }

    public Persona crearPersona (String id, String nombre, String apellido, Integer edad, String nivel){
        Persona personaNueva = new Persona(id, nombre, apellido, edad, nivel);
        this.personas.put(id,personaNueva);
        logger.info("se ha añadido una persona "+personaNueva.getNombre());//Despues de crear la persona pongo el id para identificar el objeto (con hashmap), el objeto creado lo meto como valor y lo identifico con la id
        return personaNueva;


    }
    public Muestra crearMuestra (String idMuestra, String idClinico, String idPersona, Date fecha, String idLab) {
        Muestra muestraNueva = new Muestra(idMuestra,idClinico,idPersona,fecha,idLab);
        logger.info("se ha añadido una muestra de la persona con id:"+ muestraNueva.getIdPersona());
        this.muestras.add(muestraNueva);

        return muestraNueva;


    }

    public void procesarMuestra (String resultado, String comentario) {

        Muestra muestraPrimera = this.muestras.poll();
        muestraPrimera.setComentario(comentario);
        muestraPrimera.setResultado(resultado);
        this.muestrasProc.add(muestraPrimera);
           logger.info("se ha procesado la muestra de :"+ muestraPrimera.getIdMuestra());
        }



    public List<Muestra> ListaDeMuestrasdeUnUsuario (String id){ //Me devuelve la lista de una persona en concreto
        List<Muestra> milista = new LinkedList<Muestra>();
        for (Muestra m : this.muestrasProc)
        {
            if (m.getIdPersona().equals(id))
            {
                milista.add(m);
                logger.info("ha coincidido"+m.getIdPersona());
            }
        }
        return milista;
    }

    public int sizePersonas() {

        int ret = this.personas.size();
        logger.info("size Personas: "+ ret);
        return ret;

    }
    public int sizeMuestras() {

        int ret = this.muestras.size();
        logger.info("size Muestras: "+ ret);
        return ret;

    }
    public int sizeMuestrasProc() {

        int ret = this.muestrasProc.size();
        logger.info("size Muestras Procesadas: "+ ret);
        return ret;

    }




}












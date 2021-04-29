package edu.upc.dsa.services;

import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Api(value = "/Covid19", description = "Endpoint to Text Service")
@Path("/Covid19")

public class Covid19Service {
    private Covid19ManagerImpl ct;

    public Covid19Service() {
        this.ct = Covid19ManagerImpl.getInstance();

       this.ct.Vacunacion("p1", "v1", new Date(2020, 01, 5));
        this.ct.Vacunacion("p1", "v1", new Date(2020, 02, 6));
        this.ct.Vacunacion("p1", "v1", new Date(2020, 03, 7));

        this.ct.addSeguimiento("d1", new Date(2020, 03, 05), "p1");
        this.ct.addSeguimiento("d2", new Date(2020, 04, 06), "p2");
       this.ct.addSeguimiento("d3", new Date(2020, 05, 07), "p3");
    }

    @GET
    @ApiOperation(value = "Lista de Vacunaciones", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Vacunacion.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/listaVacunaciones")
    public Response DameListaDeVacunaciones(){

      List <Vacunacion> vacunaciones = this.ct.ListaOrdenadaVacunaciones(this.ct.getListaVacunacion());




        GenericEntity<List<Vacunacion>> entity = new GenericEntity<List<Vacunacion>>(vacunaciones) {
        };
        return Response.status(201).entity(entity).build();
    }



    @POST /*Añadir Un seguimiento*/
    @ApiOperation(value = "Añadimos seguimientos", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Seguimiento.class),
            @ApiResponse(code = 500, message = "Validation Error")


    })
    @Path("/{idPersona}/{fecha}/{descripcion}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response procMuestra(@PathParam("idPersona")String idPersona,@PathParam("fecha") Date fecha ,@PathParam("descripcion")String  descripcion){

        Seguimiento seguimiento = ct.addSeguimiento(idPersona,fecha,descripcion);

        return Response.status(201).entity(seguimiento).build();
    }


    @GET
    @ApiOperation(value = "Lista de Seguimientos de una persona", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Seguimiento.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{idPersona}")
    public Response ListaSeguimiento(@PathParam("idPersona")String  idPersona){

        List <Seguimiento> seguimientos = this.ct.listaUser(idPersona);




        GenericEntity<List<Seguimiento>> entity = new GenericEntity<List<Seguimiento>>(seguimientos) {
        };
        return Response.status(201).entity(entity).build();
    }




}

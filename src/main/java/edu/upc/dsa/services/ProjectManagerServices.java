package edu.upc.dsa.services;


import edu.upc.dsa.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/pm", description = "Endpoint to Project Manager")
@Path("/pm")
public class ProjectManagerServices {

    private ProjectManager pm;

    public ProjectManagerServices(){
        this.pm = ProjectManagerImpl.getInstance();

        pm.addUser(new User("user1","Adri","Navarrete"));
        this.pm.hacerPedido(new Pedido("ped1","user1",5,1,2));
        this.pm.hacerPedido(new Pedido("ped2","user1",5,56,2));
    }


    @POST
    @ApiOperation(value = "Hacer pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Pedido.class)
    })
    @Path("/hacerpedido")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hacerPedido(Pedido p) {

        /*String id = p.getIdUser();
        int cantPan = p.getCantPan();
        int cantLeche = p.getCantLeche();
        int cantAgua = p.getCantAgua();
        String idUser = p.getIdUser();*/

        this.pm.hacerPedido(p);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Get list pedidos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Pedido.class, responseContainer = "lista"),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @Path("/user/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response damePedidosRealizadoPorUser(@PathParam("idUser") String idUser) {


        List<Pedido> pedidos = this.pm.damePedidosRealizadoPorUser(idUser);
        GenericEntity<List<Pedido>> entity = new GenericEntity<List<Pedido>>(pedidos){};
        return Response.status(201).entity(entity).build();


    }


}

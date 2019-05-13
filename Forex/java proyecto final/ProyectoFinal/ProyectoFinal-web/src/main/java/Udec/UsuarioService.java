/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Udec;

import com.Udec.proyectoFinal.clase.Usuario;
import com.Udec.proyectoFinal.interfaces.IusuarioLocal;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author David
 */
@javax.enterprise.context.RequestScoped
@Path("Logica")
public class UsuarioService {
  @EJB
  IusuarioLocal usuario;
    
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/recargarDinero")
 public Response recargaDinero(Usuario user){
     try{
          JsonObject json = Json.createObjectBuilder()
                 .add("saldo",usuario.recargaDinero(user))
                 .build();
        return Response.ok(json).build();
     }catch (Exception ex){
         return Response.status(Response.Status.NOT_ACCEPTABLE).build();
     }         
   } 
 
 
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/consultarDinero")
 public Response ConsultaDinero(Usuario user){
     try{
          JsonObject json = Json.createObjectBuilder()
                 .add("saldoOriginal",usuario.consultarDinero(user))
                 .build();
        return Response.ok(json).build();
     }catch (Exception ex){
         return Response.status(Response.Status.NOT_ACCEPTABLE).build();
     }         
   } 
 
 
    
}

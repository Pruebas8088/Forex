/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Udec;


import com.Udec.proyectoFinal.clase.Usuario;
import com.Udec.proyectoFinal.interfaces.IseguridadLocal;
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
 *clase que contiene funciones del logueo
 * @author David
 */
@javax.enterprise.context.RequestScoped
@Path("Login")
public class UsuarioLogin {

    /**
     * atributo de la interfaaz de seguridad
     */
    @EJB
    IseguridadLocal seguridad;
 /**
  * funcio que realiza la validacion del usuario
  * @param user
  * @return 
  */   
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/logeoUsuario")
 public Response retornUsuariosJwtPrueba(Usuario user ){
            
     if(seguridad.validacion(user) == true){
         JsonObject json = Json.createObjectBuilder()
                 .add("jwt",seguridad.JwtConvert(user.getEmail(),user.getPass()))
                 .build();
         return Response.ok(json).build();
     }else{
         JsonObject json = Json.createObjectBuilder()
                 .add("mensaje","Datos Erroneos")
                 .build();
         return Response.status(Response.Status.UNAUTHORIZED).entity(json).build();
     }
           
 }   
}

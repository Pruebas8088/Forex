/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Udec;

import com.Udec.proyectoFinal.clase.Datos;
import com.Udec.proyectoFinal.clase.Usuario;
import com.Udec.proyectoFinal.interfaces.Iseguridad;
import com.Udec.proyectoFinal.interfaces.IseguridadLocal;
import com.Udec.proyectoFinal.interfaces.IusuarioLocal;
import com.Udec.proyectoFinal.utilitario.Seguridad;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author David
 */
@Provider
@PreMatching
public class Interceptor implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String url = requestContext.getUriInfo().getAbsolutePath().toString();
        if(url.contains("api/Login") || url.contains("api/Registro"))
            return;
     
          String token = requestContext.getHeaderString("token-auto");
          if(token == null){
              JsonObject json = Json.createObjectBuilder()
                 .add("usertoken","Token invalido")
                 .build();
              requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                      .entity(json)
                      .type(MediaType.APPLICATION_JSON)
                      .build());
          }else if(!token.equals(traerToken(token))){
              JsonObject json = Json.createObjectBuilder()
                 .add("usertoken","Token no coincide")
                 .build();
              requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                      .entity(json)
                      .type(MediaType.APPLICATION_JSON)
                      .build());
          
            
        }
    }
    
   @EJB
   IseguridadLocal segur;
    private String traerToken(String token){
         ArrayList<Usuario> listauser = new ArrayList<Usuario>();
         listauser = segur.traerdata();
         String tokenverif="";
         for (Usuario Lusuario : listauser) {
                
                if(Lusuario.getToken().equals(token)){
                    tokenverif = Lusuario.getToken();
                    return tokenverif;
                }
               
           }
            tokenverif = "errorNoseEncuentra";
        return tokenverif;
    }
    
   
    
    
}

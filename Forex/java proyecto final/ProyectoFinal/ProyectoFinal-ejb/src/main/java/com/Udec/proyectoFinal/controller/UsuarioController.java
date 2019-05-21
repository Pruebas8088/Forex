/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.controller;

import com.Udec.proyectoFinal.clase.Datos;
import com.Udec.proyectoFinal.clase.ErrorMsg;
import com.Udec.proyectoFinal.clase.Usuario;
import java.io.IOException;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *clase que contiene funciones de usuario
 * @author David
 */
public class UsuarioController {
    
   
    /**
     * funcion que controla que los datos no esten vacios
     * @param user objetoque contiene los datos del usuario
     * @return er
     */
    public ErrorMsg anadirUser(Usuario user)  {
        ErrorMsg er = new ErrorMsg();
            if(user.getNombre().isEmpty() || user.getApellido().isEmpty() || user.getEmail().isEmpty() || user.getPass().isEmpty()){
               er.setErrormsg("no se aceptan campos vacios");
               return er;
            }else{
              Datos dat =  new Datos();
              dat.envio(user);
             er.setErrormsg("Registro exitoso");
               return er;
         }    
    }
    /**
     * funcion que recarga el dinero del usuario
     * @param user objeto que contiene los datos del usuario
     * @return dinero
     */
    public float recargaDinero(Usuario user){
        float dinero;
         Datos dat =  new Datos();
        dat.updateDinero(user);
        dinero=user.getDinero();
        return dinero;
    }
    
    /**
     * funcion que consulta el dinero del usuario
     * @param user objeto que contiene los datos del usuario
     * @return  dinero
     */
    public float consultarDinero(Usuario user){
        float dinero;
         Datos dat =  new Datos();
        
        dinero=dat.traerDinero(user);
        return dinero;
    }
    
}



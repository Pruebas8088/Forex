/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import com.Udec.proyectoFinal.clase.Datos;
import com.Udec.proyectoFinal.clase.ErrorMsg;
import com.Udec.proyectoFinal.clase.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author Jonathan
 */
@Stateless
public class Iusuario implements IusuarioLocal {

    @Override
    public ErrorMsg anadirUser(Usuario user) {
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

    @Override
    public float recargaDinero(Usuario user) {
        float dinero;
         Datos dat =  new Datos();
        dat.updateDinero(user);
        dinero=user.getDinero();
        return dinero;
    }

    @Override
    public float consultarDinero(Usuario user) {
        float dinero;
         Datos dat =  new Datos();
        
        dinero=dat.traerDinero(user);
        return dinero;
    }

    
}

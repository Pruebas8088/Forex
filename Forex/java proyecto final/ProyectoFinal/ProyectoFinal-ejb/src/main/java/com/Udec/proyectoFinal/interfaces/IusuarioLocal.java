/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import com.Udec.proyectoFinal.clase.ErrorMsg;
import com.Udec.proyectoFinal.clase.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Jonathan
 */
@Local
public interface IusuarioLocal {
    public ErrorMsg anadirUser(Usuario user) ;
    
    public float recargaDinero(Usuario user);
    
    public float consultarDinero(Usuario user);
}

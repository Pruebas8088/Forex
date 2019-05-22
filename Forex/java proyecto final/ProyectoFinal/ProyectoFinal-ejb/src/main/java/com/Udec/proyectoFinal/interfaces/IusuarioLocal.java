/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import com.Udec.proyectoFinal.clase.Divisa;
import com.Udec.proyectoFinal.clase.ErrorMsg;
import com.Udec.proyectoFinal.clase.Usuario;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *interfaz de usuario
 * @author Jonathan
 */
@Local
public interface IusuarioLocal {
    public ErrorMsg anadirUser(Usuario user) ;
    
    public float recargaDinero(Usuario user);
    
    public float consultarDinero(Usuario user);
    
    public ErrorMsg cerrarSesion(Usuario user) ;
    
    public ErrorMsg compraDivisa(Divisa divisa) ;
    
    public ArrayList<Divisa> ConsultaDivisa(Divisa divisa) ;
    
     public ArrayList<Divisa> ConsultaHistorial(Divisa divisa) ;
    
    public float operacionBeneficio(Divisa divisa);
    
    public float terminarOperacion(Divisa divisa);
    
    public ErrorMsg descontarDinero(Usuario user);
    
   
    
}

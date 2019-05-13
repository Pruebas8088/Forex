/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import com.Udec.proyectoFinal.clase.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Jonathan
 */
@Local
public interface IdatosLocal {
    public void envio(Usuario usuario);
    
    public Boolean validacion(Usuario usuario);
    
    public void updateToken(Usuario usuario,String jwt);
    
    public void updateDinero(Usuario usuario);
    
    public ArrayList<Usuario> traerInfo();
    
    public float traerDinero(Usuario user);
    
    public float llenadodinero(ResultSet rs);
    
    public ArrayList<Usuario> llenado(ResultSet rs);
    
    public void connect();
    
    public void disconnet() ;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import com.Udec.proyectoFinal.clase.Usuario;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Jonathan
 */
@Local
public interface IseguridadLocal {
    
  public String JwtConvert(String usuario, String contraseña);
  
  public boolean validacion(Usuario user);
  
  public ArrayList<Usuario> traerdata();
}

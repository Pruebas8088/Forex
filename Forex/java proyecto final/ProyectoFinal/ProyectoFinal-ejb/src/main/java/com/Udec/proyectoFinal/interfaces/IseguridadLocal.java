/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Jonathan
 */
@Local
public interface IseguridadLocal {
    
  public String JwtConvert(String usuario, String contraseña);
  
  
  
}

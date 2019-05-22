/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.clase;

import com.udec.utilitarios.Divisa;
import com.udec.utilitarios.ErrorMsg;
import com.udec.utilitarios.Usuario;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author David
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

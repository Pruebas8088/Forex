/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.clase;

import com.udec.utilitarios.Datos;
import com.udec.utilitarios.Divisa;
import com.udec.utilitarios.ErrorMsg;
import com.udec.utilitarios.Usuario;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author David
 */
@Stateless
public class Iusuario implements IusuarioLocal {

    @Override
    public ErrorMsg anadirUser(Usuario user) {
            ErrorMsg er = new ErrorMsg();
         ArrayList<Usuario> listauser = new ArrayList<Usuario>();
         Datos datos = new  Datos();
         listauser = datos.traerInfo();
         if(listauser.isEmpty()){
              Datos dat =  new Datos();
            dat.envio(user);
            er.setErrormsg("Registro exitoso");
            return er;
        }else{
            for (Usuario userL : listauser) {
                    if(userL.getEmail().equals(user.getEmail())){
                         er.setErrormsg("EL correo Ya existe");
                         return er;
                    }
                }
            Datos dat =  new Datos();
            dat.envio(user);
            er.setErrormsg("Registro exitoso");
            return er;
        }
    }

    @Override
    public float recargaDinero(Usuario user) {
        float dinero = user.getDinero();
        float dinero1 = consultarDinero(user);
        dinero = (dinero1+user.getDinero());
        user.setDinero(dinero);
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

    @Override
    public ErrorMsg cerrarSesion(Usuario user) {
        ErrorMsg er = new ErrorMsg();
            Datos dat =  new Datos();
            dat.cerradoCuenta(user);
            er.setErrormsg("Cerrado");
            return er;
    }

    @Override
    public ErrorMsg compraDivisa(Divisa divisa) {
        ErrorMsg er = new ErrorMsg();
            Datos dat =  new Datos();
            dat.compraDivisas(divisa);
            er.setErrormsg("Compra Exitosa, confirmacion enviada a su correo");
            return er;
    }

    @Override
    public ArrayList<Divisa> ConsultaDivisa(Divisa divisa) {
      ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
           
            Datos dat =  new Datos();
            listaDivisa=dat.consultaDivisa(divisa);
           
            return listaDivisa;
    }

    @Override
    public ArrayList<Divisa> ConsultaHistorial(Divisa divisa) {
      ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
           
            Datos dat =  new Datos();
            listaDivisa=dat.consultaDivisaHistorial(divisa);
           
            return listaDivisa;
    }

    @Override
    public float operacionBeneficio(Divisa divisa) {
        ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
        Datos dat =  new Datos();
        float bene =0;
        listaDivisa = dat.consultaDivisa(divisa);
        for (Divisa listdivi : listaDivisa) {
             if(listdivi.getDivisa().equals(divisa.getDivisa())){
                 if(listdivi.getIdOperacion() == 1){
                     listdivi.setBeneficio((divisa.getValorFinal()-listdivi.getValorInicial())*listdivi.getCantidad());
                     Datos datupdate1 =  new Datos();
                     datupdate1.updateDivisa(listdivi);
                     bene+=listdivi.getBeneficio();
                 }else{
                     listdivi.setBeneficio((listdivi.getValorInicial()-divisa.getValorFinal())*listdivi.getCantidad());
                      Datos datupdate2 =  new Datos();
                     datupdate2.updateDivisa(listdivi);
                     bene+=listdivi.getBeneficio();
                 }
                 
             }
              
        }
       
        return bene; }

    @Override
    public float terminarOperacion(Divisa divisa) {
    Datos dat =  new Datos();
        Datos datinsertar =  new Datos();
        dat.borrarDivisa(divisa);
        datinsertar.insertarHistorial(divisa);
        return divisa.getBeneficio();
    }

    @Override
    public ErrorMsg descontarDinero(Usuario user) {
        Datos dat =  new Datos();
        dat.updateDineroCuenta(user);
        ErrorMsg er = new ErrorMsg();
        er.setErrormsg("actualizado");
        return er;    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
